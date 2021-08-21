class Solution {
  // Function to pairwise swap elements of a linked list.
  // It should returns head of the modified list
  public Node pairwiseSwap(Node head) {
    Node d = new Node(0);
    d.next = head;
    Node cur = d;
    while (cur.next != null && cur.next.next != null) {
      Node next = cur.next;
      Node forw = cur.next.next;
      cur.next = cur.next.next;
      Node temp = forw.next;
      forw.next = next;
      next.next = temp;
      cur = next;
    }
    return d.next;
  }
}
