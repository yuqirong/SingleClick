package com.orange.note.singleclick.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.orange.note.singleclick.Except;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View throttleButton = findViewById(R.id.throttle_button);
        View normalButton = findViewById(R.id.normal_button);
        View normalXmlButton = findViewById(R.id.normal_xml_button);
        throttleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "throttle the click event button click");
            }
        });
        normalButton.setOnClickListener(new View.OnClickListener() {

            @Except
            @Override
            public void onClick(View v) {
                Log.i(TAG, "normal button click");

            }
        });
    }

    public void normalXmlButtonOnClick(View view) {
        Log.i(TAG, "throttle the click event normal xml button click");
    }

}
