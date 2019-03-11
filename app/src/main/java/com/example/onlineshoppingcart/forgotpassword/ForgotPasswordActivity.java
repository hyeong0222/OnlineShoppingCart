package com.example.onlineshoppingcart.forgotpassword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineshoppingcart.R;
import com.example.onlineshoppingcart.signin.SignInActivity;

public class ForgotPasswordActivity extends AppCompatActivity implements ForgotPasswordContract.View {

    Toolbar toolbar;
    EditText emailEditText;
    ForgotPasswordContract.Presenter contract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        contract = new ForgotPasswordPresenter(this);

        emailEditText = findViewById(R.id.forgotPasswordEmail);
        toolbar = findViewById(R.id.forgotPasswordToolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            }
        });
    }

    public void sendClickHandler(View view) {
        contract.sendRequest(emailEditText.getText().toString());
    }

    @Override
    public void getResponse(String response) {
        Toast.makeText(this, "An email with a link has been sent", Toast.LENGTH_LONG).show();
    }
}
