package com.example.onlineshoppingcart.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineshoppingcart.R;
import com.example.onlineshoppingcart.signin.SignInActivity;

public class SignUpActivity extends AppCompatActivity implements SignUpContract.View {

    Toolbar toolbar;
    EditText fNameEditText, lNameEditText, emailEditText, passwordEditText, mobileEditText, addressEditText;
    SignUpContract.Presenter contract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        contract = new SignUpPresenter(this);

        toolbar = findViewById(R.id.toolbarCreateAWalmartAccount);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            }
        });

        fNameEditText = findViewById(R.id.signUpFName);
        lNameEditText = findViewById(R.id.signUpLName);
        emailEditText = findViewById(R.id.signUpEmail);
        mobileEditText = findViewById(R.id.signUpMobile);
        passwordEditText = findViewById(R.id.signUpPassword);
        addressEditText = findViewById(R.id.signUpAddress);
    }


    @Override
    public void getResponse(String response) {
        if (response.equals("successfully registered")){
            Toast.makeText(this, "Account Created", Toast.LENGTH_LONG).show();
            Intent intent  = new Intent(SignUpActivity.this, SignInActivity.class);
            startActivity(intent);
        }
        else Toast.makeText(this, response, Toast.LENGTH_LONG).show();

    }

    public void signUpClickHandler(View view) {
        contract.setAccount(fNameEditText.getText().toString(), lNameEditText.getText().toString(),
                emailEditText.getText().toString(), passwordEditText.getText().toString(),
                mobileEditText.getText().toString(), addressEditText.getText().toString());
    }
}
