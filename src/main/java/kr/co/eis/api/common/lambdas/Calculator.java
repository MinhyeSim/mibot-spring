package kr.co.eis.api.common.lambdas;

import org.junit.jupiter.api.Test;

/**
 * packageName: kr.co.eis.api.common.lambda
 * fileName   : Calculator
 * author     : Jangwonjong
 * date       : 2022-05-11
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-11     Jangwonjong       최초 생성
 */
public class Calculator {

    interface Arithmetic{
        int operation(int a, int b);
    }
    private int operate(int a, int b, Arithmetic arith){
        return arith.operation(a,b);
    }

    @Test
    void calculatorTest(){
        var s = "계산기";
        System.out.println(s);
        Calculator c = new Calculator();
        System.out.println("10 + 5 = " + c.operate(10, 5, (a,b)->a+b));
        System.out.println("10 - 5 = " + c.operate(10, 5, (a,b)->a-b));
        System.out.println("10 x 5 = " + c.operate(10, 5, (a,b)->a*b));
        System.out.println("10 / 5 = " + c.operate(10, 5, (a,b)->a/b));
    }
}
