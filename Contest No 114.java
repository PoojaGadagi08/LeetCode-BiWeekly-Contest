1.Minimum Operations to Collect Elements



  You are given an array nums of positive integers and an integer k.

In one operation, you can remove the last element of the array and add it to your collection.

Return the minimum number of operations needed to collect elements 1, 2, ..., k.

 

Example 1:

Input: nums = [3,1,5,4,2], k = 2
Output: 4
Explanation: After 4 operations, we collect elements 2, 4, 5, and 1, in this order. Our collection contains elements 1 and 2. Hence, the answer is 4.
Example 2:

Input: nums = [3,1,5,4,2], k = 5
Output: 5
Explanation: After 5 operations, we collect elements 2, 4, 5, 1, and 3, in this order. Our collection contains elements 1 through 5. Hence, the answer is 5.
Example 3:

Input: nums = [3,2,5,3,1], k = 3
Output: 4
Explanation: After 4 operations, we collect elements 1, 3, 5, and 2, in this order. Our collection contains elements 1 through 3. Hence, the answer is 4.
 

Constraints:

1 <= nums.length <= 50
1 <= nums[i] <= nums.length
1 <= k <= nums.length
The input is generated such that you can collect elements 1, 2, ..., k.





  class Solution {
    public int minOperations(List<Integer> nums, int k) {
        int n=nums.size();
        HashSet<Integer> h=new HashSet<>();
        
        for(int i=1;i<=k;i++)
            h.add(i);
        
        int c=0;
        
        for(int i=n-1;i>=0;i--){
            int val=nums.get(i);
            if(h.contains(val))
                h.remove(val);
            
            c++;
            if(h.size()==0)
                break;
        }
        return c;
    }
}





2.Minimum Number of Operations to Make Array Empty


  You are given a 0-indexed array nums consisting of positive integers.

There are two types of operations that you can apply on the array any number of times:

Choose two elements with equal values and delete them from the array.
Choose three elements with equal values and delete them from the array.
Return the minimum number of operations required to make the array empty, or -1 if it is not possible.

 

Example 1:

Input: nums = [2,3,3,2,2,4,2,3,4]
Output: 4
Explanation: We can apply the following operations to make the array empty:
- Apply the first operation on the elements at indices 0 and 3. The resulting array is nums = [3,3,2,4,2,3,4].
- Apply the first operation on the elements at indices 2 and 4. The resulting array is nums = [3,3,4,3,4].
- Apply the second operation on the elements at indices 0, 1, and 3. The resulting array is nums = [4,4].
- Apply the first operation on the elements at indices 0 and 1. The resulting array is nums = [].
It can be shown that we cannot make the array empty in less than 4 operations.
Example 2:

Input: nums = [2,1,2,2,3,3]
Output: -1
Explanation: It is impossible to empty the array.
 

Constraints:

2 <= nums.length <= 105
1 <= nums[i] <= 106





  import java.util.HashMap;

public class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

//         HashMap<Integer, Integer> h = new HashMap<>();

//         for (int x : nums) {
//             h.put(x, h.getOrDefault(x, 0) + 1);
//         }

//         int two = 0;
//         int three = 0;

//         for (int key : h.keySet()) {
//             int count = h.get(key);
//             if (count % 2 == 0) {
//                 two += count / 2;
//             } else if (count % 3 == 0) {
//                 three += count / 3;
//             } else {
//                 return -1;
//             }
//         }

//         return two + three;
        
        HashMap<Integer, Integer> h = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int val=nums[i];
            if(h.get(val)==null)
                h.put(val,1);
            else{
                int m=h.get(val);
                m++;
                h.put(val,m);
            }
        }
        
        List<Integer> l=new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : h.entrySet()){
            l.add(entry.getValue());
        }
        
        int ans=0;
        for(int i=0;i<l.size();i++){
            int c=l.get(i);
            if(c==1){
                ans=-1;
                break;
            }
            else{
                while(c>0){
                    if(c%3==0){
                        int div=c/3;
                        ans+=div;
                        c=0;
                    }
                    else{
                        c-=2;
                            ans++;
                    }
                }
                if(c<0){
                    ans-=1;
                break;}
            }
        }
        return ans;
    }
}





3.Split Array Into Maximum Number of Subarrays


  You are given an array nums consisting of non-negative integers.

We define the score of subarray nums[l..r] such that l <= r as nums[l] AND nums[l + 1] AND ... AND nums[r] where AND is the bitwise AND operation.

Consider splitting the array into one or more subarrays such that the following conditions are satisfied:

Each element of the array belongs to exactly one subarray.
The sum of scores of the subarrays is the minimum possible.
Return the maximum number of subarrays in a split that satisfies the conditions above.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,0,2,0,1,2]
Output: 3
Explanation: We can split the array into the following subarrays:
- [1,0]. The score of this subarray is 1 AND 0 = 0.
- [2,0]. The score of this subarray is 2 AND 0 = 0.
- [1,2]. The score of this subarray is 1 AND 2 = 0.
The sum of scores is 0 + 0 + 0 = 0, which is the minimum possible score that we can obtain.
It can be shown that we cannot split the array into more than 3 subarrays with a total score of 0. So we return 3.
Example 2:

Input: nums = [5,7,1,3]
Output: 1
Explanation: We can split the array into one subarray: [5,7,1,3] with a score of 1, which is the minimum possible score that we can obtain.
It can be shown that we cannot split the array into more than 1 subarray with a total score of 1. So we return 1.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 106
