/*Binary search tree traversal using dynamic node representation*/
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
}



void create()
{
	Nodetype ptree,p,q;
	int n,number=0,i;
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

class BSTTrav
{
public static void main(String arg[])
{
	Functions f=new Functions();
	f.create();

}/*end main*/
}


/*
Enter number of nodes : 4

Enter info 4 nodes :
1
2
3
4

Inorder   :
1 2 3 4
Preorder  :
1 2 3 4
Postorder :
4 3 2 1 Press any key to continue . . .
*/