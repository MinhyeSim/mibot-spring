package kr.co.eis.api.common.lambdas;

/**
 * packageName: kr.co.eis.api.common.lambda
 * fileName   : MyLambda
 * author     : Jangwonjong
 * date       : 2022-05-13
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-13     Jangwonjong       최초 생성
 */
public class MyLambda {
    @FunctionalInterface interface MyFunction{int execute(String arg);}
    @FunctionalInterface interface MyConsumer{void execute(String arg);}
    @FunctionalInterface interface MySupplier{int execute();}
    @FunctionalInterface interface MyPredicate{boolean execute(String arg);}
    @FunctionalInterface interface MyInterface{String myMethod();}
    @FunctionalInterface interface MyUnaryOp{int operator(Integer a);}
    @FunctionalInterface interface MathOperation{int execute(int a, int b);}


}

//MyFunction<String, Integer> f = Integer::parseInt;

