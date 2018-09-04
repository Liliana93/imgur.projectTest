package steps;

/**
 * Created by Liliana on 04.09.2018.
 */
public class DriverFactory {
    public static AbstractDriver setDriver(Drivers type){
        AbstractDriver abstractDriver;

        switch (type) {
            case CHROME:
               abstractDriver = new ChromeDriver();
                break;
            case FIREFOX:
                abstractDriver = new FirefoxDriver();
                break;
            default:
                abstractDriver = new FirefoxDriver();
                break;
        }
        return abstractDriver;

    }
}
