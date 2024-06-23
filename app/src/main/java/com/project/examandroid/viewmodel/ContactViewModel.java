package com.project.examandroid.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.examandroid.model.Contact;
import com.project.examandroid.network.ApiService;
import com.project.examandroid.network.RetrofitClient;
import com.project.examandroid.network.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactViewModel extends ViewModel {

    private MutableLiveData<List<Contact>> contacts;

    public LiveData<List<Contact>> getContacts() {
        if (contacts == null) {
            contacts = new MutableLiveData<>();
            loadContacts();
        }
        return contacts;
    }

    private void loadContacts() {
        ApiService apiService = RetrofitClient.getApiService();
        Call<UserResponse> call = apiService.getContacts();

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, @NonNull Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    contacts.setValue(response.body().getUsers());
                } else {
                    contacts.setValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserResponse> call, @NonNull Throwable t) {
                contacts.setValue(null);
            }
        });
    }
}
