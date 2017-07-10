package com.example.codetribe.copy;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Months extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("January", "phando", R.drawable.january));
        words.add(new Word("February", "Luhuhi",R.drawable.february));
        words.add(new Word("March", "Ṱhafamuhwe",R.drawable.march));
        words.add(new Word("April", "Lambamai",R.drawable.april));
        words.add(new Word("May", "Shundunthule",R.drawable.may));
        words.add(new Word("June", "Fulwi",R.drawable.june));
        words.add(new Word("July", "Fulwana",R.drawable.july));
        words.add(new Word("August", "Ṱhangule",R.drawable.august));
        words.add(new Word("September", "Khubvumedzi",R.drawable.september));
        words.add(new Word("October", "Tshimedzi",R.drawable.october));
        words.add(new Word("November", "Ḽara",R.drawable.november));
        words.add(new Word("December", "Nyendavhusiku",R.drawable.december));

        ListView listView = (ListView)findViewById(R.id.listmonths);
        WordAdapter adapter = new WordAdapter(this,words,R.layout.activity_months);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(Months.this, word.getAudioResourceId());
                mMediaPlayer.start();


                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    private void releaseMediaPlayer() {

        if (mMediaPlayer != null) {

            mMediaPlayer.release();


            mMediaPlayer = null;
        }
    }
}
