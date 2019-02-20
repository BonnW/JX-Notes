package burakan;

public class LambdaTextingServiceInjector implements MessageServiceInjector
{
    @Override
    public Processor getProcess()
    {
        return new MyApplication(new LambdaMessageImpl());
    }
}
