package InflearnJava8.FunctionalInterfaceAndLambdaIntroduce;

import java.util.function.Function;

// Function<input, return>
public class Plus10 implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
