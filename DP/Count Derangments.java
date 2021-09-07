int countDer(int n) {
  int der[] = new int[n + 1];
  // Base cases
  der[1] = 0;
  der[2] = 1;
  for (int i = 3; i <= n; ++i)
    der[i] = (i - 1) * (der[i - 1] + der[i - 2]);
  return der[n];
}
