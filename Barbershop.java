import java.io.*;
import java.lang.Math;
import java.util.*;
class Barbershop {
  
  public static void main(String[] args) {
  
   Scanner s= new Scanner(System.in);
   Random r=new Random();
  
   System.out.println("Enter the number of Customers");
   int cust=s.nextInt();
   int customer[]=new int[cust]; 
   int inter_arrival[]=new int[cust];//inter-arrival time
  
   int arrival[]=new int[cust];//arrival time
     
   int servtime[]=new int[cust]; //service time
  
   int timebeg[]=new int[cust];//time service begins
     
   int waittime[]=new int[cust]; //waiting time in queue
     
   int timeend[]=new int[cust];//time service ends
    
   int tcs[]=new int[cust];//time customer spends in system

   int idle[]=new int[cust];//idle time of server in minutes
   
   for(int i=0;i<inter_arrival.length;i++) //inter-arrival time 
   {
     inter_arrival[i]=r.nextInt(10);
   }

   for(int i=1;i<arrival.length;i++)//arrival time
   {
     arrival[0]=0;
     arrival[i]=arrival[i-1]+inter_arrival[i];
   }
  
   for(int i=0;i<servtime.length;i++)//service time
   {
     servtime[i]=r.nextInt(10);
   }  
  
  
   for(int i=1;i<timeend.length;i++)//time service ends
   {
     if(arrival[i]==0)
     {
        timeend[0]=servtime[0];
     }
     timeend[i]=servtime[i]+arrival[i];
   }
   
   for(int i=1;i<timebeg.length;i++)//time service begins
   {
     if(arrival[i]==0)
     {
       timebeg[0]=arrival[0];
     }
     else
     {
      timebeg[i]=Math.max(arrival[i],timeend[i-1]);
     }
   }
   for(int i=0;i<waittime.length;i++)//waiting time in queue
   {
     waittime[i]=timebeg[i]-arrival[i];
   }
  
  

   for(int i=0;i<tcs.length;i++)//time customer spends in system
   {
     tcs[i]=timeend[i]-arrival[i];
   }
  
   for(int i=1;i<idle.length;i++)//idle time of server in minutes
   {
     idle[0]=0;
     if(arrival[i]-timeend[i-1]>0)
     {
       idle[i]=arrival[i]-timeend[i-1];
     }
     else
     { 
       idle[i]=0;
     }
   }
  
  System.out.println("Customers" + "\t" + "Inter_Arrival" + "\t" + "Arrival" + "\t" + "Service_Time" 
  + "\t" + "Time_begins" + "\t" + "Waiting_time" + "\t" + "Time_ends" + "\t" + "Time_spends" + "\t" + 
  "Idle_time");
  int j=1;
  for(int i=0;i<cust;i++)
  {
  System.out.println(j+i + "\t \t" + inter_arrival[i] + "\t \t" + arrival[i] 
  + "\t \t" + servtime[i] + "\t \t" + timebeg[i] + "\t \t" + waittime[i] + "\t \t" + timeend[i] + "\t\t" + tcs[i] + "\t \t" + idle[i]);
  }

int sumwait=0;//total waiting time in queue
for(int i=0;i<waittime.length;i++)
{
  sumwait=sumwait+waittime[i];
}

float avgdelay=(float)sumwait/cust;//average delay in queue

int count=0;//number of customers waiting in queue
int i=0;
while(i<waittime.length)
{
  if(waittime[i]==0)
  {
    i++;
  }
  else
  {
    count++;
    i++;
  }
}
float prob=(float)count/cust;//Probability of customers waiting

int total_arrival_time=0;//total time between arrivals
for(i=0;i<arrival.length;i++)
{
  total_arrival_time=total_arrival_time+arrival[i];
}

float avgarrival=(float)total_arrival_time/cust;//average time between arrivals

int total_waiting_time=0;//total time customer waits in system
for(i=0;i<waittime.length;i++)
{
  total_waiting_time=total_waiting_time+waittime[i];
}
float avgwaiting=(float)total_waiting_time/cust;//average waiting time of those who wait

int total_spend=0;//total time customer spends in system
for(i=0;i<tcs.length;i++)
{
  total_spend=total_spend+tcs[i];
}
float avgspend=(float)total_spend/cust;//average time customer spends in system

float total_idle=0;//total idle time of server
for(i=0;i<idle.length;i++)
{
  total_idle=total_idle+idle[i];
}
float server_util=(float)total_idle/total_spend;//server utilisation
System.out.println();
System.out.println();

System.out.println("Average_Delay" + "\t" + "Prob_waiting" + "\t" + "Average_Arrivals" + "\t" + "Average_wait" + "\t" + "Average_Spends" + "\t" + "Server_Utilisation");

System.out.println(avgdelay + "\t \t \t" + prob + "\t \t" + avgarrival + "\t \t" + avgwaiting + "\t \t" + avgspend + "\t \t" + "\t" + server_util);
}

}
