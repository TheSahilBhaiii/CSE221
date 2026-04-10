import java.util.Scanner;
public class t4 {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    

    //N=number of input arrays 
    int N=sc.nextInt();
    for(int k=0;k<N;k++){
    boolean flag=true;
    //M=index of the array
    int M=sc.nextInt();
    
    int arr[]=new int[M];

    for(int i=0;i<M;i++){
        arr[i]=sc.nextInt();
    }
    for(int j=0;j<M-1;j++){
        if(arr[j]>arr[j+1]){
            flag=false;
            break;
        }
        else{
            flag=true;
        }
    }
    if(flag==false){
        System.out.println("NO");
    }
    if(flag==true){
        System.out.println("YES");
    }
}
    }
}
