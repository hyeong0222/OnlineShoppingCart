package com.example.onlineshoppingcart.signin;

import org.json.JSONArray;

public interface SignInContract {

    interface View {
        void getResponse(JSONArray response);
    }

    interface Presenter {
        void setLogin(String mobile, String password);
    }
}
