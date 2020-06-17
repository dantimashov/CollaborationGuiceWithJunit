package runners;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

/**
 * @author daniil.timashov on 14/06/2020
 */
public class GuiceRunners extends BlockJUnit4ClassRunner {

    private Class<?>[] modules;

    public GuiceRunners(Class<?> klass) throws InitializationError {
        super(klass);
        this.modules = this.getModulesForClass(klass);
    }

    @Override
    protected Object createTest() throws Exception {
        Object jUnitTest = super.createTest();
        createInjector(modules).injectMembers(jUnitTest);
        return jUnitTest;
    }

    private Injector createInjector(Class<?>[] modules) {
        List<Module> moduleList = new ArrayList<>();
        for (Class<?> klass : modules) {
            try {
                Module module = (Module) klass.newInstance();
                moduleList.add(module);
            } catch (InstantiationException e) {
                throw new IllegalStateException(format("Error with instantiation during Module object creation by constructor of class %s", klass.getName()));
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(format("Error with access during Module object creation by constructor of class %s", klass.getName()));
            }
        }
        return Guice.createInjector(moduleList);
    }

    private Class<?>[] getModulesForClass(Class<?> klass) {
        GuiceModules guiceModules = klass.getAnnotation(GuiceModules.class);
        return Optional.ofNullable(guiceModules)
                       .orElseThrow(() -> new IllegalStateException(format("Not found modules for test class %s", klass.getName())))
                       .value();
    }
}
