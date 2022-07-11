package kr.co.eis.api.common.lambdas;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.function.Supplier;

/**
 * packageName: kr.co.eis.api.common.lambdas
 * fileName   : LambdaLab
 * author     : Jangwonjong
 * date       : 2022-05-26
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-26     Jangwonjong       최초 생성
 */
public class LambdaLab {
    public static void solution(){

    }

    public static String date1(){
        Supplier<Date> f = Date::new;
        return String.valueOf(f.get());
    }

    public static String date2(){
        Supplier<String> f = () -> Lambda.string(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        return f.get();
    }
    public static String date(){
        Supplier<String> f = () -> Lambda.string(LocalDate.now());
        return f.get();
    }
    @Test
    public void testsolution(){
        System.out.println(date1());
        System.out.println(date2());
        System.out.println(date());
    }
}
