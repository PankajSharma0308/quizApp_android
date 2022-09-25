package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

public class Mock extends AppCompatActivity {



    private String user_m;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock);

        web = findViewById(R.id.mock_web);

        Intent i2 = getIntent();
        user_m = i2.getStringExtra("username_mock");

    }

    public void helpPrep1(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://byjusexamprep.com/net-exams/ugc-net-exam-preparation-tips"));
        //startActivity(intent);
        web.loadUrl("https://byjusexamprep.com/net-exams/ugc-net-exam-preparation-tips");
    }

    public void helpPrep2(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://byjusexamprep.com/net-exams/ugc-net-exam-preparation-tips"));
        //startActivity(intent);
        web.loadUrl("https://www.shiksha.com/exams/ugc-net-exam-preparation");
    }

    public void helpPrep3(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://prepp.in/cbse-ugc-net-exam/preparation-tips"));
        //startActivity(intent);
        web.loadUrl("https://prepp.in/cbse-ugc-net-exam/preparation-tips");
    }

}