/*program for dynamic implementation of queue using linked list*/
class Nodetype
{
	int info;
	Nodetype next;

	Nodetype(int i)
	{
		info=i;
		next=null;
	}
}

class Operations
{
Nodetype front=null,rear=null;

/*Where front is the pointer which will point to the front of the queue
and rear will point to rear end of the queue*/


void display()
{
/*display all elements of linked list*/

	Nodetype temp;
	if(front==null)
		System.out.println("\nEmpty linked list");
	else
	{
		System.out.print("\nfront");
		temp=front;
		while(temp!=null)
		{
			System.out.print("-->"+temp.info);
			temp=temp.next;
		}
		System.out.println("<--rear");
	}
}



void insert(int x)
{
	Nodetype node=new Nodetype(x);
	node.info=x;
	node.next=null;
	if (front==null&&rear==null)
	{
		front=node;
		rear=node;
	}
	else
	{
		rear.next=node;
		rear=node;
	}
	display();



}/*end insert*/

void remove()
{
	Nodetype p=null;
	int x;
	p=front;
	if(p==null)
	{
		System.out.println("\nUnderflow\n");
		return;
	}
	System.out.print("\nThe element removed is "+p.info);
	front=front.next;
	if(front==null)
		rear=null;
	display();
}/*end removee*/

}



class LLQueue
{
public static void main(String args[])
{
	Operations L =new Operations();
	int i,j;
	for(i=0;i<5;i++)
	{
		 j = new Integer((int)(Math.random() * 100));
		 System.out.print("\n\nInsert: " + j);
		 L.insert(j);
	}
		//L.display();
	for(i=0;i<3;i++)
		L.remove();

	for(i=0;i<2;i++)
	{
		j = new Integer((int)(Math.random() * 100));
		System.out.print("\n\nInsert: " + j);
		L.insert(j);
	}
}/*end main*/
}

/*

Insert: 32
front-->32<--rear


Insert: 72
front-->32-->72<--rear


Insert: 10
front-->32-->72-->10<--rear


Insert: 88
front-->32-->72-->10-->88<--rear


Insert: 14
front-->32-->72-->10-->88-->14<--rear

The element removed is 32
front-->72-->10-->88-->14<--rear

The element removed is 72
front-->10-->88-->14<--rear

The element removed is 10
front-->88-->14<--rear


Insert: 11
front-->88-->14-->11<--rear


Insert: 27
front-->88-->14-->11-->27<--rear
*/