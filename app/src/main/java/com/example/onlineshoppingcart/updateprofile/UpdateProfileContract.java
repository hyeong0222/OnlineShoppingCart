package com.example.onlineshoppingcart.updateprofile;

public interface UpdateProfileContract {

    interface View {
        void getResponse(String response);
    }

    interface Presenter {
        void updateProfile(String fname, String lname, String email, String mobile, String address);
    }
}
