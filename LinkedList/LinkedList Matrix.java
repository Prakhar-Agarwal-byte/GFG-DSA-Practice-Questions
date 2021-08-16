class GFG {
  static Node construct(int arr[][], int n) {
    return solve(arr, 0, 0, n, arr[0].length);
  }

  static Node solve(int arr[][], int i, int j, int n, int m) {
    if (i > n - 1 || j > m - 1)
      return null;
    Node temp = new Node(arr[i][j]);
    temp.right = solve(arr, i, j + 1, n, m);
    temp.down = solve(arr, i + 1, j, n, m);
    return temp;
  }
}
