package burakan;

public class Main
{

    public static void main(String[] args)
    {
        // write your code here
        MyApplication messaging = new MyApplication(new MessageService());
        messaging.send("Hello World!", "BonnW");
    }
}
