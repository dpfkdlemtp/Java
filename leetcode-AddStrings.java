class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer ans= new StringBuffer();

        int i,j,sum,temp=0,x,y;

        i=num1.length()-1;
        j=num2.length()-1;

        while(true){
            sum=0;

            if(i<0) x=0;
            else x=num1.charAt(i)-'0';
            if(j<0) y=0;
            else y=num2.charAt(j)-'0';

            System.out.println(x+y);
            sum=x+y+temp;

            if(sum>=10){
                sum-=10;
                temp=1;
            }
            else temp=0;

            ans.append(sum);

            System.out.println(sum);

            i--; j--;
            if(i<0 && j<0) break;
        }
        if(temp>0) ans.append(1);
        return ans.reverse().toString();
    }
}
