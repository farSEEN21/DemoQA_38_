import manager.AppManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase implements AppManager {


@BeforeTest
    public void setUp(){
    init();
}

@AfterSuite(alwaysRun = true)
    public void stop(){
//    tearDown();
}


}
