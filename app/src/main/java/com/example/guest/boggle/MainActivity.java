package com.example.guest.boggle;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final Character[] consonants = new Character[]  { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
    private static final Character[] vowels = new Character[] {'a', 'e', 'i', 'o', 'u', 'y'};
    private ArrayList<Character> boggleArray = new ArrayList<Character>();
    private ArrayList<String> submissions = new ArrayList<String>();
    @Bind(R.id.wordInput) EditText wordInput;
//    @Bind(R.id.wordList) TextView wordList;
    @Bind(R.id.submitWord) Button submitWordButton;
    @Bind(R.id.boggleLetters) TextView boggleLetters;
    @Bind(R.id.welcomeText) TextView welcomeText;
    @Bind(R.id.listView) ListView userSubmissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Typeface amaticFont = Typeface.createFromAsset(getAssets(), "fonts/Amatic-Bold.ttf");
        welcomeText.setTypeface(amaticFont);
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, submissions);
        userSubmissions.setAdapter(adapter);


        submitWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] userWord = wordInput.getText().toString().split("");
                ArrayList<Character> boggleCopy = new ArrayList<Character> (boggleArray);
                if(userWord.length > 3) {
                    for (int i = 1; i < userWord.length; i++) {
                        for (int j = 0; j < boggleCopy.size(); j++) {
                            if (userWord[i].equals(Character.toString(boggleCopy.get(j)))) {
                                boggleCopy.remove(j);
                                j = -1;
                                i++;
                                if (i > userWord.length - 1) {
                                    submissions.add(" " + wordInput.getText().toString());
                                    adapter.notifyDataSetChanged();
                                    //wordList.append(" " + wordInput.getText().toString());
                                    return;
                                }
                            }
                        }
                        return;
                    }
                }
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
            boggleLetters.append(" " + Character.toString(boggleArray.get(i)));
        }
    }
}
