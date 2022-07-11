package kr.co.eis.api.common.datastructure;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName: kr.co.eis.api.common.datastructure
 * fileName   : BmiList
 * author     : Jangwonjong
 * date       : 2022-05-11
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-11     Jangwonjong       최초 생성
 */
// 키(height) 몸무게(weight) 성별 생년월일(ssn 900101-1) 아이디는 인덱스 처리
public class BmiList {
    public static void main(String[] args) {

    }
    @Data
    static class Bmi{
        protected double height, weight;
        protected int ssn;

        public Bmi(Builder builder){
            this.height = builder.height;
            this.weight = builder.weight;
            this.ssn = builder.ssn;
        }
        @NoArgsConstructor
        static class Builder{
            private double height, weight;
            private int ssn;
            public Builder height (double height){this.height=height; return this;}
            public Builder weight (double weight){this.weight=weight; return this;}
            public Builder ssn (int ssn){this.ssn=ssn; return this;}
            Bmi build(){return  new Bmi(this);}
        }
    }
    interface BmiService{
        void save(Bmi bmi);
        void update(Bmi bmi, int i);
        void delete(Bmi bmi);
        List<Bmi> findAll();
        List<Bmi> findByGender(String gender);
        Bmi findById(int i);
        int count();
        void clear();

    }
    static class BmiServiceImpl implements BmiService{
        private final List<Bmi> list;

        BmiServiceImpl() {
            this.list = new ArrayList<>();
        }

        @Override
        public void save(Bmi bmi) {
            list.add(bmi);
        }

        @Override
        public void update(Bmi bmi, int i) {
            list.set(i, bmi);

        }


        @Override
        public void delete(Bmi bmi) {
            list.remove(bmi);
        }

        @Override
        public List<Bmi> findAll() {
            return list;
        }

        @Override
        public List<Bmi> findByGender(String gender) {
            return null;
        }

        @Override
        public Bmi findById(int i) {
            return list.get(i);
        }

        @Override
        public int count() {
            return list.size();
        }

        @Override
        public void clear() {

        }
    }
}
