package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    EditText fb;
    Editable fb_text;
    RatingBar rb;
    Button submit,reset;
    String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        fb = findViewById(R.id.fb_fb);
        rb = findViewById(R.id.rb);
        submit = findViewById(R.id.fb_sub);
        reset = findViewById(R.id.fb_res);

        Intent intent = getIntent();
        uname = intent.getStringExtra("name");
        fb_text = fb.getText();

        submit.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(),"Rated "+rb.getNumStars()+""+"\nFeedback Sent.\nThank you!", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(getApplicationContext(),LandinPage.class);
            startActivity(in);
        });

        reset.setOnClickListener(v -> {
            fb.setText(null);
            rb.setRating(0);
        });
    }

    public void logout_2(View view){
        Intent i = new Intent(getApplicationContext(), LandinPage.class);
        startActivity(i);
    }
}