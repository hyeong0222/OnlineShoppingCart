package com.example.onlineshoppingcart.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.onlineshoppingcart.R;
import com.simplify.android.sdk.CardEditor;
import com.simplify.android.sdk.CardToken;
import com.simplify.android.sdk.Simplify;

public class PaymentActivity extends AppCompatActivity {

    Simplify simplify;
    CardEditor cardEditor;
    Toolbar toolbar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        cardEditor = findViewById(R.id.card_editor);
        toolbar = findViewById(R.id.toolbarPayment);
        button = findViewById(R.id.buttonSubmit);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        simplify = new Simplify();
        simplify.setApiKey("sbpb_OGJmN2I3ZTgtZTMxMi00Y2ViLThmYjQtZDBlZjVmOTY1MjRi");

        cardEditor.addOnStateChangedListener(new CardEditor.OnStateChangedListener() {
            @Override
            public void onStateChange(CardEditor cardEditor) {
                button.setEnabled(cardEditor.isValid());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simplify.createCardToken(cardEditor.getCard(), new CardToken.Callback() {
                    @Override
                    public void onSuccess(CardToken cardToken) {
                        Toast.makeText(PaymentActivity.this, "Payment Successful", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Toast.makeText(PaymentActivity.this, "Payment Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
