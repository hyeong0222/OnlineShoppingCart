package com.example.onlineshoppingcart.productsubcategory;

import org.json.JSONArray;
import org.json.JSONObject;

public interface ProductSubCategoryContract {

    interface View {
        void getResponse(JSONObject response);
    }

    interface Presenter {
        void sendRequest(String id, String api_key, String user_id);
    }
}
