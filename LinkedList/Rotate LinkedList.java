class Gfg {
  Node rotateP(Node head, int p) {
    Node cur = head;
    int t = p;
    while (t-- > 0) {
      cur = cur.next;
    }
    Node newHead = cur;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = head;
    while (p-- > 0) {
      cur = cur.next;
    }
    cur.next = null;
    return newHead;
  }
}
