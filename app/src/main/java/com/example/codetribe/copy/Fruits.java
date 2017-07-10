package com.example.codetribe.copy;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Fruits extends AppCompatActivity {


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
        setContentView(R.layout.activity_fruits);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("apple", "Apula", R.drawable.apple, R.raw.apula));
                words.add(new Word("avocado", "Afukhada", R.drawable.avocado, R.raw.afukhada));
                words.add(new Word("banana", "Muomva", R.drawable.banana, R.raw.muomva));
                words.add(new Word("grapes", "Ndirivhe", R.drawable.grapes, R.raw.ndirivhe));
                words.add(new Word("guava", "Ngwavha", R.drawable.guava, R.raw.ngwavha));
                words.add(new Word("lemon", "Tshikavhavhe", R.drawable.lemon, R.raw.tshikavhavhe));
                words.add(new Word("lichi", "Litshisi", R.drawable.lichi, R.raw.lichisi));
                words.add(new Word("manngo", "Linngo", R.drawable.manngo, R.raw.linngo));
                words.add(new Word("oranges", "Swiri", R.drawable.oranges, R.raw.swiri));
                words.add(new Word("pawpaw", "Papawe", R.drawable.pawpaw, R.raw.papawe));
                words.add(new Word("peach", "beregisi", R.drawable.peach, R.raw.beregisi));
                words.add(new Word("pineapple", "tshienge", R.drawable.pineapple, R.raw.tshienge));
                words.add(new Word("rasberry", "thobeila", R.drawable.raspberry, R.raw.thobeila));
                words.add(new Word("strawberry", "Sitiroberi", R.drawable.strawberry, R.raw.sitiroberi));
                words.add(new Word("watermelon", "bvani", R.drawable.watermelon, R.raw.bvani));




                ListView listView = (ListView)findViewById(R.id.listfruits);
                WordAdapter adapter = new WordAdapter(this,words,R.layout.activity_fruits);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        releaseMediaPlayer();

        Word word = words.get(position);
        mMediaPlayer = MediaPlayer.create(Fruits.this, word.getAudioResourceId());
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
