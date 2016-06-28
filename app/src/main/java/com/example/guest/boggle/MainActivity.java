package com.example.guest.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final Character[] consonants = new Character[]  { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
    private static final Character[] vowels = new Character[] {'a', 'e', 'i', 'o', 'u', 'y'};
    private ArrayList<Character> boggleArray = new ArrayList<Character>();
    private TextView boggleLetters;
    private Button submitWordButton;
    private TextView wordList;
    private EditText wordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boggleLetters = (TextView) findViewById(R.id.boggleLetters);
        wordList = (TextView) findViewById(R.id.wordList);
        wordInput = (EditText) findViewById(R.id.wordInput);
        submitWordButton = (Button) findViewById(R.id.submitWord);
        submitWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] userWord = wordInput.getText().toString().split("");
                for(int i = 0; i <= userWord.length; i++) {
                    for(int j = 0; j < 8; j++) {
                        if (Character.toString(boggleArray.get(j)) == userWord[i]) {
                            //remove j
                            Log.d(Character.toString(boggleArray.get(j)), "Character match!");
                            j = -1;
                            i++;
                            if (i > userWord.length) {
                                wordList.append(" " + wordInput.getText().toString());
                                Log.d("GOOD WORD", "GOOD WORD");
                                return;
                            }
                        }
                    }
                    //that's bad
                    Log.d("BAD WORD", "BAD WORD");
                    return;
                }
                wordList.append(" " + wordInput.getText().toString());
            }
        });
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
