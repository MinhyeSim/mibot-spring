package kr.co.eis.api.common.datastructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * packageName: kr.co.eis.api.common.datastructure
 * fileName   : MemberCRUD
 * author     : Jangwonjong
 * date       : 2022-05-09
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-09     Jangwonjong       최초 생성
 */

public class MemberCRUD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService service = new MemberServiceImpl();
        while (true){
            System.out.println("0.Exit 1.save 2.update 3.delete 4.findById 5.findByName 6.findAll 7.count 8.existById 9.clear");
            switch (scanner.next()){
                case "0":return;
                case "1":
                    Member jang = new Member.Builder("jang")
                            .name("won")
                            .password("1")
                            .profileImg("jang.jpg")
                            .phone("010-1234-1234")
                            .email("jwj9922@naver.com")
                            .build();
                    service.save(jang);
                    Member kim = new Member.Builder("kim")
                            .name("sin")
                            .password("2")
                            .profileImg("kim.jpg")
                            .phone("010-2222-3333")
                            .email("kim@aaaa.com")
                            .build();
                    service.save(kim);
                    Member you = new Member.Builder("you")
                            .name("sun")
                            .password("3")
                            .profileImg("you.jpg")
                            .phone("010-3333-4444")
                            .email("you@aaaa.com")
                            .build();
                    service.save(you);
                    break;
                case "2":
                    Member temp = new Member();
                    temp.setUserid("jang");
                    service.update(temp);
                    break;
                case "3":
                    Member temp1 = new Member();
                    temp1.setUserid("you");
                    service.delete(temp1);
                    System.out.println("삭제된 값은"+temp1);
                    break;
                case "4":
                    String res2 = "";
                    //Member temp2 = new Member();
                    //System.out.println(service.findById(scanner.next()));
                    //temp2.setUserid("you");
                    //res = (service.findById(scanner.next())==null) ? "찾는 값이 없습니다" : String.format("찾는 값은 %s입니다", temp2);
                    res2 = (service.findById(scanner.next())==null) ? "찾는 값이 없습니다" : "찾으시는 값은: "+service.findById(scanner.next());
                    System.out.println(res2);
                    //System.out.println(res);
                    // res 리턴 왜 null???
                    break;
                case "5":
                    System.out.println("이름검색");
                    System.out.println("찾는 아이디 정보: " + service.findByName(scanner.next()));
                    break;
                case "6":
                    System.out.println("총 회원 목록: " + service.findAll());
                    break;
                case "7":
                    System.out.println("총 회원 수: "+ service.count());
                    break;
                case "8":
                    System.out.println("사용가능 ID 검색");
                    System.out.println(service.existsById(scanner.next()) ? "Already used": "can use this ID");

                    break;
                case "9":
                    service.clear();
                    break;
                default:break;

            }
        }
    }
    @Data @NoArgsConstructor
    static class Member{
        protected String userid, name, password, profileImg, phone, email;

        public Member(Builder builder){
            this.userid = builder.userid;
            this.name = builder.name;
            this.password = builder.password;
            this.profileImg = builder.profileImg;
            this.phone = builder.phone;
            this.email = builder.email;
        }
        static class Builder{
            private String userid, name, password, profileImg, phone, email;
            public Builder(String userid){this.userid=userid;}
            public Builder name (String name){this.name=name; return this;}
            public Builder password(String password){this.password=password; return this;}
            public Builder profileImg(String profileImg){this.profileImg=profileImg; return this;}
            public Builder phone(String phone){this.phone=phone; return this;}
            public Builder email(String email){this.email=email; return this;}
            Member build(){return  new Member(this);}
        }
        @Override public String toString(){
            return String.format("[user spec] userid : %s, name : %s, password: %s, profileImg : %s, phone: %s, email: %s,",
                    userid, name, password, profileImg, phone, email);

        }
    }
    interface MemberService{
        void save(Member member);
        void update(Member member);
        void delete(Member member);
        Member findById(String id);
        Member findByName(String name);
        List<Member> findAll();
        int count();
        boolean existsById(String id);
        void clear();
    }

    static class MemberServiceImpl implements MemberService{
        private final Map<String, Member> map;

        MemberServiceImpl(){
            this.map = new HashMap<>();
        }
        @Override
        public void save(Member member) {
            map.put(member.getUserid(), member);
        }

        @Override
        public void update(Member member) {
            map.replace(member.getUserid(), member);
        }

        @Override
        public void delete(Member member) {
            map.remove(member.getUserid());
        }

        @Override
        public Member findById(String id) {
            return map.get(id);
        }

        @Override
        public Member findByName(String name) {
            return map.get(name);
        }

        // 동일인물 일 수 있으니까 list로
        /*public List<Member> findByName(String name) {
            return (List<Member>) map.get(name);*/


        @Override
        public List<Member> findAll() {
            return new ArrayList<>(map.values());
        }

        @Override
        public int count() {
            return map.size();
        }

        @Override
        public boolean existsById(String id) {
            return map.containsKey(id);
        }

        @Override
        public void clear() {
            map.clear();
        }
    }
}
