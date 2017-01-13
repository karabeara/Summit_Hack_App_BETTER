package com.example.karabressler.summit_hack_app_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.requestclients.NessieClient;

import java.util.List;

public class PayItForwardActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_it_forward);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        String loginString = extras.getString("SETUP");

    String[] myStringArray;
    ArrayAdapter<String> adapter;

    ListView list;

    public static final String EXTRA_ID = "com.example.myfirstapp.MESSAGE";

    Integer[] imageId = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
    };


    @Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.landing_page);

            NessieClient client = NessieClient.getInstance("7a7490a0996b5b7d04f1c7315804c6fd");

            //client.CUSTOMER.

            Button update_button = (Button) findViewById(R.id.loginButton);

            update_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(PayItForwardActivity.this, UpdateProfileActivity.class);
                    startActivity(intent);
                }
            });


                client.CUSTOMER.getCustomers(new NessieResultsListener() {
                @Override
                public void onSuccess(Object result) {
                    List<Customer> customers = (List<Customer>) result;
                    myStringArray = new String[5];

                    for (int i = 0; i < 4; i++) {
                        myStringArray[i] = customers.get(i).getFirstName();

                    }

                    //adapter.notifyDataSetChanged();
                    //adapter = new ArrayAdapter<String>(MainActivity.this,
                    //android.R.layout.simple_list_item_1, myStringArray);

                    CustomList adapter = new
                            CustomList(LandingPageActivity.this, myStringArray, imageId);
                    //list=(ListView)findViewById(R.id.list);

                    ListView listView = (ListView) findViewById(R.id.list_view);
                    listView.setAdapter(adapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {
                            Toast.makeText(LandingPageActivity.this, "You Clicked at " + myStringArray[+position], Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LandingPageActivity.this, PayItForwardActivity.class);

                            String message = "12124";
                            intent.putExtra(EXTRA_ID, message);
                            startActivity(intent);
                        }
                    });


                }

                @Override
                public void onFailure(NessieError error) {
                    Context context = getApplicationContext();
                    CharSequence text = "no way";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            });


        }

    }
}
