package com.example.listviewdemo43;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

    EditText etName, etPhone,etAddress;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        btnSave = findViewById(R.id.btnSave);

        Intent intent = getIntent();
        int number = intent.getIntExtra("number",2222);

        etName.setText(number + "");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =etName.getText().toString();
                String address=etAddress.getText().toString();

                Intent intent =new Intent();
                intent.putExtra("key_name",name);
                intent.putExtra("key_address",address);

                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}