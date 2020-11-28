package algorithm.basic_ps.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        printNode(l1);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = reverseLinkedList.reverseList(l1);
        printNode(head);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    public static void printNode(ListNode head) {
        System.out.println("node: ");
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println();
    }
}
