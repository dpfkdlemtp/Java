class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer ans= new StringBuffer();

        int i,j,sum,temp=0,x,y;

        i=num1.length()-1;
        j=num2.length()-1;

        while(true){
            sum=0;

            // x와 y에 일의 자리 수부터 대입, 범위를 벗어날 경우 0
            if(i<0) x=0; 
            else x=num1.charAt(i)-'0';
            if(j<0) y=0;
            else y=num2.charAt(j)-'0';

            System.out.println(x+y);
            sum=x+y+temp;

            if(sum>=10){ // 자리 수의 합이 10 이상인 경우 합-=10, carry=1
                sum-=10;
                temp=1;
            }
            else temp=0;

            ans.append(sum); // 합을 문자열에 추가

            System.out.println(sum);

            i--; j--;
            if(i<0 && j<0) break; // 인덱스가 자리 수를 초과할 경우 break
        }
        if(temp>0) ans.append(1); // 탈출 후 carry가 1인 경우 1 추가
        return ans.reverse().toString(); // StringBuffer를 Reverse하고, String으로 형변환
    }
}
