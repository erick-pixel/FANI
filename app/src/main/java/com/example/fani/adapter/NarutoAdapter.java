package com.example.fani.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fani.DetailActivity;
import com.example.fani.R;
import com.example.fani.model.ResultsItem;

import java.util.ArrayList;

public class NarutoAdapter extends RecyclerView.Adapter<NarutoAdapter.ViewHolder> {
    private ArrayList<ResultsItem> resultsItems;
    private Context context;

    public NarutoAdapter(ArrayList<ResultsItem> resultsItems, Context context) {
        this.resultsItems = resultsItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.daftar_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.judul.setText(resultsItems.get(position).getTitle());
        holder.score.setText("Score: "+resultsItems.get(position).getScore().toString());
        Glide.with(context)
                .load(resultsItems.get(position).getImageUrl())
                .error(R.mipmap.logo)
                .into(holder.gambar);
        holder.cv.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("judul", resultsItems.get(position).getTitle());
            intent.putExtra("gambar", resultsItems.get(position).getImageUrl());
            intent.putExtra("type", resultsItems.get(position).getType());
            intent.putExtra("episode", resultsItems.get(position).getEpisodes().toString());
            intent.putExtra("start", resultsItems.get(position).getStartDate());
            intent.putExtra("end", resultsItems.get(position).getEndDate());
            intent.putExtra("sinopsis", resultsItems.get(position).getSynopsis());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return resultsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cv;
        private ImageView gambar;
        private TextView judul,score;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.judul);
            score = itemView.findViewById(R.id.score);
            gambar = itemView.findViewById(R.id.gambar);
            cv = itemView.findViewById(R.id.cv);
        }
    }
}