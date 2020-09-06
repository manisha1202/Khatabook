package com.manisha.khatabook.managers;

import com.manisha.khatabook.dao.UserAuthDao;
import com.manisha.khatabook.dao.exceptions.KhatabookUserAuthDaoException;
import com.manisha.khatabook.dao.models.request.GetUserRequest;
import com.manisha.khatabook.dao.models.request.SaveUserRequest;
import com.manisha.khatabook.dao.models.response.GetUserResponse;
import com.manisha.khatabook.exceptions.KhatabookUserAuthException;
import com.manisha.khatabook.models.User;
import com.manisha.khatabook.utils.JwtUtil;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserAuthManager {

    @Autowired
    private UserAuthDao userAuthDao;

    public void registerUser(User user) {
        SaveUserRequest saveUserRequest = getSaveUserRequest(user);
        try {
            userAuthDao.saveUser(saveUserRequest);
        } catch (KhatabookUserAuthDaoException e) {
            e.printStackTrace();
        }
    }

    public ResponseEntity<String> login(User user) throws KhatabookUserAuthException {
        try {
            GetUserRequest getUserRequest = getLoginRequest(user);
            GetUserResponse getUserResponse = userAuthDao.getUser(getUserRequest);

            if (!Objects.isNull(getUserResponse)) {
                final String jwt = JwtUtil.generateToken(user);
                return ResponseEntity.ok(jwt);
            }
        } catch (Exception e) {
            throw new KhatabookUserAuthException("Failed to login.", e);
        }
        return null;
    }

    private SaveUserRequest getSaveUserRequest(@NonNull User user) {
        return SaveUserRequest.builder()
                .userName(user.getUser_name())
                .phoneNumber(user.getPhone_number())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    private GetUserRequest getLoginRequest(@NonNull User user) {
        return GetUserRequest.builder()
                .phoneNumber(user.getPhone_number())
                .password(user.getPassword())
                .build();

    }
}
