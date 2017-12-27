package com.github.onlynight.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.onlynight.rxjavademo.event.EventBus;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnEvent = findViewById(R.id.btnEvent);
        btnEvent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btnEvent:
                EventBus.getInstance().post("test own event bus");
                break;
        }
    }
}
