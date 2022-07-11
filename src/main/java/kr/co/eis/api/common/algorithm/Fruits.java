package kr.co.eis.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName: kr.co.eis.api.common.algorithm
 * fileName   : Fruits
 * author     : Jangwonjong
 * date       : 2022-05-17
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-17     Jangwonjong       최초 생성
 */
public class Fruits {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class Solution{
        private int tatal, apple, grape, orange;
        private int[][] fruitMarket;
    }
}
