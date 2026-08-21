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
    public ListNode mergeKLists(ListNode[] lists) {
        int total = 0;
        for(ListNode head : lists){ 
            ListNode temp = head;
            while(temp != null){
                total++;
                temp = temp.next;
            }
        }
        int[] arr = new int[total];
        int ind = 0;
        for(ListNode head : lists){
            ListNode temp = head;
            while(temp != null){
                arr[ind] = temp.val;
                ind++;
                temp = temp.next;
            }
        }
        Arrays.sort(arr);

        ListNode dNode = new ListNode(-1);
        ListNode curr = dNode;
        for(int value : arr){
            curr.next = new ListNode(value);
            curr = curr.next;
        }
        return dNode.next;
    }
}
