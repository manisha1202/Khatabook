package com.manisha.khatabook.managers;

import com.manisha.khatabook.dao.KhatabookDao;
import com.manisha.khatabook.dao.exceptions.KhatabookListOfUserDaoException;
import com.manisha.khatabook.dao.models.request.GetKhatabookListOfUserRequest;
import com.manisha.khatabook.models.User;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhatabookManager {

//    @Autowired
//    private KhatabookDao khatabookDao;
//
//    public void getKhatabookListOfUser(User user){
//        GetKhatabookListOfUserRequest getKhatabookListOfUserRequest=
//                getKhatabookListOfUserRequest(user);
//        try {
//            khatabookDao.getKhatabooksForAUser(getKhatabookListOfUserRequest);
//        } catch (KhatabookListOfUserDaoException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private GetKhatabookListOfUserRequest getKhatabookListOfUserRequest(@NonNull User user){
//        return GetKhatabookListOfUserRequest
//                .builder()
//                .phoneNumber(user.getPhone_number())
//                .build();
//    }
}
