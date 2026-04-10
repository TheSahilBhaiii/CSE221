import java.io.*;
import java.util.*;
public class t6{
    static PrintWriter pw;
    static int arr[];
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        printOptimalOrder(0,n-1);

        pw.println();
        pw.flush();
    }

    public static void printOptimalOrder(int left,int right){
        if(left>right){
            return;
        }
        int mid=left+(right-left)/2;

        pw.print(arr[mid]+" ");

        printOptimalOrder(left, mid-1);
        printOptimalOrder(mid+1, right);
    }
}
