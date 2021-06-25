package com.example.listviewdemo43;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewDemo extends AppCompatActivity {
    ContactBook contactBook1, contactBook2, contactBook3, contactBook4, contactBook;
    List<ContactBook> contactBookList;

    RecyclerView recyclerView;
    AdapterRecycleview adapterRecycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_demo);
        recyclerView = findViewById(R.id.lvRecyclerview);

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

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3,RecyclerView.HORIZONTAL,false);
        AdapterRecycleview adapterRecycleview = new AdapterRecycleview(contactBookList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterRecycleview);
    }
}