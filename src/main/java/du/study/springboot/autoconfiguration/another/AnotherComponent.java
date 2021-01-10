package du.study.springboot.autoconfiguration.another;

import org.springframework.stereotype.Component;

@Component
public class AnotherComponent {
    public void printTest(){
        System.out.println("hello");
    }
}
