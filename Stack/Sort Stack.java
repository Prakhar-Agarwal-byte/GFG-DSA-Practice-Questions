class GfG {
  public Stack<Integer> sort(Stack<Integer> s) {
    if (s.isEmpty())
      return s;
    int top = s.pop();
    sort(s);
    insert(s, top);
    return s;
  }

  private void insert(Stack<Integer> s, int top) {
    if (s.isEmpty() || s.peek() < top) {
      s.push(top);
      return;
    }
    int val = s.pop();
    insert(s, top);
    s.push(val);
  }
}
