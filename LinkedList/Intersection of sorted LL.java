class Sol {
  public static Node findIntersection(Node head1, Node head2) {
    Node d = new Node(0);
    Node cur = d;
    while (head1 != null && head2 != null) {
      if (head1.data < head2.data) {
        head1 = head1.next;
      } else if (head1.data > head2.data) {
        head2 = head2.next;
      } else {
        Node newNode = new Node(head1.data);
        cur.next = newNode;
        cur = cur.next;
        head1 = head1.next;
        head2 = head2.next;
      }
    }
    return d.next;
  }
}
