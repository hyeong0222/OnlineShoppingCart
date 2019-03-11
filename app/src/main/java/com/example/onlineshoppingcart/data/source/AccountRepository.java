package com.example.onlineshoppingcart.data.source;

import android.app.Application;
import android.util.Log;

import com.example.onlineshoppingcart.data.Account;
import com.example.onlineshoppingcart.data.Product;
import com.example.onlineshoppingcart.data.source.remote.AccountRemoteDataSource;

public class AccountRepository extends Application implements AccountDataSource.Presenter {

    private AccountRemoteDataSource accountRemoteDataSource;
    private AccountDataSource.ServerStringCallBack serverStringCallBack;
    private AccountDataSource.ServerArrayCallBack serverArrayCallBack;
    private AccountDataSource.ServerObjectCallBack serverObjectCallBack;

    public AccountRepository() {
        accountRemoteDataSource = new AccountRemoteDataSource();
    }

    @Override
    public void signUp(Account account, AccountDataSource.ServerStringCallBack callBack) {
        accountRemoteDataSource.signUp(account, callBack);
    }

    @Override
    public void signIn(Account account, AccountDataSource.ServerArrayCallBack callBack) {
        accountRemoteDataSource.signIn(account, callBack);
    }

    @Override
    public void updateProfile(Account account, AccountDataSource.ServerStringCallBack callBack) {
        accountRemoteDataSource.updateProfile(account, callBack);
    }

    @Override
    public void resetPassword(Account account, AccountDataSource.ServerObjectCallBack callBack) {
        accountRemoteDataSource.resetPassword(account, callBack);
    }

    @Override
    public void sendRequest(Account account, AccountDataSource.ServerStringCallBack callBack) {
        accountRemoteDataSource.sendRequest(account, callBack);
    }

    @Override
    public void productCategory(Product product, AccountDataSource.ServerObjectCallBack callBack) {
        accountRemoteDataSource.productCategory(product, callBack);
    }

    @Override
    public void productSubCategory(Product product, AccountDataSource.ServerObjectCallBack callBack) {
        accountRemoteDataSource.productSubCategory(product, callBack);
    }


    @Override
    public void productList(Product product, AccountDataSource.ServerObjectCallBack callBack) {
        accountRemoteDataSource.productList(product, callBack);
    }

}
