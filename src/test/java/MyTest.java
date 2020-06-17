import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import steps.ASteps;
import steps.BSteps;
import steps.CSteps;

/**
 * @author daniil.timashov on 13/06/2020
 */
public class MyTest {

    @Inject private ASteps aSteps;
    @Inject private BSteps bSteps;
    @Inject private CSteps cSteps;

    @Before
    public void prepare() {
         Injector injector = Guice.createInjector(new MyModuleWithSingleton());
         injector.injectMembers(this);
    }

    @Test
    public void test1() {
        printFields("test1");
    }

    @Test
    public void test2() {
        printFields("test2");
    }

    private void printFields(String testName) {
        System.out.println(testName);
        System.out.println(this.aSteps);
        System.out.println(this.bSteps);
        System.out.println(this.cSteps);
        System.out.println("============");
        System.out.println();
    }
}
