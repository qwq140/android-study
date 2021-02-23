package com.cos.mvvmex1.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cos.mvvmex1.model.Post;

import java.util.ArrayList;
import java.util.List;

// 메인액티비티를 위한 뷰모델
public class PostViewModel extends ViewModel {

    // LiveData, MutableLiveData
    private MutableLiveData<List<Post>> mtPosts = new MutableLiveData<>();


    public MutableLiveData<List<Post>> 구독(){
        return mtPosts;
    }

    public void 포스트한건추가(Post post){
        List<Post> posts = mtPosts.getValue();
        posts.add(post);
        mtPosts.setValue(posts);
    }

    public void 포스트변경(){
        List<Post> posts = mtPosts.getValue();
        posts.get(0).setTitle("테스트");
        mtPosts.setValue(posts);
    }

    public void 데이터초기화(){
        List<Post> posts = new ArrayList<>();
        mtPosts.setValue(posts);
    }

}
