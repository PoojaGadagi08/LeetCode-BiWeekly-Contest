1. Count Pairs Whose Sum is Less than Target



  Given a 0-indexed integer array nums of length n and an integer target, return the number of pairs (i, j) where 0 <= i < j < n and nums[i] + nums[j] < target.
 

Example 1:

Input: nums = [-1,1,2,3,1], target = 2
Output: 3
Explanation: There are 3 pairs of indices that satisfy the conditions in the statement:
- (0, 1) since 0 < 1 and nums[0] + nums[1] = 0 < target
- (0, 2) since 0 < 2 and nums[0] + nums[2] = 1 < target 
- (0, 4) since 0 < 4 and nums[0] + nums[4] = 0 < target
Note that (0, 3) is not counted since nums[0] + nums[3] is not strictly less than the target.
Example 2:

Input: nums = [-6,2,5,-2,-7,-1,3], target = -2
Output: 10
Explanation: There are 10 pairs of indices that satisfy the conditions in the statement:
- (0, 1) since 0 < 1 and nums[0] + nums[1] = -4 < target
- (0, 3) since 0 < 3 and nums[0] + nums[3] = -8 < target
- (0, 4) since 0 < 4 and nums[0] + nums[4] = -13 < target
- (0, 5) since 0 < 5 and nums[0] + nums[5] = -7 < target
- (0, 6) since 0 < 6 and nums[0] + nums[6] = -3 < target
- (1, 4) since 1 < 4 and nums[1] + nums[4] = -5 < target
- (3, 4) since 3 < 4 and nums[3] + nums[4] = -9 < target
- (3, 5) since 3 < 5 and nums[3] + nums[5] = -3 < target
- (4, 5) since 4 < 5 and nums[4] + nums[5] = -8 < target
- (4, 6) since 4 < 6 and nums[4] + nums[6] = -4 < target
 

Constraints:

1 <= nums.length == n <= 50
-50 <= nums[i], target <= 50



  class Solution {
    public int countPairs(List<Integer> nums, int target) {
        
        
        int lent=nums.size();
        
        int countg=0;
        
        for(int i=0;i<lent-1;i++){
            
            for(int j=i+1;j<lent;j++){
                
                int sum=nums.get(i)+nums.get(j);
                if(sum<target)
                    countg++;
            }
        }
        
        return countg;
    }
}







2.Make String a Subsequence Using Cyclic Increments

  You are given two 0-indexed strings str1 and str2.

In an operation, you select a set of indices in str1, and for each index i in the set, increment str1[i] to the next character cyclically. That is 'a' becomes 'b', 'b' becomes 'c', and so on, and 'z' becomes 'a'.

Return true if it is possible to make str2 a subsequence of str1 by performing the operation at most once, and false otherwise.

Note: A subsequence of a string is a new string that is formed from the original string by deleting some (possibly none) of the characters without disturbing the relative positions of the remaining characters.

 

Example 1:

Input: str1 = "abc", str2 = "ad"
Output: true
Explanation: Select index 2 in str1.
Increment str1[2] to become 'd'. 
Hence, str1 becomes "abd" and str2 is now a subsequence. Therefore, true is returned.
Example 2:

Input: str1 = "zc", str2 = "ad"
Output: true
Explanation: Select indices 0 and 1 in str1. 
Increment str1[0] to become 'a'. 
Increment str1[1] to become 'd'. 
Hence, str1 becomes "ad" and str2 is now a subsequence. Therefore, true is returned.
Example 3:

Input: str1 = "ab", str2 = "d"
Output: false
Explanation: In this example, it can be shown that it is impossible to make str2 a subsequence of str1 using the operation at most once. 
Therefore, false is returned.
 

Constraints:

1 <= str1.length <= 105
1 <= str2.length <= 105
str1 and str2 consist of only lowercase English letters.




  class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        
        
        int len=str1.length();
        int lent=str2.length();
        
        int ind2=0;
        int ind12=0;
        
        int countt=0;
        
        for(int i=0;i<lent;i++){
            
            char c=str2.charAt(i);
            char ori=c;
            if(c=='a'){
                c='z';
            }
            else{
                c--;
            }
            
            while(ind12<len){
                char p=str1.charAt(ind12);
                if(p==c || p==ori){
                    countt++;
                    ind12++;
                    break;
                }else
                    ind12++;
            }
            
        }
        
        if(countt==lent){
            return true;
        }else
            return false;
        
        
    }
}




3.Sorting Three Groups

  You are given a 0-indexed integer array nums of length n.

The numbers from 0 to n - 1 are divided into three groups numbered from 1 to 3, where number i belongs to group nums[i]. Notice that some groups may be empty.

You are allowed to perform this operation any number of times:

Pick number x and change its group. More formally, change nums[x] to any number from 1 to 3.
A new array res is constructed using the following procedure:

Sort the numbers in each group independently.
Append the elements of groups 1, 2, and 3 to res in this order.
Array nums is called a beautiful array if the constructed array res is sorted in non-decreasing order.

Return the minimum number of operations to make nums a beautiful array.

 

Example 1:

Input: nums = [2,1,3,2,1]
Output: 3
Explanation: It's optimal to perform three operations:
1. change nums[0] to 1.
2. change nums[2] to 1.
3. change nums[3] to 1.
After performing the operations and sorting the numbers in each group, group 1 becomes equal to [0,1,2,3,4] and group 2 and group 3 become empty. Hence, res is equal to [0,1,2,3,4] which is sorted in non-decreasing order.
It can be proven that there is no valid sequence of less than three operations.
Example 2:

Input: nums = [1,3,2,1,3,3]
Output: 2
Explanation: It's optimal to perform two operations:
1. change nums[1] to 1.
2. change nums[2] to 1.
After performing the operations and sorting the numbers in each group, group 1 becomes equal to [0,1,2,3], group 2 becomes empty, and group 3 becomes equal to [4,5]. Hence, res is equal to [0,1,2,3,4,5] which is sorted in non-decreasing order.
It can be proven that there is no valid sequence of less than two operations.
Example 3:

Input: nums = [2,2,2,2,3,3]
Output: 0
Explanation: It's optimal to not perform operations.
After sorting the numbers in each group, group 1 becomes empty, group 2 becomes equal to [0,1,2,3] and group 3 becomes equal to [4,5]. Hence, res is equal to [0,1,2,3,4,5] which is sorted in non-decreasing order.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 3


  class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        int n=nums.size();
        
        int o,t,th,ans=n;
        vector<vector<int>> v(n+1, vector<int> (4,0));
        
        for(int i=0;i<n;i++){
            for(int j=1;j<4;j++){
                if(j==nums[i])
                    v[i+1][j]=1+v[i][j];
                else
                    v[i+1][j]=v[i][j];
            }
        }
        
        for(int i=0;i<=n;i++){
            for(int j=i;j<=n;j++){
                for(int k=j;k<=n;k++){
                    o=v[i][1];
                    t=v[j][2]-v[i][2];
                    th=v[k][3]-v[j][3];
                    ans=min(ans,n-o-t-th);
                    }
            }
        }
        return ans;
    }
};
