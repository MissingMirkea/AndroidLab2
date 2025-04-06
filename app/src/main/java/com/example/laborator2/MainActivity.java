package com.example.laborator2;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button click = (Button) findViewById(R.id.button);
        click.setBackgroundColor(Color.GREEN);

        final ImageView imagine = (ImageView) findViewById(R.id.imageView);

        final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.sound1);
        final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.sound2);

        View.OnClickListener elem = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedId = v.getId();

                if (clickedId == R.id.imageView) {
                    mp1.start();
                } else if (clickedId == R.id.button) {
                    mp2.start();
                }
            }
        };


        imagine.setOnClickListener(elem);
        click.setOnClickListener(elem);
    }
}