/************************************
 *Lab9.java
 *************************************
 *2d Array manipulation
 *Gavin Cutchin
 *10/14/2020
 *CMSC 255 002
 ************************************/
package Labs.Lab9;

public class Lab9 {

    public static void main(String[] args) {
        int [][] addTo10Input = {
                {  6,  3,  2,  0,  4},{ 34, 53,  0, 23,  1},{  0, 23, 54, 11,  7}
        };

        double [][] findAvgInput = {
                {  5, 4.5,  6.8},
                {  6,  0,  3.4},
                { 7,  8.4,  2.3},

        };

        double [][] findAvgInputLarge = {
                { 6.7,  23.8,  0,  5.9,  12.8,  45.7},
                {  0,  36.8,  13.5,  6.7,  54.9,  67.4},
                {  37.4,  2.5,  39.8,  0,  2.4,  43.6},
                {  44,6,  76.5,  4.5, 2.4,  0, 54.6},
                {  5.4,  76.3,  6.5, 28.5,  54.7,  0},
                {  19.4,  0,  5.3,  65.4,  93.5,  3.5}
        };

        addTo10 (addTo10Input);
        System.out.println();
        findAverage (findAvgInput);
        System.out.println();
        findAverage (findAvgInputLarge);
        }

    public static void addTo10 (int [][] anArray)
    {
        int posRow = 0;
        int posCol = 0;
        int total = 0;
        for(int i = 0; i < anArray.length;i++)
        {
            for(int k = 0; k < anArray[i].length;k++)
            {
                if (anArray[i][k] == 0)
                {
                    posRow = i;
                    posCol = k;
                }

                total+= anArray[i][k];

            }
            anArray[posRow][posCol] = 10 - total;
            total = 0;
        }

        for(int i = 0; i < anArray.length;i++)
        {
            for(int k = 0; k < anArray[i].length;k++)
            {
                System.out.print(anArray[i][k] + " ");
            }
            System.out.println();
        }

    }

    public static void findAverage (double [][] anArray)
    {
        int posRow = 0;
        int posCol = 0;
        double vertAvg = 0;
        double horiAvg = 0;
        for(int i = 0; i < anArray.length;i++)
        {
            for(int k = 0; k < anArray[i].length;k++)
            {
                if(anArray[i][k] == 0)
                {
                    posRow = i;
                    posCol = k;
                    for (int r = 0; r < anArray[i].length; r++)
                    {
                        horiAvg += anArray[i][r];
                    }
                    for (int r = 0; r < anArray.length; r++)
                    {
                        vertAvg += anArray[r][k];
                    }



                    horiAvg = horiAvg / anArray[i].length;
                    vertAvg = vertAvg / anArray.length;

                    if(horiAvg >= vertAvg)
                    {
                        anArray[posRow][posCol] = horiAvg;
                    }
                    else
                    {
                        anArray[posRow][posCol] = vertAvg;
                    }
                }
                vertAvg = 0;
                horiAvg =0;
            }

        }

        for(int i = 0; i < anArray.length;i++)
        {
            for(int k = 0; k < anArray[i].length;k++)
            {
                System.out.print(anArray[i][k] + " ");
            }
            System.out.println();
        }

    }


}