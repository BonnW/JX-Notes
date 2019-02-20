package burakan;

public class MyApplication
{
//    private MessageService msgSrv = new MessageService(); // hard coded dependency

    private MessageService msgSrv;

    public MyApplication(MessageService msgSrv)
    {
        this.msgSrv = msgSrv;
    }

    public void send(String msg, String receiveAddress)
    {
        // rules of message
        msg = msg + "\n *** FOR YOUR EYES ONLY ***";
        msgSrv.sendMessage(msg, receiveAddress);
    }
}
