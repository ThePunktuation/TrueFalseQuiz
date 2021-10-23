package com.example.QuizGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);


        Button btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           goPlay();
                                       }
                                   }
        );


        Button btnLanguage=(Button) findViewById(R.id.btnLanguage);
        btnLanguage.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             goLanguage();
                                         }
                                     }
        );

    }

    private void goPlay() {
        Intent intent = new Intent(MainMenu.this, StartQuizActivity.class);
        this.startActivity(intent);
    }
    private void goLanguage() {
        Intent intent = new Intent(MainMenu.this, ChangeLanguageActivity.class);
        this.startActivity(intent);
    }


}