package com.embre.libru;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;

    private static ArrayList <Book> allBooks;
    private static ArrayList <Book> currentlyReadingBooks;
    private static ArrayList <Book> wantToReadBooks;
    private static ArrayList <Book> alreadyReadBooks;
    private static ArrayList <Book> favoriteBooks;

    public Utils() {
        if (null == allBooks) {
            allBooks = new ArrayList<>();
            initData();
        }

        if (null == currentlyReadingBooks) {
            currentlyReadingBooks = new ArrayList<>();
        }

        if (null == wantToReadBooks) {
            wantToReadBooks = new ArrayList<>();
        }

        if (null == alreadyReadBooks) {
            alreadyReadBooks = new ArrayList<>();
        }

        if (null == favoriteBooks) {
            favoriteBooks = new ArrayList<>();
        }
    }

    private void initData() {
        allBooks.add(new Book(1, "The Midnight Library", "Matt Haig", 304, "https://kbimages1-a.akamaihd.net/5ec850c2-70bc-4362-8c10-06ca12f3474f/1200/1200/False/the-midnight-library-3.jpg", "An exquisite depiction of existential depression and the lessons it can reveal", "Matt Haig's unique novel The Midnight Library ponders the infinite possibilities of life. It is about a young woman named Nora Seed, who lives a monotonous, ordinary life and feels unwanted and unaccomplished. One night, her despair reaches a peak and she commits suicide."));
        allBooks.add(new Book(2, "Verity", "Colleen Hoover", 336, "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1634158558l/59344312._SY475_.jpg", "Creepy, slick, unsettling, stylistic and propulsive, I was unable to tear myself away from the clutches of Verity.", "Verity describes in details how their sexual life was and how it changed, what she thought about getting pregnant, about being a mother, and how she wished they would have been never born because they took her husband away from her. The story takes you through everyone's fears and darkness."));
        allBooks.add(new Book(3, "Normal People", "Sally Rooney", 266, "https://images-na.ssl-images-amazon.com/images/I/718W0JbHm1L.jpg", "Wondrous, magical, messy, complicated and oh so relatable 'Normal People' is one show that revels in nuance and subtlety - capturing each moment in all its raw emotive glory.", "Normal People by Sally Rooney is about Marianne and Connell, their secret friendship, and their on and off again relationship. They are two young people drawn to each other who drift apart at times, but always end up coming back to each other throughout their lives."));
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static void setAllBooks(ArrayList<Book> allBooks) {
        Utils.allBooks = allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static void setCurrentlyReadingBooks(ArrayList<Book> currentlyReadingBooks) {
        Utils.currentlyReadingBooks = currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static void setWantToReadBooks(ArrayList<Book> wantToReadBooks) {
        Utils.wantToReadBooks = wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static void setAlreadyReadBooks(ArrayList<Book> alreadyReadBooks) {
        Utils.alreadyReadBooks = alreadyReadBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public static void setFavoriteBooks(ArrayList<Book> favoriteBooks) {
        Utils.favoriteBooks = favoriteBooks;
    }

    public static Utils getInstance() {
        if (instance != null) {
            return instance;
        }

        instance = new Utils();
        return instance;
    }

    public static Book getBookById(int id) {
        for (Book b : allBooks) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public static boolean addToCurrentlyRead(Book book) {
        return currentlyReadingBooks.add(book);
    }

    public static boolean addToWantToRead(Book book) {
        return wantToReadBooks.add(book);
    }

    public static boolean addToAlreadyRead(Book book) {
        return alreadyReadBooks.add(book);
    }

    public static boolean addToFavorites(Book book) {
        return favoriteBooks.add(book);
    }

    public static boolean removeFromCurrentlyRead(Book book) {
        return currentlyReadingBooks.remove(book);
    }

    public static boolean removeFromWantToRead(Book book) {
        return wantToReadBooks.remove(book);
    }
;;;;
    public static boolean removeFromAlreadyRead(Book book) {
        return alreadyReadBooks.remove(book);
    }

    public static boolean removeFromFavorite(Book book) {
        return favoriteBooks.remove(book);
    }
}
