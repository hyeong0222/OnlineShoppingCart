package com.example.onlineshoppingcart.signup;

import org.json.JSONArray;

public interface SignUpContract {

    interface View {
        void getResponse(String response);
    }

    interface Presenter {
        void setAccount(String fname, String lname, String email, String mobile, String password, String address);
    }
}
