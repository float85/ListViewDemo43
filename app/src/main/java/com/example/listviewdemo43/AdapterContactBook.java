package com.example.listviewdemo43;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterContactBook extends BaseAdapter {
    List<ContactBook> contactBookList;

    public AdapterContactBook(List<ContactBook> contactBookList) {
        this.contactBookList = contactBookList;
    }

    @Override
    public int getCount() {
        return contactBookList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactBookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_contactbook, parent, false);

        TextView tvName, tvAddress, tvNumberPhone;
        ImageView imageView;

        tvName = view.findViewById(R.id.tvName);
        tvAddress = view.findViewById(R.id.tvAddress);
        tvNumberPhone = view.findViewById(R.id.tvNumber);
        imageView = view.findViewById(R.id.imgPhoneNumber);

        ContactBook contactBook = contactBookList.get(position);

        tvName.setText(contactBook.getName());
        tvAddress.setText(contactBook.getAddress());
        tvNumberPhone.setText(contactBook.getNumberPhone());

        if (contactBook.isBlImgView()) imageView.setVisibility(View.VISIBLE);
        else imageView.setVisibility(View.GONE);

        return view;
    }
}
