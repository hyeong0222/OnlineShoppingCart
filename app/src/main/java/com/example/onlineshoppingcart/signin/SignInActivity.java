package com.example.onlineshoppingcart.signin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineshoppingcart.R;
import com.example.onlineshoppingcart.forgotpassword.ForgotPasswordActivity;
import com.example.onlineshoppingcart.resetpassword.ResetPasswordActivity;
import com.example.onlineshoppingcart.mainview.MainActivity;
import com.example.onlineshoppingcart.signup.SignUpActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInActivity extends AppCompatActivity implements SignInContract.View {

    Toolbar toolbar;
    EditText mobileEditText, passwordEditText;
    Button signInButton;
    TextView forgotPasswordTextView, resetPasswordTextView, signUpTextView;
    SignInContract.Presenter contract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        contract = new SignInPresenter(this);

        toolbar = findViewById(R.id.signInToolbar);
        mobileEditText = findViewById(R.id.signInMobile);
        passwordEditText = findViewById(R.id.signInPassword);
        signInButton = findViewById(R.id.signInButton);
        forgotPasswordTextView = findViewById(R.id.signInForgotPassword);
        resetPasswordTextView = findViewById(R.id.signInResetPassword);
        signUpTextView = findViewById(R.id.signInCreateAnAccount);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        resetPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void getResponse(JSONArray response) {
        try {
            JSONObject object = response.getJSONObject(0);
            if (object.has("msg") && object.getString("msg").equals("success")){
                Toast.makeText(this, "Welcome Back", Toast.LENGTH_LONG).show();
                Intent intent = new Intent (SignInActivity.this, MainActivity.class);
                intent.putExtra("id", object.getString("id"));
                intent.putExtra("firstname", object.getString("firstname"));
                intent.putExtra("lastname", object.getString("lastname"));
                intent.putExtra("email", object.getString("email"));
                intent.putExtra("mobile", object.getString("mobile"));
                intent.putExtra("appapikey", object.getString("appapikey "));

                startActivity(intent);
            }
        } catch (JSONException e) {
            Log.e("Parse to JSONObject", e.getMessage());
        }
    }

    public void signInClickHandler(View view) {
        contract.setLogin(mobileEditText.getText().toString(), passwordEditText.getText().toString());
    }
}
