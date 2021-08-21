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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = head;
        
        int len = 0;
        
        while(head!=null){
            len++;
            head = head.next;
        }
        head = newHead;
        
        quickSort(head,0,len-1);
        
        return newHead;
        
    }
    
    private void quickSort(ListNode node, int low, int high){
        
        while(low<high){
            int pivotIdx = partition(node, low, high);
            
            quickSort(node, low, pivotIdx-1);
            quickSort(node, pivotIdx+1,high);
            return;
        }
        
    }
    
    private int partition(ListNode node, int low, int high) {
        int pivot = getPivotValue(node, high);

        for (int i = low; i < high; i++) {
            if (node.val > pivot) {
                int temp = node.val;
                node.val = pivot;
                pivot = temp;
            }
            node = node.next;
        }
        node.val = pivot;

        return high;
    }
    
       private int getPivotValue(ListNode node, int idx){
           while(idx--!=0){
               node = node.next;
           }
           return node.val;
       }
   }
