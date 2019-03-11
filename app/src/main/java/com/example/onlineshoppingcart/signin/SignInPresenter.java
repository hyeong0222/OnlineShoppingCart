package com.example.onlineshoppingcart.signin;

import android.util.Log;

import com.example.onlineshoppingcart.data.Account;
import com.example.onlineshoppingcart.data.source.AccountDataSource;
import com.example.onlineshoppingcart.data.source.AccountRepository;

import org.json.JSONArray;

public class SignInPresenter implements SignInContract.Presenter, AccountDataSource.ServerArrayCallBack {

    AccountDataSource.Presenter mAccountRepository;
    SignInContract.View view;

    public SignInPresenter(SignInContract.View view) {
        this.view = view;
        mAccountRepository = new AccountRepository();
    }

    @Override
    public void setLogin(String mobile, String password) {
        Account account = new Account(mobile, password);
        mAccountRepository.signIn(account, this);
    }

    @Override
    public void getServerCallBack(JSONArray response) {
        view.getResponse(response);
    }
}
