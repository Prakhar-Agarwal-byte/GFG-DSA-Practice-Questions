class GFG {
  // Function to swap Kth node from beginning and end in a linked list.
  Node swapkthnode(Node head, int num, int K) {
    Node d = new Node(0);
    d.next = head;
    Node cur = head;
    int l = 0;
    while (cur != null) {
      l++;
      cur = cur.next;
    }
    if (K > l)
      return head;
    if (2*K - l == 1)
      return head;
    int count = 1;
    cur = d;
    Node prevFirst = null;
    Node first = null;
    Node prevSecond = null;
    Node second = null;
    while (cur != null) {
      if (count == K) {
        prevFirst = cur;
        first = cur.next;
      }
      if (count == l - K + 1) {
        prevSecond = cur;
        second = cur.next;
      }
      cur = cur.next;
      count++;
    }
    prevFirst.next = second;
    prevSecond.next = first;
    Node temp = first.next;
    first.next = second.next;
    second.next = temp;
    return d.next;
  }
}
