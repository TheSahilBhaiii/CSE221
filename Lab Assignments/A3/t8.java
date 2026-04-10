import java.io.*;
import java.util.*;
public class t8{
    static PrintWriter pw;
    static int pos[];
    static int postOrder[];
    static int postIndex;

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

        postOrder=new int[n];
        for(int i=0;i<n;i++){
            postOrder[i]=Integer.parseInt(st.nextToken());
        }

        printPreOrder(0,n-1,n-1);

        pw.println();
        pw.flush();
    }
    public static void printPreOrder(int left, int right, int postIndex){
        if(left>right){
            return;
        }
        int root=postOrder[postIndex];

        pw.print(root+" ");

        int inIndex=pos[root];

        int rightSize=right-inIndex;

        printPreOrder(left, inIndex - 1, postIndex - rightSize - 1);
        printPreOrder(inIndex + 1, right, postIndex - 1);
    }
}
