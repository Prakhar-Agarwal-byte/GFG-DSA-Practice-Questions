class GfG {
  boolean isCircular(Node head) {
    if (head == null)
      return true;
    Node cur = head;
    while (cur.next != null) {
      if (cur.next == head)
        return true;
      cur = cur.next;
    }
    return false;
  }
}
