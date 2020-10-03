package algorithm.cps.h;

import java.util.*;

class Data implements Comparable<Data> {
    int money; // 강연료
    int when; // 몇 일째까지

    Data(int money, int when){
        this.money = money;
        this.when = when;
    }

    // 정렬 기준
    public int compareTo(Data that) {

        // 내림차순
        if (that.when < this.when) {
            return -1;
        } else if (that.when == this.when) {
            return 0;
        } else {
            return 1;
        }

        //return that.when - this.when;
    }

}

public class ProblemEx75 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, j, a, b, res = 0, max = -2147000000;

        ArrayList<Data> T = new ArrayList<>();
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder()); // 최대 힙
        n = sc.nextInt();

        for(i=1; i<=n; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            T.add(new Data(a, b));

            if(b > max)
                max = b;
        }

        Collections.sort(T);

        j = 0;

        for(i=max; i>=1; i--){
            for(; j<n; j++){
                Data tmp = T.get(j);
                if(T.get(j).when < i)
                    break;

                priorityQueue.add(T.get(j).money);
            }

            if(!priorityQueue.isEmpty()){
                res += priorityQueue.poll();
            }
        }

        System.out.println(res);

    }
}

/*

6
50 2
20 1
40 2
60 3
30 3
30 1

*/