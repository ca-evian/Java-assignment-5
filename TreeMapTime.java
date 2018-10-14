import java.util.*;
public class TreeMapTime {
    public static void main(String args[]){
        int number = 1000000;  //ArrayList的个数
        TreeMap<Integer,Integer> treemap = new TreeMap<>();
        for(int i = 1; i<=number;i++){
            treemap.put(i,i);
        }


        HashSet<Integer> aggregate = new HashSet<>();  //aggregate存放要搜索的元素
        int max = number;
        int min = 1;
        while(aggregate.size() < (number / 10)) {
            int num = (int) (Math.random() * (max - min)) + min;
            aggregate.add(num);
        }

        long keytime = 0;
        long valuetime = 0;
        long begin = 0;
        long end = 0;


        for(Integer temp : aggregate){
            begin = System.nanoTime();
            treemap.containsKey(temp);
            end = System.nanoTime();
            keytime += end - begin;
            begin = System.nanoTime();
            treemap.containsValue(temp);
            end = System.nanoTime();
            valuetime += end - begin;
        }

        System.out.println(number+"个TreeMap中搜索"+ number / 10 +"个Key的时间为：" + keytime + "纳秒");
        System.out.println(number+"个TreeMap中搜索"+ number / 10 +"个Value的时间为：" + valuetime + "纳秒");

    }

}
