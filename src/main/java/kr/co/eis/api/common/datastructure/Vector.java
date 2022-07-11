package kr.co.eis.api.common.datastructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName: kr.co.eis.api.common.datastructure
 * fileName   : Vector
 * author     : Jangwonjong
 * date       : 2022-05-13
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-13     Jangwonjong       최초 생성
 */
@Data @Component @Lazy
public class Vector <T>{
    private ArrayList<T> list;
    Vector() {
        this.list = new ArrayList<>();
    }
    // save, update, delete, findAll, findByName, findById, count, existsBuId, clear 맵
    // add, set, remove, get(), X, get(id), size, X, clear 리스트
    // 사용할때 메소드명 헷갈리지 않게
    public void add(T t) {
        list.add(t);
    }
    public void insert(T t, int i){list.add(i,t);}
    public void set(T t, int i) {
        list.set(i,t);
    }
    public void remove(T t) {
        list.remove(t);
    }
    public List<T> get() {
        return list;
    }
    public T getId(int i) {
        return list.get(i);
    }
    public int count() {
        return list.size();
    }
    public void clear() {
        list.clear();
    }
}
