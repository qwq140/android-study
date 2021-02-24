package com.cos.movieapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cos.movieapp.model.Movie;
import com.cos.movieapp.service.MovieApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {

    private static final String TAG = "MovieViewModel";
    private MutableLiveData<List<Movie>> mtMovies = new MutableLiveData<>();
    private MovieApi movieApi = MovieApi.retrofit.create(MovieApi.class);

    public MutableLiveData<List<Movie>> 구독(){
        return mtMovies;
    }

    public void 전체가져오기(){
        Log.d(TAG, "전체가져오기: ");

        Call<List<Movie>> call = movieApi.getMovies();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                List<Movie> movies = response.body();
                // 어댑터에 던지기 + NotifyChanged
                Log.d(TAG, "onResponse: " + movies);
                mtMovies.setValue(movies);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d(TAG, "onFailure: 실패");
            }
        });
    }

    public void 데이터초기화(){
        Log.d(TAG, "데이터초기화: ");
        List<Movie> movies = new ArrayList<>();
        mtMovies.setValue(movies);
    }

    public void 삭제하기(int position){
        List<Movie> movies = mtMovies.getValue();
        long id = movies.get(position).getId();
        Call<Void> call = movieApi.deleteMovie(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(TAG, "onResponse: 삭제 성공");
                movies.remove(position);
                mtMovies.setValue(movies);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d(TAG, "onFailure: 삭제 실패");

            }
        });

    }

}
