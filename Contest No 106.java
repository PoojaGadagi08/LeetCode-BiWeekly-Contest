1.Check if The Number is Fascinating

You are given an integer n that consists of exactly 3 digits.

We call the number n fascinating if, after the following modification, the resulting number contains all the digits from 1 to 9 exactly once and does not contain any 0's:

Concatenate n with the numbers 2 * n and 3 * n.
Return true if n is fascinating, or false otherwise.

Concatenating two numbers means joining them together. For example, the concatenation of 121 and 371 is 121371.

 

Example 1:

Input: n = 192
Output: true
Explanation: We concatenate the numbers n = 192 and 2 * n = 384 and 3 * n = 576. The resulting number is 192384576. This number contains all the digits from 1 to 9 exactly once.
  
  
  class Solution {
    public boolean isFascinating(int n) {
        int  n1=n*2;
        int n2=n*3;
        
        String c=Integer.toString(n)+Integer.toString(n1)+Integer.toString(n2);
        
        char temp[]=c.toCharArray();
        Arrays.sort(temp);
        
        String s=new String(temp);
        
        if(s.equals("123456789"))
            return true;
        return false;
    }
}
