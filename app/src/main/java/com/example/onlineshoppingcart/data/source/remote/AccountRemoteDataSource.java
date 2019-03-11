package com.example.onlineshoppingcart.data.source.remote;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.onlineshoppingcart.data.Account;
import com.example.onlineshoppingcart.AppController;
import com.example.onlineshoppingcart.data.Product;
import com.example.onlineshoppingcart.data.source.AccountDataSource;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AccountRemoteDataSource implements AccountDataSource.Presenter {

    private String tag_json_obj = "json_obj_req";
    private String tag_json_arry = "json_array_req";
    private String tag_string_req = "string_req";

    public AccountRemoteDataSource() {
    }


    @Override
    public void signUp(Account account, final AccountDataSource.ServerStringCallBack callBack) {

        String urlSignUp = "http://rjtmobile.com/aamir/e-commerce/android-app/shop_reg.php?" +
                "fname=" + account.getFname() +
                "&lname=" + account.getLname() +
                "&address=" + account.getAddress() +
                "&email=" + account.getEmail() +
                "&mobile=" + account.getMobile() +
                "&password=" + account.getPassword();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlSignUp, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Sign Up", response);
                callBack.getServerCallBack(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Sign Up", error.toString());
            }
        });

        AppController.getInstance().addToRequestQueue(stringRequest, tag_string_req);
    }


    @Override
    public void signIn(final Account account, final AccountDataSource.ServerArrayCallBack callBack) {

        final String urlSignIn = "http://rjtmobile.com/aamir/e-commerce/android-app/shop_login.php?" +
                "mobile=" + account.getMobile() +
                "&password=" + account.getPassword();

//        final String urlSignIn = "http://rjtmobile.com/aamir/e-commerce/android-app/shop_login.php";

        JsonArrayRequest request = new JsonArrayRequest(urlSignIn, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Sign In", response.toString());
                callBack.getServerCallBack(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Sign In", error.getMessage());
            }
        });
//        {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("mobile", account.getMobile());
//                params.put("password", account.getPassword());
//
//                return params;
//            }
//        };

        AppController.getInstance().addToRequestQueue(request, tag_json_arry);
    }


    @Override
    public void updateProfile(Account account, final AccountDataSource.ServerStringCallBack callBack) {

        String urlUpdateProfile = "http://rjtmobile.com/aamir/e-commerce/android-app/edit_profile.php?" +
                "fname=" + account.getFname() +
                "&lname=" + account.getLname() +
                "&address=" + account.getAddress() +
                "&email=" + account.getEmail() +
                "&mobile=" + account.getMobile();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlUpdateProfile, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Update Profile", response);
                callBack.getServerCallBack(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Update Profile", error.toString());
            }
        });

        AppController.getInstance().addToRequestQueue(stringRequest, tag_string_req);
    }


    @Override
    public void resetPassword(Account account, final AccountDataSource.ServerObjectCallBack callBack) {

        String urlResetPassword = "http://rjtmobile.com/aamir/e-commerce/android-app/shop_reset_pass.php?" +
                "mobile=" + account.getMobile() +
                "&password=" + account.getPassword() +
                "&newpassword=" + account.getNewPassword();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlResetPassword, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Reset Password", response.toString());
                callBack.getServerCallBack(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Reset Password", error.getMessage());
            }
        });


        AppController.getInstance().addToRequestQueue(request, tag_json_arry);
    }

    @Override
    public void sendRequest(Account account, final AccountDataSource.ServerStringCallBack callBack) {

        String urlSendRequest = "http://rjtmobile.com/aamir/e-commerce/android-app/forgot_pass_email.php?" +
                "email=" + account.getEmail();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlSendRequest, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Update Profile", response);
                callBack.getServerCallBack(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Update Profile", error.toString());
            }
        });

        AppController.getInstance().addToRequestQueue(stringRequest, tag_string_req);
    }


    @Override
    public void productCategory(Product product, final AccountDataSource.ServerObjectCallBack callBack) {

        String urlProductCategory = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_category.php?" +
                "api_key=" + product.getApi_key() +
                "&user_id=" + product.getId();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlProductCategory, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Product Category", response.toString());
                callBack.getServerCallBack(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Product Category", error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(request, tag_json_arry);
    }


    @Override
    public void productSubCategory(Product product, final AccountDataSource.ServerObjectCallBack callBack) {

        String urlProductSubCategory = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_sub_category.php?" +
                "Id=" + product.getId() +
                "&api_key=" + product.getApi_key() +
                "&user_id=" + product.getUser_id();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlProductSubCategory, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Product SubCategory", response.toString());
                callBack.getServerCallBack(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Product SubCategory", error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(request, tag_json_obj);
    }


    @Override
    public void productList(Product product, final AccountDataSource.ServerObjectCallBack callBack) {

        String urlProductList = "http://rjtmobile.com/ansari/shopingcart/androidapp/product_details.php?" +
                "cid=" + product.getCid() +
                "&scid=" + product.getScid() +
                "&api_key=" + product.getApi_key() +
                "&user_id=" + product.getUser_id();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlProductList, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Product List", response.toString());
                callBack.getServerCallBack(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Product List", error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(request, tag_json_obj);
    }
}
