class Solution {
  public static void rearrange(Node head) {
    if (head == null || head.next == null)
      return;
    Node cur1 = head;
    Node d = new Node(0);
    Node cur2 = d;
    while (cur1.next != null) {
      cur2.next = cur1.next;
      cur1.next = cur1.next.next;
      if (cur1.next == null) break;
      cur1 = cur1.next;
      cur2 = cur2.next;
    }
    Node q = reverse(d.next);
    cur1.next = q;
  }

  public static Node reverse(Node head) {
    if (head == null || head.next == null)
      return head;
    Node p = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }
}
