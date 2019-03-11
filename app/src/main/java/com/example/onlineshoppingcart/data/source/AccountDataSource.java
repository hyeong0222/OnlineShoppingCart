package com.example.onlineshoppingcart.data.source;

import com.example.onlineshoppingcart.data.Account;
import com.example.onlineshoppingcart.data.Product;

import org.json.JSONArray;
import org.json.JSONObject;

public interface AccountDataSource {

    interface Presenter {
        void signUp(Account account, ServerStringCallBack callBack);
        void signIn(Account account, ServerArrayCallBack callBack);
        void updateProfile(Account account, ServerStringCallBack callBack);
        void resetPassword(Account account, ServerObjectCallBack callBack);
        void sendRequest(Account account, ServerStringCallBack callBack);
        void productList(Product product, ServerObjectCallBack callBack);
        void productCategory(Product product, ServerObjectCallBack callBack);
        void productSubCategory(Product product, ServerObjectCallBack callBack);
    }

    interface ServerObjectCallBack {
        void getServerCallBack(JSONObject response);
    }

    interface ServerArrayCallBack {
        void getServerCallBack(JSONArray response);
    }

    interface ServerStringCallBack {
        void getServerCallBack(String response);
    }
}
