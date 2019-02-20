package burakan;

public class LambdaTeletypeServiceInjector implements MessageServiceInjector
{
    @Override
    public Processor getProcess()
    {
        return new MyApplication(new LambdaTeletypeServiceImpl());
    }
}
