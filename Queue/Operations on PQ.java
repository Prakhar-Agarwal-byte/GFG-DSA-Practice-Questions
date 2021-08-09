import java.util.PriorityQueue;

// Helper class Geeks to implement 
// insert() and findFrequency()
class Geeks {

  // Function to insert element into the queue
  static void insert(PriorityQueue<Integer> q, int k) {
    q.add(k);
  }

  // Function to find an element k
  static boolean find(PriorityQueue<Integer> q, int k) {
    return q.contains(k);
  }

  // Function to delete the max element from queue
  static int delete(PriorityQueue<Integer> q) {
    return q.poll();
  }

}
