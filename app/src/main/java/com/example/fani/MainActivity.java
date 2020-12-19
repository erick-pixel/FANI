package com.example.fani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.fani.API.ApiConfig;
import com.example.fani.API.ApiService;
import com.example.fani.adapter.NarutoAdapter;
import com.example.fani.model.ResultsItem;
import com.example.fani.model.RootNarutoModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<ResultsItem> resultsItems;
    private NarutoAdapter narutoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        resultsItems = new ArrayList<>();
        getData();
    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData().enqueue(new Callback<RootNarutoModel>() {
            @Override
            public void onResponse(Call<RootNarutoModel> call, Response<RootNarutoModel> response) {
                if (response.isSuccessful()) {
                    resultsItems = response.body().getResults();
                    narutoAdapter = new NarutoAdapter(resultsItems, getApplicationContext());
                    rv.setAdapter(narutoAdapter);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<RootNarutoModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        rv = findViewById(R.id.rv);
    }

}