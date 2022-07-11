package kr.co.eis.api.common.streams;

import lombok.*;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * packageName: kr.co.eis.api.common.streams
 * fileName   : HelloStream
 * author     : Jangwonjong
 * date       : 2022-05-16
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-16     Jangwonjong       최초 생성
 */
//한국어 안녕, 영어 Hello
public class HelloStream {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Hello {
        private String greeting, inLanguage;
        /*
        public Hello(Builder builder) {
            this.greeting = builder.greeting;
            this.inLanguage = builder.inLanguage;
        }

        public static class Builder {
            private String greeting, inLanguage;

            public Builder greeting(String greeting) {
                this.greeting = greeting;
                return this;
            }

            public Builder inLanguage(String inLanguage) {
                this.inLanguage = inLanguage;
                return this;
            }

            public Hello build() {
                return new Hello(this);
            }
        }
        */
        @Override
        public String toString() {
            return String.format(" 인사 : %s, %s", inLanguage,greeting);
        }
    }
    interface HelloService {
            Set<Hello> greet(List<Hello> arr);
    }

    static class HelloServiceImpl implements HelloService {
            @Override
            public Set<Hello> greet(List<Hello> arr) {
                return arr
                        .stream()
                        .filter(e -> e.getInLanguage().equals("한국어"))
                        .collect(Collectors.toSet());
            }
    }
    @Test
    void helloStreamTest(){
        List<Hello> arr = Arrays.asList(
                Hello.builder().inLanguage("영어").greeting("Hello").build(),
                Hello.builder().inLanguage("한국어").greeting("안녕").build()
        );
        new HelloServiceImpl()
                .greet(arr)
                .forEach(System.out::print);
    }

}
