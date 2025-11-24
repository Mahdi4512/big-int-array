import java.util.Arrays;
import java.util.Scanner;
public class BigInteger {
    static boolean negative=false;
    public static void main(String[] args) {
       Scanner input=new Scanner(System.in);
       while(true){
           System.out.println(
                   "\n1. Addition" +
                           "\n2. Subtraction" +
                           "\n3. Division" +
                           "\n4. Multiplication (4 recursive calls)" +
                           "\n5. Multiplication (3 recursive calls)" +
                           "\n6. Exit" +
                           "\nEnter your choice:"
           );
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
               int []a=toArray(s1);
               int []b=toArray(s2);
               print(mul(a,b));
           }else if(n==5){
                System.out.print("Enter two number:");
                String s1=input.nextLine();
                String s2=input.nextLine();
                int []a=toArray(s1);
                int []b=toArray(s2);
                int []r=mul2(a,b);
                print(r);

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
static boolean isZero(int []a){
        for (int x:a){
            if(x!=0)return false;
        }
        return true;
}
static int[]even(int []a){
        if(a.length%2==0)return a;
        int []r=new int[a.length+1];
        System.arraycopy(a,0,r,0,a.length);
        return r;
}
static int[]shift(int []a,int k){
        int []r=new int[a.length+k];
        System.arraycopy(a,0,r,k,a.length);
        return r;
}
static int []toArray(String s){
        int []a=new int[s.length()];
        for(int i=0;i<s.length();i++){
            a[i]=s.charAt(s.length()-1-i)-'0';
        }
        return a;
}
static int[]mul(int []a,int []b){
        if(a.length<b.length){
            a=java.util.Arrays.copyOf(a,b.length);
        }else if(a.length>b.length){
            b=java.util.Arrays.copyOf(b,a.length);
        }
    if (isZero(a) || isZero(b)) {
        return new int[]{0};
    }
    if(a.length==1){
        int v;
        v=a[0]*b[0];
        if(v<10){
            return new int[]{v};
        }
        return new int[]{v%10,v/10};
    }
    if(a.length%2==1){
        a=even(a);
        b=even(b);
    }
    int n=a.length;
    int k=n/2;
    int []a0=java.util.Arrays.copyOfRange(a,0,k);
    int []a1=java.util.Arrays.copyOfRange(a,k,n);
    int []b0=java.util.Arrays.copyOfRange(b,0,k);
    int []b1=java.util.Arrays.copyOfRange(b,k,n);
    int []z1=mul(a0,b0);
    int []z2=mul(a0,b1);
    int []z3=mul(a1,b0);
    int []z4=mul(a1,b1);
    int []mid=add(z2,z3);
    return add(add(shift(mid,k),shift(z4,2*k)),z1);
}
static int[]add(int []a,int []b){
        int c=0;
        int max=Math.max(a.length,b.length);
        int []r=new int[max+1];
        for(int i=0;i<max;i++){
            int d1=(i<a.length)?a[i]:0;
            int d2=(i<b.length)?b[i]:0;
            int x=d1+d2+c;
            r[i]=x%10;
            c=x/10;
        }
        r[max]=c;
        return r;
}
    static int[] mul2(int[] a, int[] b){
        if (a.length < b.length)
            a = Arrays.copyOf(a, b.length);
        else if (a.length > b.length)
            b = Arrays.copyOf(b, a.length);
        boolean zeroA = true, zeroB = true;
        for (int x : a) if (x != 0) { zeroA = false; break; }
        for (int x : b) if (x != 0) { zeroB = false; break; }
        if (zeroA || zeroB) return new int[]{0};
        if (a.length == 1) {
            int v = a[0] * b[0];
            if (v < 10) return new int[]{v};
            return new int[]{v % 10, v / 10};
        }
        int n = a.length;
        if (n % 2 == 1) {
            a = Arrays.copyOf(a, n + 1);
            b = Arrays.copyOf(b, n + 1);
            n++;
        }
        int k = n / 2;
        int[] a0 = Arrays.copyOfRange(a, 0, k);
        int[] a1 = Arrays.copyOfRange(a, k, n);
        int[] b0 = Arrays.copyOfRange(b, 0, k);
        int[] b1 = Arrays.copyOfRange(b, k, n);
        int[] z0 = mul2(a0, b0);
        int[] z2 = mul2(a1, b1);
        int[] sA = add1(a0, a1);
        int[] sB = add1(b0, b1);
        int[] z1 = mul2(sA, sB);
        int[] mid = subtract(subtract(z1, z0), z2);
        int[] part1 = z0;
        int[] part2 = shift(mid, k);
        int[] part3 = shift(z2, 2 * k);
        return trim(add1(add1(part1, part2), part3));
    }
    static int[] trim(int[] a){
        int i = a.length - 1;
        while (i > 0 && a[i] == 0) i--;
        return Arrays.copyOf(a, i + 1);
    }
    static int[] add1(int[] a, int[] b){
        int max = Math.max(a.length, b.length);
        int carry = 0;
        int[] r = new int[max + 1];

        for (int i = 0; i < max; i++) {
            int d1 = (i < a.length) ? a[i] : 0;
            int d2 = (i < b.length) ? b[i] : 0;
            int x = d1 + d2 + carry;
            r[i] = x % 10;
            carry = x / 10;
        }
        r[max] = carry;
        return trim(r);
    }
    static int[] subtract(int[] a, int[] b){
        int[] r = new int[a.length];
        int borrow = 0;
        for (int i = 0; i < a.length; i++) {
            int x = a[i] - (i < b.length ? b[i] : 0) - borrow;
            if (x < 0) {
                x += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            r[i] = x;
        }
        return trim(r);
    }
}