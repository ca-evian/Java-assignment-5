import java.util.*;

public class HashMapTime {
    public static void main(String args[]) {
        int number = 1000000;  //ArrayList的个数
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 1; i <= number; i++) {
            hashmap.put(i, i);
        }


        HashSet<Integer> aggregate = new HashSet<>();  //aggregate存放要搜索的元素
        int max = number;
        int min = 1;
        while (aggregate.size() < (number / 10)) {
            int num = (int) (Math.random() * (max - min)) + min;
            aggregate.add(num);
        }

        long keytime = 0;
        long valuetime = 0;
        long begin = 0;
        long end = 0;


        for (Integer temp : aggregate) {
            begin = System.nanoTime();
            hashmap.containsKey(temp);
            end = System.nanoTime();
            keytime += end - begin;
            begin = System.nanoTime();
            hashmap.containsValue(temp);
            end = System.nanoTime();
            valuetime += end - begin;
        }

        System.out.println(number + "个HashMap中搜索" + number / 10 + "个Key的时间为：" + keytime + "纳秒");
        System.out.println(number + "个HashMap中搜索" + number / 10 + "个Value的时间为：" + valuetime + "纳秒");

    }
}
