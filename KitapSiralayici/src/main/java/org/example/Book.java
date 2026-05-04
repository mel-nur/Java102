package org.example;

public class Book implements Comparable<Book> {

    private String name;
    private Integer pageCount;
    private String authorName;
    private String publishDate;

    public Book(String name, Integer pageCount, String authorName, String publishDate){
        this.name = name;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }
    public String getName(){return this.name;}

    public Integer getPageCount(){return this.pageCount;}
    public String authorName(){return this.authorName;}
    public String getPublishDate(){return this.publishDate;}

    @Override
    public int compareTo(Book other){
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", pageCount=" + pageCount +
                ", authorName='" + authorName + '\'' +
                ", publishDate='" + publishDate + '\'' +
                '}';
    }
}
