package burakan;

public interface MessageService
{
    void sendMessage(String msg, String receiveAddress);
    String readMessage();
}
