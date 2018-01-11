package com.example.amirz.appcinema;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by amirz on 1/8/2018.
 */

public class AdapterCinema extends RecyclerView.Adapter<AdapterCinema.ViewHolder> {
    private List<ListItem> ListItems;
    private Context context;


    public AdapterCinema(List<ListItem> listItems, Context context) {
        ListItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListItem listItem =  ListItems.get(position);
        holder.textViewHead.setText(listItem.getHead());
        holder.linearLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MoviesActivity.class);
           //     intent.putExtra(CINEMA_ID, (int) v.getTag());
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return ListItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewHead;
        public ImageView imageView;
        public LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewHead =(TextView)itemView.findViewById(R.id.name);
            imageView =(ImageView)itemView.findViewById(R.id.imageView) ;
          linearLayout =(LinearLayout)itemView.findViewById(R.id.linearLayout);

        }
    }
}

