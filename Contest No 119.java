1.Find Common Elements Between Two Arrays

  You are given two 0-indexed integer arrays nums1 and nums2 of sizes n and m, respectively.

Consider calculating the following values:

The number of indices i such that 0 <= i < n and nums1[i] occurs at least once in nums2.
The number of indices i such that 0 <= i < m and nums2[i] occurs at least once in nums1.
Return an integer array answer of size 2 containing the two values in the above order.

 

Example 1:

Input: nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]
Output: [3,4]
Explanation: We calculate the values as follows:
- The elements at indices 1, 2, and 3 in nums1 occur at least once in nums2. So the first value is 3.
- The elements at indices 0, 1, 3, and 4 in nums2 occur at least once in nums1. So the second value is 4.
Example 2:

Input: nums1 = [3,4,2,3], nums2 = [1,5]
Output: [0,0]
Explanation: There are no common elements between the two arrays, so the two values will be 0.
 

Constraints:

n == nums1.length
m == nums2.length
1 <= n, m <= 100
1 <= nums1[i], nums2[i] <= 100



  class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        
        
        
        int len=nums1.length;
        
        int lent=nums2.length;
        
        HashSet<Integer> h=new HashSet<>();
        
        for(int i=0;i<len;i++){
            
            h.add(nums1[i]);
        }
        
          HashSet<Integer> ht=new HashSet<>();
        
        for(int i=0;i<lent;i++){
            
            ht.add(nums2[i]);
        }
        
        int cn=0;
        int cn2=0;
        
        for(int i=0;i<len;i++){
            
            int val = nums1[i];
            if(ht.contains(val)){
                cn++;
            }
        }
        for(int i=0;i<lent;i++){
            
            int val = nums2[i];
            if(h.contains(val)){
                cn2++;
            }
        }
        
        int arr2[]={cn,cn2};
        
        return arr2;
        
    }
}





2.Remove Adjacent Almost-Equal Characters

  You are given a 0-indexed string word.

In one operation, you can pick any index i of word and change word[i] to any lowercase English letter.

Return the minimum number of operations needed to remove all adjacent almost-equal characters from word.

Two characters a and b are almost-equal if a == b or a and b are adjacent in the alphabet.

 

Example 1:

Input: word = "aaaaa"
Output: 2
Explanation: We can change word into "acaca" which does not have any adjacent almost-equal characters.
It can be shown that the minimum number of operations needed to remove all adjacent almost-equal characters from word is 2.
Example 2:

Input: word = "abddez"
Output: 2
Explanation: We can change word into "ybdoez" which does not have any adjacent almost-equal characters.
It can be shown that the minimum number of operations needed to remove all adjacent almost-equal characters from word is 2.
Example 3:

Input: word = "zyxyxyz"
Output: 3
Explanation: We can change word into "zaxaxaz" which does not have any adjacent almost-equal characters. 
It can be shown that the minimum number of operations needed to remove all adjacent almost-equal characters from word is 3.
 

Constraints:

1 <= word.length <= 100
word consists only of lowercase English letters.



class Solution {
    
    public boolean areAlmostEqual(char a, char b) {
        // Check if characters a and b are equal or adjacent in the alphabet
        return a == b || Math.abs(a - b) == 1;
    }

    public int removeAlmostEqualCharacters(String word) {
         int n = word.length();
        int operations = 0;

        for (int i = 0; i < n - 1; i++) {
            char currentChar = word.charAt(i);
            char nextChar = word.charAt(i + 1);

            if (areAlmostEqual(currentChar, nextChar)) {
                // Increment operations and move to the next non-almost-equal character
                operations++;
                i++;
            }
        }

        return operations;
    }
}



3.
Length of Longest Subarray With at Most K Frequency


  You are given an integer array nums and an integer k.

The frequency of an element x is the number of times it occurs in an array.

An array is called good if the frequency of each element in this array is less than or equal to k.

Return the length of the longest good subarray of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,2,3,1,2,3,1,2], k = 2
Output: 6
Explanation: The longest possible good subarray is [1,2,3,1,2,3] since the values 1, 2, and 3 occur at most twice in this subarray. Note that the subarrays [2,3,1,2,3,1] and [3,1,2,3,1,2] are also good.
It can be shown that there are no good subarrays with length more than 6.
Example 2:

Input: nums = [1,2,1,2,1,2,1,2], k = 1
Output: 2
Explanation: The longest possible good subarray is [1,2] since the values 1 and 2 occur at most once in this subarray. Note that the subarray [2,1] is also good.
It can be shown that there are no good subarrays with length more than 2.
Example 3:

Input: nums = [5,5,5,5,5,5,5], k = 4
Output: 4
Explanation: The longest possible good subarray is [5,5,5,5] since the value 5 occurs 4 times in this subarray.
It can be shown that there are no good subarrays with length more than 4.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= nums.length




  class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        left, right = 0, 0
        frequency = {}
        max_length = 0

        for right in range(len(nums)):
            frequency[nums[right]] = frequency.get(nums[right], 0) + 1

            if frequency[nums[right]] > k:
                while frequency[nums[right]] > k:
                    frequency[nums[left]] -= 1
                    if frequency[nums[left]] == 0:
                        del frequency[nums[left]]
                    left += 1

            max_length = max(max_length, right - left + 1)

        return max_length







  class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
         int left = 0, right = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        int maxLength = 0;

        for (right = 0; right < nums.length; right++) {
            frequency.put(nums[right], frequency.getOrDefault(nums[right], 0) + 1);

            if (frequency.get(nums[right]) > k) {
                while (frequency.get(nums[right]) > k) {
                    frequency.put(nums[left], frequency.get(nums[left]) - 1);
                    if (frequency.get(nums[left]) == 0) {
                        frequency.remove(nums[left]);
                    }
                    left++;
                }
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
