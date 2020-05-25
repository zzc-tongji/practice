package leetcode;

/*
 * 0278. First Bad Version
 *
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 *
 * call isBadVersion(5) -> true
 *
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
public class _0278_FirstBadVersion extends VersionControl {
  public static void main(String[] args) {
    System.out.println("Hello world.");
  }

  public int firstBadVersion(int n) {
    if (n <= 0) {
      return -1;
    }
    int left = 1;
    int right = n;
    int mid = 0;
    while (left + 1 < right) {
      mid = left + (right - left) / 2;
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid;
      }
    }
    // The situation of "the 1st version is the bad one" should be considered.
    //
    // However, the situation of "the last version is the bad one" need not be
    // considered since it is excluded by the problem.
    return isBadVersion(left) ? left : right;
    /*
     * time: O(log n)
     *
     * space: O(1)
     */
  }
}

class VersionControl {
  public boolean isBadVersion(int n) {
    if (n <= 3) {
      return true;
    }
    return false;
  }
}
