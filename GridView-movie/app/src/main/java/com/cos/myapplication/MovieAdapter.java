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

public class MovieAdapter extends BaseAdapter {

    private static final String TAG = "ItemAdapter";
    private final List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
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

    // 전체크기를 확인하기 위해서 필요 (나도, 어댑터도)
    @Override
    public int getCount() {
        return movies.size();
    }

    // 클릭하거나 어떤 이벤트 발생시에 컬렉션 정보를 확인하기 위해 필요
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

        View view = inflater.inflate(R.layout.movie_item,parent,false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        ImageView tvPic = view.findViewById(R.id.tv_pic);

        tvTitle.setText(movies.get(position).getTitle());
        tvPic.setImageResource(movies.get(position).getPic());


        return view;
    }
}
