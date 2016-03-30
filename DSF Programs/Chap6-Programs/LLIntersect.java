/*Program for intersection of elements of two linked lists*/

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

Nodetype list1=null;
Nodetype list2=null;
Nodetype list=null;


void display(Nodetype  list)
{
/*display all nodes*/
	Nodetype  t;
	t=list;
	if(t==null)
		System.out.println("Linked list is empty");
	else
	{
		while(t!=null)
		{
			System.out.print("->"+t.info);
			t=t.next;
		}
	}
}/*end display*/


void addend(int x)
{
/*insert new element at the end of linked list*/
/*list will point to the list1 node and last will point to the last node*/
	Nodetype temp;
	Nodetype p=new Nodetype(x);
	temp=list;
	if(temp==null)
	    list=p;
	else
	{
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=p;
	}
}/*void insertend*/


void intersection()
{
/*find common elements */
	int in;
	int a1[]={1,3,5,7,6};
	int a2[]={3,4,6,8,7};

	System.out.println("\nFirst linked list : \nList1:");
	for(in=0;in<5;in++)
		addend(a1[in]);
	list1=list;
	display(list1);

	list=null;
	System.out.println("\nSecond linked list : \nList2:");
	for(in=0;in<5;in++)
		addend(a2[in]);
	list2=list;
	display(list2);

	list=null;

	Nodetype  i,j;
	for(i=list1;i!=null;i=i.next)
	{
		for(j=list2;j!=null;j=j.next)
		{
			if(i.info==j.info)
			{
				addend(i.info);
				break;
			}
		}
	}
	System.out.println("\nResultant linked list : \nList3:");
	display(list);
}/*end intersection*/
}


class LLIntersect
{
public static void main(String args[])
{
	Operations L =new Operations();
	L.intersection();

}/*end main*/

}


/*
First linked list :
List1:
->1->3->5->7->6
Second linked list :
List2:
->3->4->6->8->7
Resultant linked list :
List3:
->3->7->6
*/