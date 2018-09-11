import java.util.*;
import java.lang.*;
import java.io.*;
class LCG {
  public static void main(String[] args) {
    int x;
		int period=0;
		float r;
    int i;
		float sum=0;
		float density=0;
		Scanner sc=new Scanner(System.in);
		Set<Integer> rnos=new HashSet<Integer>();
		List<Float> rg=new ArrayList<Float>();
		System.out.println("Enter the seed Value");
		int x0=sc.nextInt();
		System.out.println("Enter the value of Multiplier");
		int a=sc.nextInt();
		System.out.println("Enter the value of incrementor");
		int c=sc.nextInt();
		System.out.println("Enter the value of modulus");
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
		density=sum/period;
		System.out.println("The Density of Numbers Generated is "+String.format("%.4f",density));
  }
}
