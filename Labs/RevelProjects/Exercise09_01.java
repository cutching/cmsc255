package Labs.RevelProjects;

public class Exercise09_01 {
    public static void main(String[] args)
    {
        Rectangle test = new Rectangle();
        test.specifiedRect(4.0,40.0);
        System.out.println("The area of the rectangle with width " + test.width + " and height " + test.height + " is " + test.getArea());
        System.out.println("The perimeter of a rectangle " + test.getPerimeter());
        test.specifiedRect(3.5,35.9);
        System.out.println("The area of the rectangle with width " + test.width + " and height " + test.height + " is " + test.getArea());
        System.out.println("The perimeter of a rectangle " + test.getPerimeter());
    }

    public static class Rectangle
    {
        private double width;
        private double height;

        public void defRect()
        {
            width = 1;
            height = 1;
        }

        public void specifiedRect(double width, double height)
        {
            this.width = width;
            this.height = height;
        }

        public double getArea()
        {
            return height * width;
        }

        public double getPerimeter()
        {
            return (2 * height) + (width * 2);
        }
    }
}

