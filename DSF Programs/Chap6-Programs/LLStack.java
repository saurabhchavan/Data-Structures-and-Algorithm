/*program for dynamic implementation of stack using linked list*/

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
Nodetype top=null;

/*Where top is the pointer which will point to the element
at the top of the stack hence it will act as the external
pointer list.*/


void display()
{
/*display all elements of linked list*/

	Nodetype temp;
	if(top==null)
		System.out.println("\nEmpty linked list");
	else
	{
		System.out.print("Stack\n");
		temp=top;
		while(temp!=null)
		{
			System.out.println("     "+temp.info);
			temp=temp.next;
		}
	}
}


void push(int x)
{
	Nodetype node=new Nodetype(x);
	node.info=x;
	node.next=top;
	top=node;
	display();
}/*end push*/


void pop()
{


	Nodetype p=null;
	int x;
	p=top;
	if(p==null)
	{
		System.out.println("\nStack Underflow\n");
		return;
	}

	System.out.print("\n\nThe element popped is "+p.info+"\n");
	top=top.next;
	//display();
}/*end pop*/

void stacktop()
{
	if(top==null)
	{
		System.out.println("\nStack is empty\n");
		return;
	}
	System.out.println("\nThe element at the top of the stack is "+top.info+"\n");
	display();
}/*end stacktop*/
}




class LLStack
{
public static void main(String args[])
{
	Operations L =new Operations();
	int i,j;
	for(i=0;i<5;i++)
	{
		 j = new Integer((int)(Math.random() * 100));
		 System.out.println("\n\nPush: " + j);
		 L.push(j);
	}
		//L.display();
	for(i=0;i<3;i++)
	{
		L.pop();
		L.stacktop();
	}
	for(i=0;i<2;i++)
	{
		j = new Integer((int)(Math.random() * 100));
		System.out.println("\n\nPush: " + j);
		L.push(j);
	}
}/*end main*/
}



/*


Push: 73
-->73

Push: 10
-->10-->73

Push: 88
-->88-->10-->73

Push: 92
-->92-->88-->10-->73

Push: 70
-->70-->92-->88-->10-->73

The element popped is 70

The element at the top of the stack is 92

-->92-->88-->10-->73

The element popped is 92

The element at the top of the stack is 88

-->88-->10-->73

The element popped is 88

The element at the top of the stack is 10

-->10-->73

Push: 44
-->44-->10-->73

Push: 11
-->11-->44-->10-->73
*/


/*




Push: 19
Stack
     19


Push: 66
Stack
     66
     19


Push: 3
Stack
     3
     66
     19


Push: 80
Stack
     80
     3
     66
     19


Push: 80
Stack
     80
     80
     3
     66
     19


The element popped is 80

The element at the top of the stack is 80

Stack
     80
     3
     66
     19


The element popped is 80

The element at the top of the stack is 3

Stack
     3
     66
     19


The element popped is 3

The element at the top of the stack is 66

Stack
     66
     19


Push: 83
Stack
     83
     66
     19


Push: 43
Stack
     43
     83
     66
     19
*/