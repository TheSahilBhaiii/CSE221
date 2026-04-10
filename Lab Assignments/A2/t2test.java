import java.io.*;
import java.util.*;

public class t3{
    public static void main(String[] args) throws Exception{
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        long x=Long.parseLong(st.nextToken());

        long arr[][]=new long[n][2];

        st=new StringTokenizer(bf.readLine());

        for(int i=0;i<n;i++){
            arr[i][0]=Long.parseLong(st.nextToken());
            arr[i][1]=i+1;
        }

        Arrays.sort(arr, (a,b) -> Long.compare(a[0],b[0]));

        boolean flag=false;

        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;

            while(left<right){
                long currentsum=arr[i][0]+arr[left][0]+arr[right][0];
                
                if(currentsum==x){
                    pw.println(arr[i][1]+" "+arr[left][1]+" "+arr[right][1]);
                    flag=true;
                    break;
                }
                else if(currentsum<x){
                    left++;
                }
                else{
                    right--;
                }
            }
            if(flag==true){
                break;
            }
        }
         if(flag==false){
                pw.println("-1");
            }
            pw.flush();
    }
}