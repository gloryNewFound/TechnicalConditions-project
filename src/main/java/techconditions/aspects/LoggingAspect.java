package techconditions.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @After("writingTechConditionsPointcut()")
    public void afterTechConditionsWritingLoggingAspect() {
        System.out.println("******************************************************************");
        System.out.println("");
        System.out.println("******************************************************************");
    }
}
