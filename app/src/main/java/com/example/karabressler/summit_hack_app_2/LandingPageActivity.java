package com.example.karabressler.summit_hack_app_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LandingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        Button login_button  = (Button) findViewById(R.id.loginButton);
        Button setup_button = (Button) findViewById(R.id.loginButton);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LandingPageActivity.this, "hello this is toast", Toast.LENGTH_LONG).show();

                String loginText = "userID";

                Intent intent = new Intent(LandingPageActivity.this, UpdateProfileActivity.class);
                intent.putExtra("LOGIN", loginText);
                startActivity(intent);
            }
        });

        setup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String editTextInput = editText.getText().toString();

                String setupText = "This is setup data!";

                Intent intent = new Intent(LandingPageActivity.this, UpdateProfileActivity.class);
                intent.putExtra("SETUP", setupText);
                startActivity(intent);
            }

        });




    }
}
