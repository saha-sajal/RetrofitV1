package com.week6.retrofitv1;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ResponseAPI {
    @GET("posts")
    Call<List<PostResponse>> getPost();

    @GET("comments")
    Call<List<CommentResponse>> getComment();

}
