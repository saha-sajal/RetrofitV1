package com.week6.retrofitv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewResult);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();

        ResponseAPI postResponseAPI = retrofit.create(ResponseAPI.class);




        Call<List<CommentResponse>> comments = postResponseAPI.getComment();

        comments.enqueue(new Callback<List<CommentResponse>>() {
            @Override
            public void onResponse(Call<List<CommentResponse>> call, Response<List<CommentResponse>> response) {

                if(!response.isSuccessful())
                {
                    textView.setText("Code: "+response.code());
                    return;
                }

                List<CommentResponse> commentResponses = response.body();
                String content = "";

                for(CommentResponse comment: commentResponses)
                {
                    content = content + comment.getPostId()+"\n"+comment.getId()+"\n"+comment.getName()+"\n"+comment.getEmail()+"\n"+comment.getComment()+"\n\n";
                }
                textView.setText(content);

            }

            @Override
            public void onFailure(Call<List<CommentResponse>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}

