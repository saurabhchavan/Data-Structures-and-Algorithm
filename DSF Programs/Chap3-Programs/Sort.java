import java.util.*;
import java.io.*;
class Sort
{
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\n\t\tMENU");
		System.out.println("select a choice from the MENU");
		system.out.println("\t\t1:Selection Sort");
		int n=sc.nextInt();
		switch(n)
		{
			case 1:
			{
    	/* Program to implement Selection Sort */
		int i,n=0;
		int increments[]={5,3,1};
 		int x[]=new int[25];
				    System.out.print("Enter how many numbers to be sorted : ");
               	    x =sc.nextInt();
                    System.out.println("Enter "+x+" numbers in any order....");
                    for(i=0;i<x;i++)
                    {
                 	System.out.print("\t\tElement x["+(i+1)+"]=");
            	        a[i] =sc.nextInt();
                    }
                selection(x,n);
          	        System.out.println("\nSorted Elements are :");
                for(i=0;i<x;i++)
                     System.out.println("\t\tElement x["+(i+1)+"]="+a[i]);
	//Selection Sort Function
	static void selection(int a[],int x)
	{
		int i,indx,j,large;
		for(i=x-1;i>0;i--)
  		{
                   	large=a[0];
                  	indx=0;

			for(j=1;j<=i;j++)
    			   if(a[j]>large)
        		   {
              			large=a[j];
              			indx=j;
         		   }/*end for...if*/
               		a[indx]=a[i];
               		a[i]=large;

			for(int v=0;v<x;v++)
                     		System.out.print("\t"+a[v]);
			System.out.println();
		}
	}
				break;
			}
		}
	}
}