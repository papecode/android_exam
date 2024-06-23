package com.project.examandroid.network;

import com.project.examandroid.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("users")
    Call<UserResponse> getContacts();
}
