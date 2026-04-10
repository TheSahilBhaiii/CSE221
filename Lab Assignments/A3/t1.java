import java.io.*;
import java.util.*;
public class t1{
    static long inversionCount = 0;
    public static void main(String[] args) throws Exception{
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(bf.readLine());

        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int sortedArr[]=mergeSort(arr);

        pw.println(inversionCount);

        for(int i=0;i<n;i++){
            pw.print(sortedArr[i]);
            if(i==n-1){
                pw.print("");
            }
            else{
                pw.print(" ");
            }
        }
        pw.flush();
    }
    public static int[] mergeSort(int arr[]){
        if(arr.length <=1){
            return arr;
        }
        int mid=arr.length/2;
        int left[]=Arrays.copyOfRange(arr,0,mid);
        int right[]=Arrays.copyOfRange(arr,mid,arr.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int []merge(int a[], int b[]){
        int result[]=new int[a.length+b.length];
        int i=0;
        int j=0;
        int k=0;

        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                result[k++]=a[i++];
            }
            else{
                result[k++]=b[j++];
                inversionCount+=(a.length-i);
            }
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        
        return result;
    }
}