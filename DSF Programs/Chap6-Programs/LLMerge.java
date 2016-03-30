/*Program  to merge two linked list */
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
	Nodetype list3=null;
	Nodetype list=null;

void display(Nodetype list)
{
/*display all elements of linked list*/
	Nodetype temp;
	if(list==null)
		System.out.println("\nEmpty linked list");
	else
	{
		temp=list;
		while(temp!=null)
		{
			System.out.print("->"+temp.info);
			temp=temp.next;
		}
	}
	System.out.println();
}/*end display*/


void addend(int x)
{
/*add new element in the end of this list*/
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

	//display(list);
}/*end addend*/



void merge()
{
/*merge two sorted linked list*/

	int i;
	int a1[]={1,3,5,7,9};
	int a2[]={2,4,6,8,10};

	System.out.println("\nFirst linked list : \nList1:");
	for(i=0;i<5;i++)
		addend(a1[i]);
	list1=list;
	display(list1);

	list=null;
	System.out.println("\nSecond linked list : \nList2:");
	for(i=0;i<5;i++)
		addend(a2[i]);
	list2=list;
	display(list2);

	list=null;
	while(list1!=null&&list2!=null)
	{
	    /*copy smaller element into resultant list*/
		if(list1.info<list2.info)
	    {
			addend(list1.info);
			list1=list1.next;
			if(list1==null)
			{
				/*if first list is exausted copy remining elements*/
				/*of second list into resultant list*/
				while(list2!=null)
				{
					addend(list2.info);
					list2=list2.next;
				}
			}
	    }
	    else
	    {
			addend(list2.info);
			list2=list2.next;
			if(list2==null)
			{
				/*if second list is exausted copy remining elements*/
				/*of first list into resultant list*/

				while(list1!=null)
				{
					addend(list1.info);
					list1=list1.next;
				}
			}
	    }
	}
	System.out.println("\nResultant linked list : \nList3:");
	list3=list;
	display(list3);
}/*end merge*/
}


class LLMerge
{
public static void main(String args[])
{
	Operations L =new Operations();
	L.merge();
}
}

/*
First linked list :
List1:
->1->3->5->7->9

Second linked list :
List2:
->2->4->6->8->10

Resultant linked list :
List3:
->1->2->3->4->5->6->7->8->9->10
*/