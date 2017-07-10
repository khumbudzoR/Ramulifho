package com.example.codetribe.copy;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colours extends AppCompatActivity {
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
        setContentView(R.layout.colours);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("black", "Mutshu", R.drawable.black, R.raw.mutsu));
        words.add(new Word("blue", "Lutombo", R.drawable.blue, R.raw.lutombo));
        words.add(new Word("brown", "Buraweni", R.drawable.brown, R.raw.buraweni));
        words.add(new Word("green", "Mudala", R.drawable.green, R.raw.mudala));
        words.add(new Word("grey", "Museṱha", R.drawable.grey, R.raw.musetha));
        words.add(new Word("meroon", "Meruni", R.drawable.meroon, R.raw.meruni));
        words.add(new Word("orange", "Swiri", R.drawable.orange, R.raw.orenzhi));
        words.add(new Word("pink", "Pinki", R.drawable.pink, R.raw.pinki));
        words.add(new Word("red", "Mutsuku", R.drawable.red, R.raw.mutsuku));
        words.add(new Word("white", "Mutshena", R.drawable.white, R.raw.mutshena));
        words.add(new Word("yellow", "Ṱhaḓa", R.drawable.yellow, R.raw.thada));




        ListView listView = (ListView)findViewById(R.id.listshspes);
        WordAdapter adapter = new WordAdapter(this,words,R.layout.colours);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(Colours.this, word.getAudioResourceId());
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
