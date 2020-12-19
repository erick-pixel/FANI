package com.example.fani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fani.API.ApiConfig;
import com.example.fani.API.ApiService;
import com.example.fani.adapter.NarutoAdapter;
import com.example.fani.alarm.AlarmActivity;
import com.example.fani.model.ResultsItem;
import com.example.fani.model.RootNarutoModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<ResultsItem> resultsItems;
    private NarutoAdapter narutoAdapter;
    private Text alarm;
    private SharedPreferences preferences;
    private String sharedPrefFile = "com.example.fani";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        resultsItems = new ArrayList<>();
        getData();
        preferences = getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
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
        alarm = findViewById(R.id.alarm);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.alarm:
                Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
                String mOrderMessage = null;
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = preferences.edit();
        preferencesEditor.apply();
    }

}