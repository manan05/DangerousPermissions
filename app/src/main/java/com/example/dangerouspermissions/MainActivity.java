package com.example.dangerouspermissions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                String telNo = etPhNo.getText().toString();
                Uri uri = Uri.parse("tel:" + telNo);
                Intent i = new Intent(Intent.ACTION_CALL,uri);
                // We can also write ACTION_VIEW but that will just make the dialer open
                // This will directly make the call
                //But it will show an error that we do not have the permission
                //When clearly we do
                //This is because CALL is a dangerous permission
                startActivity(i);
            }
        });
    }
}
