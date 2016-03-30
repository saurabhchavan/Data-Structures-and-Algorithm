import java.util.*;
public class Stack
{
	private Object a[];
	private int top=-1;
	public Stack()
	{
		a=new Object[5];
	}
	public Stack(int n)
	{
		a=new Object[n];
	}
	public void push(Object v)throws Exception
	{
		if(a.length-1==top)
		throw new Exception("Stack is full");
		else
			a[++top]=v;
	}
	Object pop()throws Exception
	{
		if(top==1)
		/*	return -1; or */ throw new Exception("Stack is full");
		else
			return a[top--];
	}
	boolean empty()
	{
		return top==-1;
	}
	Object StackTop()throws Exception
	{
		if(top==-1)
			throw new Exception("Stack is Empty");
		else
			return a[top];
	}
	public static void main(String arg[])
	{
		Stack s=new Stack();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter a no");
			int n=sc.nextInt();
		try
		{
			while(n!=0)
			{
				s.push(n%2);
				n=n/2;
			}
			//System.out.println("Stack is Empty");
			//s.push(10);
			//System.out.println("1");
			s.push(20);
			//System.out.println("2");
			Object v;
			while(!s.empty())
			{
				v=s.pop();
				System.out.println("Elements left in the stack "+v);
			}
		}
		catch (Exception e)
		{
		}
	}
}
