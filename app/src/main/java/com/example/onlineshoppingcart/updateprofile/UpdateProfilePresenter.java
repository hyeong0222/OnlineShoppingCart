package com.example.onlineshoppingcart.updateprofile;

import com.example.onlineshoppingcart.data.Account;
import com.example.onlineshoppingcart.data.source.AccountDataSource;
import com.example.onlineshoppingcart.data.source.AccountRepository;

public class UpdateProfilePresenter implements UpdateProfileContract.Presenter, AccountDataSource.ServerStringCallBack {

    AccountDataSource.Presenter mAccountRepository;
    UpdateProfileContract.View view;

    public UpdateProfilePresenter(UpdateProfileContract.View view) {
        this.view = view;
        mAccountRepository = new AccountRepository();
    }

    @Override
    public void getServerCallBack(String response) {
        view.getResponse(response);
    }

    @Override
    public void updateProfile(String fname, String lname, String email, String mobile, String address) {
        Account account = new Account(fname, lname, email, mobile, address);
        mAccountRepository.updateProfile(account, this);
    }
}
