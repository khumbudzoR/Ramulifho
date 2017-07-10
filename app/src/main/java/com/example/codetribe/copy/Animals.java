package com.example.codetribe.copy;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class Animals extends AppCompatActivity {


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
        setContentView(R.layout.word_list);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word ("birds", "Tshinoni", R.drawable.birds, R.raw.tshinoni));
        words.add(new Word("bitterfly", "Tshisusu", R.drawable.bitterfly, R.raw.tshisususu));
        words.add(new Word("chicken", "Khuhu", R.drawable.chicken, R.raw.khuhu));
        words.add(new Word("cow", "Kholomo", R.drawable.cow, R.raw.kholomo));
        words.add(new Word("crocodile", "Ngwena", R.drawable.crocodile, R.raw.ngwena));
        words.add(new Word("dog", "Mmbwa", R.drawable.dog, R.raw.mmbwa));
        words.add(new Word("elephant", "Ndou", R.drawable.elephant, R.raw.ndou));
        words.add(new Word("frog", "Tshidula", R.drawable.frog, R.raw.tshidula));
        words.add(new Word("giraffe", "Thudwa", R.drawable.giraffe, R.raw.thundwa));
        words.add(new Word("goat", "Mbudzi", R.drawable.goat, R.raw.mbudzi));
        words.add(new Word("horse", "Bere", R.drawable.horse, R.raw.bere));
        words.add(new Word("leopard", "Didingwe", R.drawable.leopard, R.raw.didingwe));
        words.add(new Word("lion", "Ndau", R.drawable.lion, R.raw.ndau));
        words.add(new Word("lizard", "Luaviavi", R.drawable.lizard, R.raw.luaviavi));
        words.add(new Word("puppy", "Tshimbwanana", R.drawable.puppy, R.raw.tshimbwanana));
        words.add(new Word("rabit", "Muvhuda", R.drawable.rabit, R.raw.muvhuda));
        words.add(new Word("tortoise", "Tshibode", R.drawable.tortoise, R.raw.tshibode));
        words.add(new Word("zebra", "Mbidi", R.drawable.zebra, R.raw.mbidi));




        ListView listView = (ListView)findViewById(R.id.list);
        WordAdapter adapter = new WordAdapter(this,words,R.layout.activity_animals);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);
                mMediaPlayer = MediaPlayer.create(Animals.this, word.getAudioResourceId());
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
