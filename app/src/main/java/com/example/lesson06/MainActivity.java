package com.example.lesson06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvNumbers;
    private List<String> data = new ArrayList<>();
    private UserAdapter userAdapter;
    private PostAdapter postAdapter;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNumbers = findViewById(R.id.rvNumbers);

        api = NetworkService.getInstance().getApi();

        displayALlUsers();
    }

        private void displayALlUsers() {
            Call<List<User>> call = api.getAllUsers();
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    List<User> users = response.body();
                    userAdapter = new UserAdapter(
                            MainActivity.this,
                            R.layout.item_list,
                            users
                    );
                    rvNumbers.setAdapter(userAdapter);
                    LinearLayoutManager manager = new LinearLayoutManager(
                            MainActivity.this,
                            RecyclerView.VERTICAL,
                            false
                    );
                    rvNumbers.setLayoutManager(manager);
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    // Handle failure
                }
            });
        }
}
