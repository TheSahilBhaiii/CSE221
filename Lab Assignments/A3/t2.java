import java.io.*;
import java.util.*;
public class t2{
    static long inversionCount=0;
    public static void main(String[] args) throws Exception{
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int arr[]=new int[n];

        st=new StringTokenizer(bf.readLine());

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        mergeSort(arr);

        pw.println(inversionCount);

        pw.flush();
    }

    public static int[] mergeSort(int arr[]){
        if(arr.length<=1){
            return arr;
        }
        int mid=arr.length/2;
        int left[]=Arrays.copyOfRange(arr,0,mid);
        int right[]=Arrays.copyOfRange(arr,mid,arr.length);

        return merge(mergeSort(left),mergeSort(right));
    }

    public static int[] merge(int a[], int b[]){
        
        for(int i=0;i<a.length;i++){
            int target=a[i];
            
            if(target<=0){
                continue;
            }
            long limit=(long)Math.ceil(Math.sqrt(target))-1;

            int start=lowerbound(b,-limit);
            int end=upperbound(b,limit);

            if(end>start){
                inversionCount+=(end-start);
            }
        }
        int i=0;
        int j=0;
        int k=0;
        int res[]=new int[a.length+b.length];

        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
            res[k++]=a[i++];
            }
            else{
                res[k++]=b[j++];
            }
        }
        while(i<a.length)  res[k++]=a[i++];
        while(j<b.length)  res[k++]=b[j++];

        return res;
    }

    public static int lowerbound(int arr[],long val){
        int l=0;
        int r=arr.length;

        while(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=val){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public static int upperbound(int arr[],long val){
        int l=0;
        int r=arr.length;

        while(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid]>val){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}