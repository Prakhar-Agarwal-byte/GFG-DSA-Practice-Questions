import java.util.Arrays;

class Solution {
  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int n = startTime.length;
    Job[] jobs = new Job[n];
    for (int i = 0; i < n; i++) {
      jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
    }
    Arrays.sort(jobs, (a, b) -> (a.end - b.end));
    int[] dp = new int[n];
    dp[0] = jobs[0].profit;
    for (int i = 1; i < n; i++) {
      int including = jobs[i].profit;
      int latNonCon = -1;
      for (int j = i - 1; j >= 0; j--) {
        if (jobs[j].end <= jobs[i].start) {
          latNonCon = j;
          break;
        }
      }
      if (latNonCon != -1) {
        including += dp[latNonCon];
      }
      dp[i] = Math.max(including, dp[i - 1]);
    }
    return dp[n - 1];
  }
}

class Job {
  int start;
  int end;
  int profit;

  Job(int start, int end, int profit) {
    this.start = start;
    this.end = end;
    this.profit = profit;
  }
}
