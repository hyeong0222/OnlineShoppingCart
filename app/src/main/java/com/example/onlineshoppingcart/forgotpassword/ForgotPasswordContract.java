package com.example.onlineshoppingcart.forgotpassword;

public interface ForgotPasswordContract {

    interface View {
        void getResponse(String response);
    }

    interface Presenter {
        void sendRequest(String email);
    }
}
