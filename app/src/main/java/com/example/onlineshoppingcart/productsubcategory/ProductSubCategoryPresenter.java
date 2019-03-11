package com.example.onlineshoppingcart.productsubcategory;

import com.example.onlineshoppingcart.data.Product;
import com.example.onlineshoppingcart.data.source.AccountDataSource;
import com.example.onlineshoppingcart.data.source.AccountRepository;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProductSubCategoryPresenter implements ProductSubCategoryContract.Presenter, AccountDataSource.ServerObjectCallBack {

    AccountDataSource.Presenter mAccountRepository;
    ProductSubCategoryContract.View view;

    public ProductSubCategoryPresenter(ProductSubCategoryContract.View view) {
        this.view = view;
        mAccountRepository = new AccountRepository();
    }

    @Override
    public void getServerCallBack(JSONObject response) {
        view.getResponse(response);
    }

    @Override
    public void sendRequest(String id, String api_key, String user_id) {
        Product product = new Product(id, api_key, user_id);
        mAccountRepository.productSubCategory(product, this);
    }
}