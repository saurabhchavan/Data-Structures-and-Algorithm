/*Program to implement Doubly Linked List*/


class Nodetype
{
	int info;
	Nodetype right,left;
	Nodetype(int i)
	{
		info=i;
		right=null;
		left=null;
	}
}


class Operations
{
Nodetype list=null;



void display()
{
/*display all nodes*/
	Nodetype p;
	p=list;
	if(p==null)
		System.out.println("\nThe linked list is empty");
	else
	{
		System.out.print("\nList");
		while(p!=null)
		{
			System.out.print("<==>|"+p.info+"|");
			p=p.right;
		}
	}
}/*end display*/

void insertbeg(int x)
{
/*insert new element in the beginning of linked list*/
	Nodetype q=new Nodetype(x);
	q.info=x;
	q.right=list;
	list=q;
	display();
}/*end insertbeg*/

void deletebeg()
{
/*delete a node from the beginning of the linked list*/
	int x;
	Nodetype q;
	q=list;
	if(list==null)
		System.out.println("\nThe linked list is empty");
	else
	{
		x=q.info;
		list=q.right;
		(q.right).left=null;
		System.out.println("\n\nThe deleted element is "+x);
		display();
	}
}/*end deletebeg*/

void insertend(int x)
{
/*insert new element at the end of linked list*/
	Nodetype temp;
	Nodetype q=new Nodetype(x);
	q.info=x;
	q.right=null;
	temp=list;
	if(list==null)
	{
		list=q;
		q.left=null;
	}
	else
	{
		while(temp.right!=null)
			temp=temp.right;
		temp.right=q;
		q.left=temp;
	}
	display();
}/*end insertend*/

void deleteend()
{
/*delete a node from the end of the linked list*/
	Nodetype q,temp=null;
	int x;
	q=list;
	if(list==null)
		System.out.println("\nThe linked list is empty");
	else
	{
		if(list.right==null)
			list=null;
		else
		{
			while(q.right!=null)
			{
				temp=q;
				q=q.right;
			}
		temp.right=null;
		}
	System.out.println("\n\nThe deleted element is "+q.info);
	}
	display();
}/*end deleteend
*/
void insright(int x,int nx)
{
/*insert new element towards right of a  specific node*/
	Nodetype r,p;
	p=list;
	do
	{
		if(p.info==x)          /*node found*/
			break;
		else
			p=p.right;

	}while(p!=null);
	if(p==null)
	{
		System.out.println("\nElement not found");
		return;
	}
	Nodetype q=new Nodetype(x);
	q.info=nx;
	r=p.right;
	if(r!=null)
		r.left=q;
	q.right=r;
	q.left=p;
	p.right=q;

	display();
}/*end insright*/

void delright(int x)
{
/*delete a node which is towards right of a node*/
	Nodetype q,p;
	p=list;
	do
	{
		if(p.info==x) /*node found*/
			break;
		else
			p=p.right;

	}while(p!=null);
	if(p==null)
	{
		System.out.println("\nElement not found");
		return;
	}
	if(p.right==null)
	{
		System.out.println("\nThere is no right node");
		return;
	}
	q=p.right;
	System.out.println("\n\nThe deleted element is "+q.info);
	p.right=q.right;
	if(q.right!=null)
		(q.right).left=p;
	display();
}/*end delafter*/

void insleft(int x,int nx)
{
/*insert new node towards left of a specific node*/
	Nodetype l,p;

	p=list;
	do
	{
		if(p.info==x)
			break;
		else
			p=p.right;

	}while(p!=null);
	if(p==null)
	{
		System.out.println("\nElement not found");
		return;
	}
	Nodetype q=new Nodetype(x);
	q.info=nx;
	l=p.left;
	if(l!=null)
		l.right=q;
	q.right=p;
	q.left=l;
	p.left=q;
	if(p==list)
		list=q;
	display();

}/*end insloc*/

void delleft(int x)
{
/*delete a node which is towards left of a specific node*/
	Nodetype l,q,p;
	p=list;
	do
	{
		if(p.info==x)
			break;
		else
			p=p.right;
	}while(p!=null);
	if(p==null)
	{
		System.out.println("\nElement not found");
		return;
	}
	if(p.left==null)
	{
		System.out.println("\nThere is no left node");
		return;
	}
	q=p.left;
	if(q==list)
		list=p;
	System.out.println("\n\nThe deleted element is "+q.info);
	p.left=q.left;
	l=q.left;
	if(l!=null)
		(q.left).right=p;

	display();

}/*end delloc*/
}

class LLDoubly
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

	System.out.print("\n\nInsert 11,22,33,44 in the end ");
	L.insertend(11);
	L.insertend(22);
	L.insertend(33);
	L.insertend(44);

	System.out.print("\n\nDelete 2 items from the end");
	L.deleteend();
	L.deleteend();

	System.out.print("\n\nInsert 100 to right of 11");
	L.insright(11,100);

	System.out.print("\n\nInsert 80 to left of 44");
	L.insleft(44,80);

	System.out.print("\n\nInsert 81 to left of 55");
	L.insleft(55,81);

	System.out.print("\n\nDelete item right of 100");
	L.delright(100);

	System.out.print("\n\nDelete item left of 22");
	L.delleft(2);

	System.out.print("\n\nDelete item left of 11");
	L.delleft(11);

}/*end main*/
}


/*
Insert 55,50,40,90 in the begining
List<==>|55|
List<==>|50|<==>|55|
List<==>|40|<==>|50|<==>|55|
List<==>|90|<==>|40|<==>|50|<==>|55|

Delete 3 items from the beginning

The deleted element is 90

List<==>|40|<==>|50|<==>|55|

The deleted element is 40

List<==>|50|<==>|55|

The deleted element is 50

List<==>|55|

Insert 11,22,33,44 in the end
List<==>|55|<==>|11|
List<==>|55|<==>|11|<==>|22|
List<==>|55|<==>|11|<==>|22|<==>|33|
List<==>|55|<==>|11|<==>|22|<==>|33|<==>|44|

Delete 2 items from the end

The deleted element is 44

List<==>|55|<==>|11|<==>|22|<==>|33|

The deleted element is 33

List<==>|55|<==>|11|<==>|22|

Insert 100 to right of 11
List<==>|55|<==>|11|<==>|100|<==>|22|

Insert 80 to left of 44
Element not found


Insert 81 to left of 55
List<==>|81|<==>|55|<==>|11|<==>|100|<==>|22|

Delete item right of 100

The deleted element is 22

List<==>|81|<==>|55|<==>|11|<==>|100|

Delete item left of 22
Element not found


Delete item left of 11

The deleted element is 55

List<==>|81|<==>|11|<==>|100|*/