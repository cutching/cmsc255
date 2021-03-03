package Labs.midterm;

public class question {
    public static void main(String[] args) {
        int a = 3;
        int b = 7;
        int c = 4;
        c = c + b * a;
        a = c % b;
        c = b;
        b = c / a;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
