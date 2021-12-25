// import java.util.Stack;

// class Solution {
//   public String decodeString(String s) {
//     Stack<Pair> st = new Stack<>();
//     st.push(new Pair(0, new StringBuilder()));
//     for (int i = 0; i < s.length(); i++) {
//       char ch = s.charAt(i);
//       if (Character.isDigit(ch)) {
//         int num = 0;
//         while (Character.isDigit(s.charAt(i))) {
//           num = num * 10 + (s.charAt(i) - '0');
//           i++;
//         }
//         st.push(new Pair(num, new StringBuilder()));
//         continue;
//       }
//       if (ch == ']') {
//         Pair p = st.pop();
//         String sTemp = p.sb.toString();
//         StringBuilder temp = new StringBuilder();
//         for (int j = 0; j < p.n; j++) {
//           temp.append(sTemp);
//         }
//         st.peek().sb.append(temp.toString());
//         continue;
//       }
//       st.peek().sb.append(ch);
//     }
//     return st.pop().sb.toString();
//   }
// }

// class Pair {
//   int n;
//   StringBuilder sb;

//   Pair(int n, StringBuilder sb) {
//     this.n = n;
//     this.sb = sb;
//   }
// }

class Solution {
  int idx = 0;

  public String decodeString(String s) {
    StringBuilder sb = new StringBuilder();
    int num = 0;
    while (idx < s.length()) {
      char c = s.charAt(idx++);
      if (Character.isDigit(c)) {
        num = num * 10 + c - '0';
      } else if (c == '[') {
        String str = decodeString(s);
        for (int i = 0; i < num; i++)
          sb.append(str);
        num = 0;
      } else if (c == ']') {
        break;
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
