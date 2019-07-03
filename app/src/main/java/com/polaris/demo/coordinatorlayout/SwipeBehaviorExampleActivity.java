package com.polaris.demo.coordinatorlayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.behavior.SwipeDismissBehavior;

public class SwipeBehaviorExampleActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_behavior);


        final SwipeDismissBehavior swipe = new SwipeDismissBehavior();
        swipe.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY);
        swipe.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override public void onDismiss(View view) {
                Toast.makeText(SwipeBehaviorExampleActivity.this,
                        "Card swiped !!", Toast.LENGTH_SHORT).show();
            }

            @Override public void onDragStateChanged(int state) {}
        });

        CardView cardView = findViewById(R.id.swype_card);
        CoordinatorLayout.LayoutParams coordinatorParams = (CoordinatorLayout.LayoutParams) cardView.getLayoutParams();
        coordinatorParams.setBehavior(swipe);
    }

    public static void start(Context c) {
        c.startActivity(new Intent(c, SwipeBehaviorExampleActivity.class));
    }

}