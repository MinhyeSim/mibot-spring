package kr.co.eis.api.common.datastructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import kr.co.eis.api.user.domains.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName: kr.co.eis.api.common.datastructure
 * fileName   : Box
 * author     : Jangwonjong
 * date       : 2022-05-12
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-12     Jangwonjong       최초 생성
 */

@Component @Data @Lazy
public class Box<K, V> {
    private HashMap<K, V> map;

    public Box(){
        this.map = new HashMap<>();
    }
    public void save(K k, V v){
        map.put(k, v);
    }

    public void update(K k, V v){
        map.replace(k, v);
    }

    public void delete(K k){
        map.remove(k);
    }

    public List<V> findAll(){
        return (List<V>) map.values();
    }

    public V findById(K k){
        return map.get(k);
    }

    public int count(){
        return map.size();
    }

    public void clear(){
        map.clear();
    }
    // custom 부분
    // 회원목록요청시
    public List<User> findAllList(){
        List<User> ls = new ArrayList<>();
        for(Map.Entry<K,V > e: map.entrySet()){
            ls.add((User) e.getValue());
        }
        return ls;
    }

    // 테이블 키값 목록요청시
    public List<V> findAllKeyList(){
        List<V> ls = new ArrayList<>();
        for(Map.Entry<K,V > e: map.entrySet()){
            ls.add(e.getValue());
        }
        return ls;
    }

    // 이름으로 검색된 회원 목록 요청(필터가 필요없이 리액트로 던지는 경우)
    public List<User> findByUserName(String name){
        List<User> ls = new ArrayList<>();
        for(User v: ls){
            if(name.equals(v.getName())){
                ls.add(v);
            }
        }
        return ls;
    }
    // 이름으로 검색된 회원 목록 요청(추가 필터를 통해 더 줄어든 결과값이 필요한 경우)
    public Map<String, User> findMapByUserName(String name){
        Map<String,User> map = new HashMap<>();
        for (Map.Entry<String, User> e : map.entrySet()){
            if (name.equals(e.getValue().getName())) map.put(e.getKey(),e.getValue());
        }
        return map;
    }

}


