class Solution {
  // Function to find the length of a loop in the linked list.
  static int countNodesinLoop(Node head) {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return findLen(slow);
      }
    }
    return 0;
  }

  private static int findLen(Node slow) {
    int count = 1;
    Node cur = slow;
    while (cur.next != null) {
      if (cur.next == slow) {
        break;
      }
      count++;
      cur = cur.next;
    }
    return count;
  }
