package Contest346;

public class Q2 {
    public String makeSmallestPalindrome(String s) {
        char[]a=s.toCharArray();
        int i=0;
        int j=a.length-1;
        while(i<=j){
            if(a[i]!=a[j]){
                if(a[i]<a[j]){
                    a[j]=a[i];
                }else{
                    a[i]=a[j];
                }
            }
            i++;
            j--;
        }
        return new String(a);
    }
}
