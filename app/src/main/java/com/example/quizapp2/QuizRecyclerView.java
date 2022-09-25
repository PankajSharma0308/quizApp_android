package com.example.quizapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QuizRecyclerView extends AppCompatActivity {

    RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_recycler_view);
        getSupportActionBar().hide();
        rvMain = findViewById(R.id.rvMain);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(new RvAdapter());
    }

    class RowHolder extends RecyclerView.ViewHolder {
        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

//    class AdHolder extends RecyclerView.ViewHolder {
//        public AdHolder(@NonNull View itemView) {
//            super(itemView);
//        }
//    }

    class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (viewType == 0) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
                return new RowHolder(view);
            } else {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_new_comedy, parent, false);
                return new RowHolder(view);
            }
        }

        //onClick on each item of Recycler View
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), LandinPage.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0)
                return 1;
            return position % 3;
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }
}