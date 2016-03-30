

class Nodetype
{
	int info,next;
	Nodetype(int i,int n)
	{
		info=i;
		next=n;
	}
}

class Operations
{

int maxnodes=10;
Nodetype node[]=new Nodetype[maxnodes];

int avail;
int list=-1;

void createlist()
{
/*link all available nodes together*/

	int i;
	avail=0;
	for(i=0;i<maxnodes-1;i++)
		node[i]=new Nodetype(0,i+1);
	node[maxnodes-1]=new Nodetype(0,-1);
}

int getnode()
{
/*obtain a node from available list and return its index */
	int p;
	if(avail==-1)
	{
		System.out.println("\nEmpty Linked List");
	}
	p=avail;
	avail=node[avail].next;
	return(p);
}/*end getnode*/

void freenode(int p)
{
/*accept index of a node and return that node to the available list*/
	node[p].next=avail;
	node[p].info=0;
	avail=p;
}/*end freenode*/


void display()
{
/*display all elements of linked list*/
	int i;
	int temp;
	if(list==-1)
		System.out.println("\nEmpty linked list");
	else
	{
		temp=list;
		//System.out.println("\n"+temp);
		System.out.println();

		while(temp!=-1)
		{
			System.out.print("-->|"+node[temp].info+"|"+node[temp].next+"|");
			temp=node[temp].next;
		}
	}
}/*end display*/



void insertbeg(int x)
{
/*insert new node at the beginning of linked list*/
	int q;
	q=getnode();
	node[q].info=x;
	node[q].next=list;
	list=q;
	display();
}/*end insertbeg*/


void deletebeg()
{
/*delete a node from the beginning of linked list*/
	int p,x;
	p=list;
	if(p==-1)
		System.out.println("\nEmpty Linked List");
	else
	{
		x=node[p].info;

		list=node[p].next;
		System.out.print("\nThe element deleted is "+x);
		freenode(p);
	}
	display();
}/*end deletebeg*/

void insertend(int x)
{
/*insert new node at the end of linked list*/
	int q,temp;
	q=getnode();
	node[q].info=x;
	node[q].next=-1;
	temp=list;
	if(temp==-1)
	{
		list=q;
	}
	else
	{
		while(node[temp].next!=-1)
			temp=node[temp].next;
		node[temp].next=q;
	}
	display();
}/*end insertend*/

void deleteend()
{
/*delete a node from the end of linked list*/
	int p,x,temp=-1;
	p=list;
	if(p==-1)
		System.out.println("\nEmpty Linked List");
	else
	{
		while(node[p].next!=-1)
		{
			temp=p;
			p=node[p].next;
		}
		x=node[p].info;
		node[temp].next=-1;
		System.out.print("\nThe element deleted is "+x);
		freenode(p);
	}
	display();
}/*delete end*/

void insloc(int p,int x)
{
/*insert new node at specified location*/
	int t,i,q,temp;
	temp=list;
	for(i=0;i<(p-2);i++)
	{
		if(temp==-1)
			break;
		temp=node[temp].next;

	}
	if(temp!=-1)
	{
		q=getnode();
		node[q].info=x;
		node[q].next=node[temp].next;
		node[temp].next=q;
	}
	display();
}/*end insertloc*/

void delloc(int p)
{
/*delete a node from specified location*/
	int t=-1,i,q,temp;
	temp=list;
	if(p==1)
		list=node[list].next;
	for(i=0;i<p-1;i++)
	{
		if(node[temp].next==-1)
		{
		System.out.print("\nThere are less than "+p+" elements in list ");
		break;
		}
		t=temp;
		temp=node[temp].next;
	}
	if(i==p-1)
	{
		System.out.print("\nThe element deleted is "+node[temp].info);
		node[t].next=node[temp].next;
		freenode(temp);
	}
	display();
}/*end deleteloc*/

void search(int x)
{
/*search an element in linked list and return its location*/
	int i=1,q,p;
	if(list==-1)
		System.out.println("\nList is empty");
	else
	{
		q=list;
		do
		{
			if(node[q].info==x)
			{
				System.out.println("\nElement found at location "+i);
				break;
			}
			i++;
			q=node[q].next;
		}
		while(q!=-1);
		if(q==-1)
		System.out.println("\nElement not found");
	}
}/*end search*/

}


class StaticLL
{
public static void main(String args[])
{

	int ch,p,info,x;
	char ans='y';
	Operations L =new Operations();
	L.createlist();
	System.out.print("\nInsert 55,50,40,90 in the begining ");
  	L.insertbeg(55);
	L.insertbeg(50);
	L.insertbeg(40);
	L.insertbeg(90);

	System.out.print("\n\nDelete 3 items from the beginning");
	L.deletebeg();
	L.deletebeg();
	L.deletebeg();

	System.out.print("\n\nInsert 67,22,11,57 in the end ");
	L.insertend(67);
	L.insertend(22);
	L.insertend(11);
	L.insertend(57);

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
-->|55|-1|
-->|50|0|-->|55|-1|
-->|40|1|-->|50|0|-->|55|-1|
-->|90|2|-->|40|1|-->|50|0|-->|55|-1|

Delete 3 items from the beginning
The element deleted is 90
-->|40|1|-->|50|0|-->|55|-1|
The element deleted is 40
-->|50|0|-->|55|-1|
The element deleted is 50
-->|55|-1|

Insert 67,22,11,57 in the end
-->|55|1|-->|67|-1|
-->|55|1|-->|67|2|-->|22|-1|
-->|55|1|-->|67|2|-->|22|3|-->|11|-1|
-->|55|1|-->|67|2|-->|22|3|-->|11|4|-->|57|-1|

Delete 2 items from the end
The element deleted is 57
-->|55|1|-->|67|2|-->|22|3|-->|11|-1|
The element deleted is 11
-->|55|1|-->|67|2|-->|22|-1|

Insert 100 at location 2
-->|55|3|-->|100|1|-->|67|2|-->|22|-1|

Insert 80 at location 4
-->|55|3|-->|100|1|-->|67|4|-->|80|2|-->|22|-1|

Delete item present at location 2
The element deleted is 100
-->|55|1|-->|67|4|-->|80|2|-->|22|-1|

Delete item present at location 10
There are less than 10 elements in list
-->|55|1|-->|67|4|-->|80|2|-->|22|-1|

Search '1' in the list
Element not found

*/