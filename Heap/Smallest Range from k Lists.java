import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
  public int[] smallestRange(List<List<Integer>> nums) {
    int minRange = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    PriorityQueue<HeapItem> minHeap = new PriorityQueue<>(new Comparator<HeapItem>() {
      @Override
      public int compare(HeapItem o1, HeapItem o2) {
        if (o1.list.get(o1.index) > o2.list.get(o2.index))
          return 1;
        if (o1.list.get(o1.index) < o2.list.get(o2.index))
          return -1;
        return 0;
      }
    });
    for (int i = 0; i < nums.size(); i++) {
      minHeap.add(new HeapItem(nums.get(i), 0));
      max = Math.max(max, nums.get(i).get(0));
    }
    int min = 0;
    while (true) {
      HeapItem item = minHeap.poll();
      min = item.list.get(item.index);
      minRange = Math.min(minRange, max - min);
      if (item.index + 1 >= item.list.size())
        break;
      item.index++;
      minHeap.add(item);
      max = Math.max(max, item.list.get(item.index));
    }
    int[] res = new int[2];
    res[0] = min;
    res[1] = max;
    return res;
  }
}

class HeapItem {
  List<Integer> list;
  int index;

  HeapItem(List<Integer> list, int index) {
    this.list = list;
    this.index = index;
  }
}
