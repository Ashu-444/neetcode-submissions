/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        ListNode prev = null;
        ListNode temp = head;

        while(temp != null){
            ListNode kthNode = getkthNode(temp , k);
            if(kthNode == null){
                if(prev != null){
                    prev.next = temp;
                }
                break;
            }
            ListNode nextNode = kthNode.next;

            kthNode.next = null;

            reverseList(temp);

            if(temp == head){
                head = kthNode;
            } else {
                prev.next = kthNode;
            }
            prev = temp;

            temp = nextNode;
        }
        return head;
    }
    public ListNode getkthNode(ListNode temp , int k){
        while(temp != null && k > 1){
            temp = temp.next;
            k--;
        }
        return temp;
    }
    public void reverseList(ListNode head){
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null){
            ListNode nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
    }
}
