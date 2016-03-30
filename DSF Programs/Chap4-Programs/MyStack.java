class Stack
{
	int stk[]=new int[10];
	int top;
	Stack()
	{
		top=-1;
	}
	void push (int item)
	{
		if (top==9)
			System.out.println("Stack overflow");
		else
			stk[++top]=item;
	}/*end push*/

	boolean isempty()
	{
		if (top<0)
			return true;
		else
			return false;
	}/*end isempty*/

	int pop()
	{
		if (isempty())
		{
			System.out.println("Stack underflow");
			return 0;
		}
		else
			return (stk[top--]);
	}/*end pop*/

	void stacktop()
	{
		if(isempty())
			System.out.println("Stack underflow ");
		else
			System.out.println("Stack top is "+(stk[top]));
	}/*end stacktop*/

	void display()
	{
		System.out.println("Stack-->");
		for(int i=0;i<=top;i++)
			System.out.println(stk[i]);
	}/*end display*/
}


class MyStack
{
	public static void main(String args[])
	{
		Stack s=new Stack();

		//push some numbers onto the stack
		for(int i=1;i<=5;i++)
			s.push(i);

		s.stacktop();
		s.display();
		//pop some numbers from the stack
		for(int i=1;i<=3;i++)
			System.out.println("Popped element : "+s.pop());
		s.stacktop();
		s.display();

	}
}


/*
Stack top is 5
Stack-->
1
2
3
4
5
Popped element : 5
Popped element : 4
Popped element : 3
Stack top is 2
Stack-->
1
2
*/