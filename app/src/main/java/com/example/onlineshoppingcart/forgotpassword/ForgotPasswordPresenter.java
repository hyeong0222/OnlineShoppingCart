package com.example.onlineshoppingcart.forgotpassword;

import com.example.onlineshoppingcart.data.Account;
import com.example.onlineshoppingcart.data.source.AccountDataSource;
import com.example.onlineshoppingcart.data.source.AccountRepository;

public class ForgotPasswordPresenter implements ForgotPasswordContract.Presenter, AccountDataSource.ServerStringCallBack {

    AccountDataSource.Presenter mAccountRepository;
    ForgotPasswordContract.View view;

    public ForgotPasswordPresenter(ForgotPasswordContract.View view) {
        this.view = view;
        mAccountRepository = new AccountRepository();
    }

    @Override
    public void getServerCallBack(String response) {
        view.getResponse(response);
    }

    @Override
    public void sendRequest(String email) {
        Account account = new Account(email);
        mAccountRepository.updateProfile(account, this);
    }
}
