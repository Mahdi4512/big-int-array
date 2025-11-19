import java.util.Scanner;
public class BigIntegerSumArray {
    static boolean negative=false;
    public static void main(String[] args) {
       Scanner input=new Scanner(System.in);
       while(true){
           System.out.println("\n1.sum\n2.Menha\n3.Taqsim\n4.zarb with normal method\n6.Exit \nEnter your choice:");
           int n=input.nextInt();
           input.nextLine();
           if(n==1){
               System.out.print("Enter two number:");
               String s1=input.nextLine();
               String s2=input.nextLine();
               int []result=f(s1,s2);
               print(result);
           }else if(n==2){
               System.out.println("Enter two number:");
               String s1=input.nextLine();
               String s2=input.nextLine();
               int []result=f2(s1,s2);
               printsign(result);
           } else if (n==3) {
              System.out.println("Enter two number:");
              String s=input.nextLine();
              int d=input.nextInt();
               int []result=f3(s,d);
               print(result);
           } else if (n==4) {
               System.out.println("Enter two number:");
               String s1=input.nextLine();
               String s2=input.nextLine();
               int []result=f4(s1,s2);
                print(result);
           }else if(n==5){

           }else break;
       }
    }
    static void print(int []arr){
        boolean s=false;
        for(int i=arr.length-1;i>=0;i--){
            if(!s && arr[i]==0 ){
                continue;
            }
            s=true;
            System.out.print(arr[i]);
        }
        if(!s){
            System.out.print("0");
        }

    }
    static int []f(String s1,String s2){
        int []num1=new int[s1.length()];
        int []num2=new int[s2.length()];
        int max=Math.max(s1.length(),s2.length());
        int []result=new int[max+1];
        for(int i=0;i<s1.length();i++){
            num1[i]=s1.charAt(s1.length()-1-i)-'0';
        }
        for(int i=0;i<s1.length();i++){
            num2[i]=s2.charAt(s2.length()-1-i)-'0';
        }
        int carry=0;
        for(int i=0;i<max;i++){
         int d1=(i<s1.length())?num1[i]:0;
         int d2=(i<s2.length())?num2[i]:0;
         int sum=d1+d2+carry;
         result[i]=sum%10;
         carry=sum/10;
        }
        result[max]=carry;
      return result;
    }
    static int []f2(String s1,String s2){
        negative=false;
        if(s1.length()<s2.length() || s1.length()==s2.length() && s1.compareTo(s2)<0){
            String temp=s1;
            s1=s2;
            s2=temp;
            negative=true;
        }
        int []num1=new int[s1.length()];
        int []num2=new int[s2.length()];
        int max=Math.max(s1.length(),s2.length());
        int []result=new int[max];
        for(int i=0;i<s1.length();i++){
            num1[i]=s1.charAt(s1.length()-1-i)-'0';
        }
        for(int i=0;i<s2.length();i++){
            num2[i]=s2.charAt(s2.length()-1-i)-'0';
        }
        for(int i=0;i<max;i++){
            int d1=(i<s1.length()) ? num1[i]:0;
            int d2=(i<s2.length())?num2[i]:0;
            if(d1<d2){
                int j=i+1;
                while(num1[j]==0){
                    num1[j]=9;
                    j++;
                }
                num1[j]--;
                d1+=10;
            }
            result[i]=d1-d2;
        }
        return result;
    }
    static int []f3(String s,int d){
       int []num=new int[s.length()];
       for(int i=0;i<s.length();i++){
           num[i]=s.charAt(s.length()-1-i)-'0';
       }
       int r=0;
       int []result=new int[num.length];
       for(int i=num.length-1;i>=0;i--){
           int c=r*10+num[i];
           result[i]=c/d;
           r=c%d;
       }
        return result;
    }
static void printsign(int []arr){
        if(negative){
            System.out.print("-");
        }
        print(arr);
}
//zarb
static int[]f4(String s1,String s2){
      int []num1=new int[s1.length()];
      int []num2=new int[s2.length()];
      int []result=new int[s2.length()+s1.length()];
    for(int i=0;i<s1.length();i++){
        num1[i]=s1.charAt(s1.length()-1-i)-'0';
    }
    for(int i=0;i<s2.length();i++){
        num2[i]=s2.charAt(s2.length()-1-i)-'0';
    }
    for(int i=0;i<num1.length;i++){
        for(int j=0;j<num2.length;j++){
            result[i+j]+=num1[i]*num2[j];
        }
    }
      for(int i=0;i<result.length-1;i++){
          result[i+1]+=result[i]/10;
          result[i]%=10;
      }
      return result;
}

}