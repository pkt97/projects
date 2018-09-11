import java.io.*;
import java.util.*;
public class KS{
public static void main(String args[])
{
 int i;
 float j;
  int c1=0;
    float m,c,a,x0,f1;
    float x2=0;
 float n;
 float d;
 for(int k=0;k<3;k++)
 {
 
    Scanner sc=new Scanner(System.in);
System.out.println("Enter initial value(X0): ");  
x0=sc.nextInt();
System.out.println("Enter multiplier(a): ");
a=sc.nextInt();
System.out.println("Enter incrementor(c): ");  
c=sc.nextInt();
System.out.println("Enter modulus(m): ");
m=sc.nextInt();

  float x1;
  //float r1;
  float r2[]= new float[101];
  //float N[]= new float[101];
 //float dmax1[]= new float[101];
 int period=0;
    for(i=0;i<100;i++)
    {
        x1=((a*x0)+c)%m;
  
        x0=x2+x1;
  
        r2[i]=x0/100;
        period++;
  }
  System.out.println("Period is "+period);
  System.out.println("Random numbers are: ");
  for(i=0;i<period;i++)
  {
    System.out.print(r2[i]+" ");
  }
  Arrays.sort(r2);
  System.out.println();
  System.out.println("Sorted array is: ");
  for(i=0;i<100;i++)
  {
  System.out.print(r2[i]+ " ");

   }
   System.out.println();
   d=ks(r2);
   
   if (d<(1.3581/Math.sqrt(period))) {
    System.out.println("Null hypothesis accepted");
   } else {
    System.out.println("Null hypothesis rejected");
   }
   
   
 }
}
static float ks(float num[]) 
  {
   Arrays.sort(num);
   float value[] = new float[num.length];
   float difference[] = new float[num.length];
   float n = (float) num.length;
   for (int i = 0; i < num.length; i++) {
    value[i] = ((i) / n) - num[i];
   }
   for (int i = 0; i < num.length; i++) {
    difference[i] = (num[i] - (i-1) / n);
   }
   float dplus = value[0];
   for (int i = 0; i < num.length; i++) {
    if (dplus <= value[i]) {
     dplus = value[i];
    }
   }
   
   System.out.println("D+ = " + dplus);
   float dminus = difference[0];
   for (int i = 0; i < num.length; i++) {
    if (dminus <= difference[i]) {
     dminus = difference[i];
    }
   }
   System.out.println("D- = " + dminus);
   float d;
   if (dplus > dminus) {
    d = dplus;
    System.out.println("D = " + d);
   } 
   else {
    d = dminus;
    System.out.println("D = " + d);
   }
   return d;
  
  }
  
}
