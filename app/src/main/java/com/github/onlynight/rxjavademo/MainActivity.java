package com.github.onlynight.rxjavademo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.onlynight.rxjavademo.event.EventBus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textTest;
    private Button btnSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textTest = findViewById(R.id.textTest);
        btnSecondActivity = findViewById(R.id.btnSecondActivity);
        btnSecondActivity.setOnClickListener(this);

        EventBus.getInstance().registerSubscriber(this);
    }

    public void onEvent(Object event) {

        if (event instanceof String) {
            textTest.setText((String) event);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getInstance().unregisterSubscriber(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnSecondActivity:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}
