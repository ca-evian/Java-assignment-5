import java.util.*;

public class VectorTime {
    public static void main(String args[]){
        int number = 1000000;  //ArrayList的个数
        List<Integer> vector = new Vector<>();
        for(int i = 1; i<=number;i++){
            vector.add(i);
        }


        HashSet<Integer> aggregate = new HashSet<>();  //aggregate存放要搜索的元素
        int max = number;
        int min = 1;
        while(aggregate.size() < (number / 10)) {
            int num = (int) (Math.random() * (max - min)) + min;
            aggregate.add(num);
        }

        long time = 0;
        long begin = 0;
        long end = 0;


        for(Integer temp : aggregate){
            begin = System.nanoTime();
            vector.contains(temp);
            end = System.nanoTime();
            time += end - begin;
        }

        System.out.println(number+"个Vector中搜索"+ number / 10 +"个元素的时间为：" + time + "纳秒");
    }

}
