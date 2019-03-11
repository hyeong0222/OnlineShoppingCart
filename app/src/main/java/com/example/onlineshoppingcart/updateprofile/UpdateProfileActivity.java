package com.example.onlineshoppingcart.updateprofile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.example.onlineshoppingcart.R;
import com.example.onlineshoppingcart.signin.SignInActivity;

public class UpdateProfileActivity extends AppCompatActivity implements UpdateProfileContract.View {

    Toolbar toolbar;
    EditText fNameEditText, lNameEditText, emailEditText, mobileEditText, addressEditText;
    Button button;
    UpdateProfileContract.Presenter contract;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        contract = new UpdateProfilePresenter(this);

        fNameEditText = findViewById(R.id.editTextFName);
        lNameEditText = findViewById(R.id.editTextLName);
        emailEditText = findViewById(R.id.signInMobile);
        mobileEditText = findViewById(R.id.editTextFName);
        addressEditText = findViewById(R.id.editTextAddress);
        button = findViewById(R.id.forgotPasswordButton);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            }
        });
    }

    @Override
    public void getResponse(String response) {

    }

    public void updateClickHandler(View view) {
        contract.updateProfile(fNameEditText.getText().toString(),
                lNameEditText.getText().toString(),
                emailEditText.getText().toString(),
                mobileEditText.getText().toString(),
                addressEditText.getText().toString());
    }
}
