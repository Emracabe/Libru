package com.embre.libru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private Button btnAddToCurrentlyReading, btnAddToAlreadyRead, btnAddToWantToRead, btnAddToFavorites;
    private TextView txtBookName, txtBookAuthor, txtBookPages, txtBookDescription;
    private ImageView txtBookImage;
    public static final String BOOK_ID_KEY = "bookID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        Intent intent = getIntent();

        if (intent != null) {
            int bookID = intent.getIntExtra(BOOK_ID_KEY, -1);

            if (bookID != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookID);

                if (incomingBook != null) {
                    setBook(incomingBook);

                    handleCurrentlyReading(incomingBook);
                    handleWantToRead(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handleFavorites(incomingBook);
                }
            }
        }
    }

    private void handleFavorites(final Book book) {
        ArrayList <Book> favoriteBooks = Utils.getInstance().getFavoriteBooks();

        boolean existInFavoriteBooks = false;

        for (Book b : favoriteBooks) {
            if (b.getId() == book.getId()) {
                existInFavoriteBooks = true;
            }
        }

        if (existInFavoriteBooks) {
            btnAddToFavorites.setEnabled(false);
        } else {
            btnAddToFavorites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToFavorites(book)) {
                        Toast.makeText(BookActivity.this, "Book Added to Favorites", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, FavoriteBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleAlreadyRead(final Book book) {
        ArrayList <Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false;

        for (Book b : alreadyReadBooks) {
            if (b.getId() == book.getId()) {
                existInAlreadyReadBooks = true;
            }
        }

        if (existInAlreadyReadBooks) {
            btnAddToAlreadyRead.setEnabled(false);
        } else {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToAlreadyRead(book)) {
                        Toast.makeText(BookActivity.this, "Book Added to Already Read", Toast.LENGTH_SHORT).show();

                         Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                         startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToRead(final Book book) {
        ArrayList <Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();

        boolean existInWantToReadBooks = false;

        for (Book b : wantToReadBooks) {
            if (b.getId() == book.getId()) {
                existInWantToReadBooks = true;
            }
        }

        if (existInWantToReadBooks) {
            btnAddToWantToRead.setEnabled(false);
        } else {
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToWantToRead(book)) {
                        Toast.makeText(BookActivity.this, "Book Added to Want to Read", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, WantToReadBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReading(final Book book) {
        ArrayList <Book> currentlyReadBooks = Utils.getInstance().getCurrentlyReadingBooks();

        boolean existInCurrentlyReadBooks = false;

        for (Book b : currentlyReadBooks) {
            if (b.getId() == book.getId()) {
                existInCurrentlyReadBooks = true;
            }
        }
        
        if (existInCurrentlyReadBooks) {
            btnAddToCurrentlyReading.setEnabled(false);
        } else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToCurrentlyRead(book)) {
                        Toast.makeText(BookActivity.this, "Book Added to Currently Reading", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, CurrentlyReadBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setBook(Book book) {
        setTitle(book.getName());
        txtBookName.setText(book.getName());
        txtBookAuthor.setText(book.getAuthor());
        txtBookPages.setText(String.valueOf(book.getPages()));
        txtBookDescription.setText(book.getLongDesc());

        Glide.with(this)
                .asBitmap()
                .load(book.getImageURL())
                .into(txtBookImage);
    }

    private void initViews() {
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReadingList);
        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyReadList);
        btnAddToWantToRead = findViewById(R.id.btnAddToWantToReadList);
        btnAddToFavorites = findViewById(R.id.btnAddToFavorites);

        txtBookName = findViewById(R.id.txtBName);
        txtBookAuthor = findViewById(R.id.txtBAuthor);
        txtBookPages = findViewById(R.id.txtBPages);
        txtBookDescription = findViewById(R.id.txtBDescription);

        txtBookImage = findViewById(R.id.bImg);
    }
}