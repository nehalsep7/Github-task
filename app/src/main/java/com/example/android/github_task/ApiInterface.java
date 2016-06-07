package com.example.android.github_task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by kumnehal on 06/07/16.
 */
public interface ApiInterface {

    @GET("repos/{owner}/rails/commits")
    Call<List<Example>> getCommits(@Path("owner") String owner);

}
