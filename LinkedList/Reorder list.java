class Solution {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;
    ListNode slow = head;
    ListNode fast = head;
    ListNode temp = head;
    while (fast != null && fast.next != null) {
      temp = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    slow = reverse(slow);
    temp.next = null;
    fast = head;
    while (fast.next != null) {
      ListNode fNext = fast.next;
      ListNode sNext = slow.next;
      fast.next = slow;
      slow.next = fNext;
      slow = sNext;
      fast = fNext;
    }
      fast.next = slow;
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode p = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }

}
