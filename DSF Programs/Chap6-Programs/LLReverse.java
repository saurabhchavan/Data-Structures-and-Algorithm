/*Program to reverse the linked list*/
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
	Nodetype l1=null;
	Nodetype list=null;


void display()
{
/*display all elements*/
	Nodetype  p;
	p=list;
	if(p==null)
	{
		System.out.println("\nThe list is empty:\n");
		return;
	}
	while(p!=null)
	{
		System.out.print("->"+p.info);
		p=p.next;
	}
	System.out.println("\n");
}/*end display*/

void addend(int x)
{
/*add new element in the end of this list*/
	Nodetype temp;
	Nodetype p=new Nodetype(x);

	p.info=x;
	p.next=null;
	temp=list;
	if(temp==null)
	{
	       list=p;
	}
	else
	{
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=p;
	}
}/*end addend*/

void addbeg(int x)
{
/*insert new element at the beginning of linked list*/
	Nodetype q=new Nodetype(x);

	q.info=x;
	q.next=list;
	list=q;
}/*end addbeg*/




void reverse()
{
	int x;
	int i;
	int a1[]={1,3,5,7,9};

	System.out.println("\nFirst linked list : \nList1:");
	for(i=0;i<5;i++)
			addend(a1[i]);
	l1=list;
	display();

	list=null;
	System.out.println("\nThe elements of the linked list in reverse order : ");
    while(l1!=null)
	{
		/*insert element in the beginning of second linked list*/
		addbeg(l1.info);
		l1=l1.next;
	}
	System.out.println("\nlist2");
	display();

}
}


class LLReverse
{

public static void main(String args[])
{
	Operations L =new Operations();
	L.reverse();
}
}


/*
First linked list :
List1:
->1->3->5->7->9


The elements of the linked list in reverse order :

list2
->9->7->5->3->1

*/