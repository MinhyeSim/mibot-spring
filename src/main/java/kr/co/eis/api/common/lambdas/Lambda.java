package kr.co.eis.api.common.lambdas;

import org.springframework.cglib.core.internal.Function;

import java.io.File;
import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

/**
 * packageName: kr.co.eis.api.common.lambda
 * fileName   : Lambda
 * author     : Jangwonjong
 * date       : 2022-05-11
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-11     Jangwonjong       최초 생성
 */
public class Lambda {
    public static void main(String[] args) {
        /**System.out.println(Lambda.integer("900"));
        System.out.println(Lambda.string(555));
        System.out.println(string(new Apple.Builder().origin("영동").color("R").price(1000).build()));
        System.out.println(
                string(
                        Arrays.asList(
                                new Apple.Builder().origin("영동").color("R").price(1000).build(),
                                new Apple.Builder().origin("풍기").color("B").price(1500).build(),
                                new Apple.Builder().origin("영동").color("R").price(2000).build()
                        )
                ));
        System.out.println(!equals("1","1"));
        System.out.println(array(5).length);**/
        System.out.println(random(1,6));
        System.out.println(random2(1,6));
    }

    public static int integer(String arg){
        // Integer i = Integer.parseInt("900")
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(arg);
    }
    public static long longParser(String s){
        Function<String, Long> f = Long::parseLong;
        return f.apply(s);
    }
    public static float floatParser(String s){
        Function<String, Float> f = Float::parseFloat;
        return f.apply(s);
    }
    public static String date(){
        Supplier<String> f = () -> string(LocalDate.now());
        return f.get();
    }

    public static String string(Object object){
        // String s = String.valueOf(Object)

        Function<Object, String> f = String::valueOf;
        return f.apply(object);
    }
    public static boolean equals(String s1, String s2){
        BiPredicate<String, String > predicate = String::equals;
            return predicate.test(s1,s2);
    }
    // int[] arr = new int [3];
    // int[]::new
    public static int[] array(int i){
        Function<Integer, int[]> f = int[]::new;
            return f.apply(i);
    }
    public static int random(int i, int j){
        BiFunction<Integer, Integer, Integer> f = (a, b) -> (int)(Math.random()*b)+a;
        return f.apply(i,j);
    }


    public static int random2(int i, int j){
        Supplier<Double> f = Math::random;
        return (int)(f.get()*j)+i;
    }
    //makeFile()   File file = new File("d:\\example\\new_directory");
    public static File makeFile(String  a){
        Function< String,File > f = File::new;
        return f.apply(a);
    }
}
