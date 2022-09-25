package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;

public class LandinPage extends AppCompatActivity {

    private TextView txet;
    private String user,uname;
    private ImageButton logout_menu;
    private ImageButton popup_menu;
    private ConstraintLayout cl;
    SharedPreferences sharedPreferences;
    String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        txet = findViewById(R.id.logged_in_user);
        logout_menu = findViewById(R.id.logout_menu);
        popup_menu = findViewById(R.id.popup_menu);
        cl = findViewById(R.id.cl_landing);

        sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE);


        uname = sharedPreferences.getString("name_key","");

        if(uname.equals(""))
            txet.setText(user);
        else
            txet.setText(uname);

        registerForContextMenu(cl);

        Toast.makeText(getApplicationContext(),uname,Toast.LENGTH_SHORT).show();


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // you can set menu header with title icon etc
        menu.setHeaderTitle("Choose a color");
        // add menu items
        menu.add(0, v.getId(), 0, "Original");
        menu.add(0, v.getId(), 0, "White");
        menu.add(0, v.getId(), 0, "Black");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle() == "Original") {
            cl.setBackground(getDrawable(R.drawable.bmbackgroundone));
            txet.setTextColor(Color.BLACK);
        } else if (item.getTitle() == "White") {
            cl.setBackgroundColor(Color.WHITE);
            txet.setTextColor(Color.BLACK);
        } else if (item.getTitle() == "Black") {
            cl.setBackgroundColor(Color.BLACK);
            txet.setTextColor(Color.WHITE);
        }

        return true;
    }


    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }
        getMenuInflater().inflate(R.menu.menu_ugc_guide, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_cu:
                Toast.makeText(LandinPage.this, "Feedback", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(this,Feedback.class);
                in.putExtra("name",user);
                startActivity(in);
                return true;

            case R.id.item_logout:
                Toast.makeText(LandinPage.this, "Logout", Toast.LENGTH_SHORT).show();
                SharedPreferences sp;
                getSharedPreferences("myprefs",0).edit().clear().apply();
                Intent ins = new Intent(this,MainActivity.class);
                startActivity(ins);
                return true;

            case R.id.item_cancel:
                Toast.makeText(LandinPage.this, "Exited", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void pop(View view){
        PopupMenu popup = new PopupMenu(LandinPage.this,popup_menu);
        popup.getMenuInflater().inflate(R.menu.popup_mennu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(LandinPage.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                if(item.getTitle().equals("Recycler"))
                {
                    Intent in = new Intent(getApplicationContext(), QuizRecyclerView.class);
                    startActivity(in);
                }
                if(item.getTitle().equals("Notify"))
                {
                    Intent i = new Intent(getApplicationContext(),Notifcications.class);
                    startActivity(i);
                }
                return true;
            }
        });
        popup.show();//showing popup menu

    }


    public void logout_(View view){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }

    public void ugcSite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ugcnet.nta.nic.in/"));
        startActivity(intent);
    }

    public void ugcMock(View view) {
        Intent intent_mock = new Intent(LandinPage.this, Mock.class);
        intent_mock.putExtra("username_mock",user);
        startActivity(intent_mock);
    }

    public void toastClick(View view) {
        Intent i = new Intent( LandinPage.this, MainActivity2.class );
        startActivity(i);
    }

    public void ugcGuide(View view) {
        Intent i_guide = new Intent(LandinPage.this, UGCGuide.class);
        startActivity(i_guide);
    }
}