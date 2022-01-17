package ch04.CH04_03.src;// =============== Program Description ===============
// �������ƣ� CH04_03.java                               
// ����Ŀ�ģ�����������ջ
// ===================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node //���ӽڵ�������i
{
	int data;
	Node next;
	public Node(int data)
	{
		this.data=data;
		this.next=null;
	}
}
class StackByLink 
{
	public Node front; //ָ���ջ�׶˵�ָ��
	public Node rear;  //ָ���ջ���˵�ָ��
   //�෽����isEmpty()
   //�ж϶�ջ���Ϊ�ն�ջ,��front==null;
	public boolean isEmpty()
	{
		return front==null;
	}
   //�෽����output_of_Stack()
   //��ӡ��ջ����
	public void output_of_Stack()
	{
		Node current=front;
		while(current!=null)
		{
		System.out.print("["+current.data+"]");
		current=current.next;
		}
		System.out.println();
	}
   //�෽����output_of_Stack()
   //�ڶ�ջ���˼�������
	public void insert(int data)
	{
		Node newNode=new Node(data);
		if(this.isEmpty())
		{
			front=newNode;
			rear=newNode;
		}
		else
		{
			rear.next=newNode;
			rear=newNode;
		}
	}
   //�෽����output_of_Stack()
   //�ڶ�ջ����ɾ������
	public void pop()
	{
		Node newNode;
		if(this.isEmpty())
		{
			System.out.print("===ĿǰΪ�ն�ջ===\n");
			return;
		}
		newNode=front;
		if(newNode==rear) 
			{
			front=null;
			rear=null;
			System.out.print("===ĿǰΪ�ն�ջ===\n");
			}
		else
		{
			while(newNode.next!=rear) 
				newNode=newNode.next;
			newNode.next=rear.next;
			rear=newNode;
		}

	}
}

class CH04_03
{
   public static void main(String args[]) throws IOException
   {
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		StackByLink stack_by_linkedlist =new StackByLink();
		int choice=0;
                while(true)
		{
			System.out.print("(0)����(1)�ڶ�ջ�м�������(2)������ջ����:");
			choice=Integer.parseInt(buf.readLine());		
			if(choice==2)
			{
				stack_by_linkedlist.pop();
				System.out.println("���ݵ�����Ķ�ջ����:");
				stack_by_linkedlist.output_of_Stack();
			}
			else if(choice==1)
			{
				System.out.print("������Ҫ�����ջ������:");
				choice=Integer.parseInt(buf.readLine());
				stack_by_linkedlist.insert(choice);
				System.out.println("���ݼ����Ķ�ջ����:");
				stack_by_linkedlist.output_of_Stack();
			}
			else if(choice==0)
				break;
			else
			{
				System.out.println("�������!!");
			}
		}
	}
}