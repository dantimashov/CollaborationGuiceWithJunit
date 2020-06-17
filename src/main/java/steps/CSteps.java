package steps;

import com.google.inject.Inject;
import utils.WebDriver;

/**
 * @author daniil.timashov on 13/06/2020
 */
public class CSteps {

    @Inject private WebDriver driver;

    @Override
    public String toString() {
        return String.format(
                "CSteps object with hash %d and driver field with hash %d", this.hashCode(), this.driver.hashCode()
        );
    }
}
