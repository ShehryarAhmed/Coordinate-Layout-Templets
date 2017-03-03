package com.example.iq.coordinatorlayout;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.main_collapsing);
        toolbarLayout.setTitle("Coordinate Eample");
        
    }
}
