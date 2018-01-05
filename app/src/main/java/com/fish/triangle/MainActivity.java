package com.fish.triangle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    TriangleView leftView;
    int y;

    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftView = (TriangleView) findViewById(R.id.arrow_top);

        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftView.invalidate();
            }
        });

        findViewById(R.id.changeColor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftView.setColor(Color.YELLOW);
            }
        });

        findViewById(R.id.changeDirection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftView.setDirection(TriangleView.DR_BOTTOM);
            }
        });
    }
}
