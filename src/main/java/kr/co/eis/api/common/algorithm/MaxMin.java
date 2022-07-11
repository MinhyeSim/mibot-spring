package kr.co.eis.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * packageName: kr.co.eis.api.common.algorithm
 * fileName   : MaxMin
 * author     : Jangwonjong
 * date       : 2022-05-17
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-17     Jangwonjong       최초 생성
 */
public class MaxMin {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private int[] arr;
        private int max, min;
        @Override
        public String toString(){
            return String.format("최소값: %d 최대값: %d", min,max);
        }
    }
    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution s);
    }
    @Test
    void testSolution(){
        int[] arr = {5,1,9,3,123,2};
        SolutionService f = e ->{
            int min = 123;
            int max = 0;
            for(int i : e.getArr()){
                if(i < min) min = i;
            }
            for(int i : e.getArr()){
                if(i > max) max = i;
            }
            return Solution.builder().min(min).max(max).build();
        };

        Solution solution2 = Solution.builder().arr(arr).build();
        System.out.println(f.solution(solution2));
    }

}

