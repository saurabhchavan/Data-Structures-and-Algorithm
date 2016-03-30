

class Queue
{
/*array is used to hold queue elements*/
/*two integer variables are used for front and rear pointers*/
	int items[]=new int[10];
	int front,rear;

	Queue()
	{/*create queue*/
		front=9;
		rear=9;
	}/*end createqueue*/

	int empty()
	{/*Return 1 if queue is empty and 0 otherwise*/

		return(rear==front? 1:0);
	}/*end empty*/



	void remove()
	{
	/*remove first element using front pointer and increment front*/
		if(empty()==1)
			System.out.println("Queue underflow");
		else
		{
			if(front==9)
				front=0;
			else
				front++;
			System.out.println("Removed element : "+items[front]);
		}/*end else*/
	}/*end remove*/

	void insert(int e)
	{
	/*inset new element in the end of the queue and increment rear*/
		if(rear==9)
			rear=0;
		else
			rear++;
		if(rear!=front)
		{
			System.out.println("Insert: " + e);
			items[rear]=e;
		}
		else
		{
			System.out.println("Queue overflow");
			rear--;
		}
	}/*end insert*/

	void display()
	{
	/*display all the queue elements using front and rear pointers*/
		if(empty()==1)
			System.out.println("Queue is empty");
		else
		{
			int r,f;
			r=rear;
			f=front;
			System.out.println("Queue : ");
			while(r!=f)
			{
				if(f==9)
					f=0;
				else
					f++;
				System.out.print("  "+items[f]);
			}/*end while*/
		}/*end else*/
		System.out.println();
	}/*end display*/

}



class QCircular
{
public static void main(String args[])
{

	Queue q=new Queue();
	q.front=9;q.rear=9;
		int i,j;
		System.out.println("Starting...");
		for(i=0;i<10;i++)
		{
		   	j = new Integer((int)(Math.random() * 100));
		   	q.insert(j);

		}
		q.display();

		//while(q.empty()==0)
		//{
		for(i=0;i<5;i++)
			q.remove();
		q.display();

		for(i=0;i<6;i++)
		{
		 	j = new Integer((int)(Math.random() * 100));
		 	q.insert(j);
		}
		q.display();

	System.out.println("Done ;-)");
}/*end main*/

}


/*
Starting...
Insert: 93
Insert: 55
Insert: 55
Insert: 30
Insert: 58
Insert: 14
Insert: 22
Insert: 35
Insert: 31
Queue overflow
Queue :
  93  55  55  30  58  14  22  35  31
Removed element : 93
Removed element : 55
Removed element : 55
Removed element : 30
Removed element : 58
Queue :
  14  22  35  31
Insert: 19
Insert: 66
Insert: 43
Insert: 49
Insert: 82
Queue overflow
Queue :
  14  22  35  31  19  66  43  49  82
Done :-)
*/
