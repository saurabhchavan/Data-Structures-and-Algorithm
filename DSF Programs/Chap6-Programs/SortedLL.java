/*Program for dynamic implementation of sorted linked list*/
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


void insert(int x)
{
	Nodetype p=null;
	Nodetype temp=list;
	Nodetype node=new Nodetype(x);

	if(temp==null)
	{
		list=node;
		node.next=temp;
		display();
		return;
	}
	while(temp!=null)
	/*travel linked list till u get its correct position*/
	{
		if(x >= temp.info)
		{
		p=temp;
		temp=temp.next;
		}
		else
			break;
	}
	if(temp!=null&&list==temp)
	/*insert new node in the beginning*/
	{	list=node;
		node.next=temp;
		display();
		return;
	}
	/*insert in the middle*/
	node.next=p.next;
	p.next=node;
	display();
}/*end insert*/

void deleten(int x)
{

	Nodetype p=null;
	Nodetype temp=list;
	/*travel linked list till u get its correct position*/
	while(temp!=null)
	{
		if(x==temp.info)
			break;
		else
		{
		p=temp;
		temp=temp.next;
		}
	}
	if(temp==null)
	{
		System.out.println("\n list is empty/element not found");
		return;
	}
	else
	if(temp==list)
	{
		list=temp.next;
		display();
		return;
	}
	else
	p.next=temp.next;
	display();
}
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
				System.out.print("\nElement found at location "+i);
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


class SortedLL
{

public static void main(String args[])
{
	Operations L =new Operations();
	System.out.print("\n\nInsert 50");
	L.insert(50);
	System.out.print("\n\nInsert 12");
	L.insert(12);
	System.out.print("\n\nInsert 15");
	L.insert(15);
	System.out.print("\n\nInsert 11");
	L.insert(11);
	System.out.print("\n\nSearch 50");
	L.search(50);
	System.out.print("\n\nDelete 15");
	L.deleten(15);
	System.out.print("\n\nInsert 100");
	L.insert(100);
	System.out.print("\n\nInsert 70");
	L.insert(70);
	System.out.print("\n\nInsert 90");
	L.insert(90);
	System.out.print("\n\nInsert 85");
	L.insert(85);
	System.out.print("\n\nDelete 50");
	L.deleten(50);
	System.out.print("\n\nSearch 12");
	L.search(12);

}/*end main*/
}


/*

Insert 50
-->50

Insert 12
-->12-->50

Insert 15
-->12-->15-->50

Insert 11
-->11-->12-->15-->50

Search 50
Element found at location 4

Delete 15
-->11-->12-->50

Insert 100
-->11-->12-->50-->100

Insert 70
-->11-->12-->50-->70-->100

Insert 90
-->11-->12-->50-->70-->90-->100

Insert 85
-->11-->12-->50-->70-->85-->90-->100

Delete 50
-->11-->12-->70-->85-->90-->100

Search 12
Element found at location 2
*/