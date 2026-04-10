import java.io.*;
import java.util.*;

public class t1{
    public static void main(String[] args) throws Exception{
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        int arr[]=new int[n];

        st=new StringTokenizer(bf.readLine());


        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int left=0;
        int right=n-1;
        boolean flag=false;

        while(left<right){
            long sum=(long)arr[left]+arr[right];

            if(sum==s){
                pw.println((left+1)+" "+(right+1));
                flag=true;
                break;
            }
            else if(sum<s){
                left++;
            }
            else{
                right--;
            }
        }
        if(flag==false){
            pw.println(-1);
        }
        pw.flush();

    }
}

