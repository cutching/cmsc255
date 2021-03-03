package Labs.Lab8;

public class Array {
    public static void main(String[] args)
    {
        String[] tokens = args[0].split(",");
        String[] customerName = new String[8];

        for(int i = 0; i < tokens.length; i++)
        {
            customerName[i] = tokens[i];
        }

        for (String i: customerName)
        {
            System.out.println(i);

        }
        System.out.println();

        customerName[6] = customerName[4];
        customerName[7] = customerName[5];
        customerName[4] = customerName[3];
        customerName[5] = "Jessica";

        for (String i: customerName)
        {
            System.out.println(i);
        }
        System.out.println();

        for(int i = 0; i < customerName.length/2; i++)
        {

            String temp = customerName[i];
            customerName[i] = customerName[customerName.length-i-1];
            customerName[customerName.length-i-1] = temp;
        }

        for (String i: customerName)
        {
            System.out.println(i);
        }
        System.out.println();

        for(int i = 0; i < customerName.length; i++)
        {
            if(customerName[i] != null)
            {
                if(customerName[i].equals("Rick"))
                {
                    customerName[i] = null;

                    for(int temp = i + 1;temp<customerName.length;temp++)
                    {
                        customerName[temp-1] = customerName[temp];
                    }
                    customerName[customerName.length-1] = null;
                    i--;
                }
            }
        }

        for (String i: customerName)
        {
            System.out.println(i);
        }
        System.out.println();
    }
}
