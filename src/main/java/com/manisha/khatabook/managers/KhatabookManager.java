package com.manisha.khatabook.managers;

import com.manisha.khatabook.dao.KhatabookDao;
import com.manisha.khatabook.dao.exceptions.KhatabookListOfUserDaoException;
import com.manisha.khatabook.dao.models.request.GetBalanceRequest;
import com.manisha.khatabook.dao.models.request.GetKhatabooksRequest;
import com.manisha.khatabook.dao.models.response.GetBalanceResponse;
import com.manisha.khatabook.dao.models.response.GetKhatabooksResponse;
import com.manisha.khatabook.models.Khatabook;
import com.manisha.khatabook.models.User;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhatabookManager {

    @Autowired
    private KhatabookDao khatabookDao;

    public GetKhatabooksResponse getKhatabooks(User user){
        GetKhatabooksRequest getKhatabooksRequest =
                getKhatabooksRequest(user);
        try {
            return khatabookDao.getKhatabooks(getKhatabooksRequest);
        } catch (KhatabookListOfUserDaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    private GetKhatabooksRequest getKhatabooksRequest(@NonNull User user){
        return GetKhatabooksRequest.builder()
                .phoneNumber(user.getPhone_number())
                .build();
    }

    public GetBalanceResponse getBalance(Khatabook khatabook) {
        GetBalanceRequest getBalanceRequest= getBalanceRequest(khatabook);
        try{
            return khatabookDao.getBalance(getBalanceRequest);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private GetBalanceRequest getBalanceRequest(@NonNull Khatabook khatabook){
        return GetBalanceRequest.builder()
                .khatabookId(khatabook.getId())
                .build();
    }
}
