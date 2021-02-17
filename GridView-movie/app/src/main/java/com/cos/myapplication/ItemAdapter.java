package com.cos.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private static final String TAG = "ItemAdapter";
    private final List<Movie> movies;

    public ItemAdapter(List<Movie> movies) {
        this.movies = movies;
    } // 10개 짜리

    public void addItem(Movie movie){
        movies.add(movie);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        movies.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MainActivity mainActivityContext = (MainActivity)parent.getContext();
        LayoutInflater inflater = (LayoutInflater)mainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.list_item,parent,false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        ImageView tvPic = view.findViewById(R.id.tv_pic);


        tvTitle.setText(movies.get(position).getTitle());
        tvPic.setImageResource(movies.get(position).getPic());

        view.setOnClickListener(v -> {
            Intent intent = new Intent(mainActivityContext,DetailActivity.class);
            intent.putExtra("movie",movies.get(position));
            mainActivityContext.startActivity(intent);
        });

        return view;
    }
}
