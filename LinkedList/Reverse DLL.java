class Solution {
  public static Node reverseDLL(Node head) {
    if (head == null || head.next == null)
      return head;
    Node prev = null;
    Node cur = head;
    Node next = head;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      cur.prev = next;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}
