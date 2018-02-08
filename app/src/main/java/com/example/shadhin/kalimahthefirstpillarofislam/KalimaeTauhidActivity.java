package com.example.shadhin.kalimahthefirstpillarofislam;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class KalimaeTauhidActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalimae_tauhid);
        setTitle("The first Pillar of Islam");initial();
        initial();
    }
    private void initial() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String s = item.toString();
        switch (s) {
            case "Home":
                /*Intent intent1 = new Intent(KalimaeTauhidActivity.this, MainActivity.class);
                startActivity(intent1);*/
                finish();

                break;

            case "Exit":
                AlertDialog.Builder builder = new AlertDialog.Builder(KalimaeTauhidActivity.this);
                builder.setMessage("Are you sure want to Exit?");
                builder.setCancelable(false);
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int Which) {

                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int Which) {
                        finish();
                        moveTaskToBack(true);
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
                break;

            case "About":
                Dialog d = new Dialog(this);
                d.setTitle("Info");
                TextView tv = new TextView(this);
                tv.setText("    App:Kalimah The First Pillar of Islam \n    Version:1.0\n    Copyright ©2015\n    Developer:Moniruzzaman Shadhin\n    Contact:Shadhinemail@gmail.com");
                tv.setTextSize(15);

                d.setContentView(tv);
                d.show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
