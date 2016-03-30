/*program for circular linked list*/
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
	Nodetype p=null;
	p=list;
	if(list==null)
		System.out.println("\nThe list is empty");
	else
	{
		System.out.println();
		p=p.next;
		while(p!=list)
		{
			System.out.print("-->"+p.info);
			p=p.next;
		}
		System.out.print("-->"+p.info);
	}
}/*end display*/

void insertbeg(int x)
{
	Nodetype p=new Nodetype(x);
	p.info=x;
	if(list==null)
	{
		list=p;
		p.next=p;
	}
    else
    {
		p.next=list.next;
		list.next=p;
	}
	display();
}/*end insertbeg*/

void insertend(int x)
{
	Nodetype p=new Nodetype(x);
	p.info=x;
	if(list==null)
		p.next=p;
	else
	{
		p.next=list.next;
		list.next=p;
	}
	list=p;
	display();
}/*end insertend*/

void deletebeg()
{
	Nodetype p=null;
	if(list==null)
		System.out.println("\nThe List is empty");
    else
    {
		p=list.next;
		System.out.print("\nThe element deleted is "+p.info);
        list.next=p.next;
        if(list.next==p)
			list=null;
		display();
	}
}/*end deletebeg*/

void deleteend()
{
	Nodetype p,q;
	if(list==null)
		System.out.println("\nThe list is empty");
	else
	{
		q=list;
		p=list;
		if(p.next==p)
			list=null;
		else
		{
			while(q.next!=p)
				q=q.next;
			q.next=p.next;
			list=q;
		}
		System.out.print("\nThe element deleted is "+p.info);
		display();
	}
}/*end deleteend*/
}


class LLCircular
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
}/*end main*/
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

Insert 11,22,33,44 in the end
-->55-->11
-->55-->11-->22
-->55-->11-->22-->33
-->55-->11-->22-->33-->44

Delete 2 items from the end
The element deleted is 44
-->55-->11-->22-->33
The element deleted is 33
-->55-->11-->22


*/