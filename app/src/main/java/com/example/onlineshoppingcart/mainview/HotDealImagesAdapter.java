package com.example.onlineshoppingcart.mainview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlineshoppingcart.R;
import com.example.onlineshoppingcart.signin.SignInActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HotDealImagesAdapter extends RecyclerView.Adapter<HotDealImagesAdapter.MyViewHolder> {

    List<String> recyclerViewImageList;

    public HotDealImagesAdapter(List<String> recyclerViewImageList) {
        this.recyclerViewImageList = recyclerViewImageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_hot_deal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String images = recyclerViewImageList.get(i);
        Picasso.get().load(images).fit().into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return recyclerViewImageList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textViewDeal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewDeal = imageView.findViewById(R.id.textViewDeal);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent (context, SignInActivity.class);
            context.startActivity(intent);
        }
    }
}
