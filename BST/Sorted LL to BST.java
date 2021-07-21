// O(nLogn) TC

class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null)
      return new TreeNode(head.val);
    ListNode slow = head, pre = null, fast = head;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    pre.next = null;
    TreeNode node = new TreeNode(slow.val);
    node.left = sortedListToBST(head);
    node.right = sortedListToBST(slow.next);
    return node;
  }
}

// O(n)

class Solution {
  ListNode node;

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null)
      return null;
    ListNode cur = head;
    node = head;
    int size = 0;
    while (cur != null) {
      cur = cur.next;
      size++;
    }
    return inorderHelper(0, size - 1);
  }

  public TreeNode inorderHelper(int l, int r) {
    if (l > r)
      return null;
    if (node == null)
      return null;
    int mid = l + (r - l) / 2;
    TreeNode leftChild = inorderHelper(l, mid - 1);
    TreeNode treeNode = new TreeNode(node.val);
    treeNode.left = leftChild;
    node = node.next;
    TreeNode rightChild = inorderHelper(mid + 1, r);
    treeNode.right = rightChild;
    return treeNode;
  }
}
