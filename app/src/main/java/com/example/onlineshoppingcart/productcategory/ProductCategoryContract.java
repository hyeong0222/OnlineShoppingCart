package com.example.onlineshoppingcart.productcategory;

import org.json.JSONObject;

public interface ProductCategoryContract {

    interface View {
        void getResponse(JSONObject response);
    }

    interface Presenter {
        void sendRequest(String api_key, String id);
    }
}
