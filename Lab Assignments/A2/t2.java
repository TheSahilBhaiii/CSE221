import java.io.*;
import java.util.*;

public class t2{
    public static void main(String[] args) throws Exception{
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(bf.readLine());
        
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        long k=Long.parseLong(st.nextToken());
        
        st=new StringTokenizer(bf.readLine());
        
        long a[]=new long[n];
        for(int i=0;i<n;i++){
            a[i]=Long.parseLong(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        long b[]=new long[m];
        for(int i=0;i<m;i++){
            b[i]=Long.parseLong(st.nextToken());
        }

        int left=0;
        int right=m-1;

        long bestdiff=Long.MAX_VALUE;
        int bestleft=-1;
        int bestright=-1;

        while(left<n && right>=0){
            long currentsum=a[left]+b[right];
            long currentdiff=Math.abs(currentsum-k);

            if(currentdiff<bestdiff){
                bestdiff=currentdiff;
                bestleft=left;
                bestright=right;
            }
            if(currentsum==k){
                break;
            }
            else if(currentsum<k){
                left++;
            }
            else{
                right--;
            }
        }
        pw.println((bestleft+1)+" "+(bestright+1));
        pw.flush();
    }
}