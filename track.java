package com.example.aimusiccomposer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class track extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    String music_url = "http://sampleswap.org/mp3/artist/46669/joevirus_Out-post-aiff-160.mp3";
    ImageView imageView8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        imageView8 = findViewById(R.id.imageView8);
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    imageView8.setImageResource(R.drawable.ic_baseline_pause_24);
                } else {
                    mediaPlayer.pause();
                    imageView8.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                }
            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(music_url);
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
