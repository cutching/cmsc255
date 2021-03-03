package Labs.Lab11;

public class Book {
    //sets default book values
    private String title = "Test";
    private String author = null;

    //no-args constructor
    public Book(){
    }

    //constructor that takes a title and author name
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    //returns a string of the title and author
    public String toString(){
        return "\"" + title + "\" by " + author;
    }

    //returns author name
    public String getAuthor() {
        return author;
    }

    //sets author name
    public void setAuthor(String author) {
        this.author = author;
    }

    //returns title name
    public String getTitle() {
        return title;
    }

    //sets title name
    public void setTitle(String title) {
        this.title = title;
    }


}
