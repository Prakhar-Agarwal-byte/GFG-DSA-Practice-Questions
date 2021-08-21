class GfG {
  Node delete(Node head, int k) {
    if (k == 1) return null;
    int count = 1;
    Node d = new Node(0);
    d.next = head;
    Node cur = d;
    while (cur != null && cur.next != null) {
      if (count == k) {
        cur.next = cur.next.next;
        count = 1;
      }
      count++;
      cur = cur.next;
    }
    return d.next;
  }
}
