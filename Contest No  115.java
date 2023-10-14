1.Last Visited Integers



  Given a 0-indexed array of strings words where words[i] is either a positive integer represented as a string or the string "prev".

Start iterating from the beginning of the array; for every "prev" string seen in words, find the last visited integer in words which is defined as follows:

Let k be the number of consecutive "prev" strings seen so far (containing the current string). Let nums be the 0-indexed array of integers seen so far and nums_reverse be the reverse of nums, then the integer at (k - 1)th index of nums_reverse will be the last visited integer for this "prev".
If k is greater than the total visited integers, then the last visited integer will be -1.
Return an integer array containing the last visited integers.

 

Example 1:

Input: words = ["1","2","prev","prev","prev"]
Output: [2,1,-1]
Explanation: 
For "prev" at index = 2, last visited integer will be 2 as here the number of consecutive "prev" strings is 1, and in the array reverse_nums, 2 will be the first element.
For "prev" at index = 3, last visited integer will be 1 as there are a total of two consecutive "prev" strings including this "prev" which are visited, and 1 is the second last visited integer.
For "prev" at index = 4, last visited integer will be -1 as there are a total of three consecutive "prev" strings including this "prev" which are visited, but the total number of integers visited is two.
Example 2:

Input: words = ["1","prev","2","prev","prev"]
Output: [1,2,1]
Explanation:
For "prev" at index = 1, last visited integer will be 1.
For "prev" at index = 3, last visited integer will be 2.
For "prev" at index = 4, last visited integer will be 1 as there are a total of two consecutive "prev" strings including this "prev" which are visited, and 1 is the second last visited integer.
 

Constraints:

1 <= words.length <= 100
words[i] == "prev" or 1 <= int(words[i]) <= 100






  class Solution {
    public List<Integer> lastVisitedIntegers(List<String> w) {
         int l=w.size();
        List<Integer> result = new ArrayList<>();
       for(int i=0;i<l;i++){
           String s=w.get(i);
           if(s.equals("prev")){
               int c=0;
               int j=1;
               for(j=i;j>=0;j--){
                   if(w.get(j).equals("prev"))
                       c++;
                   else break;
               }
               
               int cnt=0;
               int ans=-1;
               
               for(int k=j;k>=0;k--){
                   String m=w.get(k);
                   if(m.equals("prev")){}
                   else {
                       cnt++;
                       if(cnt==c){
                           ans=Integer.parseInt(m);
                           break;
                       }
                   }
               }
               result.add(ans);
           }
       }
        return result;
    }
}








2.Longest Unequal Adjacent Groups Subsequence I


  You are given an integer n, a 0-indexed string array words, and a 0-indexed binary array groups, both arrays having length n.

You need to select the longest subsequence from an array of indices [0, 1, ..., n - 1], such that for the subsequence denoted as [i0, i1, ..., ik - 1] having length k, groups[ij] != groups[ij + 1], for each j where 0 < j + 1 < k.

Return a string array containing the words corresponding to the indices (in order) in the selected subsequence. If there are multiple answers, return any of them.

A subsequence of an array is a new array that is formed from the original array by deleting some (possibly none) of the elements without disturbing the relative positions of the remaining elements.

Note: strings in words may be unequal in length.

 

Example 1:

Input: n = 3, words = ["e","a","b"], groups = [0,0,1]
Output: ["e","b"]
Explanation: A subsequence that can be selected is [0,2] because groups[0] != groups[2].
So, a valid answer is [words[0],words[2]] = ["e","b"].
Another subsequence that can be selected is [1,2] because groups[1] != groups[2].
This results in [words[1],words[2]] = ["a","b"].
It is also a valid answer.
It can be shown that the length of the longest subsequence of indices that satisfies the condition is 2.
Example 2:

Input: n = 4, words = ["a","b","c","d"], groups = [1,0,1,1]
Output: ["a","b","c"]
Explanation: A subsequence that can be selected is [0,1,2] because groups[0] != groups[1] and groups[1] != groups[2].
So, a valid answer is [words[0],words[1],words[2]] = ["a","b","c"].
Another subsequence that can be selected is [0,1,3] because groups[0] != groups[1] and groups[1] != groups[3].
This results in [words[0],words[1],words[3]] = ["a","b","d"].
It is also a valid answer.
It can be shown that the length of the longest subsequence of indices that satisfies the condition is 3.
 

Constraints:

1 <= n == words.length == groups.length <= 100
1 <= words[i].length <= 10
0 <= groups[i] < 2
words consists of distinct strings.
words[i] consists of lowercase English letters.


  #include<vector>
#include<string>

class Solution {
public:
  std::vector<std::string> getWordsInLongestSubsequence(int n, std::vector<std::string>& w, std::vector<int>& g) {
        int l=0;
      int c=-1;
      std::vector<std::string> ls;
      for(int i=0;i<n;i++){
          if(g[i]!=c){
              c=g[i];
          ls.push_back(w[i]);
          ++l;
          }
      }
      return ls;
    }
};
