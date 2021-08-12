class Solution {
  // Function to delete middle element of a stack.
  public void deleteMid(Stack<Integer> s, int sizeOfStack) {
    delete(s, sizeOfStack, 0);
  }

  private void delete(Stack<Integer> s, int sizeOfStack, int cur) {
    if (s.isEmpty() || cur == sizeOfStack)
      return;
    int val = s.pop();
    delete(s, sizeOfStack, cur+1);
    if (cur != sizeOfStack / 2) {
      s.push(val);
    }
  }
}
