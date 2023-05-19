package com.example.checkyourriskscore;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView attributeView,attributeValView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        attributeView = itemView.findViewById(R.id.attribute);
        attributeValView = itemView.findViewById(R.id.attributeVal);
    }
}
