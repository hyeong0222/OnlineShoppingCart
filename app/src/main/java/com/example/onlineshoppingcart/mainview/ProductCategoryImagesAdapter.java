package com.example.onlineshoppingcart.mainview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlineshoppingcart.R;
import com.example.onlineshoppingcart.productcategory.ItemClickListener;
import com.example.onlineshoppingcart.productsubcategory.ProductSubCategoryActivity;
import com.example.onlineshoppingcart.productsubcategory.ProductSubCategoryFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductCategoryImagesAdapter extends RecyclerView.Adapter<ProductCategoryImagesAdapter.MyViewHolder> {

    private ItemClickListener clickListener;
    List<ProductCategory> recyclerViewImageList;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor preferencesEditor;
    String api_key;
    Context context;


    public ProductCategoryImagesAdapter(List<ProductCategory> recyclerViewImageList, Context context) {
        this.recyclerViewImageList = recyclerViewImageList;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferencesEditor = sharedPreferences.edit();
        this.api_key = sharedPreferences.getString("api_key", null);
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_product_category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        ProductCategory category = recyclerViewImageList.get(i);

//        String cname = category.getCname();
        String images = category.getCimagerl();
        myViewHolder.textViewProductCategory.setText("Hello");
        Picasso.get().load(images).fit().into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return recyclerViewImageList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textViewProductCategory;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.imageView);
            textViewProductCategory = itemView.findViewById(R.id.textViewRecyclerViewProductCategory);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            ProductCategory element = recyclerViewImageList.get(itemPosition);

            if (element.cname.equals("Electronics")) {
                Intent intent = new Intent(context, ProductSubCategoryActivity.class);
                intent.putExtra("cid", "107");
                context.startActivity(intent);
            }
            else if (element.cname.equals("Clothes")) {
                Intent intent = new Intent(context, ProductSubCategoryActivity.class);
                intent.putExtra("cid", "108");
                context.startActivity(intent);
            }
            else if (element.cname.equals("Jewellery")) {
                Intent intent = new Intent(context, ProductSubCategoryActivity.class);
                intent.putExtra("cid", "109");
                context.startActivity(intent);
            }
            else if (element.cname.equals("Shoes")) {
                Intent intent = new Intent(context, ProductSubCategoryActivity.class);
                intent.putExtra("cid", "111");
                context.startActivity(intent);
            }
            else if (element.cname.equals("Mobile Phones")) {
                Intent intent = new Intent(context, ProductSubCategoryActivity.class);
                intent.putExtra("cid", "112");
                context.startActivity(intent);
            }
            else if (element.cname.equals("Fashion")) {
                Intent intent = new Intent(context, ProductSubCategoryActivity.class);
                intent.putExtra("cid", "113");
                context.startActivity(intent);
            }
            else if (element.cname.equals("home appliances")) {
                Intent intent = new Intent(context, ProductSubCategoryActivity.class);
                intent.putExtra("cid", "114");
                context.startActivity(intent);
            }
            else if (element.cname.equals("Personal Care")) {
                Intent intent = new Intent(context, ProductSubCategoryActivity.class);
                intent.putExtra("cid", "115");
                context.startActivity(intent);
            }
        }
    }
}
