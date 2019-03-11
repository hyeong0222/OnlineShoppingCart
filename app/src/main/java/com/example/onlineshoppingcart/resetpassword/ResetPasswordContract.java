package com.example.onlineshoppingcart.resetpassword;

import org.json.JSONArray;
import org.json.JSONObject;

public interface ResetPasswordContract {

    interface View {
        void getResponse(JSONObject response);
    }

    interface Presenter {
        void setPassword(String mobile, String currentPassword, String newPassword);
    }
}
