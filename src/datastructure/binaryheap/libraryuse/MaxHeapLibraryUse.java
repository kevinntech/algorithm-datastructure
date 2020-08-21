package datastructure.binaryheap.libraryuse;

import java.util.Comparator;
        import java.util.PriorityQueue;
        import java.util.Queue;
        import java.util.Scanner;

public class MaxHeapLibraryUse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

/*
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
*/

        while(input-- > 0){
            int x = sc.nextInt();
            if(x == 0){
                if(queue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(queue.poll());
            }
            else
                queue.add(x);
        }
    }
}