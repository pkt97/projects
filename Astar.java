import java.util.Scanner;
import java.util.*;
public class Main
{
  Scanner sc=new Scanner(System.in);
  public void compute(int weight[][],int heuristic[],int source,int dest)
  {
 	PriorityQueue<Integer> pQueue=new PriorityQueue<>();
 	boolean value=true;
 	int number_of_nodes = weight[source].length - 1;
       //int distance[] = new int[number_of_nodes + 1]; 
      // int[] visited = new int[number_of_nodes + 1];
       //pQueue.add(source);
       int j, element;
       //visited[source] = 1;
       pQueue.add(source);
 		 
 	
 	while (value==true)
       {
   	   int cost=0;
              element = pQueue.remove();
              //j = element;
              System.out.print(element + "->");
              j=0;
              while (j < number_of_nodes )
              {
                int distance[] = new int[number_of_nodes ];
                  if (weight[element][j]!=0 && weight[j][element]!=0 && j!=dest)
                 {
                    //int distance[] = new int[number_of_nodes + 1];  
                    distance[j]=cost+weight[element][j]+heuristic[j];
                    int min=distance[j];
                    if(distance[j]<=min)
                    {
                      cost=cost+weight[element][j];
                      pQueue.add(j);
                    }
                  
                 }
                  else if(weight[element][j]!=0 && weight[j][element]!=0 && j==dest)
                  {
                    cost=cost+weight[element][j];
                    pQueue.add(j);
                    System.out.print(j);
                    System.out.println("\n"+ "The cost of path is "+cost);

                    value=false;
                    break;
                  }
                  j++;                         
              }
             
             
          }
 	
             

 	
   	
 	  
    
  }
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    int no_of_nodes, source, dest;
    System.out.println("Enter the number of nodes");
    no_of_nodes=sc.nextInt();
    if(no_of_nodes==0)
      System.exit(0);   
    int[][] weight=new int[no_of_nodes+1][no_of_nodes+1];
    System.out.println("Enter the weight of node");
    for(int i=0;i<no_of_nodes;i++)
      for(int j=0;j<no_of_nodes;j++)
      {
        weight[i][j]=sc.nextInt();
      }
    
    	int []heuristic =new int[no_of_nodes];
 	System.out.println("Enter the heuristic values of node");
 	for(int i=0;i<no_of_nodes;i++) 
 	{
   	heuristic[i]=sc.nextInt();
   	
 	}
 	System.out.println("Enter the source node");
 	source=sc.nextInt();
 	System.out.println("Enter the destination node");
 	dest=sc.nextInt();
    Main a=new Main();
    a.compute(weight,heuristic,source,dest);
    
  }
} 
