class Solution {
  static int minValue(String s, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if (o1 < o2)
          return 1;
        if (o1 > o2)
          return -1;
        return 0;
      }
    });
    int[] freq = new int[26];
    for (char ch : s.toCharArray()) {
      freq[ch - 'a']++;
    }
    for (int i = 0; i < freq.length; i++) {
      if (freq[i] != 0)
        maxHeap.add(freq[i]);
    }
    while (k > 0) {
      int val = maxHeap.poll();
      maxHeap.add(val - 1);
      k--;
    }
    int total = 0;
    while (!maxHeap.isEmpty()) {
      int val = maxHeap.poll();
      total += val * val;
    }
    return total;
  }
}
