package techconditions.aspects;


import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* find*(..))")
    public void writingTechConditionsPointcut(){}
}
