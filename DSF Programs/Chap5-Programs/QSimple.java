/*program for Queue implementation*/


class Queue
{
/*array is used to hold queue elements*/
/*two integer variables are used for front and rear pointers*/
	int items[]=new int[10];
	int front,rear;

	Queue()
	{/*create queue*/
		front=0;
		rear=-1;
	}/*end createqueue*/

	void insert(int e)
	{/*if queue is not full insert new element at rear end of queue*/
		if(rear==9)
			System.out.println("Queue overflow");
		else
		{

			items[++rear]=e;
		}
	}/*end insert*/


	int empty()
	{/*Return 1 if queue is empty and 0 otherwise*/

		return(rear<front? 1:0);
	}/*end empty*/

	void remove()
	{/*if queue is not empty remove one element from front */
		if(empty()==1)
			System.out.println("Queue Underflow");
		else
			System.out.println("Removed element : "+items[front++]);
		/*end else*/
	}/*end rem*/

	void display()
	{/*Display all elements from front to rear end of queue*/
		if(empty()==0)
		{
			System.out.println("Queue : ");
			int t=front;
			while(t<=rear)
				System.out.print(" "+items[t++]);
			System.out.println();

		}
	}/*end display*/

}


class QSimple
{
public static void main(String args[])
{
	Queue q=new Queue();
	int i,j;
	System.out.println("Starting...");
	for(i=0;i<=10;i++)
	{
	   	j = new Integer((int)(Math.random() * 100));
	   	System.out.println("Insert: " + j);
	   	q.insert(j);
	}
	q.display();
	while(q.empty()==0)
	{
	     q.remove();
	}
	q.remove();
	System.out.println("Done ;-)");
}/*end main*/
}


/*
starting...
Insert: 27
Insert: 69
Insert: 77
Insert: 26
Insert: 96
Insert: 57
Insert: 88
Insert: 23
Insert: 47
Insert: 94
Insert: 68
Queue overflow
Queue :
 27 69 77 26 96 57 88 23 47 94
Removed element : 27
Removed element : 69
Removed element : 77
Removed element : 26
Removed element : 96
Removed element : 57
Removed element : 88
Removed element : 23
Removed element : 47
Removed element : 94
Queue Underflow
Done ;-)
Press any key to continue . . .*/