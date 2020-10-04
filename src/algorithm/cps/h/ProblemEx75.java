package algorithm.cps.h;

import java.util.*;

class Data implements Comparable<Data> {
    int money; // 강연료
    int when; // 몇 일 안에 와야 되는지에 대한 기한

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
        int n, i, m, d, res = 0, max = -2147000000;

        ArrayList<Data> list = new ArrayList<>(); // Data 타입을 저장하는 ArrayList 생성
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder()); // 최대 힙
        n = sc.nextInt(); // n: 기업의 수

        for(i=1; i<=n; i++){
            m = sc.nextInt(); // 강연료
            d = sc.nextInt(); // D일 (기한)

            list.add(new Data(m, d));

            if(d > max) // 날짜 중에 가장 큰 값을 찾는다. max : 마지막 강연 날짜
                max = d;
        }

        Collections.sort(list); // 날짜를 기준으로 내림차순 정렬한다.

        /*
            max 부터 강연 스케줄링을 한다.
            j 일차에는 어떤 강연을 할 것인지 결정한다. (j는 강연 하는 날짜를 의미)
        */
        int j = 0;

        for(i=max; i>=1; i--){
            while(j < n){ // 강연 요청을 한 기업의 수(n)만큼 반복
                Data data = list.get(j);
                if(data.when < i) // ArrayList에 있는 강연 날짜가 i 일차 보다 작으면, 우선 순위 큐에 넣지 마라.
                    break;        // 즉 max가 3일 때, 3 보다 작은 1, 2는 우선 순위 큐에 넣으면 안되므로 반복 종료 (3 일차에 할 수 없는 강연이므로)

                priorityQueue.offer(data.money); // i 일차에 할 수 있는 강연료를 우선 순위 큐에 넣는다.

                j++;
            }

            if(!priorityQueue.isEmpty()){ // 우선 순위 큐가 비어 있지 않으면
                res += priorityQueue.poll(); // 우선 순위 큐에서 가장 큰 값을 꺼낸 다음, 결과에 더한다.
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