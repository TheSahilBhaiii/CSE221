import java.io.*;
import java.util.*;
public class t7{
    static PrintWriter pw;
    static int pos[];
    static int preOrder[];
    static int preIndex=0;

    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());

        pos=new int[n+1];

        for(int i=0;i<n;i++){
            int val=Integer.parseInt(st.nextToken());
            pos[val]=i;
        }
        st=new StringTokenizer(bf.readLine());

        preOrder=new int[n];

        for(int i=0;i<n;i++){
            preOrder[i]=Integer.parseInt(st.nextToken());
        }

        printPostOrder(0,n-1);

        pw.println();
        pw.flush();
    }

    public static void printPostOrder(int left,int right){
        if(left>right){
            return;
        }
        int root=preOrder[preIndex++];
        int inIndex=pos[root];

        printPostOrder(left, inIndex-1);
        printPostOrder(inIndex+1, right);

        pw.print(root+" ");
    }
}
