import java.util.Scanner;
public class t2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<N;i++){
            String str=sc.nextLine();
            String x="";
            String y="";
            char check=' ';
            boolean flag=false;

            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='+'){
                check='+';
                }
                if(str.charAt(j)=='-'){
                check='-';
                }
                if(str.charAt(j)=='*'){
                check='*';
                }
                if(str.charAt(j)=='/'){
                check='/';
                }
            }

            for(int k=0;k<str.length();k++){
                if(str.charAt(k)==check){
                    flag=true;
                    continue;
                }
                if((int)str.charAt(k)>=48 && (int)str.charAt(k)<=57){
                    if(flag==false){
                        x+=str.charAt(k);
                    }
                    if(flag==true){
                        y+=str.charAt(k);
                    }
                }
            }
            double a=Double.parseDouble(x);
            double b=Double.parseDouble(y);
            
            if(check=='+'){
                System.out.println(a+b);
            }
            if(check=='-'){
                System.out.println(a-b);
            }
            if(check=='*'){
                System.out.println(a*b);
            }
            if(check=='/'){
                System.out.println(a/b);
            }
        }
    }
}