package com.patialashahi.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public void generate(int timesTable){
        ArrayList<String> timestableContent = new ArrayList<String>();
        ListView listView = (ListView)findViewById(R.id.listView);
        for(int i = 1 ;i<=10;i++){
            timestableContent.add(Integer.toString(i*timesTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,timestableContent);
        listView.setAdapter(arrayAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        ListView listView = (ListView) findViewById(R.id.listView);
        seekBar.setMax(50);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTable;
                if(i < min){
                    timesTable = min;
                    seekBar.setProgress(min);
                }else{
                    timesTable = i;
                }
                generate(timesTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generate(10);
        int timesTable = 10;
        ArrayList<String> timestableContent = new ArrayList<String>();
        for(int i = 1 ;i<=10;i++){
            timestableContent.add(Integer.toString(i*timesTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,timestableContent);
        listView.setAdapter(arrayAdapter);

    }
}
