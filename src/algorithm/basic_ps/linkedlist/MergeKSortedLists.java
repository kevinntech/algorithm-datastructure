package algorithm.basic_ps.linkedlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;

        ListNode result = mergeKLists(list);
        System.out.println("====");

        while(result !=null) {
            System.out.println(result.val);
            result= result.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comp());

        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead; // p는 조작할 때 사용한다.

        System.out.println(Arrays.toString(lists));

        // 우선 순위 큐에 입력 받은 노드를 저장다. [1] [1] [2]
        for (ListNode node : lists) {
            if (node != null)
                queue.offer(node);
        }

        // 큐에 데이터가 있는 동안에는 반복한다.
        while (!queue.isEmpty()) {
            ListNode node = queue.poll(); // 큐에서 노드를 하나 꺼낸다.

            p.next = node; // 꺼낸 노드를 정답으로 리턴 할 더미 노드의 다음 노드로 추가한다.
            p = p.next;

            if (node.next != null) // 방금 꺼낸 노드의 다음 노드가 존재한다면
                queue.offer(node.next); // 그 다음 노드를 우선 순위 큐에 저장한다.
        }

        return dummyHead.next;
    }

}

// 노드의 값을 기준으로 오름차순 정렬
class Comp implements Comparator<ListNode>{
    @Override
    public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
    }
}
