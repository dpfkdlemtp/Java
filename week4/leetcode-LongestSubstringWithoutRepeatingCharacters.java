/*
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
       String s2= "";
        int ans=0;
        int count=1;

        if(s.length()==0) return 0;
        else if(s.length()==1) return 1;

        for(int i=0;i<s.length();) {
            char c=s.charAt(i);
            if(!s2.contains(String.valueOf(c))) {
                s2+=c;
                i++;
            }
            else{
                count=s2.length();
                s2=s2.substring(1);
            }
            if(count>ans) ans=count;
        }
        count=s2.length();
        if(count>ans) ans=count;
        return ans;
    }
}
