1) Account Balance After Rounded Purchase


  Initially, you have a bank account balance of 100 dollars.

You are given an integer purchaseAmount representing the amount you will spend on a purchase in dollars.

At the store where you will make the purchase, the purchase amount is rounded to the nearest multiple of 10. In other words, you pay a non-negative amount, roundedAmount, such that roundedAmount is a multiple of 10 and abs(roundedAmount - purchaseAmount) is minimized.

If there is more than one nearest multiple of 10, the largest multiple is chosen.

Return an integer denoting your account balance after making a purchase worth purchaseAmount dollars from the store.

Note: 0 is considered to be a multiple of 10 in this problem.

 

Example 1:

Input: purchaseAmount = 9
Output: 90
Explanation: In this example, the nearest multiple of 10 to 9 is 10. Hence, your account balance becomes 100 - 10 = 90.
Example 2:

Input: purchaseAmount = 15
Output: 80
Explanation: In this example, there are two nearest multiples of 10 to 15: 10 and 20. So, the larger multiple, 20, is chosen.
Hence, your account balance becomes 100 - 20 = 80.
 

Constraints:

0 <= purchaseAmount <= 100



  class Solution {
    public int accountBalanceAfterPurchase(int p) {
      int b=100;
        
        if(p==0)
            return 100;
        
        if(p%10==0)
            return b-p;
        
        int rem=p%10;
        int div=p/10;
        
        if(rem>=5)
            div++;
        
        int a=div*10;
        
        b-=a;
        
        return b;
        

    }
}



2)Insert Greatest Common Divisors in Linked List

  Given the head of a linked list head, in which each node contains an integer value.

Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.

Return the linked list after insertion.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.

 

Example 1:


Input: head = [18,6,10,3]
Output: [18,6,6,2,10,1,3]
Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes (nodes in blue are the inserted nodes).
- We insert the greatest common divisor of 18 and 6 = 6 between the 1st and the 2nd nodes.
- We insert the greatest common divisor of 6 and 10 = 2 between the 2nd and the 3rd nodes.
- We insert the greatest common divisor of 10 and 3 = 1 between the 3rd and the 4th nodes.
There are no more adjacent nodes, so we return the linked list.
Example 2:


Input: head = [7]
Output: [7]
Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes.
There are no pairs of adjacent nodes, so we return the initial linked list.
 

Constraints:

The number of nodes in the list is in the range [1, 5000].
1 <= Node.val <= 1000



  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int gcd(int x,int y){
      int r=0,a,b;
        a=(x>y) ? x:y;
        b=(x<y) ? x:y;
        r=b;
        while(a%b!=0){
            r=a%b;
            a=b;
            b=r;
        }
        return r;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode left=head;
        ListNode rig=head.next;
        
        while(rig!=null){
            int lv=left.val;
            int rv=rig.val;
            
            int gcd=gcd(lv,rv);
            
            ListNode nn =new ListNode();
            
            nn.val=gcd;
            left.next=nn;
            nn.next=rig;
            
            left=rig;
            rig=rig.next;
            
        }
        return head;
    }
}
