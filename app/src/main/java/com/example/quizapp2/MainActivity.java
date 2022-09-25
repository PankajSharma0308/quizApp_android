package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText username;
    private EditText password ;
    private Button login ;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.button);

        sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE);

        String st = sharedPreferences.getString("name_key","");
        if(!st.equals("")) {
            username.setText(st);
            Toast.makeText(this, "Welcome back, "+st, Toast.LENGTH_SHORT).show();
        }

        //this.getSharedPreferences("mypref", 0).edit().clear().commit();

    }

    public void login_app(View view) {

        editor = sharedPreferences.edit();
        editor.putString("name_key", username.getText().toString());
        editor.commit();

        if( password.getText().toString().equals("root") ) {

            Intent logged_in = new Intent(MainActivity.this, LandinPage.class);
            logged_in.putExtra("username",username.getText().toString());
            startActivity(logged_in);
        }


    }

    public void register(View view) {




        Intent register_i = new Intent(MainActivity.this, Register.class);
        startActivity(register_i);

    }

}