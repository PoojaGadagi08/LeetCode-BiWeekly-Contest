1.Subarrays Distinct Element Sum of Squares I

  You are given a 0-indexed integer array nums.

The distinct count of a subarray of nums is defined as:

Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that 0 <= i <= j < nums.length. Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].
Return the sum of the squares of distinct counts of all subarrays of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,2,1]
Output: 15
Explanation: Six possible subarrays are:
[1]: 1 distinct value
[2]: 1 distinct value
[1]: 1 distinct value
[1,2]: 2 distinct values
[2,1]: 2 distinct values
[1,2,1]: 2 distinct values
The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 + 22 + 22 + 22 = 15.
Example 2:

Input: nums = [1,1]
Output: 3
Explanation: Three possible subarrays are:
[1]: 1 distinct value
[1]: 1 distinct value
[1,1]: 1 distinct value
The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 = 3.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100


  import java.util.*;

public class Solution {
    public int sumCounts(List<Integer> nums) {
       int result = 0;
        
//         for (int left = 0; left < nums.size(); left++) {
//             HashMap<Integer, Integer> distinctCount = new HashMap<>();
//             int sum = 0;
//             for (int right = left; right < nums.size(); right++) {
//                 // If the element is distinct, add it to the sum and update distinctCount HashMap
//                 if (!distinctCount.containsKey(nums.get(right))) {
//                     sum = nums.get(right);
                   
//                 }
//                  distinctCount.put(nums.get(right), 1);
//                 // Add the square of the current sum to the result
//                 result += sum * sum;
//             }
//         }
        
//         return result;
        
        int n=nums.size();
        for(int i=0;i<n;i++){
            //int arr[]=new int[101];
            HashSet<Integer> h =new HashSet<>();
            for(int j=i;j<n;j++){
                h.add(nums.get(j));
                
                int dist = h.size();
                dist=dist*dist;
                result+=dist;
            }
        }
        return result;
    }
}





2.Minimum Number of Changes to Make Binary String Beautiful

  You are given a 0-indexed binary string s having an even length.

A string is beautiful if it's possible to partition it into one or more substrings such that:

Each substring has an even length.
Each substring contains only 1's or only 0's.
You can change any character in s to 0 or 1.

Return the minimum number of changes required to make the string s beautiful.

 

Example 1:

Input: s = "1001"
Output: 2
Explanation: We change s[1] to 1 and s[3] to 0 to get string "1100".
It can be seen that the string "1100" is beautiful because we can partition it into "11|00".
It can be proven that 2 is the minimum number of changes needed to make the string beautiful.
Example 2:

Input: s = "10"
Output: 1
Explanation: We change s[1] to 1 to get string "11".
It can be seen that the string "11" is beautiful because we can partition it into "11".
It can be proven that 1 is the minimum number of changes needed to make the string beautiful.
Example 3:

Input: s = "0000"
Output: 0
Explanation: We don't need to make any changes as the string "0000" is beautiful already.
 

Constraints:

2 <= s.length <= 105
s has an even length.
s[i] is either '0' or '1'.


  // class Solution {
//     public int minChanges(String s) {
//         int n=s.length();
//         String s1=s.substring(0,n/2);
//         String s2=s.substring(n/2,n);
        
//         int zero1=0;
//         int one1=0;
        
//         int zero2=0;
//         int one2=0;
        
//         for(int i=0;i<s1.length();i++){
//             if(s1.charAt(i)=='1')
//                 one1++;
//             else 
//                 zero1++;
//         }
        
//                 for(int i=0;i<s2.length();i++){
//             if(s2.charAt(i)=='1')
//                 one2++;
//             else 
//                 zero2++;
//         }
        
//         if(n==2 && s.charAt(0)==s.charAt(1))
//             return 0;
//         else 
//             return 1;
        
        
//         int sum1=0; int sum2=0;
//         if(zero1<=one1)
//             sum1+=zero1;
//         else 
//             sum1+=one1;
        
//         if(zero2<=one2)
//             sum2+=zero2;
//         else 
//             sum2+=one2;
        
//         return sum1+sum2;
//     }
// }

class Solution {
    public int minChanges(String s) {
//        int changeToZero =0;
//         int changeToOne =0;
        
//         for(int i=0;i<s.length();i++){
//             if(i%2 == 0){
//                 if(s.charAt(i) != '0')
//                     changeToZero++;
//                if(s.charAt(i) != '1') 
//                     changeToOne++;
//             }
//         }
//         return Math.min(changeToZero,changeToOne);
        
        int c=0;
        for(int i=0;i<s.length()-1;i+=2){
            if(s.charAt(i) != s.charAt(i+1))
                c++;
        }
        return c;
    }
}








3.Length of the Longest Subsequence That Sums to Target

  You are given a 0-indexed array of integers nums, and an integer target.

Return the length of the longest subsequence of nums that sums up to target. If no such subsequence exists, return -1.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [1,2,3,4,5], target = 9
Output: 3
Explanation: There are 3 subsequences with a sum equal to 9: [4,5], [1,3,5], and [2,3,4]. The longest subsequences are [1,3,5], and [2,3,4]. Hence, the answer is 3.
Example 2:

Input: nums = [4,1,3,2,1,5], target = 7
Output: 4
Explanation: There are 5 subsequences with a sum equal to 7: [4,3], [4,1,2], [4,2,1], [1,1,5], and [1,3,2,1]. The longest subsequence is [1,3,2,1]. Hence, the answer is 4.
Example 3:

Input: nums = [1,1,5,4,5], target = 3
Output: -1
Explanation: It can be shown that nums has no subsequence that sums up to 3.
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 1000
1 <= target <= 1000


  class Solution {
    // public int fun(int i, ArrayList<Integer> arr, int target, int sum, int n, List<Integer> nums){
//         if(i==n){
//             if(sum==target){
//                 return arr.size();
//             }
//         }
        
//         arr.add(nums.get(i));
//         sum+=nums.get(i);
//         fun(i+1, arr, target, sum, n, nums);
        
//         arr.remove(nums.get(i));
//         sum-=nums.get(i);
//         fun(i+1, arr, target, sum, n, nums);
//     }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
//         int n=nums.size();
//          ArrayList<Integer> arr =new ArrayList<>();
//         return fun(0, arr, target, 0, n, nums);
        
        
        
        int n = nums.size();
        List<Integer> dp =  new ArrayList<>(Collections.nCopies(target+1, -1));
        dp.set(0,0);
        
        for(int num :nums){
            for(int i=target; i>=num;i--){
                if(dp.get(i-num) != -1){
                    dp.set(i, Math.max(dp.get(i), dp.get(i-num)+1));
                }
            }
        }
        return dp.get(target);
    }
}


