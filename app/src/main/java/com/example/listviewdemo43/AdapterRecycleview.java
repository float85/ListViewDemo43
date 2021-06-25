package com.example.listviewdemo43;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRecycleview extends RecyclerView.Adapter<AdapterRecycleview.ViewHoder> {

    List<ContactBook> contactBookList;

    public AdapterRecycleview(List<ContactBook> contactBookList) {
        this.contactBookList = contactBookList;
    }

    @NonNull
    @Override
    public AdapterRecycleview.ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recycleview, parent, false);
        ViewHoder viewHoder = new ViewHoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycleview.ViewHoder holder, int position) {
        ContactBook contactBook = contactBookList.get(position);

        holder.tvAddress.setText(contactBook.getAddress());
        holder.tvName.setText(contactBook.getName());
        holder.tvPhone.setText(contactBook.getNumberPhone());
    }

    @Override
    public int getItemCount() {
        return contactBookList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView tvName, tvPhone, tvAddress;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            tvAddress = itemView.findViewById(R.id.tvAddressRec);
            tvName = itemView.findViewById(R.id.tvAddressRec);
            tvPhone = itemView.findViewById(R.id.tvAddressRec);
        }
    }
}
