import java.util.Scanner;
public class t6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        for(int k=0;k<N;k++){
        for(int i=0;i<N-1;i++){

        if(arr[i]%2==0 && arr[i+1]%2==0){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        if(arr[i]%2!=0 && arr[i+1]%2!=0){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        }
    }
    for(int i=0;i<N;i++){
        System.out.print(arr[i]+" ");
    }
}
}
