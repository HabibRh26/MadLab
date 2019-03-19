package com.example.labwork_18march;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinner ;
    EditText edtMsg,edtEmail,edtDial;
    private int currentItem =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner_id);
        edtMsg = findViewById(R.id.txtVwMsg);
        edtEmail = findViewById(R.id.txtVwEmail);
        edtDial = findViewById(R.id.txtVwDial);

        String selected_item = String.valueOf(spinner.getSelectedItem());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){


                    item_1_Method();
                }
                else if(position ==2){
                    item_2_Method();
                }
                else if(position ==3){
                    item_3_Method();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void item_3_Method() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String dialno = edtDial.getText().toString();
        intent.setData(Uri.parse("tel:"+dialno));
        startActivity(intent);
    }

    private void item_2_Method() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String mailList[] = {"remondc26@gmail.com","emon.zobaer@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL,mailList);
        String subject = edtEmail.getText().toString();
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,"THIS IS EXTRA TEXT");
        intent.setType("message/rfc822");
        Intent chooser = Intent.createChooser(intent,"send Email");
        startActivity(chooser);
    }

    private void item_1_Method() {
        String msgValue = edtMsg.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra("address",msgValue);
        intent.putExtra("sms body","Todays class is cancelled");
        intent.setType("vnd.android-dir/mms-sms");
        startActivity(intent);
    }

}

