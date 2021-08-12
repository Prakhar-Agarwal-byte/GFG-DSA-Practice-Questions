import java.util.Stack;

/*Complete the function(s) below*/
class GfG {
  int min = Integer.MAX_VALUE;

  public void push(int a, Stack<Integer> s) {
    if (a > min) {
      s.push(a);
    } else {
      int val = 2 * a - min;
      s.push(val);
      min = a;
    }
  }

  public int pop(Stack<Integer> s) {
    if (s.peek() >= min) {
      return s.pop();
    } else {
      int val = min;
      min = 2 * min - s.peek();
      s.pop();
      return min;
    }
  }

  public int min(Stack<Integer> s) {
    return min;
  }

  public boolean isFull(Stack<Integer> s, int n) {
    return s.size() == n;
  }

  public boolean isEmpty(Stack<Integer> s) {
    return s.isEmpty();
  }
}
