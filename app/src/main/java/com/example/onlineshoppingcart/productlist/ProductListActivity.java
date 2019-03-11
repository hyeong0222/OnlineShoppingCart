package com.example.onlineshoppingcart.productlist;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.onlineshoppingcart.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity implements ProductListContract.View {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor preferencesEditor;
    private String sharedPrefFile = "com.example.onlineshoppingcart";

    ProductListContract.Presenter contract;
    List<String> imageUrl = new ArrayList<>();

    String cid;
    String scid;
    String api_key;
    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        sharedPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);
        preferencesEditor = sharedPreferences.edit();

        this.cid = sharedPreferences.getString("cid", null);
//        this.scid
        this.api_key = sharedPreferences.getString("api_key", null);
        this.user_id = sharedPreferences.getString("user_id", null);

        sendRequest();
    }

    @Override
    public void getResponse(JSONObject response) {
        try {
            JSONArray jsonArray = response.getJSONArray("products");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                imageUrl.add(jsonObject.getString("image"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void sendRequest() {
        contract.sendRequest(cid, scid, api_key, user_id);
    }
}
