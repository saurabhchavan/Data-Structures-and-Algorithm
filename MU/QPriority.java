/* Program To implement priority queue using arrays*/

import java.io.*;
import java.io.DataInputStream;
class Queue
{
/*array is used to hold queue elements*/
/*two integer variables are used for front and rear pointers*/
	int items[]=new int[10];
	int front,rear;

	Queue()
	{/*create queue*/
		front=1;
		rear=0;
	}/*end createqueue*/

	int empty()
	{
		if((front==1)&&(rear==0) ||(front>rear))
			return 1;
		else
			return 0;


	}

	void display( )
	{
	/* function to display queue elements */
		int i=front;
		if(empty()==1)
			System.out.println("Q is empty ");
		else
		{
			System.out.print("Front-->");
			while(i<=rear)
			{
				System.out.print("  "+items[i]);
				i++;
			}
			System.out.println("<--Rear");
		}
	}


	void add(int x)
	 {
	/*function to add new element*/
		System.out.println("\nInsert: " + x);
		if(rear==9)
			System.out.println("Queue is FUll");
		else
		{
			rear++;

			items[rear]=x;
			display();
		}

	}



	void delet( )
	{
	/* Function to delete the largest number */
		int large,i,j,k;
		if(empty()==1)
			System.out.println("Q is empty ");
		else
		{
			i=front+1;
			large=items[front];
			k=front;
			while(i<=rear)
			{
				if (items[i]>large)
				{
					 large=items[i];
					 k=i;
				}
				i++;
			}
			System.out.println("\nNumber being deleted is : "+items[k]);
			if(k==front)/*if first element is deleted increment front pointer*/
				front++;
			else
			{
			/*if middle element or last element is deleted decrement rear pointer*/
			/*after coping all elements forward*/
			for(i=k;i<rear;i++)
				items[i]=items[i+1];
			rear--;
			}
		display();
		}
	}

}


class QPriority
{
public static void main(String args[])
{
	Queue q=new Queue();
	int i,j;
	System.out.println("Starting...");
	for(i=0;i<10;i++)
	{
	   	j = new Integer((int)(Math.random() * 100));
	   	q.add(j);
	}

	while(q.empty()==0)
	{
	     q.delet();
	}
	System.out.println("Done ;-)");
}
}