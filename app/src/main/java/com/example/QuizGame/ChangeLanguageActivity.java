package com.example.QuizGame;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;


public class ChangeLanguageActivity extends AppCompatActivity {
    //Button bReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_change_language);

        Button bReturn = (Button) findViewById(R.id.bReturn);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));



        Button chLanguage = findViewById(R.id.ChangeLang);
        chLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showChangeLanguageDialog();

            }


        });


        bReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChangeLanguageActivity.this, MainMenu.class));
                ChangeLanguageActivity.this.finish();
            }
        });

    }

    private void showChangeLanguageDialog() {
        final String[] listItems = {"Français - French", "Española - Spanish", "日本 - Japanese", "English"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(ChangeLanguageActivity.this);
        mBuilder.setTitle("Choose App Language: ");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    //French
                    setLocale("fr");
                    recreate();
                }
                else if (i == 1) {
                    //Spanish
                    setLocale("es");
                    recreate();
                }
                else if (i == 2) {
                    //Japanese
                    setLocale("ja");
                    recreate();
                }
                else if (i == 3) {
                    //English
                    setLocale("en");
                    recreate();
                }
                //shut box down
                dialogInterface.dismiss();


            }
        });
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();

    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }
    public void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
    }

}