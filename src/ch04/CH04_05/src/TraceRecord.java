package ch04.CH04_05.src;// =============== Program Description ===============
// �������ƣ� TraceRecord.java                               
// ����Ŀ�ģ���¼�����Թ�������·��
// ===================================================

class Node 
{
	int x;
	int y;
	Node next;
	public Node(int x,int y)
	{
		this.x=x;
		this.y=y;
		this.next=null;
	}
}
public class TraceRecord
{
	public Node first;
	public Node last;
	public boolean isEmpty()
	{
		return first==null;
	}
	public void insert(int x,int y)
	{
		Node newNode=new Node(x,y);
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

	public void delete()
	{
		Node newNode;
		if(this.isEmpty())
		{
			System.out.print("[�����Ѿ�����]\n");
			return;
		}
		newNode=first;
		while(newNode.next!=last) 
			newNode=newNode.next;
		newNode.next=last.next;
		last=newNode;

	}
}