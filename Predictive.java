import java.io.*;
	
class Predictive
{	static char[] stack=new char[10];//stack for holiding the nonterminals and terminals
	static 	int top=1;
	static String str;
	static int j=0,cnt=0,inc=0,p=0;
	static char[] arr;		
	static void push(char c)//method for adding terminals or nonterminals to stack if there is production
	{
		stack[++top]=c;
	}
	static void pop()//removing element from stack when there is production or matching the symbols
	{
		top--;

	}
static void disp()//method for displaying contents of stack
{
	for(int j=0;j<=top;j++)
	{
		System.out.print(stack[j]);
	} 	
}
 		static void in(int r)//method for showing the terminals from input string
		{	System.out.print("\t\t");
			for(int k=r;k<arr.length;k++)
			{
				System.out.print(arr[k]);
			}
		}

	public static void main(String arg[])throws IOException
	{
		DataInputStream ds=new DataInputStream(System.in);   //E'-X,t'-Y
		System.out.println("Enter the exprssion:");
		str=ds.readLine();
		String a,b;
		int o=0;
		//System.out.println(str);
		arr=str.toCharArray();//converting string to character array
		for(char c:arr)
		{ //System.out.println(c); 
		cnt++;//here cnt var is used to count total terminals in input string for later operation
		}
		stack[0]='$';//pushing onto the stack
		stack[1]='E';//pushing onto the stack
		//top=1;
		//disp();
		String ss;
	System.out.println("STACK\t\tINPUT\t\tOUTPUT");
	disp();//method call
	in(o);//method call
	System.out.println();
	
		
		//System.out.println(stack[0]+""+stack[1]);
		while(cnt!=inc)//here intially inc=0,everytime cnt will checked with inc for breaking the loop
		{	
			if(stack[top]=='E')//1
			{
				if(arr[j]=='i')
				{
				//E->TX
				pop();
				push('X');
				push('T');
				disp();
				in(j);
				a="E->TX";
				System.out.print("\t\t"+a);
				
				}
				else if(arr[j]=='+')
				{
					pop();
					disp();
					in(j);
					System.out.print("\t\tpop no trans");
				}
				else if(arr[j]=='*')
				{
					pop();
					disp();
					in(j);
					System.out.print("\t\tpop no trans");
				}
				else if(arr[j]=='(')
				{	//E->TE' E->TX
					pop();
					push('X');
					push('T');
				
					disp();
					in(j);
					a="E->TX";
					System.out.println("\t\t"+a);
				}
				else if(arr[j]==')')
				{
					pop();
					disp();
					in(j);System.out.print("\t\tpop no trans");
				}
				else if(arr[j]=='$')
				{
					pop();
					disp();
					in(j);System.out.print("\t\tpop no trans");
				}
			}//1
			else if(stack[top]=='X')//2
			{
				if(arr[j]=='i')
				{
					pop();
					disp();
					in(j);System.out.print("\t\tpop no trans");
				}
				else if(arr[j]=='+')
				{	//X->+TX
					pop();
					push('X');
					push('T');
					push('+');
					disp();
					in(j);
					a="X->+TX";
					System.out.print("\t\t"+a);
				}
				else if(arr[j]=='*')
				{
					pop();disp();
					in(j);System.out.print("\t\tpop no trans");
				}
				else if(arr[j]=='(')
				{
					pop();disp();
					in(j);System.out.print("\t\tpop no trans");
				}
				else if(arr[j]==')')
				{
					pop();disp();in(j);
					a="X->e";
					System.out.print("\t\t"+a);
				}
				else if(arr[j]=='$')
				{
					pop();disp();in(j);
					a="X->e";
					System.out.print("\t\t"+a);
				
				}
			
			

			}//2
			else if(stack[top]=='T')//3
			{
				if(arr[j]=='i')
				{	//T->FY,T'=y
					pop();
					push('Y');
					push('F');disp();in(j);
					a="T->FY";
					System.out.print("\t\t"+a);
				}
				else if(arr[j]=='+')
				{
					pop();disp();in(j);System.out.print("\t\tpop no trans");
				}
				else if(arr[j]=='*')
				{
					pop();disp();in(j);System.out.print("\t\tpop no trans");
				}
				else if(arr[j]=='(')
				{
					pop();
					push('Y');
					push('F');disp();in(j);
					a="T->FY";
					System.out.print("\t\t"+a);

				}
				else if(arr[j]==')')
				{
					pop();disp();in(j);System.out.print("\t\tpop no trans");
				}
				else if(arr[j]=='$')
				{
					pop();disp();in(j);System.out.print("\t\tpop no trans");
				}
				
			}//3
			else if(stack[top]=='Y')//4
			{
				if(arr[j]=='i')
				{
					pop();disp();in(j);System.out.print("\t\tpop no trans");
				}

				else if(arr[j]=='+')
				{pop();disp();in(j);
					a="Y->e";
					System.out.print("\t\t"+a);
				}
				else if(arr[j]=='*')
				{
					//T'->*FT'  ,Y->YF*
					pop();
					push('Y');
					push('F');
					push('*');
					disp();in(j);
					a="*FY";
					System.out.print("\t\t"+a);
				}
				else if(arr[j]=='(')
				{pop();disp();in(j);System.out.print("\t\tpop no trans");
				}
				else if(arr[j]==')')
				{pop();disp();in(j);a="Y->e";
					System.out.print("\t\t"+a);
				
				}
				else if(arr[j]=='$')
				{pop();disp();in(j);a="Y->e";
					System.out.print("\t\t"+a);
				
				}
				
		}//4
		else if(stack[top]=='F')//5
		{
			if(arr[j]=='i')
			{
				//F->i
				pop();
				push('i');
				disp();in(j);
				a="F->i";
				System.out.print("\t\t"+a);
			}
			else if(arr[j]=='+')
			{
				pop();disp();in(j);
				a="F->e";
				System.out.print("\t\t"+a);
			}
			else if(arr[j]=='*')
			{
				pop();
				disp();in(j);
				
				a="F->e";
				System.out.print("\t\t"+a);
			}
			else if(arr[j]=='(')
			{
				pop();
				//F->(E)
				push(')');
				push('E');
				push('(');
				disp();in(j);
				a="F->(E)";
				System.out.print("\t\t"+a);
			}
			else if(arr[j]==')')
			{
				pop();
				disp();
				in(j);		
				System.out.print("\t\tpop no trans");
			}
			else if(arr[j]=='$')
			{
				pop();
				disp();
				in(j);		
				System.out.print("\t\tpop no trans");
			}	
		}//5
		else if(stack[top]=='i')//6
		{
			if(arr[j]=='i')
			{
				
				pop();disp();
				j++;in(j);
				System.out.print("\t\tmatched");
			}
		}//6
		else if(stack[top]=='+')//7
		{
			if(arr[j]=='+')
			{
				
				pop();disp();
				j++;in(j);
				System.out.print("\t\tmatched");
			}
		}//7

		else if(stack[top]=='*')//8
		{
			if(arr[j]=='*')
			{
				
				pop();disp();
				j++;in(j);System.out.print("\t\tmatched");
			}
		}//8
		else if(stack[top]=='(')//9
		{
			if(arr[j]=='(')
			{
				
				pop();disp();
				j++;in(j);System.out.print("\t\tmatched");
			}
		}//9
		else if(stack[top]==')')//10
		{
			if(arr[j]==')')
			{
				
				pop();disp();
				j++;in(j);System.out.print("\t\tmatched");
			}
		}//10
		else if(stack[top]=='$')//11
		{
			if(arr[j]=='$')//254//
			{
				//System.out.println("valid");
				//pop();
				disp();
				in(j);System.out.print("\t\tmatched");
				j++;
			}
		}//11

		
		System.out.println();
		inc=j;
/*if((top==0)&&(inc==cnt))
{
	System.out.println("invalid");
	break;
}
else
{
System.out.println("valid");
}*/

		}//end of while
			
	}//end of main


}//end of class
