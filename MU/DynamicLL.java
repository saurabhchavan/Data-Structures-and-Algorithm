

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
Nodetype list=null;


void display()
{
/*display all elements of linked list*/

	Nodetype temp;
	if(list==null)
		System.out.println("\nEmpty linked list");
	else
	{
		temp=list;
		//System.out.println("\n"+temp);
		System.out.println();

		while(temp!=null)
		{
			System.out.print("-->"+temp.info);
			temp=temp.next;
		}
	}
}/*end display*/



void insertbeg(int x)
{
/*insert new node at the beginning of linked list*/
	Nodetype node=new Nodetype(x);
	node.next=list;
	list=node;
	display();
}/*end insertbeg*/


void deletebeg()
{
/*delete a node from the beginning of linked list*/
	if(list==null)
		System.out.println("\nEmpty Linked List");
	else
	{
		System.out.print("\nThe element deleted is "+list.info);
		list=list.next;
	}
	display();
}/*end deletebeg*/


void insertend(int x)
{
/*insert new node at the end of linked list*/


	Nodetype node=new Nodetype(x);
	node.info=x;
	node.next=null;
	Nodetype temp;
	temp=list;
	if(temp==null)
	{
		list=node;
	}
	else
	{
		while(temp.next!=null)
			temp=temp.next;
		temp.next=node;
	}
	display();
}/*end insertend*/

void deleteend()
{
/*delete a node from the end of linked list*/
	Nodetype temp=null;
	Nodetype p=list;
	if(p==null)
		System.out.println("\nEmpty Linked List");
	else
	{
		while(p.next!=null)
		{
			temp=p;
			p=p.next;
		}
		System.out.print("\nThe element deleted is "+p.info);
		temp.next=null;
	}
	display();
}/*delete end*/


void insloc(int p,int x)
{
/*insert new node at specified location*/
	int i;
	Nodetype temp=list;
	for(i=0;i<(p-2);i++)
	{
		if(temp==null)
			break;
		temp=temp.next;

	}
	if(temp!=null)
	{
		Nodetype node=new Nodetype(x);
		node.next=temp.next;
		temp.next=node;
	}
	display();
}/*end insertloc*/

void delloc(int p)
{
/*delete a node from specified location*/
	int i;
	Nodetype temp=list;
	Nodetype t=null;
	if(p==1)
		list=list.next;
	for(i=0;i<p-1;i++)
	{
		if(temp.next==null)
		{
		System.out.print("\nThere are less than "+p+" elements in list ");
		break;
		}
		t=temp;
		temp=temp.next;
	}
	if(i==p-1)
	{
		System.out.print("\nThe element deleted is "+temp.info);
		t.next=temp.next;
	}
	display();
}/*end deleteloc*/

void search(int x)
{
/*search an element in linked list and return its location*/
	int i=1;
	Nodetype q;
	if(list==null)
		System.out.println("\nList is empty");
	else
	{
		q=list;
		do
		{
			if(q.info==x)
			{
				System.out.println("\nElement found at location "+i);
				break;
			}
			i++;
			q=q.next;
		}
		while(q!=null);
		if(q==null)
		System.out.println("\nElement not found");
	}
}/*end search*/

}


class DynamicLL
{
public static void main(String args[])
{

	Operations L =new Operations();

	System.out.print("\nInsert 55,50,40,90 in the begining ");
  	L.insertbeg(55);
	L.insertbeg(50);
	L.insertbeg(40);
	L.insertbeg(90);

	System.out.print("\n\nDelete 3 items from the beginning");
	L.deletebeg();
	L.deletebeg();
	L.deletebeg();

	System.out.print("\n\nInsert 1,2,3,4 in the end ");
	L.insertend(1);
	L.insertend(2);
	L.insertend(3);
	L.insertend(4);

	System.out.print("\n\nDelete 2 items from the end");
	L.deleteend();
	L.deleteend();

	System.out.print("\n\nInsert 100 at location 2");
	L.insloc(2,100);

	System.out.print("\n\nInsert 80 at location 4");
	L.insloc(4,80);

	System.out.print("\n\nDelete item present at location 2");
	L.delloc(2);

	System.out.print("\n\nDelete item present at location 10");
	L.delloc(10);

	System.out.print("\n\nSearch '1' in the list");
	L.search(1);

}
}


/*


Insert 55,50,40,90 in the begining
-->55
-->50-->55
-->40-->50-->55
-->90-->40-->50-->55

Delete 3 items from the beginning
The element deleted is 90
-->40-->50-->55
The element deleted is 40
-->50-->55
The element deleted is 50
-->55

Insert 1,2,3,4 in the end
-->55-->1
-->55-->1-->2
-->55-->1-->2-->3
-->55-->1-->2-->3-->4

Delete 2 items from the end
The element deleted is 4
-->55-->1-->2-->3
The element deleted is 3
-->55-->1-->2

Insert 100 at location 2
-->55-->100-->1-->2

Insert 80 at location 4
-->55-->100-->1-->80-->2

Delete item present at location 2
The element deleted is 100
-->55-->1-->80-->2

Delete item present at location 10
There are less than 10 elements in list
-->55-->1-->80-->2

Search '1' in the list
Element found at location 2
Press any key to continue . . .
*/