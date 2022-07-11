package kr.co.eis.api.common.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName: kr.co.eis.api.common.streams
 * fileName   : PersonStream2
 * author     : Jangwonjong
 * date       : 2022-05-17
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-17     Jangwonjong       최초 생성
 */
public class PersonStream {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Person{
        private String name, ssn;
        private boolean getGenderChecker(String ssnGenderpos){
            return ssn.substring(7,8).equals(ssnGenderpos);
        }
        @Override
        public String toString(){
            String gender =(getGenderChecker("1")||getGenderChecker("3"))? "남자" :"여자";
            int year = Integer.parseInt(ssn.substring(0,2));
            if(getGenderChecker("1")){year+= 1900;}
            else if(getGenderChecker("2")){year+= 1900;}
            else {year+= 2000;}
            String age = String.valueOf(2022-year+1);
            return String.format("이름 : %s 성별 : %s 나이 : %s", name, gender, age);
        }
    }
    @FunctionalInterface interface PersonService{
        Person search(List<Person> persons);
    }
    @Test
    void personStreamTest(){
        // "홍길동","900120-1"
        // "김유신","970620-1"
        // "유관순","040920-4"
        // 남성, 여성, 나이 판단 로직
        List<Person> l = Arrays.asList(
                Person.builder().name("홍길동").ssn("900120-1").build(),
                Person.builder().name("김유신").ssn("970620-1").build(),
                Person.builder().name("유관순").ssn("040920-4").build()
        );

        PersonService ps = a -> a
                .stream()
                .filter(e -> e.getName().equals("홍길동"))
                .collect(Collectors.toList()).get(0);
        System.out.println(ps.search(l));

    }
}

