package com.embre.libru;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAllBooks, btnAlreadyRead, btnWantToRead, btnCurrentlyReading, btnFavorites, btnAbout;
    String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.getInstance();

        initViews();

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AllBooksActivity.class));
            }
        });

        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CurrentlyReadBookActivity.class));
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WantToReadBookActivity.class));
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AlreadyReadBookActivity.class));
            }
        });

        btnFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FavoriteBookActivity.class));
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);
                        intent.putExtra("url", "https://codepen.io/Emracabe/full/wvemeqB");
                        intent.putExtra("newUrl", "https://www.google.com");
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setMessage("Developed by Embre. Do you think this is an amazing app? If yes, please do visit my website for amazing mobile application:");
                builder.setTitle("About");
                builder.create().show();
            }
        });
    }

    private void initViews() {
        Log.d(TAG, "initViews started");

        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnFavorites = findViewById(R.id.btnFavorites);
        btnAbout = findViewById(R.id.btnAbout);
    }


}