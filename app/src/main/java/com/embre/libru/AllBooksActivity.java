package com.embre.libru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        setTitle("All Books");

        recyclerView = findViewById(R.id.recView);

        BooksRecViewAdapter bookAdapter = new BooksRecViewAdapter(this, "allBooks");
        bookAdapter.setBooks(Utils.getInstance().getAllBooks());

        recyclerView.setAdapter(bookAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}