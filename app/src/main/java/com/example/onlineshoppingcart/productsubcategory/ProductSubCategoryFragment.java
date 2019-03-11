package com.example.onlineshoppingcart.productsubcategory;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlineshoppingcart.R;
import com.example.onlineshoppingcart.mainview.ProductSubCategory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductSubCategoryFragment extends Fragment implements ProductSubCategoryContract.View{

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor preferencesEditor;
    private String sharedPrefFile = "com.example.onlineshoppingcart";

    RecyclerView subCategoryRecyclerView;
    ProductSubCategoryContract.Presenter contract;
    String id, api_key, user_id;
    List<ProductSubCategory> recyclerViewProductSubCategoryList = new ArrayList<>();


    public ProductSubCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_product_sub_category, container, false);

        contract = new ProductSubCategoryPresenter(this);
        subCategoryRecyclerView = view.findViewById(R.id.recyclerViewProductSubCategory);

        sharedPreferences = this.getActivity().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);

        this.id = sharedPreferences.getString("id", null);
        this.api_key = sharedPreferences.getString("api_key", null);
        this.user_id = sharedPreferences.getString("user_id", null);

        sendRequest();

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void getResponse(JSONObject response) {
        try {
            JSONArray jsonArray = response.getJSONArray("category");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String scid = jsonObject.getString("scid");
                String scname = jsonObject.getString("scname");
                String scdiscription = jsonObject.getString("scdiscription");
                String scimageurl = jsonObject.getString("scimageurl");

                ProductSubCategory productSubCategory = new ProductSubCategory(scid, scname, scdiscription, scimageurl);
                recyclerViewProductSubCategoryList.add(productSubCategory);
            }

        } catch (JSONException e) {
            Log.e("Parse to JSONObject", e.getMessage());
        }
    }

    public void sendRequest() {
        contract.sendRequest(id, api_key, user_id);
    }

}
