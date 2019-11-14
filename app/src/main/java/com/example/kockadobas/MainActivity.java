package com.example.kockadobas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnDobas;
    private TextView txtEredmeny;
    private ImageView imgGep, imgJatekos;
    private Random rnd;
    private int pontszamGep, pontszamJatekos;
    private AlertDialog alertDialog;
    private AlertDialog.Builder alertDialogBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnDobas.setOnClickListener(this);


    }

    private void init(){
        btnDobas = findViewById(R.id.buttonDobas);
        imgGep = findViewById(R.id.kepGep);
        imgJatekos = findViewById(R.id.kepJatekos);
        txtEredmeny = findViewById(R.id.textviewEredmeny);
        rnd = new Random();
        pontszamGep = 0;
        pontszamJatekos = 0;
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

    }


    @Override
    public void onClick(View v){
            int GepSzama = rnd.nextInt(6) + 1;
            int JatekosSzama = rnd.nextInt(6) + 1;
            switch (GepSzama) {
                case 1:
                    imgGep.setImageResource(R.drawable.kocka1);
                    break;
                case 2:
                    imgGep.setImageResource(R.drawable.kocka2);
                    break;
                case 3:
                    imgGep.setImageResource(R.drawable.kocka3);
                    break;
                case 4:
                    imgGep.setImageResource(R.drawable.kocka4);
                    break;
                case 5:
                    imgGep.setImageResource(R.drawable.kocka5);
                    break;
                case 6:
                    imgGep.setImageResource(R.drawable.kocka6);
                    break;
            }
            switch (JatekosSzama) {
                case 1:
                    imgJatekos.setImageResource(R.drawable.kocka1);
                    break;
                case 2:
                    imgJatekos.setImageResource(R.drawable.kocka2);
                    break;
                case 3:
                    imgJatekos.setImageResource(R.drawable.kocka3);
                    break;
                case 4:
                    imgJatekos.setImageResource(R.drawable.kocka4);
                    break;
                case 5:
                    imgJatekos.setImageResource(R.drawable.kocka5);
                    break;
                case 6:
                    imgJatekos.setImageResource(R.drawable.kocka6);
                    break;
            }
            String eredmeny = "";
            if (JatekosSzama > GepSzama) {
                pontszamJatekos++;
                txtEredmeny.setText(String.format("Eredmeny %d-%d", pontszamGep, pontszamJatekos));
            } else if (GepSzama > JatekosSzama) {
                pontszamGep++;
                txtEredmeny.setText(String.format("Eredmeny %d-%d", pontszamGep, pontszamJatekos));
            }
        if (pontszamGep == 3){
            alertDialogBuilder.setMessage("A Gép nyert szeretne újra játszani?");
            alertDialogBuilder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    pontszamGep = 0;
                    pontszamJatekos = 0;
                    imgJatekos.setImageResource(R.drawable.kocka1);
                    imgGep.setImageResource(R.drawable.kocka1);
                    txtEredmeny.setText("Eredmény 0-0");
                }
            });
            alertDialogBuilder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialogBuilder.setCancelable(false);

            alertDialog = alertDialogBuilder.create();


            alertDialog.show();
        }
        if (pontszamJatekos == 3){
            alertDialogBuilder.setMessage("Ön nyert szeretne újra játszani?");
            alertDialogBuilder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    pontszamGep = 0;
                    pontszamJatekos = 0;
                    imgJatekos.setImageResource(R.drawable.kocka1);
                    imgGep.setImageResource(R.drawable.kocka1);
                    txtEredmeny.setText("Eredmény 0-0");
                }
            });
            alertDialogBuilder.setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialogBuilder.setCancelable(false);

            alertDialog = alertDialogBuilder.create();

            alertDialog.show();
        }

    }
}
