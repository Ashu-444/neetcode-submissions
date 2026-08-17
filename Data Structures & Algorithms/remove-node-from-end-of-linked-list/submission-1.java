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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        if(len == n){
            return head.next;
        }
        int cnt = 0;
        temp = head;
        ListNode prev = null;
        while(temp != null){
            cnt++;
            if(cnt == len - n){
                prev = temp;
                break;
            }
            temp = temp.next;
        }
        prev.next = prev.next.next;

        return head;
    }
}
