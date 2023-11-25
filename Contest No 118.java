1. Find Words Containing Character

  You are given a 0-indexed array of strings words and a character x.

Return an array of indices representing the words that contain the character x.

Note that the returned array may be in any order.

 

Example 1:

Input: words = ["leet","code"], x = "e"
Output: [0,1]
Explanation: "e" occurs in both words: "leet", and "code". Hence, we return indices 0 and 1.
Example 2:

Input: words = ["abc","bcd","aaaa","cbc"], x = "a"
Output: [0,2]
Explanation: "a" occurs in "abc", and "aaaa". Hence, we return indices 0 and 2.
Example 3:

Input: words = ["abc","bcd","aaaa","cbc"], x = "z"
Output: []
Explanation: "z" does not occur in any of the words. Hence, we return an empty array.



  class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> l=new ArrayList<>();
        
        for(int i=0;i<words.length;i++){
            if(words[i].indexOf(x) != -1)
                l.add(i);
        }
        return l;
    }
}





2.Maximize Area of Square Hole in Grid


  There is a grid with n + 2 horizontal bars and m + 2 vertical bars, and initially containing 1 x 1 unit cells.

The bars are 1-indexed.

You are given the two integers, n and m.

You are also given two integer arrays: hBars and vBars.

hBars contains distinct horizontal bars in the range [2, n + 1].
vBars contains distinct vertical bars in the range [2, m + 1].
You are allowed to remove bars that satisfy any of the following conditions:

If it is a horizontal bar, it must correspond to a value in hBars.
If it is a vertical bar, it must correspond to a value in vBars.
Return an integer denoting the maximum area of a square-shaped hole in the grid after removing some bars (possibly none).

 

Example 1:



Input: n = 2, m = 1, hBars = [2,3], vBars = [2]
Output: 4
Explanation: The left image shows the initial grid formed by the bars.
The horizontal bars are in the range [1,4], and the vertical bars are in the range [1,3].
It is allowed to remove horizontal bars [2,3] and the vertical bar [2].
One way to get the maximum square-shaped hole is by removing horizontal bar 2 and vertical bar 2.
The resulting grid is shown on the right.
The hole has an area of 4.
It can be shown that it is not possible to get a square hole with an area more than 4.
Hence, the answer is 4.
Example 2:



Input: n = 1, m = 1, hBars = [2], vBars = [2]
Output: 4
Explanation: The left image shows the initial grid formed by the bars.
The horizontal bars are in the range [1,3], and the vertical bars are in the range [1,3].
It is allowed to remove the horizontal bar [2] and the vertical bar [2].
To get the maximum square-shaped hole, we remove horizontal bar 2 and vertical bar 2.
The resulting grid is shown on the right.
The hole has an area of 4.
Hence, the answer is 4, and it is the maximum possible.
Example 3:



Input: n = 2, m = 3, hBars = [2,3], vBars = [2,3,4]
Output: 9
Explanation: The left image shows the initial grid formed by the bars.
The horizontal bars are in the range [1,4], and the vertical bars are in the range [1,5].
It is allowed to remove horizontal bars [2,3] and vertical bars [2,3,4].
One way to get the maximum square-shaped hole is by removing horizontal bars 2 and 3, and vertical bars 3 and 4.
The resulting grid is shown on the right.
The hole has an area of 9.
It can be shown that it is not possible to get a square hole with an area more than 9.
Hence, the answer is 9.
 

Constraints:

1 <= n <= 109
1 <= m <= 109
1 <= hBars.length <= 100
2 <= hBars[i] <= n + 1
1 <= vBars.length <= 100
2 <= vBars[i] <= m + 1
All values in hBars are distinct.
All values in vBars are distinct.


  class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        
        
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        
        int maxHConsucutive=0;
        int maxVConsuctive=0;
        
        int len=hBars.length;
        
        if(len!=0)
            maxHConsucutive=1;
        
        int lent=vBars.length;
        
        if(lent!=0)
            maxVConsuctive=1;
        
        int count=1;
        
        int h=n+2;
        int v=m+2;
        
        for(int i=0;i<len-1;i++){
            
            int inc=hBars[i]+1;
            if(hBars[i+1]==inc){
                count++;
                if(count>maxHConsucutive){
                    maxHConsucutive=count;
                }
            }else{
                count=1;
            }
        }
        
        count=1;
         for(int i=0;i<lent-1;i++){
            
            int inc=vBars[i]+1;
            if(vBars[i+1]==inc){
                count++;
                if(count>maxVConsuctive){
                    maxVConsuctive=count;
                }
            }else{
                count=1;
            }
        }
        
        System.out.println(maxHConsucutive+" "+maxVConsuctive);
        
        int ans=1;
        
        if(maxVConsuctive>0)
            maxVConsuctive++;
        if(maxHConsucutive>0)
            maxHConsucutive++;
        
        if(maxVConsuctive<maxHConsucutive){
            ans=maxVConsuctive;
        }else{
            ans=maxHConsucutive;
        }
        
        
        if(maxVConsuctive>0 && maxHConsucutive>0){
             return ans*ans;
        }else if(maxVConsuctive>0 && maxHConsucutive==0){
            
            if(len==1){
                return 4;
            }else{
                return 1;
            }
        }else if(maxVConsuctive==0 && maxHConsucutive>0){
            
             if(lent==1){
                return 4;
            }else{
                return 1;
            }
            
        }else{
            return 1;
        }
        
       
        
    }
}




3.Minimum Number of Coins for Fruits



  You are at a fruit market with different types of exotic fruits on display.

You are given a 1-indexed array prices, where prices[i] denotes the number of coins needed to purchase the ith fruit.

The fruit market has the following offer:

If you purchase the ith fruit at prices[i] coins, you can get the next i fruits for free.
Note that even if you can take fruit j for free, you can still purchase it for prices[j] coins to receive a new offer.

Return the minimum number of coins needed to acquire all the fruits.

 

Example 1:

Input: prices = [3,1,2]
Output: 4
Explanation: You can acquire the fruits as follows:
- Purchase the 1st fruit with 3 coins, you are allowed to take the 2nd fruit for free.
- Purchase the 2nd fruit with 1 coin, you are allowed to take the 3rd fruit for free.
- Take the 3rd fruit for free.
Note that even though you were allowed to take the 2nd fruit for free, you purchased it because it is more optimal.
It can be proven that 4 is the minimum number of coins needed to acquire all the fruits.
Example 2:

Input: prices = [1,10,1,1]
Output: 2
Explanation: You can acquire the fruits as follows:
- Purchase the 1st fruit with 1 coin, you are allowed to take the 2nd fruit for free.
- Take the 2nd fruit for free.
- Purchase the 3rd fruit for 1 coin, you are allowed to take the 4th fruit for free.
- Take the 4th fruit for free.
It can be proven that 2 is the minimum number of coins needed to acquire all the fruits.
 

Constraints:

1 <= prices.length <= 1000
1 <= prices[i] <= 105


  class Solution {
int solve(int currentIndex, int n, const std::vector<int>& prices, int remainingOffer, std::vector<std::vector<int>>& dp) {
        if (currentIndex == n)
            return 0;
        if (currentIndex > n)
            return 1e8;

        if (dp[currentIndex][remainingOffer] != -1)
            return dp[currentIndex][remainingOffer];

      
        if (remainingOffer) {
            return dp[currentIndex][remainingOffer] = std::min(
                prices[currentIndex] + solve(currentIndex + 1, n, prices, currentIndex + 1, dp),
                solve(currentIndex + 1, n, prices, remainingOffer - 1, dp)
            );
        }

     
        return dp[currentIndex][remainingOffer] = prices[currentIndex] + solve(currentIndex + 1, n, prices, currentIndex + 1, dp);
    }

public:
    int minimumCoins(std::vector<int>& prices) {
        int n = prices.size();
        std::vector<std::vector<int>> dp(n + 1, std::vector<int>(n + 1, -1));

        return solve(0, n, prices, 0, dp);
    }
};





