package Labs.Lab11;

import java.util.ArrayList;

public class Bookshelf {

    private int size = 2;
    private  ArrayList<Book> books = new ArrayList<Book>(size);

    //No arg constructor sets all list values to null
    public Bookshelf() {
    }

    //Size input constructor, sets all list values to null
    public Bookshelf(int size){
        this.size = size;
        ArrayList<Book> books = new ArrayList<Book>(this.size);
    }

    //returns array list size
    public int getSize() {
        return this.size;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    //returns the book at the specified index on the bookshelf
    public Book getBook(int i) {
        return books.get(i);
    }

    //adds a book to the bookshelf if there is room
    public void addBook(Book entry) {
        if(books.size() < size) {
            books.add(entry);
        }
    }

    //removes the first element in the array list
    public Book removeBook() {
        if(books.isEmpty()) {
            return null;
        }
        else {
            return books.remove(0);
        }
    }

    //empties the entire array list
    public void emptyBookshelf(){
        books.removeAll(books);
    }
}
