class Solution {
  public static Node zigZag(Node head) {
    Node d = new Node(0);
    d.next = head;
    Node prev = d;
    Node cur = head;
    boolean shouldBeSmaller = false;
    while (cur != null && cur.next != null) {
      Node next = cur.next;
      if (shouldBeSmaller) {
        if (next.data > cur.data) {
          Node forw = next.next;
          cur.next = forw;
          next.next = cur;
          prev.next = next;
        } else {
            cur = cur.next;
        }
      } else {
        if (next.data < cur.data) {
          Node forw = next.next;
          cur.next = forw;
          next.next = cur;
          prev.next = next;
        } else {
            cur = cur.next;
        }
      }
      prev = prev.next;
      
      shouldBeSmaller = !shouldBeSmaller; 
    }
    return d.next;
  }
}
