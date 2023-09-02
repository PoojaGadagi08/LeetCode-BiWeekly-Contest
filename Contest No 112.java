1. Check if Strings Can be Made Equal With Operations I

  You are given two strings s1 and s2, both of length 4, consisting of lowercase English letters.

You can apply the following operation on any of the two strings any number of times:

Choose any two indices i and j such that j - i = 2, then swap the two characters at those indices in the string.
Return true if you can make the strings s1 and s2 equal, and false otherwise.

 

Example 1:

Input: s1 = "abcd", s2 = "cdab"
Output: true
Explanation: We can do the following operations on s1:
- Choose the indices i = 0, j = 2. The resulting string is s1 = "cbad".
- Choose the indices i = 1, j = 3. The resulting string is s1 = "cdab" = s2.
Example 2:

Input: s1 = "abcd", s2 = "dacb"
Output: false
Explanation: It is not possible to make the two strings equal.
 

Constraints:

s1.length == s2.length == 4
s1 and s2 consist only of lowercase English letters.




  class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char arr[]=s1.toCharArray();
        
        char p[]={arr[0],arr[2]};
        Arrays.sort(p);
        
        char m[]={arr[1],arr[3]};
        Arrays.sort(m);
        
        arr[0]=p[0];
        arr[2]=p[1];
        
        arr[1]=m[0];
        arr[3]=m[1];
        
        char arr2[]=s2.toCharArray();
        
        char p2[]={arr2[0],arr2[2]};
        Arrays.sort(p2);
        
        char m2[]={arr2[1],arr2[3]};
        Arrays.sort(m2);
        
        arr2[0]=p2[0];
        arr2[2]=p2[1];
        
        arr2[1]=m2[0];
        arr2[3]=m2[1];
        
        boolean  ans=true;
        
        for(int i=0;i<4;i++){
            if(arr[i]!=arr2[i])
                ans=false;
        }
        return ans;
    }
}




2. Check if Strings Can be Made Equal With Operations II

  You are given two strings s1 and s2, both of length n, consisting of lowercase English letters.

You can apply the following operation on any of the two strings any number of times:

Choose any two indices i and j such that i < j and the difference j - i is even, then swap the two characters at those indices in the string.
Return true if you can make the strings s1 and s2 equal, and false otherwise.

 

Example 1:

Input: s1 = "abcdba", s2 = "cabdab"
Output: true
Explanation: We can apply the following operations on s1:
- Choose the indices i = 0, j = 2. The resulting string is s1 = "cbadba".
- Choose the indices i = 2, j = 4. The resulting string is s1 = "cbbdaa".
- Choose the indices i = 1, j = 5. The resulting string is s1 = "cabdab" = s2.
Example 2:

Input: s1 = "abe", s2 = "bea"
Output: false
Explanation: It is not possible to make the two strings equal.
 

Constraints:

n == s1.length == s2.length
1 <= n <= 105
s1 and s2 consist only of lowercase English letters.


  class Solution {
    
    public String get(String s1){
        
          List<Character> li=new ArrayList<>();
         List<Character> li2=new ArrayList<>();
       
        int len5=s1.length();
        
        int p=0;
        
        for(int i=0;i<len5;i++){
            
            char c=s1.charAt(i);
          
            if(p==0){
                li.add(c);
                p=1;
            }else{
                li2.add(c);
                p=0;
            }
            
        }
        
        Collections.sort(li);
        Collections.sort(li2);
        
        int start=0;
        
        StringBuilder ans=new StringBuilder();
        
        int ind=0;
        int ind2=0;
        
        for(int i=0;i<len5;i++){
            
            if(start==0){
                ans.append(li.get(ind));
                start=1;
                ind++;
            }else{
                ans.append(li2.get(ind2));
                ind2++;
                start=0;
            }
        }
        
        return ans.toString();
    }
    
    public boolean checkStrings(String s1, String s2) {
        
        
      String first=get(s1);
        String next=get(s2);
        
        if(first.equals(next))
         return true;
        else
            return false;
        
        
    }
}

3. Maximum Sum of Almost Unique Subarray

  You are given an integer array nums and two positive integers m and k.

Return the maximum sum out of all almost unique subarrays of length k of nums. If no such subarray exists, return 0.

A subarray of nums is almost unique if it contains at least m pairwise distinct elements.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [2,6,7,3,1,7], m = 3, k = 4
Output: 18
Explanation: There are 3 almost unique subarrays of size k = 4. These subarrays are [2, 6, 7, 3], [6, 7, 3, 1], and [7, 3, 1, 7]. Among these subarrays, the one with the maximum sum is [2, 6, 7, 3] which has a sum of 18.
Example 2:

Input: nums = [5,9,9,2,4,5,4], m = 1, k = 3
Output: 23
Explanation: There are 5 almost unique subarrays of size k. These subarrays are [5, 9, 9], [9, 9, 2], [9, 2, 4], [2, 4, 5], and [4, 5, 4]. Among these subarrays, the one with the maximum sum is [5, 9, 9] which has a sum of 23.
Example 3:

Input: nums = [1,2,1,2,1,2,1], m = 3, k = 3
Output: 0
Explanation: There are no subarrays of size k = 3 that contain at least m = 3 distinct elements in the given array [1,2,1,2,1,2,1]. Therefore, no almost unique subarrays exist, and the maximum sum is 0.
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= m <= k <= nums.length
1 <= nums[i] <= 109


  class Solution:
    def maxSum(self, nums: List[int], m: int, k: int) -> int:
        i=0
        j=0
        _sum=0;
        ans=0;
        _map={};
        
        def add(_map,key):
            if key in _map:
                _map[key]+=1
            else :
                _map[key]=1
        
        def remove(_map,key):
            if key in _map:
                if _map[key]!=1:
                    _map[key]-=1
                else :
                    del _map[key]
                    
        while j<len(nums):
            if j-i<k:
                add(_map,nums[j])
                _sum+=nums[j]
                j+=1
            else :
                if len(_map)>=m:
                    ans=max(ans,_sum)
                remove(_map,nums[i])
                _sum-=nums[i]
                i+=1
        
        while i<len(nums):
            if j-i<k:
                break
            else:
                if len(_map)>=m:
                    ans=max(ans,_sum)
                remove(_map,nums[i])
                _sum-=nums[i]
                i+=1
        return ans

          4.Count K-Subsequences of a String With Maximum Beauty


          You are given a string s and an integer k.

A k-subsequence is a subsequence of s, having length k, and all its characters are unique, i.e., every character occurs once.

Let f(c) denote the number of times the character c occurs in s.

The beauty of a k-subsequence is the sum of f(c) for every character c in the k-subsequence.

For example, consider s = "abbbdd" and k = 2:

f('a') = 1, f('b') = 3, f('d') = 2
Some k-subsequences of s are:
"abbbdd" -> "ab" having a beauty of f('a') + f('b') = 4
"abbbdd" -> "ad" having a beauty of f('a') + f('d') = 3
"abbbdd" -> "bd" having a beauty of f('b') + f('d') = 5
Return an integer denoting the number of k-subsequences whose beauty is the maximum among all k-subsequences. Since the answer may be too large, return it modulo 109 + 7.

A subsequence of a string is a new string formed from the original string by deleting some (possibly none) of the characters without disturbing the relative positions of the remaining characters.

Notes

f(c) is the number of times a character c occurs in s, not a k-subsequence.
Two k-subsequences are considered different if one is formed by an index that is not present in the other. So, two k-subsequences may form the same string.
 

Example 1:

Input: s = "bcca", k = 2
Output: 4
Explanation: From s we have f('a') = 1, f('b') = 1, and f('c') = 2.
The k-subsequences of s are: 
bcca having a beauty of f('b') + f('c') = 3 
bcca having a beauty of f('b') + f('c') = 3 
bcca having a beauty of f('b') + f('a') = 2 
bcca having a beauty of f('c') + f('a') = 3
bcca having a beauty of f('c') + f('a') = 3 
There are 4 k-subsequences that have the maximum beauty, 3. 
Hence, the answer is 4. 
Example 2:

Input: s = "abbcd", k = 4
Output: 2
Explanation: From s we have f('a') = 1, f('b') = 2, f('c') = 1, and f('d') = 1. 
The k-subsequences of s are: 
abbcd having a beauty of f('a') + f('b') + f('c') + f('d') = 5
abbcd having a beauty of f('a') + f('b') + f('c') + f('d') = 5 
There are 2 k-subsequences that have the maximum beauty, 5. 
Hence, the answer is 2. 
 

Constraints:

1 <= s.length <= 2 * 105
1 <= k <= s.length
s consists only of lowercase English letters.


  class Solution {
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        final int MOD=1_000_000_007;
        int mb=0;
        int mc=0;
        Map<Character, Integer> c=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            c.put(ch,c.getOrDefault(ch,0)+1);
            
            if(i>=k){
                char l=s.charAt(i-k);
                
                if(c.get(l)==1)
                    c.remove(l);
                else 
                    c.put(l,c.get(l)-1);
            }
            
            int cb=c.values().stream().mapToInt(Integer::intValue).sum();
            
            if(cb>mb){
                mb=cb;
                mc=1;
                
            }else if(cb==mb)
                mc++;
        }
        return mc%MOD;
    }
}
