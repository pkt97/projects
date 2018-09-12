import java.io.*;
import java.lang.Math.*;
import java.util.*;
class Runs{
public static void main(String args[])
{
for(int j=0;j<5;j++)
{
int x;
		int period=0;
		float r;
    int i;
		float sum=0;
		float density=0;
		Scanner sc=new Scanner(System.in);
		Set<Integer> rnos=new HashSet<Integer>();
		List<Float> rg=new ArrayList<Float>();
		System.out.println("Enter the seed Value (X0): ");
		int x0=sc.nextInt();
		System.out.println("Enter the value of Multiplier (a): ");
		int a=sc.nextInt();
		System.out.println("Enter the value of incrementor (c): ");
		int c=sc.nextInt();
		System.out.println("Enter the value of modulus (m): ");
		int m=sc.nextInt();
		rnos.add(x0);
		x=x0;
		do{
		x=(a*x+c)%m;
		r=(float)x/m;
		rg.add(r);
		period++;
		}
		while(rnos.add(x));
		System.out.println("Period of LCM is " + period);
		for(i=1;i<rg.size();i++){
		sum += rg.get(i)-rg.get(i-1);
		}
    System.out.println(rg.toString());
		//density=sum/period;
		//System.out.println("The Density of Numbers Generated is "+String.format("%.4f",density));
//Collections.sort(rg);
System.out.println();
/*System.out.println("The sorted list is: ");
for(i=1;i<rg.size();i++)
{
System.out.println(rg.get(i).toString());
}*/
String form=rg.getClass().getName();
float mean=0.495f;
/*for(i=0;i<period;i++)
{
if(form=="float")
{
  mean=0.495f;
}
else if(form=="int")
{
  mean=49.5f;
}
}*/
System.out.println("Mean is "+mean);
System.out.println();
int seq[]=new int[period];
for(i=0;i<period;i++)
{
  if(rg.get(i)-mean>0)
  {
      seq[i]=1;
  }
  else{
      seq[i]=0;
  }
}
System.out.println("Run sequence is: ");
//System.out.println();
for(i=0;i<period;i++)
{
  System.out.print(seq[i]);
}
int runs=0;
for(i=0;i<period-1;i++)
{
  if(seq[i]!=seq[i+1])
  {
    runs+=1;
  }
}
System.out.println();
System.out.println("Number of runs are "+runs);
int n1=0,n2=0;
for(i=0;i<period;i++)
{
  if(seq[i]==1)
  {
    n1+=1;
  }
  else{
    n2+=1;
  }
}
System.out.println("Number of values above mean: "+n1);
System.out.println("Number of values below mean: "+n2);
//int p=n1+n2;

float mu=(float)(((2*n1*n2)/period)+0.5);
float sigma=(2*n1*n2*((2*n1*n2))-period)/((period*period)*period-1);
float z0=(float)((runs-mu)/Math.sqrt(sigma));
float Zalpha=1.96f;
if(z0<Zalpha)
{
  System.out.println("Null hypothesis not rejected");
}
else
{
  System.out.println("Null hypothesis rejected");
}
}
}
  
  }
