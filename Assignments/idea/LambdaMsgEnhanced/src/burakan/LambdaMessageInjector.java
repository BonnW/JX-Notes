package burakan;

// Will be needed for each message type
public class LambdaMessageInjector implements MessageServiceInjector
{
    @Override
    public Processor getProcess()
    {
        return new MyApplication(new LambdaMessageImpl());
    }
}
