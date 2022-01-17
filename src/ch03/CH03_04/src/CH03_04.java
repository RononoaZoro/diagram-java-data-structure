package ch03.CH03_04.src;// =============== Program Description ===============
// �������ƣ� CH03_04.java                               
// ����Ŀ�ģ�����ʽ���
// ===================================================

import java.io.IOException;

class Node 
{
	int coef;
	int exp;
	Node next;
	public Node(int coef,int exp)
	{
		this.coef=coef;
		this.exp=exp;
		this.next=null;
	}
}

class PolyLinkedList 
{
	public Node first;
	public Node last;
		
	public boolean isEmpty()
	{
		return first==null;
	}	

	public void create_link(int coef,int exp)
	{
		Node newNode=new Node(coef,exp);
		if(this.isEmpty())
		{
			first=newNode;
			last=newNode;
		}
		else
		{
			last.next=newNode;
			last=newNode;
		}
	}

	public void print_link()
	{
		Node current=first;
		while(current!=null)
		{
			if(current.exp==1 && current.coef!=0) // X^1ʱ����ʾָ��
				System.out.print(current.coef+"X + ");
			else if(current.exp!=0 && current.coef!=0)
				System.out.print(current.coef+"X^"+current.exp+" + ");
			else if(current.coef!=0)             // X^0ʱ����ʾ����
				System.out.print(current.coef);
		current=current.next;
		}
		System.out.println();
	}
	
	public PolyLinkedList sum_link(PolyLinkedList b)
	{
	int sum[]=new int[10];
	int i=0,maxnumber;
	PolyLinkedList tempLinkedList=new PolyLinkedList();
	PolyLinkedList a=new PolyLinkedList();
	int tempexp[]=new int[10];
	Node ptr;
	a=this;
	ptr=b.first;
	while(a.first!=null)                      //�ж϶���ʽ1
	   {  
		b.first=ptr;                         // �ظ��Ƚ�A��B��ָ��
		while(b.first!=null)
		{  
			if(a.first.exp==b.first.exp)          //ָ����ȣ�ϵ�����
			{  
				sum[i]=a.first.coef+b.first.coef;
				tempexp[i]=a.first.exp;
				a.first=a.first.next;
				b.first=b.first.next;
				i++;
			}
			else if(b.first.exp > a.first.exp)     //Bָ���ϴ�ָ��ϵ����C
			{  
				sum[i]=b.first.coef;
				tempexp[i]=b.first.exp;
				b.first=b.first.next;
				i++;
				
			}
			else if(a.first.exp > b.first.exp)      //Aָ���ϴ�ָ��ϵ����C
			{  
			        sum[i]=a.first.coef;
				tempexp[i]=a.first.exp; 
				a.first=a.first.next;
				i++;
			}
			} // end of inner while loop
		}	// end of outer while loop
		maxnumber=i-1;
		for (int j=0;j<maxnumber+1;j++) tempLinkedList.create_link(sum[j],maxnumber-j);
		return tempLinkedList;
	} // end of sum_link
} // end of class PolyLinkedList 


public class CH03_04 
{
   public static void main(String args[]) throws IOException
   {
	PolyLinkedList a=new PolyLinkedList();
	PolyLinkedList b=new PolyLinkedList();
	PolyLinkedList c=new PolyLinkedList();
	
	int data1[]={8,54,7,0,1,3,0,4,2};         //����ʽA��ϵ��
	int data2[]={-2,6,0,0,0,5,6,8,6,9};         //����ʽB��ϵ��
	System.out.print("ԭʼ����ʽ��\nA=");

	for(int i=0;i<data1.length;i++)
		a.create_link(data1[i],data1.length-i-1); //��������ʽA��ϵ����3�ݼ�

	for(int i=0;i<data2.length;i++)
		b.create_link(data2[i],data2.length-i-1); //��������ʽB��ϵ����3�ݼ�

	a.print_link();                  //��ӡ����ʽA
	System.out.print("B=");
	b.print_link();                  //��ӡ����ʽB
	System.out.print("����ʽ��ӽ����\nC=");
	c=a.sum_link(b);                //CΪA��B����ʽ��ӽ��
	c.print_link();                  //��ӡ����ʽC
	
   }
}
