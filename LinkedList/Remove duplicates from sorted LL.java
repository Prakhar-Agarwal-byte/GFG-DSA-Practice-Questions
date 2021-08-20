class GfG {
  // Function to remove duplicates from sorted linked list.
  Node removeDuplicates(Node head) {
    if (head == null || head.next == null)
      return head;
    Node cur = head;
    while (cur.next != null) {
      if (cur.next.data == cur.data) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }
}
