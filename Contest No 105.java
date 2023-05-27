// 1.Buy Two Chocolates

// You are given an integer array prices representing the prices of various chocolates in a store. You are also given a single integer money, which 
// represents your initial amount of money.

// You must buy exactly two chocolates in such a way that you still have some non-negative leftover money. You would like to minimize the sum of the 
// prices of the two chocolates you buy.

// Return the amount of money you will have leftover after buying the two chocolates. If there is no way for you to buy two chocolates without 
// ending up in debt, return money. Note that the leftover must be non-negative.

//  Example 1:

// Input: prices = [1,2,2], money = 3
// Output: 0
// Explanation: Purchase the chocolates priced at 1 and 2 units respectively. You will have 3 - 3 = 0 units of money afterwards. 
//   Thus, we return 0.
  
  class Solution {
    public int buyChoco(int[] p, int m) {
        Arrays.sort(p);
        
        int a=p[0]+p[1];
        
        if(a<=m)
            return m-a;
        else
            return m;
    }
}


// 3 .Maximum Strength of a Group
// You are given a 0-indexed integer array nums representing the score of students in an exam.
//   The teacher would like to form one non-empty group of students with maximal strength, where the strength of a group of students of 
//   indices i0, i1, i2, ... , ik is defined as nums[i0] * nums[i1] * nums[i2] * ... * nums[ik​].

// Return the maximum strength of a group the teacher can create.
  
//   Input: nums = [3,-1,-5,2,5,-9]
// Output: 1350
// Explanation: One way to form a group of maximal strength is to group the students at indices [0,2,3,4,5]. Their strength is 3 * (-5) * 2 * 5 * (-9) = 1350, which
// we can show is optimal.
  
  
  class Solution {
    public long maxStrength(int[] nums) {
        
        int leng=nums.length;
        
        if(leng==1)
            return nums[0];
        
        List<Integer> less=new ArrayList<>();
        
        List<Integer> gre=new ArrayList<>();
        
        for(int i=0;i<leng;i++){
            
            if(nums[i]<0)
                less.add(nums[i]);
            else if(nums[i]>0)
                gre.add(nums[i]);
        }
        
        long a1=0;
        Collections .sort(less);
        Collections.sort(gre);
        
        for(int i=0;i<less.size();i++){
            if(i==0)
                a1=(long)less.get(i);
            else{
                if(less.size()%2==0){
                    long n=less.get(i);
                    a1=a1*n;
                }else{
                    if(i<less.size()-1){
                        long n=less.get(i);
                        a1=a1*n;
                    }
                }
            }
        }
        
        long a2=0;
        for(int i=0;i<gre.size();i++){
            if(a2==0)
                a2=(long)gre.get(i);
            else{
                long p=(long)gre.get(i);
                a2=a2*p;
            }
        }
        
        if(a1>0 && a2>0)
            return a1*a2;
        else if(a1>0)
            return a1;
        else if(a2>0)
            return a2;
        else
            return 0;
    }
}
  
  
  
  
  
  
  
  
