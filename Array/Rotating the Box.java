class Solution {
  public char[][] rotateTheBox(char[][] box) {
    int n = box.length;
    int m = box[0].length;
    char[][] resBox = new char[m][n];
    for (int i = 0; i < n; i++) {
      int idx = m - 1;
      for (int j = m - 1; j >= 0; j--) {
        char ch = box[i][j];
        switch (ch) {
          case '#':
            char temp = box[i][idx];
            box[i][idx] = box[i][j];
            box[i][j] = temp;
            idx--;
            break;
          case '*':
            idx = j - 1;
            break;
          default:
            break;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        resBox[i][j] = box[n - j - 1][i];
      }
    }
    return resBox;
  }
}
