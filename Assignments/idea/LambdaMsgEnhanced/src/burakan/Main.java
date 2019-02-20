package burakan;

public class Main
{

    public static void main(String[] args)
    {
        // write your code here
        String myMsg = "Whats up Me";
        String myAddress = "Burakan.address";
        String myText = "Some Message Text";

        MessageServiceInjector injector;
        Processor app;

        injector = new LambdaMessageInjector();
        app = injector.getProcess();
        app.sendMessage(myMsg, myAddress);

        injector = new LambdaTextingServiceInjector();
        app = injector.getProcess();
        app.sendMessage(myMsg, myText);
//
        injector = new LambdaTeletypeServiceInjector();
        app = injector.getProcess();
        app.sendMessage(myMsg, myAddress);

        System.out.println("\n\n");
    }
}
