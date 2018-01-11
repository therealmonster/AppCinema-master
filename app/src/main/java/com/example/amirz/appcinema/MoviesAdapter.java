package com.example.amirz.appcinema;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by amirz on 1/10/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<AdapterCinema.ViewHolder> {
    private List<MovieItem> ListItems;
    private Context context;

    public MoviesAdapter(List<MovieItem> listItems, Context context) {
        ListItems = listItems;
        this.context = context;
    }

    @Override
    public AdapterCinema.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new  AdapterCinema.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterCinema.ViewHolder holder, int position) {
        final MovieItem listItem =  ListItems.get(position);
        holder.textViewHead.setText(listItem.getHead());
        Picasso.with(context)
                .load(listItem.getImageUrl())
                .into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
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
            imageView =(ImageView)itemView.findViewById(R.id.imageView);
            linearLayout =(LinearLayout)itemView.findViewById(R.id.linearLayout2);

        }
    }
}
