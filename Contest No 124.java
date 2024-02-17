1.Maximum Number of Operations With the Same Score I

  Given an array of integers called nums, you can perform the following operation while nums contains at least 2 elements:

Choose the first two elements of nums and delete them.
The score of the operation is the sum of the deleted elements.

Your task is to find the maximum number of operations that can be performed, such that all operations have the same score.

Return the maximum number of operations possible that satisfy the condition mentioned

  Example 1:

Input: nums = [3,2,1,4,5]
Output: 2
Explanation: We perform the following operations:
- Delete the first two elements, with score 3 + 2 = 5, nums = [1,4,5].
- Delete the first two elements, with score 1 + 4 = 5, nums = [5].
We are unable to perform any more operations as nums contain only 1 element.
Example 2:

Input: nums = [3,2,6,1,4]
Output: 1
Explanation: We perform the following operations:
- Delete the first two elements, with score 3 + 2 = 5, nums = [6,1,4].
We are unable to perform any more operations as the score of the next operation isn't the same as the previous one.
 

Constraints:

2 <= nums.length <= 100
1 <= nums[i] <= 1000



  class Solution {
    public int maxOperations(int[] nums) {
        // Stack<Integer> s =new Stack<>();
        int n=nums.length;
        // int preSum=0;
        // int newSum=0;
        // int i=0;
        // while(n>=2){
        //     s.push(nums[i++]);
        //     if(i%2==0 && i>0){
        //         preSum +=s.pop();
        //     }
        // }
        
        
        Queue<Integer> q =new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(nums[i]);
        }
        
        int ans=0;
        int sum2=-1;
        
        while(true){
            try{
                int f =q.remove();
                int s= q.remove();
                
                int sum=f+s;
                
                if(sum2==-1){
                    sum2=sum;
                    ans++;
                }else{
                    if(sum == sum2)ans++;
                    else break;
                }
            }
            catch(Exception e){
                break;
            }
        }
        return ans;
    }
}




2.Apply Operations to Make String Empty

  You are given a string s.

Consider performing the following operation until s becomes empty:

For every alphabet character from 'a' to 'z', remove the first occurrence of that character in s (if it exists).
Return the value of the string s right before applying the last operation.

  class Solution {
    
    public String lastNonEmptyString(String s) {
        
        int lent = s.length();
        
        int max = 0;
        
        HashMap<Character,Integer> h = new HashMap<>();
        
        HashMap<Character,Integer> lastInd = new HashMap<>();
        
        for(int i=0;i<lent;i++){
            
            char c= s.charAt(i);
            
            if(h.get(c) == null){
                h.put(c,1);
            }else{
                int p = h.get(c);
                p++;
                h.put(c,p);
            }
            lastInd.put(c,i);
        }
        
      //  System.out.println(h);
        
        List<Character> li = new ArrayList<>();
        HashSet<Character> ht = new HashSet<>();
        
       for (Map.Entry<Character, Integer> entry : h.entrySet()) {
            char key = entry.getKey(); // Corrected method name
            int count = entry.getValue();
            
            if(count>max){
                li = new ArrayList<>();
                 ht = new HashSet<>();
                max = count;
                li.add(key);
                ht.add(key);
            }else if(count == max){
                li.add(key);
                 ht.add(key);
            }
            
           
        }
        
       // System.out.println(lastInd);
        HashMap<Integer,Character> hp = new HashMap<>();
        List<Integer> lk = new ArrayList<>();
       for (Map.Entry<Character, Integer> entry : lastInd.entrySet()) {
           
           
            char key = entry.getKey(); // Corrected method name
            int count = entry.getValue();
           if(ht.contains(key)){
            lk.add(count);
            hp.put(count,key);
           }
        }
       
        Collections.sort(lk);
         // System.out.println(hp);
        String ans = "";
        
        for(int i=0;i<lk.size();i++){
            
            int ind = lk.get(i);
             //value = hp.get(ind);
            // System.out.println(ind +" -= "+value);
            char m = s.charAt(ind);
            ans = ans + hp.get(ind)+"";
        }
        
        return ans;
        
    }
}

3.Maximum Number of Operations With the Same Score II


  Given an array of integers called nums, you can perform any of the following operation while nums contains at least 2 elements:

Choose the first two elements of nums and delete them.
Choose the last two elements of nums and delete them.
Choose the first and the last elements of nums and delete them.
The score of the operation is the sum of the deleted elements.

Your task is to find the maximum number of operations that can be performed, such that all operations have the same score.

Return the maximum number of operations possible that satisfy the condition mentioned above.

 

Example 1:

Input: nums = [3,2,1,2,3,4]
Output: 3
Explanation: We perform the following operations:
- Delete the first two elements, with score 3 + 2 = 5, nums = [1,2,3,4].
- Delete the first and the last elements, with score 1 + 4 = 5, nums = [2,3].
- Delete the first and the last elements, with score 2 + 3 = 5, nums = [].
We are unable to perform any more operations as nums is empty.
Example 2:

Input: nums = [3,2,6,1,4]
Output: 2
Explanation: We perform the following operations:
- Delete the first two elements, with score 3 + 2 = 5, nums = [6,1,4].
- Delete the last two elements, with score 1 + 4 = 5, nums = [6].
It can be proven that we can perform at most 2 operations.
 

Constraints:

2 <= nums.length <= 2000
1 <= nums[i] <= 1000




  // #include <vector>
// #include <iostream>
// using namespace std;

class Solution {
public:
    
    int solve(int i, int j, int sum, vector<int> & nums, vector<vector<int>>& dp){
        if(i >= j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int a = 0, b = 0, c = 0, x = 0, y = 0, z = 0;
        
        a = nums[i] + nums[j];
        if(a == sum)
            x = 1 + solve(i + 1, j - 1, sum, nums, dp);
        
        b = nums[i] + nums[i + 1];
        if(b == sum)
            y = 1 + solve(i + 2, j, sum, nums, dp);
        
        c = nums[j] + nums[j - 1];
        if(c == sum)
            z = 1 + solve(i, j - 2, sum, nums, dp);
        
        return dp[i][j] = max({x, y, z});
    }
    
    int maxOperations(vector<int>& nums) {
        int n = nums.size();
        if(n < 2)
            return 0;
        
        int s1 = nums[0] + nums[1];
        int s2 = nums[n - 1] + nums[n - 2];
        int s3 = nums[0] + nums[n - 1];
        
        vector<vector<int>> dp(n, vector<int>(n, -1));
        
        int a = solve(0, n - 1, s1, nums, dp);
        fill(dp.begin(), dp.end(), vector<int>(n, -1)); // Clearing dp array
        int b = solve(0, n - 1, s2, nums, dp);
        fill(dp.begin(), dp.end(), vector<int>(n, -1)); // Clearing dp array
        int c = solve(0, n - 1, s3, nums, dp);
        
        cout << a << " " << b << " " << c << endl;
        
        int ans = max({a, b, c});
        return ans;
    }
};
