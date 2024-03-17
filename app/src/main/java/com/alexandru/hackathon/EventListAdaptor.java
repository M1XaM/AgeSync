package com.alexandru.hackathon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

//public class EventListAdaptor extends RecyclerView.Adapter<EventListAdaptor.ViewHolder>{
    public class EventListAdaptor{

//    private static final int VIEW_TYPE_HEADER = 0;
//    private static final int VIEW_TYPE_ITEM = 1;
//    private static final int VIEW_TYPE_FOOTER = 2;
//
//    private List<Product> productList;
//    private Context context;
//    private static ButtonClickListener buttonClickListener;
//    private Intent intent;
//
//    public void updateProductList(List<Product> newProductList) {
//        productList.addAll(newProductList);
//        notifyDataSetChanged(); // Notify adapter that dataset has changed
//    }
//
//    public ProductListAdaptor(List<Product> productList, Context context, ButtonClickListener buttonClickListener) {
//        this.productList = productList;
//        this.context = context;
//        ProductListAdaptor.buttonClickListener = buttonClickListener;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        if (position == 0) {
//            return VIEW_TYPE_HEADER;
//        } else if (position == productList.size() + 1) {
//            return VIEW_TYPE_FOOTER;
//        } else {
//            return VIEW_TYPE_ITEM;
//        }
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = null;
//        int pos = -1;
//        switch (viewType){
//            case VIEW_TYPE_HEADER: {
//                view = LayoutInflater.from(context).inflate(R.layout.recycle_item_header, parent, false);
//                pos = VIEW_TYPE_HEADER;
//            } break;
//            case VIEW_TYPE_ITEM: {
//                view = LayoutInflater.from(context).inflate(R.layout.recycle_item_base, parent, false);
//                pos = VIEW_TYPE_ITEM;
//            } break;
//            default: {
//                view = LayoutInflater.from(context).inflate(R.layout.recycle_item_footer, parent, false);
//                pos = VIEW_TYPE_FOOTER;
//            } break;
//        }
//        return new ViewHolder(view, pos);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        if (getItemViewType(position) == VIEW_TYPE_ITEM) {
//            //subtract -1 to account for the header
//            Product product = productList.get(position - 1);
//
//            holder.prodName.setText(product.getName());
//            holder.prodSomlDesc.setText(product.getSize());
//            String priceString = String.format(Locale.UK,"$%.1f-", product.getPrice());
//            holder.prodPrice.setText(priceString);
//            holder.prodPriceSecond.setText(priceString);
//            Picasso.get().load(product.getMainImageLink()).into(holder.prodImg);
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return productList.size() + 2;
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder{
//        ImageView prodImg;
//        GridLayout prodGridLayout;
//        TextView prodName;
//        TextView prodSomlDesc;
//        TextView prodPrice;
//        TextView prodPriceSecond;
//        ImageView prodFavIcon;
//        ImageView prodCartIcon;
//        CardView loadMoreBtn;
//
//        public ViewHolder(@NonNull View itemView, int type) {
//            super(itemView);
//
//            if (type == VIEW_TYPE_ITEM) {
//                prodImg = itemView.findViewById(R.id.image_prod);
//                prodGridLayout = itemView.findViewById(R.id.prod_grid_view);
//                prodName = itemView.findViewById(R.id.name_prod);
//                prodSomlDesc = itemView.findViewById(R.id.smol_desc_prod);;
//                prodPrice = itemView.findViewById(R.id.price_prod);
//                prodPriceSecond = itemView.findViewById(R.id.price_prod_secondary);
//                prodFavIcon = itemView.findViewById(R.id.fav_btn);
//                prodCartIcon = itemView.findViewById(R.id.cart_btn);
//            } else if (type == VIEW_TYPE_FOOTER) {
//                //TODO: add 'load more' btn fnctionality
//                loadMoreBtn = itemView.findViewById(R.id.load_more_btn);
//
//                loadMoreBtn.setOnClickListener(v -> buttonClickListener.onButtonClick());
//            }
//        }
//    }
//
//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }
//
//    public Context getContext() {
//        return context;
//    }
//
//    public void setContext(Context context) {
//        this.context = context;
//    }

}
