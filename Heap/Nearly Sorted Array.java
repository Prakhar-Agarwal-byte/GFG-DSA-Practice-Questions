// Basically heap sort

import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
  public ArrayList<Integer> nearlySortedArray(int[] arr, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    ArrayList<Integer> res = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      minHeap.add(arr[i]);
    }
    for (int i = k; i < arr.length; i++) {
      res.add(minHeap.poll());
      minHeap.add(arr[i]);
    }
    while (!minHeap.isEmpty()) {
      res.add(minHeap.poll());
    }
    return res;
  }
}
