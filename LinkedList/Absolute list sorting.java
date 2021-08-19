class GfG {
  Node sortList(Node head) {
    if (head == null || head.next == null)
      return head;
    Node d = new Node(0);
    d.next = head;
    Node cur = head;
    while (cur.next != null) {
      if (cur.next.data < 0) {
        Node next = cur.next;
        Node dNext = d.next;
        d.next = next;
        cur.next = next.next;
        next.next = dNext;
      } else {
        cur = cur.next;
      }
    }
    return d.next;
  }
}
