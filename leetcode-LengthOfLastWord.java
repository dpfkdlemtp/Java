class Solution {
    public int lengthOfLastWord(String s) {
        if(s.trim().length()>0){ // 공백 제거 후 길이 검사
            String[] str=s.split(" "); // 공백 기준으로 배열에 대입
            return str[str.length-1].length();
        }
        else return 0;
    }
}
