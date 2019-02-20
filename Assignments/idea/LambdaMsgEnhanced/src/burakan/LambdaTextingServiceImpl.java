package burakan;

public class LambdaTextingServiceImpl implements MessageService
{
    @Override
    public void sendMessage(String msg, String receiveAddress)
    {
        System.out.println(msg + ": " + receiveAddress.toUpperCase());
    }

    @Override
    public String readMessage()
    {
        return "Not Implemented yet";
    }
}
