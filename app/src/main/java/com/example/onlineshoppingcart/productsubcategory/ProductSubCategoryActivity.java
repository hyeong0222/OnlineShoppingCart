package com.example.onlineshoppingcart.productsubcategory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.onlineshoppingcart.R;
import com.example.onlineshoppingcart.mainview.MainActivity;
import com.example.onlineshoppingcart.mainview.ProductCategoryImagesAdapter;
import com.example.onlineshoppingcart.mainview.ProductSubCategory;
import com.example.onlineshoppingcart.mainview.ProductSubCategoryImagesAdapter;
import com.example.onlineshoppingcart.signin.SignInActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductSubCategoryActivity extends AppCompatActivity implements ProductSubCategoryContract.View {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor preferencesEditor;
    private String sharedPrefFile = "com.example.onlineshoppingcart";

    Toolbar toolbar;
    ProductSubCategoryImagesAdapter productSubCategoryAdapter;
    RecyclerView productSubCategoryRecyclerView;
    ProductSubCategoryContract.Presenter contract;
    String id, api_key, user_id;
    List<ProductSubCategory> recyclerViewProductSubCategoryList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_sub_category);

        toolbar = findViewById(R.id.toolbarCreateAWalmartAccount);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        contract = new ProductSubCategoryPresenter(this);
        productSubCategoryRecyclerView = findViewById(R.id.recyclerViewProductSubCategory);

        sharedPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);
        preferencesEditor = sharedPreferences.edit();

        this.id = getIntent().getExtras().getString("cid");
        this.api_key = sharedPreferences.getString("api_key", null);
        this.user_id = sharedPreferences.getString("user_id", null);

        sendRequest();

    }

    @Override
    protected void onStart() {
        super.onStart();

        productSubCategoryAdapter = new ProductSubCategoryImagesAdapter(recyclerViewProductSubCategoryList, this);
        RecyclerView.LayoutManager layoutManagerGrid = new GridLayoutManager(this, 2);
        productSubCategoryRecyclerView.setLayoutManager(layoutManagerGrid);
        productSubCategoryRecyclerView.setAdapter(productSubCategoryAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        preferencesEditor.putString("cid", id);
        preferencesEditor.apply();
    }

    @Override
    public void getResponse(JSONObject response) {
        try {
            List<ProductSubCategory> temp = new ArrayList<>();
            JSONArray jsonArray = response.getJSONArray("subcategory");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String scid = jsonObject.getString("scid");
                String scname = jsonObject.getString("scname");
                String scdiscription = jsonObject.getString("scdiscription");
                String scimageurl = jsonObject.getString("scimageurl");

                ProductSubCategory productSubCategory = new ProductSubCategory(scid, scname, scdiscription, scimageurl);
                temp.add(productSubCategory);
            }
            recyclerViewProductSubCategoryList = temp;
        } catch (JSONException e) {
            Log.e("Parse to JSONObject", e.getMessage());
        }
    }

    public void sendRequest() {
        contract.sendRequest(id, api_key, user_id);
    }


}
