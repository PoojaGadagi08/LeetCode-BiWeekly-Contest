//1) Number of Senior Citizens


// User Accepted:12258
// User Tried:12573
// Total Accepted:12648
// Total Submissions:16222
// Difficulty:Easy
// You are given a 0-indexed array of strings details. Each element of details provides information about a given passenger compressed into a string of length 15. The system is such that:

// The first ten characters consist of the phone number of passengers.
// The next character denotes the gender of the person.
// The following two characters are used to indicate the age of the person.
// The last two characters determine the seat allotted to that person.
// Return the number of passengers who are strictly more than 60 years old.

class Solution {
    public int countSeniors(String[] details) {
        int c=0;
        for(int i=0;i<details.length;i++){
            int s=Integer.parseInt(details[i].substring(11,13));
            if(s>60)
                c++;
        }
        return c;
    }
}



// 2)Sum in a Matrix


// User Accepted:9880
// User Tried:11243
// Total Accepted:10098
// Total Submissions:18196
// Difficulty:Medium
// You are given a 0-indexed 2D integer array nums. Initially, your score is 0. Perform the following operations until the matrix becomes empty:

// From each row in the matrix, select the largest number and remove it. In the case of a tie, it does not matter which number is chosen.
// Identify the highest number amongst all those removed in step 1. Add that number to your score.
// Return the final score.

class Solution {
    public int matrixSum(int[][] a) {
        int len=a.length;
        
        //PrioriotyQueue<Integer> m=new PrioriotyQueue<>(Collections.reverseOrder());
        List<PriorityQueue<Integer>> l=new ArrayList<>();
        
        for(int i=0;i<len;i++){
             PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
            
            for(int j=0;j<a[0].length;j++){
                max.add(a[i][j]);
            }
            l.add(max);
        }
        int max=0;
        int s=0;
        for(int i=0;i<a[0].length;i++){
            int mxx=0;
            for(int j=0;j<l.size();j++){
                int mx=l.get(j).poll();
                if(mx>mxx)
                    mxx=mx;
            }
            s+=mxx;
        }
        return s;
    }
}
