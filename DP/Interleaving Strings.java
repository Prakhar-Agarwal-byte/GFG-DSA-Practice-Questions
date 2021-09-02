import java.util.HashMap;

class Solution {
  HashMap<String, Boolean> map;

  public boolean isInterleave(String s1, String s2, String s3) {
    int len1 = s1.length();
    int len2 = s2.length();
    int len3 = s3.length();
    if (len1 + len2 != len3)
      return false;
    map = new HashMap<>();
    return check(s1, s2, s3, len1, len2, len3, 0, 0, 0);
  }

  private boolean check(String s1, String s2, String s3, int len1, int len2, int len3, int p1, int p2, int p3) {
    if (p3 == len3) {
      if (p1 == len1 && p2 == len2)
        return true;
      return false;
    }
    String key = p1 + " " + p2 + " " + p3;
    if (map.containsKey(key))
      return map.get(key);
    if (p1 == len1) {
      if (s2.charAt(p2) == s3.charAt(p3)) {
        boolean res = check(s1, s2, s3, len1, len2, len3, p1, p2 + 1, p3 + 1);
        ;
        map.put(key, res);
        return res;
      }
      map.put(key, false);
      return false;
    }
    if (p2 == len2) {
      if (s1.charAt(p1) == s3.charAt(p3)) {
        boolean res = check(s1, s2, s3, len1, len2, len3, p1 + 1, p2, p3 + 1);
        map.put(key, res);
        return res;
      }
      map.put(key, false);
      return false;
    }
    boolean one = false, two = false;
    if (s1.charAt(p1) == s3.charAt(p3)) {
      one = check(s1, s2, s3, len1, len2, len3, p1 + 1, p2, p3 + 1);
    }
    if (s2.charAt(p2) == s3.charAt(p3)) {
      two = check(s1, s2, s3, len1, len2, len3, p1, p2 + 1, p3 + 1);
    }
    map.put(key, one || two);
    return one || two;
  }
}
