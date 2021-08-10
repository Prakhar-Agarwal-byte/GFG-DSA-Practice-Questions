class Solution {
  public String FirstNonRepeating(String A) {
    int[] visited = new int[26];
    Queue<Character> q = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    for (char ch : A.toCharArray()) {
      visited[ch - 'a']++;
      q.add(ch);
      while (!q.isEmpty() && visited[q.peek() - 'a'] > 1) {
        q.remove();
      }
      if (q.isEmpty())
        sb.append("#");
      else
        sb.append(q.peek());
    }
    return sb.toString();
  }
}
