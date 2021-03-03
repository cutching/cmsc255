package Labs.RevelProjects;

public class Exercise09_09
{
    public static void main(String[] arg)
    {
        RegularPolygon poly1 = new RegularPolygon();
        RegularPolygon poly2 = new RegularPolygon(6, 4);
        RegularPolygon poly3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("Polygon 1 perimeter: " + poly1.getPerimeter());
        System.out.println("Polygon 1 area: " + poly1.getArea());
        System.out.println("Polygon 2 perimeter: " + poly2.getPerimeter());
        System.out.println("Polygon 2 area: " + poly2.getArea());
        System.out.println("Polygon 3 perimeter: " + poly3.getPerimeter());
        System.out.println("Polygon 3 area: " + poly3.getArea());
    }

    public static class RegularPolygon
    {
        private int n = 3;
        private double side = 1;
        private double x = 0;
        private double y = 0;

        public RegularPolygon()
        {
        }

        public RegularPolygon(int n, double side)
        {
            this.n = n;
            this.side = side;
        }

        public RegularPolygon(int n, double side, double x, double y)
        {
            this.n = n;
            this.side = side;
            this.x = x;
            this.y = y;
        }

        public void setN(int n)
        {
            this.n = n;
        }

        public void setSide(double side) {
            this.side = side;
        }

        public void setX(double x)
        {
            this.x = x;
        }

        public void setY(double y)
        {
            this.y = y;
        }

        public double getSide()
        {
            return side;
        }

        public double getX()
        {
            return x;
        }

        public double getY()
        {
            return y;
        }

        public int getN()
        {
            return n;
        }

        public double getPerimeter()
        {
            return n * side;
        }

        public double getArea()
        {
            return n * Math.pow(side,2) / (4 * Math.tan(Math.PI / n));
        }
    }


}
