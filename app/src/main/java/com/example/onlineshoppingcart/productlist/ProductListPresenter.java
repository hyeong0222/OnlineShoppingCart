package com.example.onlineshoppingcart.productlist;

import com.example.onlineshoppingcart.data.Product;
import com.example.onlineshoppingcart.data.source.AccountDataSource;
import com.example.onlineshoppingcart.data.source.AccountRepository;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProductListPresenter implements ProductListContract.Presenter, AccountDataSource.ServerObjectCallBack {

    AccountDataSource.Presenter mAccountRepository;
    ProductListContract.View view;

    public ProductListPresenter(ProductListContract.View view) {
        this.view = view;
        mAccountRepository = new AccountRepository();
    }

    @Override
    public void getServerCallBack(JSONObject response) {
        view.getResponse(response);
    }

    @Override
    public void sendRequest(String cid, String scid, String api_key, String user_id) {
        Product product = new Product(cid, scid, api_key, user_id);
        mAccountRepository.productList(product, this);
    }
}
