import com.google.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import runners.GuiceModules;
import runners.GuiceRunners;
import steps.ASteps;
import steps.BSteps;
import steps.CSteps;

/**
 * @author daniil.timashov on 13/06/2020
 */
@RunWith(GuiceRunners.class)
@GuiceModules(MyModuleWithSingleton.class)
public class MyTestWithRunners {

    @Inject private ASteps aSteps;
    @Inject private BSteps bSteps;
    @Inject private CSteps cSteps;

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
