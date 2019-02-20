package Burakan;

public class Main
{
    public static int fact(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        else
        {
            return n * fact(n - 1);
        }
    }

    // psvm == public static void main(String[] args)
    public static void main(String[] args)
    {
        System.out.println("Factorial " + fact(7));
    }
}
