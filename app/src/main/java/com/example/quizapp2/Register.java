package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    SwitchCompat switch1;
    ConstraintLayout cl_1;
    TextView tx;
    Button button;
    Snackbar snc;
    CoordinatorLayout cl;
    ImageButton reg_back_dialog;
    EditText reg_email,reg_pass;
    Editable email, pass;
    ToggleButton tb;
    Spinner sp;
    public String countries[] = {"India", "USA", "France", "China", "Canada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        switch1 = findViewById(R.id.switch1);
        cl_1 = findViewById(R.id.cl_1);
        tx = findViewById(R.id.textView2);
        button = findViewById(R.id.bbtn_reg);
        cl = findViewById(R.id.ll_reg);
        reg_back_dialog = findViewById(R.id.reg_back_dialog);
        reg_email = findViewById(R.id.reg_email);
        reg_pass = findViewById(R.id.reg_pass);
        tb = findViewById(R.id.tb_zoom);
        sp = findViewById(R.id.spin_country);


        email = reg_email.getText();
        pass = reg_pass.getText();


        sp.setOnItemSelectedListener(this);
        sp.getBackground().setColorFilter(getResources().getColor(R.color.white,this.getTheme()), PorterDuff.Mode.SRC_ATOP);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,countries);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);

        tb.setTextOn("Normal");
        tb.setTextOff("Zoomed");

        final float siz = 28;
        final float siz_em = 20;
        final float siz_pa = 20;

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               if( tb.getText().toString().equals("Normal"))
               {
                   tx.setTextSize(siz);
                   reg_email.setTextSize(siz_em);
                   reg_pass.setTextSize(siz_pa);

               }
               else
               {
                   tx.setTextSize(siz+5);
                   reg_email.setTextSize(siz_em+10);
                   reg_pass.setTextSize(siz_pa+10);

               }
            }
        });


        reg_back_dialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                snc = Snackbar.make(cl, "Confirm Back?",Snackbar.LENGTH_SHORT)
                        .setAction("Yes", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar snc1 = Snackbar.make(cl, "Done", Snackbar.LENGTH_SHORT);
                                snc1.show();
                                Intent ins = new Intent(Register.this,MainActivity.class);
                                startActivity(ins);

                            }
                        });
                cl.setTextAlignment(cl.TEXT_ALIGNMENT_CENTER);
                snc.show();
            }
        });

        switch1.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {
                    cl_1.setBackground(getDrawable(R.drawable.bmbackgroundtwo));
                    tx.setTextColor(getResources().getColor(R.color.white,getTheme()));

                }
                else {
                    cl_1.setBackground(getDrawable(R.drawable.bmbackgroundone));
                    tx.setTextColor(getResources().getColor(R.color.white,getTheme()));

                }
            }
        });

    }

    public void exit(View view){


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Confirm !!!");

        alertDialogBuilder.setMessage("Your Details -> \n"+""+email+"\nAre You Sure?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Intent in = new Intent(Register.this,MainActivity.class);
                Toast.makeText(getApplicationContext(),"Details have been saved.", Toast.LENGTH_SHORT).show();
                startActivity(in);
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You clicked over No",Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You clicked on Cancel",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView)parent.getChildAt(0)).setTextColor(Color.WHITE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        ((TextView)parent.getChildAt(0)).setText("Country");


    }
}