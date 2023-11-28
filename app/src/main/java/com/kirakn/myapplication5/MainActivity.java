package com.kirakn.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String poem = "У лукоморья дуб зеленый;\n" +
            "Златая цепь на дубе том:\n" +
            "И днем и ночью кот ученый\n" +
            "Всё ходит по цепи кругом...";
    private int numberOfCharacters;
    private int numberOfWords;
    private int numberOfCharactersL;
    private boolean isWordFifth;
    private String wordsCharactersD;

    private TextView infoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfCharacters = numberOfCharacters(poem);
        numberOfWords = numberOfWords(poem);
        numberOfCharactersL = numberOfCharactersL(poem);
        isWordFifth = isWordFifth(poem);
        wordsCharactersD = wordsCharactersD(poem);

        infoApp = findViewById(R.id.infoApp);

        infoApp.setText("Число символов с строке " + numberOfCharacters + "\n"
                + "Число слов в строке " + numberOfWords + "\n"
                + "Число букв \"л\" в строке " + numberOfCharactersL + "\n"
                + "Наличие слов из 5 букв " + isWordFifth + "\n"
                + "Строка из слов, начинающихся на букву Д " + wordsCharactersD);
    }

    private String wordsCharactersD(String stringPoem) {
        String stringD = "";
        String stPoem = stringPoem.replace("\n","").trim();
        String[] arrayPoem = stPoem.split(" ");

        for(String string : arrayPoem) {
            if(string.charAt(0) == 'Д' | string.charAt(0) == 'д') {
                stringD += string + " ";
            }
        }
        return stringD.trim();
    }

    private boolean isWordFifth(String stringPoem) {
        String[] words = stringPoem.split("\\s+");
        for (String word : words) {
            if (word.length() == 5) {
                return true;
            }
        }
        return false;
    }


    private int numberOfCharactersL(String stringPoem) {
        int count = 0;
        for(int i = 0; i < stringPoem.length(); i++) {
            if (stringPoem.charAt(i) == 'л') {
                count++;
            }
        }
        return count;
    }

    private int numberOfWords(String stringPoem) {
        String stPoem = stringPoem.trim();
        int count = 0;
        for (int i = 0; i < stPoem.length(); i++) {
            if(stPoem.charAt(i) == ' ' | stPoem.charAt(i) == '\n') {
                count++;
            }
        }
        return count;
    }
    private int numberOfCharacters(String stringPoem) {
        return stringPoem.length();
    }
}