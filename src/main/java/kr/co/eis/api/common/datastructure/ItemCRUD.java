package kr.co.eis.api.common.datastructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * packageName: kr.co.eis.api.common.datastructure
 * fileName   : ItemCRUD
 * author     : Jangwonjong
 * date       : 2022-05-10
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-10     Jangwonjong       최초 생성
 */
public class ItemCRUD {
    public static void main(String[] args) {

    }
    @Data @AllArgsConstructor @Component
    class Item{}

    interface ItemService{}

    @RequiredArgsConstructor
    class ItemServiceImpl implements ItemService{}

}
