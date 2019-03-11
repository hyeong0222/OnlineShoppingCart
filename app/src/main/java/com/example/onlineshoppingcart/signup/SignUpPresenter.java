package com.example.onlineshoppingcart.signup;

import com.example.onlineshoppingcart.data.Account;
import com.example.onlineshoppingcart.data.source.AccountDataSource;
import com.example.onlineshoppingcart.data.source.AccountRepository;

import org.json.JSONArray;

public class SignUpPresenter implements SignUpContract.Presenter, AccountDataSource.ServerStringCallBack {

    AccountDataSource.Presenter mAccountRepository;
    SignUpContract.View view;

    public SignUpPresenter(SignUpContract.View view) {
        this.view = view;
        this.mAccountRepository = new AccountRepository();
    }

    @Override
    public void setAccount(String fname, String lname, String email, String mobile, String password, String address) {
        Account account = new Account(fname, lname, email, mobile, password, address);
        mAccountRepository.signUp(account, this);
    }

    @Override
    public void getServerCallBack(String response) {
        view.getResponse(response);
    }
}
