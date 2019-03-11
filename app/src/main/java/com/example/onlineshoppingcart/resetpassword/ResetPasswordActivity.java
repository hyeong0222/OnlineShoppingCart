package com.example.onlineshoppingcart.resetpassword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineshoppingcart.R;
import com.example.onlineshoppingcart.signin.SignInActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResetPasswordActivity extends AppCompatActivity implements ResetPasswordContract.View {

    Toolbar toolbar;
    EditText mobileEditText, currentPasswordEditText, newPasswordEditText;
    Button button;
    ResetPasswordContract.Presenter contract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        contract = new ResetPasswordPresenter(this);

        toolbar = findViewById(R.id.resetPasswordToolbar);
        mobileEditText = findViewById(R.id.resetPasswordMobile);
        currentPasswordEditText = findViewById(R.id.resetPasswordMobileCurrentPassword);
        newPasswordEditText = findViewById(R.id.resetPasswordMobileNewPassword);
        button = findViewById(R.id.resetPasswordButton);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            }
        });
    }

    @Override
    public void getResponse(JSONObject response) {
        Toast.makeText(this, "Password reset successfully", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(ResetPasswordActivity.this, SignInActivity.class);
        startActivity(intent);
    }

    public void resetClickHandler(View view) {
        contract.setPassword(mobileEditText.getText().toString(),
                currentPasswordEditText.getText().toString(),
                newPasswordEditText.getText().toString());
    }
}
