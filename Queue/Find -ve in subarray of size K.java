class Compute {
  public long[] printFirstNegativeInteger(long A[], int N, int K) {
    Queue<Integer> q = new LinkedList<>();
    long[] res = new long[N - K + 1];
    int ri = 0;
    for (int i = 0; i < N; i++) {
      if (!q.isEmpty() && q.peek() == i - K) {
        q.poll();
      }
      if (A[i] < 0) {
        q.offer(i);
      }
      if (i >= K - 1) {
        if (q.isEmpty()) {
          res[ri++] = 0;
        } else {
          res[ri++] = A[q.peek()];
        }
      }
    }
    return res;
  }
}
