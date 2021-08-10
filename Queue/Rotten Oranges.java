import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int orangesRotting(int[][] grid) {
    Queue<Coordinate> q = new LinkedList<>();
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          q.add(new Coordinate(i, j));
        }
        if (grid[i][j] != 0) {
          count++;
        }
      }
    }
    if (count == 0)
      return 0;
    int time = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      count -= size;
      for (int k = 0; k < size; k++) {
        Coordinate temp = q.remove();
        int i = temp.i;
        int j = temp.j;
        if (isValid(i + 1, j, grid)) {
          grid[i + 1][j] = 2;
          q.add(new Coordinate(i + 1, j));
        }
        if (isValid(i - 1, j, grid)) {
          grid[i - 1][j] = 2;
          q.add(new Coordinate(i - 1, j));
        }
        if (isValid(i, j + 1, grid)) {
          grid[i][j + 1] = 2;
          q.add(new Coordinate(i, j + 1));
        }
        if (isValid(i, j - 1, grid)) {
          grid[i][j - 1] = 2;
          q.add(new Coordinate(i, j - 1));
        }
      }
      if (q.size() > 0) {
        time++;
      }
    }
    if (count == 0)
      return time;
    else
      return -1;
  }

  private boolean isValid(int i, int j, int[][] grid) {
    return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 0 && grid[i][j] != 2;
  }
}

class Coordinate {
  int i = 0;
  int j = 0;

  Coordinate(int i, int j) {
    this.i = i;
    this.j = j;
  }
}
