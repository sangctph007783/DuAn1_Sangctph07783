package com.example.DuAn1_SangCtph07783.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.DuAn1_SangCtph07783.R;
import com.example.DuAn1_SangCtph07783.activity.ActInformation;
import com.example.DuAn1_SangCtph07783.database.SachTruyenSqlite;
import com.example.DuAn1_SangCtph07783.moder.YeuThich;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class YeuThichAdapter extends RecyclerView.Adapter<YeuThichAdapter.MyRecycleview> {
    private SachTruyenSqlite sachTruyenSqlite;
    private Context mContext;
    private List<YeuThich> yeuThichList;


    public YeuThichAdapter(Context mContext, List<YeuThich> yeuThichList) {
        this.mContext = mContext;
        this.yeuThichList = yeuThichList;
    }

    @NonNull
    @Override
    public MyRecycleview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        final LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.row_list_yeuthich, parent, false);
        return new MyRecycleview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleview holder, final int position) {

        YeuThich yeuThich = yeuThichList.get(position);
        holder.tv_Name.setText(yeuThichList.get(position).getNameSach());
        Picasso.with(mContext).load(yeuThich.anh).into(holder.anh);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                            Intent intent = new Intent(mContext, ActInformation.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("i", String.valueOf(yeuThichList.get(position).idName));
                            intent.putExtra("TT", bundle);
                            mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return yeuThichList.size();
    }

    public class MyRecycleview extends RecyclerView.ViewHolder {
        TextView tv_Name;
        ImageView anh;


        public MyRecycleview(@NonNull View itemView) {
            super(itemView);
            anh = (ImageView) itemView.findViewById(R.id.imgAvataSach);
            tv_Name = (TextView) itemView.findViewById(R.id.tvNamesach);


        }
    }

}