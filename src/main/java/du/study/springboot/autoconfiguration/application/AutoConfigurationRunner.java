package du.study.springboot.autoconfiguration.application;

import du.study.springboot.autoconfiguration.another.AnotherComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AutoConfigurationRunner implements ApplicationRunner {
    @Autowired
    public AnotherComponent anotherComponent;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        anotherComponent.printTest();
    }
}
