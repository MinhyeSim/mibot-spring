package kr.co.eis.api.common.streams;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName: kr.co.eis.api.common.streams
 * fileName   : PersonStream
 * author     : Jangwonjong
 * date       : 2022-05-16
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-16     Jangwonjong       최초 생성
 */
public class Example {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Person{
        private String name;
        private String ssn;


        @Override
        public String toString() {

            String gender = ssn;
            int age = (123 - Integer.parseInt(ssn.substring(0,2)))%100;

            if(ssn.substring(7).equals("1")||ssn.substring(7).equals("3")){
                gender = "남성";
            }else if (ssn.substring(7).equals("2")||ssn.substring(7).equals("4")){
                gender = "여성";
            }

            return String.format("%s님은 %d살이고 %s입니다", name, age, gender);
        }
    }
    // 기능 : 회원검색
    interface PersonService{
        Person search(List<Person> arr);

    }
    static class PersonServiceImpl implements PersonService{
        @Override
        public Person search(List<Person> arr2) {
            return arr2
                    .stream()
                    .filter(e -> e.getName().equals("장원종"))
                    .collect(Collectors.toList()).get(0);
        }
    }

    // "장원종", "900123-1"
    // "스칼라", "921021-2"
    // "벡터",   "040505-4"
    // 남성, 여성 판단 로직 + 나이 출력 ssn을 줬을 때 계산되는 나이
    // print "장원종은 남성입니다"
    @Test
    void exampleTest(){
        List<Person> arr = Arrays.asList(
                Person.builder().name("장원종").ssn("910804-1").build(),
                Person.builder().name("스칼라").ssn("910804-2").build(),
                Person.builder().name("벡터").ssn("900000-4").build()

        );

        System.out.println(
                new PersonServiceImpl()
                .search(arr));
    }
}
