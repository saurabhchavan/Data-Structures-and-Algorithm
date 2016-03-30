/*Program for dynamic implementation of sorted Doubly linked list*/
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
	Nodetype t;
	t=list;
	if(t==null)
		System.out.println("\nThe linked list is empty");
	else
	{
		System.out.print("\nList");
		while(t!=null)
		{
			System.out.print("<==>|"+t.info+"|");
			t=t.right;
		}
	}
}/*end display*/

void insert(int x)
{
	Nodetype  p=null,temp;
	temp=list;
	Nodetype q=new Nodetype(x);
	//q.info=x;
	if(temp==null)
	{
		list=q;
		q.right=temp;
		q.left=null;
		display();
	return;
	}
	while(temp!=null)
	{
		/*travel linked list till u get its correct position*/
		if(x >= temp.info)
		{
			p=temp;
			temp=temp.right;
		}
		else
			break;
	}
	if(temp!=null&&list==temp)
	{
		/*insert new node in the beginning*/
		list=q;
		q.right=temp;
		q.left=null;
		display();
		return;
	}
	/*insert in the middle*/
	q.right=p.right;
	p.right=q;
	q.left=p;
	(p.right).left=q;
	display();

}/*end insert*/
void deleten(int x)
{
	Nodetype  p=null,temp;
	temp=list;
	/*travel linked list till u get its correct position*/
	while(temp!=null)
	{
		if(x==temp.info)
			break;
		else
		{
		p=temp;
		temp=temp.right;
		}
	}
	if (temp==null)
	{
		System.out.println("\nList is empty/Element not found");
		return;
	}
	if (temp==list)
	{
		list=temp.right;
		(temp.right).left=null;

		display();
		return;
	}
	p.right=temp.right;
	(temp.right).left=p;

	display();
}

void search(int x)
{
	int i=0;
	Nodetype  p,temp;
	temp=list;
	/*travel linked list till u get its correct position*/
	while(temp!=null)
	{
		i++;
		if(x==temp.info)
		{
			System.out.println("\nElement found at position : "+i);
			break;
		}
		else
		{
		p=temp;
		temp=temp.right;
		}
	}
	if(temp==null)
	{
		System.out.println("\n list is empty/element not found");
		return;
	}

}
}

class DLLSorted
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
List<==>|50|

Insert 12
List<==>|12|<==>|50|

Insert 15
List<==>|12|<==>|15|<==>|50|

Insert 11
List<==>|11|<==>|12|<==>|15|<==>|50|

Search 50Element found at position : 4


Delete 15
List<==>|11|<==>|12|<==>|50|

Insert 100
List<==>|11|<==>|12|<==>|50|<==>|100|

Insert 70
List<==>|11|<==>|12|<==>|50|<==>|70|<==>|100|

Insert 90
List<==>|11|<==>|12|<==>|50|<==>|70|<==>|90|<==>|100|

Insert 85
List<==>|11|<==>|12|<==>|50|<==>|70|<==>|85|<==>|90|<==>|100|

Delete 50
List<==>|11|<==>|12|<==>|70|<==>|85|<==>|90|<==>|100|

Search 12
Element found at position : 2
*/