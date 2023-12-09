package practise;

import java.util.*;
import java.lang.*;
import java.io.*;
 class Codechef
{
    static PrintWriter out=new PrintWriter((System.out));
    // consoleOutput.printf
    static Reader sc=new Reader();
    static int c=0;
    public static void main(String args[])throws IOException
    {
        int t=sc.nextInt();
        while(t-->0)
        {
            
            solve();
            c++;
        }
        out.close();
    }
    
    public static void solve()
    {
       
        int n=sc.nextInt();
        int[]a=new int[n];
        int x=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        int i=0;int j=0;
        int sum=0,count=0;
        while(j<a.length){
            sum+=a[j];
            while(i<a.length&&j-i+1>3){
                sum-=a[i];
                i++;
            }
            if(j-i+1==3){
                if(sum%3!=0){
                    a[j]+=3-sum%3;
                    count+=3-sum%3;
                    sum+=3-sum%3;
                    
                }
                System.out.println(sum);
            }
            j++;

        }
        System.out.println(count);




        

    }
    
    static class Reader 
    { 
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        public String next()
        {
            while(!st.hasMoreTokens())
            {
                try
                {
                    st=new StringTokenizer(br.readLine());
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        public int nextInt()
        {
            return Integer.parseInt(next());
        }
    
        public long nextLong()
        {
            return Long.parseLong(next());
        }
        public double nextDouble()
        {
            return Double.parseDouble(next());
        }
        public String nextLine()
        {
            try
            {
                return br.readLine();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
        public boolean hasNext()
        {
            String next=null;
            try
            {
                next=br.readLine();
            }
            catch(Exception e)
            {
            }
            if(next==null)
            {
                return false;
            }
            st=new StringTokenizer(next);
            return true;
        }
    } 
}