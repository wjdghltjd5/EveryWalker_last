package com.example.every;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.BLACK);
        }

        setContentView(R.layout.newboard_layout);

        ImageButton button = (ImageButton) findViewById(R.id.check);
        final EditText title = (EditText) findViewById(R.id.title);
        final EditText content = (EditText) findViewById(R.id.content);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewPostActivity.this, BoardReadActivity.class);
                intent.putExtra("title", String.valueOf(title.getText()));
                intent.putExtra("content", String.valueOf(content.getText()));
                startActivity(intent);
            }
        });
    }
}