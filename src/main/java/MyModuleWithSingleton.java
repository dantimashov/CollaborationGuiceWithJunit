import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import utils.WebDriver;

/**
 * @author daniil.timashov on 13/06/2020
 */
public class MyModuleWithSingleton extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriver.class).in(Scopes.SINGLETON);
    }

}
