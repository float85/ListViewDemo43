package com.example.listviewdemo43;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    ContactBook contactBook1, contactBook2, contactBook3, contactBook4, contactBook;
    List<ContactBook> contactBookList;

    View btnAdd;
    int _position;
    AdapterContactBook adapterContactBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = findViewById(R.id.lvContact);
        btnAdd = findViewById(R.id.btnAdd);

        contactBookList = new ArrayList<>();

        contactBook = new ContactBook("Android 43", "Dịch Vọng", "0902789789", true);
        contactBook1 = new ContactBook("Lập trình", "Hà Nội", "0911111111", false);
        contactBook2 = new ContactBook("Thiết Kế", "Hồ Chí Minh", "090222222222", true);
        contactBook3 = new ContactBook("Đi học", "Bắc Ninh", "09044444444", false);
        contactBook4 = new ContactBook("học online", "Thái Nguyên", "09025555", true);

        contactBookList.add(contactBook);
        contactBookList.add(contactBook1);
        contactBookList.add(contactBook2);
        contactBookList.add(contactBook3);
        contactBookList.add(contactBook4);

        adapterContactBook = new AdapterContactBook(contactBookList);
        lvContact.setAdapter(adapterContactBook);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddContactActivity.class);
                intent.putExtra("number", 904);
//                  startActivity(intent);// chuyển sang activity khác
                startActivityForResult(intent, 113);
            }
        });


        //câu lệnh bắt sự kiện click trên adapter
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ContactBook contactBook = contactBookList.get(position);
                _position = position;

                Intent intent = new Intent(getBaseContext(), AddContactActivity.class);
                intent.putExtra("number", 904);
                startActivityForResult(intent, 115);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String name = data.getStringExtra("key_name");
        String address = data.getStringExtra("key_address");
        switch (resultCode) {
            case RESULT_OK:
                if (requestCode == 113) {
                    ContactBook contactBook = new ContactBook(name, address, 7781 + "", true);
                    contactBookList.add(contactBook);
                    adapterContactBook.notifyDataSetChanged();
                } else if (requestCode == 115) {
                    contactBookList.set(_position, new ContactBook(name, address, "", true));
                    adapterContactBook.notifyDataSetChanged();
                }
                break;
        }
    }
}