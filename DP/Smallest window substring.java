class Solution {
  public static String smallestWindow(String sStr, String pStr) {
    char[] s = sStr.toCharArray();
    char[] p = pStr.toCharArray();
    int count = 0;
    int[] m = new int[256];
    int ans = Integer.MAX_VALUE;
    int start = 0;
    for (int i = 0; i < s.length; i++) {
      if (m[p[i]] == 0)
        count++;
      m[p[i]]++;
    }
    int i = 0;
    int j = 0;
    while (j < s.length) {
      m[s[j]]--;
      if (m[s[j]] == 0)
        count--;
      while (count == 0) {
        if (ans > j - i + 1) {
          ans = Math.min(ans, j - i + 1);
          start = i;
        }
        m[s[i]]++;
        if (m[s[i]] > 0)
          count++;

        i++;
      }
      j++;
    }
    if (ans != Integer.MAX_VALUE)
      return sStr.substring(start, ans + start);
    else
      return "-1";
  }
}
