/*
Given a string s, find the length of the longest substring without repeating characters.
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
                if(i>=s.length()) {
                    if(!c.equals(s.substring(i,i+1))) count++;
                    break;
                }
                c=s.substring(i,i+1);
            }
            if(count>ans) ans=count;
            sb.append(c);
        }
        if(count>ans) ans=count;
        return ans;
    }
}
