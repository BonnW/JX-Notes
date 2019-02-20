package burakan;

public class MessageService
{
    public void sendMessage(String message, String address)
    {
        System.out.println("For " + address + ": " +  message);
    }

    public String readMessage()
    {
        return "Not Implemented";
    }
}
