package com.example.books;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MYAdapter extends RecyclerView.Adapter<MYAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<BookProperty> ListBook;

    public MYAdapter(Context context, ArrayList<BookProperty> ListBook) {
        this.context = context;
        this.ListBook = ListBook;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.itemcontent,parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv1.setText(ListBook.get(position).getBook_name());
        holder.tv2.setText(ListBook.get(position).getAuthor());
        holder.tv3.setText(ListBook.get(position).getPages());
        //holder.rg.setOnCheckedChangeListener(ListBook);


    }

    @Override
    public int getItemCount() {
        return ListBook.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        private RadioGroup rg;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=(TextView) itemView.findViewById(R.id.text1);
            tv2=(TextView) itemView.findViewById(R.id.text2);
            tv3=(TextView) itemView.findViewById(R.id.page);
            rg=(RadioGroup) itemView.findViewById(R.id.rdGroup);

        }
        }
    }

