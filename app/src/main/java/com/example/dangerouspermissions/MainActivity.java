package com.example.dangerouspermissions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etPhNo;
    Button btnDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPhNo = findViewById(R.id.etPhNo);
        btnDial = findViewById(R.id.btnDial);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if we have the permission
                int perm = ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE);
                if(perm == PackageManager.PERMISSION_GRANTED){
                    callNumber();
                }
                else{
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{
                                    Manifest.permission.CALL_PHONE},
                            121);
                            }};
                });
        }


    void callNumber(){
        String telNo = etPhNo.getText().toString();
        Uri uri = Uri.parse("tel:" + telNo);
        Intent i = new Intent(Intent.ACTION_CALL,uri);

        // We can also write ACTION_VIEW but that will just make the dialer open
        // This will directly make the call
        //But it will crash the app and logcat shows an error that we do not have the permission
        //When clearly we do
        //This is because CALL is a dangerous permission

        startActivity(i);
    }
}

