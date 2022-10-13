package techconditions.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @After("writingTechConditionsPointcut()")
    public void afterTechConditionsWritingLoggingAspect(JoinPoint joinPoint) {
        System.out.println("Found");
        System.out.println("******************************************************************");
    }
}
