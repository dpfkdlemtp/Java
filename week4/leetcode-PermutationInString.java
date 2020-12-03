/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
*/
class Solution {
    static Map<Character, Integer> map=new HashMap();

    public static void mapadd(Character c, Integer i){
        
        int val=map.getOrDefault(c,0)+i;
        map.put(c,val);
        if (val == 0) {
            map.remove(c);
        }
    }
    
    public boolean checkInclusion(String s1, String s2) {
        map.clear();
        if(s1.length()>s2.length()) return false;
        for (int i=0;i<s1.length();i++) {
            mapadd(s1.charAt(i),1);
            mapadd(s2.charAt(i),-1);
        }
        System.out.println(map);
        if(map.size()==0) return true;
        for(int i=s1.length();i<s2.length();i++){
            mapadd(s2.charAt(i-s1.length()), 1);
            mapadd(s2.charAt(i),-1);
            System.out.println(map);
            if(map.size()==0)   return true;
        }

        return false;
    }
}
