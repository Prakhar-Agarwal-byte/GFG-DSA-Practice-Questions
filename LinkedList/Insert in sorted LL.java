class Solution {
  Node sortedInsert(Node head1, int key) {
    Node d = new Node(0);
    d.next = head1;
    Node cur = d;
    while (cur.next != null) {
      if (cur.next.data > key) {
        Node newNode = new Node(key);
        newNode.next = cur.next;
        cur.next = newNode;
        return d.next;
      }
      cur = cur.next;
    }
    Node newNode = new Node(key);
    cur.next = newNode;
    return d.next;
  }
}
