package com.example.karabressler.summit_hack_app_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.reimaginebanking.api.nessieandroidsdk.requestclients.NessieClient;

/**
 * Created by karabressler on 1/12/17.
 */

public class UpdateProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_profile);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        Button pay_button = (Button) findViewById(R.id.loginButton);

        pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(UpdateProfileActivity.this, PayItForwardActivity.class);
                startActivity(intent);
            }
        });

        String idString = extras.getString("userID");

        NessieClient client = NessieClient.getInstance("7a7490a0996b5b7d04f1c7315804c6fd");

        //client.ACCOUNT.get();




    }
}
