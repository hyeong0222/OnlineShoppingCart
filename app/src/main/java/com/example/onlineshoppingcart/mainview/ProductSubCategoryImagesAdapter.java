package com.example.onlineshoppingcart.mainview;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlineshoppingcart.R;
import com.example.onlineshoppingcart.productcategory.ItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductSubCategoryImagesAdapter extends RecyclerView.Adapter<ProductSubCategoryImagesAdapter.MyViewHolder> {

    List<ProductSubCategory> recyclerViewImageList;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor preferencesEditor;
    String id;

    public ProductSubCategoryImagesAdapter(List<ProductSubCategory> recyclerViewImageList, Context context) {
        this.recyclerViewImageList = recyclerViewImageList;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferencesEditor = sharedPreferences.edit();
        this.id = sharedPreferences.getString("cid", null);
    }

    @NonNull
    @Override
    public ProductSubCategoryImagesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_product_category, parent, false);
        return new ProductSubCategoryImagesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSubCategoryImagesAdapter.MyViewHolder myViewHolder, int i) {
        ProductSubCategory subCategory = recyclerViewImageList.get(i);

        String scname = subCategory.getScname();
        String images = subCategory.getScimageurl();
        myViewHolder.textViewProductSubCategory.setText(scname);
        Picasso.get().load(images).fit().into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return recyclerViewImageList.size();
    }

//    public void setClickListener(ItemClickListener itemClickListener) {
//        this.clickListener = itemClickListener;
//    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textViewProductSubCategory;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.imageViewProductSubCategory);
            textViewProductSubCategory = itemView.findViewById(R.id.textViewProductSubCategory);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            ProductSubCategory element = recyclerViewImageList.get(itemPosition);

//            if (element.scname.equals("Electronics")) {
//                preferencesEditor.putString("cid", "107");
//                preferencesEditor.putString("cname", "Electronics");
//
//                preferencesEditor.apply();
//            }
//            else if (element.cname.equals("Clothes")) {
//                preferencesEditor.putString("cid", "108");
//                preferencesEditor.putString("cname", "Clothes");
//
//                preferencesEditor.apply();
//            }
//            else if (element.cname.equals("Jewellery")) {
//                preferencesEditor.putString("cid", "109");
//                preferencesEditor.putString("cname", "Jewellery");
//
//                preferencesEditor.apply();
//            }
//            else if (element.cname.equals("Shoes")) {
//                preferencesEditor.putString("cid", "111");
//                preferencesEditor.putString("cname", "Shoes");
//
//                preferencesEditor.apply();
//            }
//            else if (element.cname.equals("Mobile Phones")) {
//                preferencesEditor.putString("cid", "112");
//                preferencesEditor.putString("cname", "Mobile Phones");
//
//                preferencesEditor.apply();
//            }
//            else if (element.cname.equals("Fashion")) {
//                preferencesEditor.putString("cid", "113");
//                preferencesEditor.putString("cname", "Fashion");
//
//                preferencesEditor.apply();
//            }
//            else if (element.cname.equals("home appliances")) {
//                preferencesEditor.putString("cid", "114");
//                preferencesEditor.putString("cname", "home appliances");
//
//                preferencesEditor.apply();
//            }
//            else if (element.cname.equals("Personal Care")) {
//                preferencesEditor.putString("cid", "115");
//                preferencesEditor.putString("cname", "Personal Care");
//
//                preferencesEditor.apply();
//            }


        }
    }
}
