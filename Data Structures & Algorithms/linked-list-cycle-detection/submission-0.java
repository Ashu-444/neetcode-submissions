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
    public boolean hasCycle(ListNode head) {
        // if(head == null) return null;
        ListNode temp = head;
        Map<ListNode , Integer > nodeMap = new HashMap<>();
        while(temp != null){
            if(nodeMap.containsKey(temp)){
                return true;
            }
            nodeMap.put(temp , 1);
            temp = temp.next;
        }
        return false;
    }
}
