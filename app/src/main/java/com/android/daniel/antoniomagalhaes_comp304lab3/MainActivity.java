package com.android.daniel.antoniomagalhaes_comp304lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private String[] exercisesList = new String[]{"Exercise 1", "Exercise 2", "Exercise 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv_exercises);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, exercisesList);

        listView.setAdapter(arrayAdapter);

        final Intent intent = new Intent();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: {
                        intent.setClass(MainActivity.this, Exercise1Activity.class);
                        break;
                    }
                    case 1: {
                        intent.setClass(MainActivity.this, Exercise2Activity.class);
                        break;
                    }
                    case 2:{
                        intent.setClass(MainActivity.this, Exercise3Activity.class);
                        break;
                    }
                }
                startActivity(intent);
            }
        });

    }
}
