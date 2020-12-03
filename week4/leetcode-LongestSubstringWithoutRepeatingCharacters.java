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
        StringBuffer sb= new StringBuffer();
        int ans=0;
        int count=1;
        
        if(s.length()==0) return 0;
        else if(s.length()==1) return 1;
        sb.append(s.substring(0,1));

        for(int i=1;i<s.length();i++) {
            String c=s.substring(i,i+1);
            if(sb.indexOf(c)<0) {
                count++;
            }
            else{
                for(int j=i-1;j>=0;j--){
                    if(s.substring(j,j+1).equals(c)){
                        i=j+1;
                        break;
                    }
                }
                count=1;
                sb.setLength(0);
                c=s.substring(i,i+1);
            }
            if(count>ans) ans=count;
            sb.append(c);
        }
        if(count>ans) ans=count;
        return ans;
    }
}
