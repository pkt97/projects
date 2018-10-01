import java.util.*;
import java.io.*;
public class Bayesian{
  public static void main(String args[])
  {
    char ch;
    do{
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the probability that student has studied: ");
    float study=s.nextFloat();
    float not_study=1-study;
    System.out.println("Enter probability that student has passed: ");
    float pass=s.nextFloat();
    float fail=1-pass;
    System.out.println("Enter probability that student has studied and passed: ");
    float study_pass=s.nextFloat();
    float study_fail=1-study_pass;
    System.out.println("Enter probability that student has not studied but passed");
    float not_study_pass=s.nextFloat();
    float not_study_fail=1-not_study_pass;
    System.out.println();
    System.out.println("Press 1 to know the probability that student has passed given that he has studied");
    System.out.println();
    System.out.println("Press 2 to know the probability that student has failed given that he has studied");
    System.out.println();
    System.out.println("Press 3 to know the probability that student has passed given that he has not studied");
    System.out.println();
    System.out.println("Press 4 to know the probability that student has failed given that he has not studied");
    System.out.println();
    System.out.println("Enter your choice");
    int choice=s.nextInt();
    switch(choice)
    {
      case 1: 
      float pass_study=(pass*study_pass)/study;
      System.out.println("Probability is "+pass_study);
      break;
      
      case 2:
      float fail_study=(fail*study_fail)/study;
      System.out.println("Probability is "+fail_study);
      break;

      case 3:
      float pass_not_study=(pass*not_study_pass)/not_study;
      System.out.println("Probability is "+pass_not_study);
      break;

      case 4:
      float fail_not_study=(fail*not_study_fail)/not_study;
      System.out.println("Probability is "+fail_not_study);
      break;
    
      default:
      System.out.println("Enter valid choice");
      break;
    }
    System.out.println("Do you want to continue (y/n) ?");
    ch=s.next().charAt(0);
    //s.close();
  }while(ch=='y'||ch=='Y');
  }
}
