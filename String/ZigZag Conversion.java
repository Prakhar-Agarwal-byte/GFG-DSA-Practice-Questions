import java.util.*;

class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1) return s;
    StringBuilder[] list = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
      list[i] = new StringBuilder();
    }
    int cur = 0;
    boolean isDown = true;
    for (int i = 0; i < s.length(); i++) {
      list[cur].append(s.charAt(i));
      if (cur == numRows - 1) {
        isDown = false;
      } else if (cur == 0) {
        isDown = true;
      }
      if (isDown) {
        cur++;
      } else {
        cur--;
      }
    }
    StringBuilder res = new StringBuilder();
    for (StringBuilder sb : list) {
      res.append(sb);
    }
    return res.toString();
  }
}
