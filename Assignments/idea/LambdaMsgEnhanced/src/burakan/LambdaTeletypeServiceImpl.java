package burakan;

public class LambdaTeletypeServiceImpl implements MessageService
{
    @Override
    public void sendMessage(String msg, String address)
    {
        System.out.println(address + ": " + msg + ": " + address);
    }

    @Override
    public String readMessage()
    {
        return "Not Implemented Yet";
    }
}
