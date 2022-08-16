package com.embre.libru;

public class Book {
    private int id;
    private String name;
    private String author;
    private int pages;
    private String imageURL;
    private String shortDesc;
    private String longDesc;
    private boolean expanded;

    public Book(int id, String name, String author, int pages, String imageURL, String shortDesc, String longDesc) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.imageURL = imageURL;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }
}
