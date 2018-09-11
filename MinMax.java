import java.io.*;
import java.util.*;

public class MinMax
{
  public static void main(String args[]) throws IOException
  {
    Scanner s=new Scanner(System.in);
    System.out.print("Enter the branching factor:");
		int br=s.nextInt();
    System.out.print("Enter the height of the tree:");
    int h=s.nextInt();
    int n=0;
		int temp=0;

			for(int i=0;i<=h;i++)
				{
					temp=(int)(Math.pow(br,i));
					n+=temp;
				}

                        int[] result=new int[n];

            for(int i=n-temp,c=1;i<n;i+=br,c++)

                {
					System.out.print("Enter the values of sub-tree "+c+" :");
					int j=0;
					for(j=i;j<i+br;j++)
	
						{ 
              
                        
						 result[j]=s.nextInt();
                        }
						
                         for(;j<i+br;j++)
                        {
							if(h%2==0)
							result[j]=Integer.MAX_VALUE;
							else
							result[j]=Integer.MIN_VALUE;
                        }
                }
                      int ans=findmax(0,0,true,result,h,br);
                      System.out.println("Hence Solution of Min Max Algorithm is:"+ans);
            }

            public static int findmax(int d,int ind,boolean isMax,int[] result,int h,int br)

            {
                        if(d==h)
                        {
                         return result[ind];
                        }
                        else
                        {
                          int ans=0;
                            if(isMax)
                                 ans=findmax(d+1,ind*br+1,false,result,h,br);
                             else
								 ans=findmax(d+1,ind*br+1,true,result,h,br);
								for(int i=2;i<=br;i++)
                                    {
                                     if(isMax)
                                           ans=Math.max(ans,findmax(d+1,ind*br+i,false,result,h,br));
                                           else
                                           ans=Math.min(ans,findmax(d+1,ind*br+i,true,result,h,br));
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
