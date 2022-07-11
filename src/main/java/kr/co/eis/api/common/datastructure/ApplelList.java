package kr.co.eis.api.common.datastructure;

import static kr.co.eis.api.common.lambdas.Lambda.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * packageName: kr.co.eis.api.common.datastructure
 * fileName   : ApplelList
 * author     : Jangwonjong
 * date       : 2022-05-11
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-11     Jangwonjong       최초 생성
 */
// Apple color price(int) origin(영동, 풍기)
public class ApplelList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppleService service = new AppleServiceImpl();
        while (true) {
            switch (scanner.next()) {
                case "0":
                    return;
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":
                    break;
                case "6":
                    System.out.println("총 회원 목록: " + service.findAll());
                    break;
                case "7":
                    System.out.println("총 회원 수: " + service.count());
                    break;
                case "8":
                    break;
                case "9":
                    service.clear();
                    break;
                case "10":
                    System.out.println("사과 가격은"+ integer("1000"));
                    System.out.println("array size"+ array(20).length);
                    break;
                default:
                    break;

            }
        }
    }
    @Test
    void applelistTest(){
        System.out.println("0.Exit 1.save 2.update 3.delete 4.findById 5.findByName 6.findAll 7.count 8.existById 9.clear");

        AppleService service = new AppleServiceImpl();
        System.out.println("### 1. save ###");
        Apple yd = new Apple.Builder()
                .origin("영동")
                .color("RED")
                .price(1000)
                .build();
        service.save(yd);
        Apple yd2 = new Apple.Builder()
                .origin("영동")
                .color("BLUE")
                .price(1500)
                .build();
        service.save(yd2);
        Apple pg = new Apple.Builder()
                .origin("풍기")
                .color("RED")
                .price(2000)
                .build();
        service.save(pg);
        System.out.println(yd);
        System.out.println(yd2);
        System.out.println(pg);
        System.out.println("### 2. update ###");
        service.update(1,new Apple.Builder().origin("서울").color("GREEN").price(3).build());
        System.out.println("### 3. delete ###");
        System.out.println("### 4. findById ###");
        System.out.println("### 5. findByName ###");
        System.out.println("### 6. findAll ###");
        System.out.println(service.findAll());
        System.out.println("### 7. count ###");
        System.out.println("### 8. existById ###");
        System.out.println("### 9. clear ###");
        service.clear();
    }


    @Data
    public static class Apple{
        protected String color, origin;
        protected int price;

        public Apple(Builder builder){
            this.color = builder.color;
            this.origin = builder.origin;
            this.price = builder.price;
        }
        @NoArgsConstructor
        public static class Builder{
            private String color, origin;
            private int price;
            public Builder color (String color){this.color=color; return this;}
            public Builder origin(String origin){this.origin=origin; return this;}
            public Builder price(int price){this.price=price; return this;}
            public Apple build(){return  new Apple(this);}
        }
        @Override public String toString(){
            return String.format("[apple spec] origin : %s, color : %s, price: %d",
                    origin, color, price);

        }
    }
    interface AppleService{
        void save(Apple apple);
        void update(int i, Apple apple);
        void delete(Apple apple);
        List<Apple> findAll();
        List<Apple> findByOrigin(String orgin);
        List<Apple> findByColor(String color);
        Apple findById(int i);
        int count();
        void clear();
    }

    static class AppleServiceImpl implements AppleService{
        private final List<Apple> list;

        AppleServiceImpl() {
            this.list = new ArrayList<>();
        }


        @Override
        public void save(Apple apple) {
            list.add(apple);
        }

        @Override
        public void update(int i, Apple apple) {
            list.set(i, apple);
        }


        @Override
        public void delete(Apple apple) {
            list.remove(apple);
        }

        @Override
        public List<Apple> findAll() {
            return list;
        }
        @Override
        public List<Apple> findByOrigin(String orgin) {
            return list.stream()
                    .filter(apple -> apple.getOrigin().equals(orgin))
                    .collect(Collectors.toList());
        }

        @Override
        public List<Apple> findByColor(String color) {
            return list.stream()
                    .filter(apple -> apple.getColor().equals(color))
                    .collect(Collectors.toList());
        }

        @Override
        public Apple findById(int i) {
            return list.get(i);
        }

        @Override
        public int count() {
            return list.size();
        }

        @Override
        public void clear() {
            list.clear();
        }
    }



}
