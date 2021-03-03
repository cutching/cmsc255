package Labs.Lab11;

public class Lab11 {
    public static void main(String[] args) {
        Book Moby = new Book("Moby Dick" , "Herman Melville");
        Book Jojo = new Book("Jojo's Bizarre Adventure", "HiroHiko Araki");
        Book Candide = new Book("Candide","Voltaire");

        System.out.println(Moby.toString());
        System.out.println(Jojo.toString());
        System.out.println(Candide.toString());

        Bookshelf myShelf = new Bookshelf(3);

        myShelf.addBook(Moby);
        myShelf.addBook(Jojo);
        myShelf.addBook(Candide);

        for(int i = 0; i < myShelf.getSize(); i++) {
           Book temp = myShelf.getBook(i);
           System.out.println(temp.toString());
        }

        myShelf.emptyBookshelf();

        System.out.println(myShelf.toString());
    }
}
