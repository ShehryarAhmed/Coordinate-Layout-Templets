package com.example.iq.coordinatelayout_5;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CardView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardView = (CardView) findViewById(R.id.cardView);

        final SwipeDismissBehavior<CardView> swipe = new SwipeDismissBehavior();

        swipe.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY);

        swipe.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(View view) {
                Toast.makeText(MainActivity.this, "Card Swiped..!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDragStateChanged(int state) {
//                Toast.makeText(MainActivity.this, "onDragState", Toast.LENGTH_SHORT).show();
                Log.e("Dragging", "the CardView is dragging..");
            }
        });
        LayoutParams layoutParams = (LayoutParams) mCardView.getLayoutParams();
        layoutParams.setBehavior(swipe);
    }
}
