package com.example.onlineshoppingcart.resetpassword;

import com.example.onlineshoppingcart.data.Account;
import com.example.onlineshoppingcart.data.source.AccountDataSource;
import com.example.onlineshoppingcart.data.source.AccountRepository;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResetPasswordPresenter implements ResetPasswordContract.Presenter, AccountDataSource.ServerObjectCallBack {

    AccountDataSource.Presenter mAccountRepository;
    ResetPasswordContract.View view;

    public ResetPasswordPresenter(ResetPasswordContract.View view) {
        this.view = view;
        this.mAccountRepository = new AccountRepository();
    }

    @Override
    public void setPassword(String mobile, String currentPassword, String newPassword) {
        Account account = new Account(mobile, currentPassword, newPassword);
        mAccountRepository.resetPassword(account, this);
    }

    @Override
    public void getServerCallBack(JSONObject response) {
        view.getResponse(response);
    }
}
