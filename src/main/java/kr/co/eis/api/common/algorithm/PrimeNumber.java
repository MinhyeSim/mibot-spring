package kr.co.eis.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName: kr.co.eis.api.common.algorithm
 * fileName   : PrimeNumber
 * author     : Jangwonjong
 * date       : 2022-05-17
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-17     Jangwonjong       최초 생성
 */
// 1-100까지의 정수 중 소수 구하기
public class PrimeNumber {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Solution{
        private int start, end;
        List<Integer> prime;
        @Override
        public String toString() {
            return String.format("%d와 %d 사이 소수 : %s", start, end, prime);
        }
    }
    @FunctionalInterface private interface SolutionService{
       Solution solution(Solution solution);
    }
    @Test
    void testPrime() {
        SolutionService f = e -> {
            Solution s = Solution.builder().start(e.start).end(e.end).prime(e.prime).build();
            for (int i = s.start; i <= s.end; i++) {
                boolean isPrimeNumber = true;
                if (i == 1) continue;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrimeNumber = false;
                        break;
                    }
                }
                if (isPrimeNumber) { s.prime.add(i); }
            }
            return s;
        };
        Solution s = Solution.builder().start(1).end(100).prime(new ArrayList<>()).build();
        System.out.println(f.solution(s));
    }
}
