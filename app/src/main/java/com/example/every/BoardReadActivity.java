package com.example.every;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BoardReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.BLACK);
        }

        setContentView(R.layout.board_layout);

        ImageButton button = (ImageButton) findViewById(R.id.newpost);

        Intent intent = new Intent(this.getIntent());
        String title=intent.getStringExtra("title");
        TextView titlev = (TextView)findViewById(R.id.title_view);
        titlev.setText(title);
        String content=intent.getStringExtra("content");
        TextView contentv = (TextView)findViewById(R.id.content_view);
        contentv.setText(content);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoardReadActivity.this, NewPostActivity.class);
                startActivity(intent);
            }
        });
    }
}