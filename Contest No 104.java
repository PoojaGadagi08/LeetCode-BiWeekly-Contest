// Number of Senior Citizens


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

