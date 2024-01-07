1.Smallest Missing Integer Greater Than Sequential Prefix Sum

  You are given a 0-indexed array of integers nums.

A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1. In particular, the prefix consisting only of nums[0] is sequential.

Return the smallest integer x missing from nums such that x is greater than or equal to the sum of the longest sequential prefix.

 

Example 1:

Input: nums = [1,2,3,2,5]
Output: 6
Explanation: The longest sequential prefix of nums is [1,2,3] with a sum of 6. 6 is not in the array, therefore 6 is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.
Example 2:

Input: nums = [3,4,5,1,12,14,13]
Output: 15
Explanation: The longest sequential prefix of nums is [3,4,5] with a sum of 12. 12, 13, and 14 belong to the array while 15 does not. Therefore 15 is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.
 

Constraints:

1 <= nums.length <= 50
1 <= nums[i] <= 50




  public class Solution {

    public int missingInteger(int[] nums) {
        int n = nums.length;
        int longestSequentialPrefixSum = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] == nums[i - 1] + 1) {
                longestSequentialPrefixSum += nums[i];
            } else {
                break;
            }
        }

        int targetSum = longestSequentialPrefixSum ;

        while (contains(nums, targetSum)) {
            targetSum++;
        }

        return targetSum;
    }

    private boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}



2.Minimum Number of Operations to Make Array XOR Equal to K

  You are given a 0-indexed integer array nums and a positive integer k.

You can apply the following operation on the array any number of times:

Choose any element of the array and flip a bit in its binary representation. Flipping a bit means changing a 0 to 1 or vice versa.
Return the minimum number of operations required to make the bitwise XOR of all elements of the final array equal to k.

Note that you can flip leading zero bits in the binary representation of elements. For example, for the number (101)2 you can flip the fourth bit and obtain (1101)2.

 

Example 1:

Input: nums = [2,1,3,4], k = 1
Output: 2
Explanation: We can do the following operations:
- Choose element 2 which is 3 == (011)2, we flip the first bit and we obtain (010)2 == 2. nums becomes [2,1,2,4].
- Choose element 0 which is 2 == (010)2, we flip the third bit and we obtain (110)2 = 6. nums becomes [6,1,2,4].
The XOR of elements of the final array is (6 XOR 1 XOR 2 XOR 4) == 1 == k.
It can be shown that we cannot make the XOR equal to k in less than 2 operations.
Example 2:

Input: nums = [2,0,2,0], k = 0
Output: 0
Explanation: The XOR of elements of the array is (2 XOR 0 XOR 2 XOR 0) == 0 == k. So no operation is needed.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 106
0 <= k <= 106



  class Solution:
    def minOperations(self, efgh, ijkl):
        x = 0
        for qrst in efgh:
            x ^= qrst

        uvwx = x ^ ijkl
        yz = 0

        while uvwx != 0:
            yz += uvwx & 1
            uvwx >>= 1

        return yz





  3.
  Minimum Number of Operations to Make X and Y Equal

  You are given two positive integers x and y.

In one operation, you can do one of the four following operations:

Divide x by 11 if x is a multiple of 11.
Divide x by 5 if x is a multiple of 5.
Decrement x by 1.
Increment x by 1.
Return the minimum number of operations required to make x and y equal.

 

Example 1:

Input: x = 26, y = 1
Output: 3
Explanation: We can make 26 equal to 1 by applying the following operations: 
1. Decrement x by 1
2. Divide x by 5
3. Divide x by 5
It can be shown that 3 is the minimum number of operations required to make 26 equal to 1.
Example 2:

Input: x = 54, y = 2
Output: 4
Explanation: We can make 54 equal to 2 by applying the following operations: 
1. Increment x by 1
2. Divide x by 11 
3. Divide x by 5
4. Increment x by 1
It can be shown that 4 is the minimum number of operations required to make 54 equal to 2.
Example 3:

Input: x = 25, y = 30
Output: 5
Explanation: We can make 25 equal to 30 by applying the following operations: 
1. Increment x by 1
2. Increment x by 1
3. Increment x by 1
4. Increment x by 1
5. Increment x by 1
It can be shown that 5 is the minimum number of operations required to make 25 equal to 30.
 

Constraints:

1 <= x, y <= 104




  class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
          Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{x, 0});
        visited.add(x);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int operations = current[1];

            if (value == y) {
                return operations;
            }

            if (!visited.contains(value + 1)) {
                queue.offer(new int[]{value + 1, operations + 1});
                visited.add(value + 1);
            }

            if (!visited.contains(value - 1)) {
                queue.offer(new int[]{value - 1, operations + 1});
                visited.add(value - 1);
            }

            if (value % 5 == 0 && !visited.contains(value / 5)) {
                queue.offer(new int[]{value / 5, operations + 1});
                visited.add(value / 5);
            }

            if (value % 11 == 0 && !visited.contains(value / 11)) {
                queue.offer(new int[]{value / 11, operations + 1});
                visited.add(value / 11);
            }
        }

        return -1;
    }
}
