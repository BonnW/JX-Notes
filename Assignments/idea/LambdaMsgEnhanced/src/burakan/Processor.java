package burakan;

public interface Processor
{
    void sendMessage(String msg, String address);
    String readMessage();
}
