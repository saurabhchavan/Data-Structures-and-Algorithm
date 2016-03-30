/*Binary search tree - Ascending priority queue*/
import java.io.*;
import java.util.*;

class Nodetype
{
	 int info;
	 Nodetype left;
	 Nodetype right;
	 Nodetype(int i)
	 {
		info=i;
		left=null;
		right=null;
	 }
}

class Functions
{


Nodetype maketree(int x)
{
	Nodetype node=new Nodetype(x);
	return(node);
}/*end maketree*/

void setleft(Nodetype p,int x)
{
	if(p==null)
		System.out.println("\nInvalid insertion");
	else
		if(p.left!=null)
			System.out.println("\nInvalid insertion");
		else p.left=maketree(x);
}/*end setleft*/

void setright(Nodetype p,int x)
{
	if(p==null)
		System.out.println("\nInvalid insertion");
	else
		if(p.right!=null)
			System.out.println("\nInvalid insertion");
		else
			p.right=maketree(x);
}/*end setright*/

void intrav(Nodetype ptree)
{
	if(ptree!=null)
	{
		intrav(ptree.left);
		System.out.print(ptree.info+" ");
		intrav(ptree.right);
	}
}/*end intrav*/

void pretrav(Nodetype ptree)
{
	if(ptree!=null)
	{
		System.out.print(ptree.info+" ");
		pretrav(ptree.left);
		pretrav(ptree.right);
	}
}/*end pretrav*/

void posttrav(Nodetype ptree)
{
	if(ptree!=null)
	{
	posttrav(ptree.left);
	posttrav(ptree.right);
	System.out.print(ptree.info+" ");
	}
}/*end posttrav*/


void pqdelete(Nodetype   ptree)
{
	Nodetype q=null,p=ptree,t=ptree;
	int ans;
	do
	{
		if(t==null)
		{
			System.out.println("\nTree is empty");
			return;
		}
		while(ptree!=null)
		{
			q=p;
			p=ptree;
			ptree=ptree.left;
		}
		System.out.println("Deleted Element : "+p.info);
		if(p==t)
			t=t.right;
		else
			q.left=p.right;
		ptree=t;
		System.out.println("\nDo u want to delete an element(1/0) : ");
		ans=getNumber();
	}while(ans==1);
}/*end pqdelete*/


void create()
{
	Nodetype ptree,p,q=null;
	int n,number=0,i,ans;
	System.out.print("\nEnter number of nodes : ");
	n=getNumber();
	System.out.println("\nEnter info "+n+" nodes :");
	number=getNumber();
	ptree=maketree(number);
	for(i=1;i<n;i++)
	{
		number=getNumber();
		p=q=ptree;
		while(q!=null&&number!=p.info)
		{
			p=q;
			if(number<p.info)
				  q=p.left;
			else
				  q=p.right;
		}
		if(number==p.info)
			System.out.println("Sorry !....."+number+"is a duplicate\n");
		else
		if(number<p.info)
			setleft(p,number);
		else
			setright(p,number);
	}
	System.out.println("\nInorder   : ");
	intrav(ptree);
	System.out.println("\nPreorder  : ");
	pretrav(ptree);
	System.out.println("\nPostorder : ");
	posttrav(ptree);
	System.out.println("\nDo u want to delete an element(1/0) : ");
	ans=getNumber();
	if (ans==1)
		pqdelete(ptree);

}

int getNumber()
{
	 String str;
	 int ne=0;
	 InputStreamReader input=new InputStreamReader(System.in);
	 BufferedReader in=new BufferedReader(input);
	 try
	 {
		 str=in.readLine();
		 ne=Integer.parseInt(str);
	 }
	 catch(Exception e)
	 {
		System.out.println("I/O Error");
	 }
	 return ne;
}


}

class BSTApq
{
public static void main(String arg[])
{
	Functions f=new Functions();
	f.create();

}/*end main*/
}


/*
Enter number of nodes : 6

Enter info 6 nodes :
50
20
70
10
75
85

Inorder   :
10 20 50 70 75 85
Preorder  :
50 20 10 70 75 85
Postorder :
10 20 85 75 70 50
Do u want to delete an element(1/0) :
1
Deleted Element : 10

Do u want to delete an element(1/0) :
1
Deleted Element : 20

Do u want to delete an element(1/0) :
1
Deleted Element : 50

Do u want to delete an element(1/0) :
1
Deleted Element : 70

Do u want to delete an element(1/0) :
1
Deleted Element : 75

Do u want to delete an element(1/0) :
1
Deleted Element : 85

Do u want to delete an element(1/0) :
1

Tree is empty

*/