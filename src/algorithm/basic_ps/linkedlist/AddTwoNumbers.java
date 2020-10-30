package algorithm.basic_ps.linkedlist;

class ListNode{
    int val;

    ListNode next;

    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(2)));

        // 아래 예시로 실행하면 결과 : [8,9,9,9,0,0,0,1]
        ListNode l1 = new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9,
                                                                new ListNode(9)
                                                        )
                                                )
                                        )
                                )
                        )
                    );

        ListNode l2 = new ListNode(9,
                        new ListNode(9,
                            new ListNode(9,
                                new ListNode(9)
                            )
                        )
                    );

        ListNode node = addTwoNumbers(l1, l2);

        // 출력하기
        while(node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // dummyHead로 사용 할 노드를 생성한다.
        ListNode dummyHead = new ListNode(0);

        ListNode p1 = l1, p2 = l2 , p3 = dummyHead;

        int carry = 0; // 자리 올림

        while(p1 != null || p2 != null){
            if(p1 != null) {
                carry += p1.val;    // p1.val = 2
                p1 = p1.next;       // p1이 다음 노드를 가리키도록 한다.
            }

            if(p2 != null) {
                carry += p2.val;    // p2.val = 5
                p2 = p2.next;       // p2가 다음 노드를 가리키도록 한다.
            }

            p3.next = new ListNode(carry % 10); // p3.next.val : 7
            p3 = p3.next;           // p3가 다음 노드를 가리키도록 한다.
            carry /= 10;  // 자리 올림 수
        }

        if(carry == 1) p3.next = new ListNode(1);

        return dummyHead.next;
    }
}