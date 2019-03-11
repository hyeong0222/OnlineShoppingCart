package com.example.onlineshoppingcart.productlist;

import org.json.JSONArray;
import org.json.JSONObject;

public interface ProductListContract {

    interface View {
        void getResponse(JSONObject response);
    }

    interface Presenter {
        void sendRequest(String cid, String scid, String api_key, String user_id);
    }
}
