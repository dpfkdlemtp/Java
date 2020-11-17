class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        char tmp;
        for(int i=0;i<len/2;i++){ // 처음과 끝을 바꾸는 작업 len/2 번 반복
            tmp=s[i];
            s[i]=s[len-i-1];
            s[len-i-1]=tmp;
        }
    }
}
