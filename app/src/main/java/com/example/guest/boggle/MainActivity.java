package com.example.guest.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final Character[] consonants = new Character[]  { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
    private static final Character[] vowels = new Character[] {'a', 'e', 'i', 'o', 'u', 'y'};
    private ArrayList<Character> boggleArray = new ArrayList<Character>();
    private TextView boggleLetters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boggleLetters = (TextView) findViewById(R.id.boggleLetters);
        Random rng = new Random();
        for (int i = 0; i < 6; i++) {
            boggleArray.add(consonants[rng.nextInt(consonants.length)]);
        }
        for (int i = 0; i < 2; i++) {
            boggleArray.add(vowels[rng.nextInt(vowels.length)]);
        }
        for (int i = 0; i < boggleArray.size(); i++) {
            Log.d(Character.toString(boggleArray.get(i)), "BoggleString");
        }

        for (int i = 0; i < 8; i++) {
            boggleLetters.append(Character.toString(boggleArray.get(i)));
        }

    }
}
