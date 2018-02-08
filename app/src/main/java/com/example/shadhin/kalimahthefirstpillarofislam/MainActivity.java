package com.example.shadhin.kalimahthefirstpillarofislam;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    static final String TAG = "xxx";
    ListView lv;
    String[] list = {"Kalima e Tayyabah (কালিমা তাইয়্যেবা)", "Kalima e Shahaadat (কালিমা শাহাদৎ)", "Kalima e Tumjeed (কালিমা তামজীদ)", "Kalima e Tauhid (কালিমা তাওহীদ)", "Kalima Rud-A-Kuffer (রদ্দে কুফর)"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("The first Pillar of Islam");
        initial();
        listmain();


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
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                finish();
                break;

            case "Exit":
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure want to Exit?");
                builder.setCancelable(false);
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int Which) {

                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int Which) {

                        // onDestroy();
                        finish();
                       // moveTaskToBack(true);
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

    public void print(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }


    public void listmain() {
        lv = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < list.length; i++) {
                    //print(i+"=" + a[i]);
                    Log.d(TAG, i + "=" + list[i]);
                }
                switch (position) {


                    case 0:

                        Intent intent = new Intent(MainActivity.this, KalimaeTayyabahActivity.class);
                        startActivity(intent);

                        break;
                    case 1:
                        Intent intent1 = new Intent(MainActivity.this, KalimaEShahaadatActivity.class);
                        startActivity(intent1);

                        break;
                    case 2:
                        Intent intent2 = new Intent(MainActivity.this, KalimaeTumjeedActivity.class);
                        startActivity(intent2);

                        break;
                    case 3:
                        Intent intent3 = new Intent(MainActivity.this, KalimaeTauhidActivity.class);
                        startActivity(intent3);

                        break;
                    case 4:
                        Intent intent4 = new Intent(MainActivity.this, KalimaRud_A_KufferActivity.class);
                        startActivity(intent4);


                        break;
                }
                //print("\n"+position+"\n"+id);
                //String s = (String) parent.getItemAtPosition(position);
                //print(s);
                /*Intent intent = new Intent(KalimaeTayyabahActivity.this, ListViewC.class);
                intent.putExtra("PERSON", s);
                startActivity(intent);*/
                /*if(position==0)
                {
                    print("a");
                }
                else if(position==1)
                {
                    print("b");
                }*/
            }
        });
    }
}
