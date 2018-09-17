import java.io.*;
import java.util.*;

public class Main
{
  public static void main(String args[]) throws IOException
  {
    Scanner s=new Scanner(System.in);
    System.out.print("Enter the branching factor:");
		int branch=s.nextInt();
    System.out.print("Enter the height of the tree:");
    int height=s.nextInt();
    int n=0;
		int temp=0;                          

		for(int i=0;i<=height;i++)
		{
		  temp=(int)(Math.pow(branch,i));
			n+=temp;
		}

    int[] result=new int[n];

    for(int i=n-temp,c=1;i<n;i+=branch,c++)
    {
		  System.out.print("Enter the values of sub-tree "+c+" :");
			int j=0;
			for(j=i;j<i+branch;j++)
			{ 
  		 result[j]=s.nextInt();
      }
      for(;j<i+branch;j++)
      {
				if(height%2==0)
				result[j]=Integer.MAX_VALUE;
				else
				result[j]=Integer.MIN_VALUE;
      }
    }
    int ans=findmax(0,0,true,result,height,branch);
    System.out.println("Hence Solution of Min Max Algorithm is:"+ans);
   }
public static int findmax(int d,int ind,boolean isMax,int[] result,int height,int branch)
{
  if(d==height)
  {
   return result[ind];
  }
  else
  {
    int ans=0;
    if(isMax)
    ans=findmax(d+1,ind*branch+1,false,result,height,branch);
    else
		ans=findmax(d+1,ind*branch+1,true,result,height,branch);
		for(int i=2;i<=branch;i++)
    {
      if(isMax)
    ans=Math.max(ans,findmax(d+1,ind*branch+i,false,result,height,branch));
      else
     ans=Math.min(ans,findmax(d+1,ind*branch+i,true,result,height,branch));
    }
    if(ans==Integer.MAX_VALUE)
     return Integer.MIN_VALUE;
    else if(ans==Integer.MIN_VALUE)
      return Integer.MAX_VALUE;
    if(isMax)
      System.out.println("Max("+ind+")="+ans);
    else
      System.out.println("Min of Node "+ind+" = "+ans);
    return ans;
  }

}
}
