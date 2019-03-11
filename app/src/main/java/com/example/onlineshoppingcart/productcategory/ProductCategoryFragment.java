package com.example.onlineshoppingcart.productcategory;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlineshoppingcart.R;
import com.example.onlineshoppingcart.mainview.HotDealImagesAdapter;
import com.example.onlineshoppingcart.mainview.ProductCategory;
import com.example.onlineshoppingcart.mainview.ProductCategoryImagesAdapter;
import com.example.onlineshoppingcart.mainview.ProductCategoryImagesAdapterTemp;
import com.example.onlineshoppingcart.mainview.ProductSubCategory;
import com.example.onlineshoppingcart.productsubcategory.ProductSubCategoryActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductCategoryFragment extends Fragment implements ProductCategoryContract.View {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor preferencesEditor;
    private String sharedPrefFile = "com.example.onlineshoppingcart";


    RecyclerView hotDealRecyclerView, productCategoryRecyclerView;
    HotDealImagesAdapter hotDealAdapter;
    ProductCategoryImagesAdapterTemp productCategoryAdapterTemp;
    ProductCategoryImagesAdapter productCategoryAdapter;
    ProductCategoryContract.Presenter contract;

    String user_id, fname, lname, email, mobile, api_key;


    List<String> recyclerViewHotDealImageList = new ArrayList<>();
    List<String> recyclerViewProductCategoryListTemp = new ArrayList<>();
    List<ProductCategory> recyclerViewProductCategoryList = new ArrayList<>();

    public ProductCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_product_category, container, false);

        contract = new ProductCategoryPresenter(this);

        hotDealRecyclerView = view.findViewById(R.id.recyclerViewHotDeal);
        productCategoryRecyclerView = view.findViewById(R.id.recyclerViewProductCategory);

        recyclerViewHotDealImageList.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/product_images/images.jpg");
        recyclerViewHotDealImageList.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/product_images/mylaptop1.jpg");
        recyclerViewHotDealImageList.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/product_images/dell_laptop.jpg");
        recyclerViewHotDealImageList.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/product_images/lenovo-lap.png");
        recyclerViewHotDealImageList.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/product_images/acer-lap.png");

        hotDealAdapter = new HotDealImagesAdapter(recyclerViewHotDealImageList);
        RecyclerView.LayoutManager layoutManagerHorizontal = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        hotDealRecyclerView.setLayoutManager(layoutManagerHorizontal);
        hotDealRecyclerView.setAdapter(hotDealAdapter);

        recyclerViewProductCategoryListTemp.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/category_images/clothes.jpg");
        recyclerViewProductCategoryListTemp.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/category_images/shoes.jpg");
        recyclerViewProductCategoryListTemp.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/category_images/personal_care.png");
        recyclerViewProductCategoryListTemp.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/category_images/images.jpg");
        recyclerViewProductCategoryListTemp.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/category_images/jewellery.jpg");
        recyclerViewProductCategoryListTemp.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/category_images/fashion.png");
        recyclerViewProductCategoryListTemp.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/category_images/home.png");
        recyclerViewProductCategoryListTemp.add("https://rjtmobile.com/ansari/shopingcart/admin/uploads/category_images/mob_phones.jpg");

        sharedPreferences = this.getActivity().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);

        String api = sharedPreferences.getString("api_key", null);
        System.out.println(api);
        if (api == null) {
            productCategoryAdapterTemp = new ProductCategoryImagesAdapterTemp(recyclerViewProductCategoryListTemp);
            RecyclerView.LayoutManager layoutManagerGrid = new GridLayoutManager(getContext(), 2);
            productCategoryRecyclerView.setLayoutManager(layoutManagerGrid);
            productCategoryRecyclerView.setAdapter(productCategoryAdapterTemp);
        }
        else {
            this.user_id = sharedPreferences.getString("user_id", null);
            this.api_key = sharedPreferences.getString("api_key", null);

            sendRequest();

            productCategoryAdapter = new ProductCategoryImagesAdapter(recyclerViewProductCategoryList, getContext());
            RecyclerView.LayoutManager layoutManagerGrid = new GridLayoutManager(getContext(), 2);
            productCategoryRecyclerView.setLayoutManager(layoutManagerGrid);
            productCategoryRecyclerView.setAdapter(productCategoryAdapter);
        }

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void getResponse(JSONObject response) {
        try{
            JSONArray jsonArray = response.getJSONArray("category");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String cid = jsonObject.getString("cid");
                String cname = jsonObject.getString("cname");
                String cdiscription = jsonObject.getString("cdiscription");
                String cimagerl = jsonObject.getString("cimagerl");

                ProductCategory productCategory = new ProductCategory(cid, cname, cdiscription, cimagerl);
                recyclerViewProductCategoryList.add(productCategory);
            }
        } catch (JSONException e) {
            Log.e("Parse to JSONObject", e.getMessage());
        }
    }
    public void sendRequest() { contract.sendRequest(api_key, user_id);}

//    @Override
//    public void onClick(View view, int position) {
//        Intent intent = new Intent(getActivity(), ProductSubCategoryActivity.class);
//        startActivity(intent);
//    }
}
