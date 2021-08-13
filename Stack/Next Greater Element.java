class Solution {
  // Function to find the next greater element for each element of the array.
  public static long[] nextLargerElement(long[] arr, int n) {
    long[] res = new long[n];
    Stack<Long> st = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && st.peek() <= arr[i]) {
        st.pop();
      }
      if (st.isEmpty()) {
        res[i] = -1;
      } else {
        res[i] = st.peek();
      }
      st.push(arr[i]);
    }
    return res;
  }
}
