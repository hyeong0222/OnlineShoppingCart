package com.example.onlineshoppingcart.productcategory;

import com.example.onlineshoppingcart.data.Product;
import com.example.onlineshoppingcart.data.source.AccountDataSource;
import com.example.onlineshoppingcart.data.source.AccountRepository;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProductCategoryPresenter implements ProductCategoryContract.Presenter, AccountDataSource.ServerObjectCallBack {

    AccountDataSource.Presenter mAccountRepository;
    ProductCategoryContract.View view;

    public ProductCategoryPresenter(ProductCategoryContract.View view) {
        this.view = view;
        mAccountRepository = new AccountRepository();
    }

    @Override
    public void getServerCallBack(JSONObject response) {
        view.getResponse(response);
    }

    @Override
    public void sendRequest(String api_key, String id) {
        Product product = new Product(api_key, id);
        mAccountRepository.productCategory(product, this);
    }
}