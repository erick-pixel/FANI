package com.example.fani;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView judul = findViewById(R.id.judul);
        TextView type = findViewById(R.id.type);
        TextView episode = findViewById(R.id.episode);
        TextView start = findViewById(R.id.start);
        TextView end = findViewById(R.id.end);
        TextView sinopsis = findViewById(R.id.sinopsis);
        ImageView gambar = findViewById(R.id.gambar);

        judul.setText(getIntent().getStringExtra("judul"));
        type.setText("Type: "+getIntent().getStringExtra("type"));
        episode.setText("Jumlah Episode: "+getIntent().getStringExtra("episode"));
        start.setText("Tanggal Mulai: "+getIntent().getStringExtra("start"));
        end.setText("Tanggal Berakhir: "+getIntent().getStringExtra("end"));
        sinopsis.setText(getIntent().getStringExtra("sinopsis"));
       Glide.with(getApplicationContext())
                .load(getIntent()
                        .getStringExtra("gambar")).error(R.mipmap.logo).into(gambar);
    }
}