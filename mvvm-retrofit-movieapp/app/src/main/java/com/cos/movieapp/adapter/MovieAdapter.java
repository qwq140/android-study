package com.cos.movieapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.cos.movieapp.MainActivity;
import com.cos.movieapp.R;
import com.cos.movieapp.model.Movie;
import com.cos.movieapp.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private static final String TAG = "MovieAdapter";
    private List<Movie> movies = new ArrayList<>();

    private MovieViewModel movieViewModel;


    public MovieAdapter(MovieViewModel movieViewModel){
        this.movieViewModel = movieViewModel;

    }

    public void setPosts(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    public void addItem(Movie movie){
        movies.add(movie);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        movies.remove(position);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle, tvRating, tvYear, tvRuntime;
        private ImageView ivPoster;
        private Button btnDelete;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvRating = itemView.findViewById(R.id.tv_rating);
            tvRuntime = itemView.findViewById(R.id.tv_runtime);
            tvYear = itemView.findViewById(R.id.tv_year);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            btnDelete = itemView.findViewById(R.id.btn_delete);

        }

        public void setItem(Movie movie){
            tvTitle.setText(movie.getTitle());
            tvRating.setText(movie.getRating()+"");
            tvRuntime.setText(movie.getRuntime()+"분");
            tvYear.setText(movie.getYear()+"");

            Glide
                    .with(ivPoster.getContext())
                    .load(movie.getMedium_cover_image())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(ivPoster);

            btnDelete.setOnClickListener(v -> {
                Log.d(TAG, "setItem: "+getAdapterPosition());
                movieViewModel.삭제하기(getAdapterPosition());
            });

        }
    }

}
