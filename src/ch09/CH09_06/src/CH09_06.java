package ch09.CH09_06.src;// =============== Program Description ===============
// �������ƣ� CH09_06.java                               
// ����Ŀ�ģ�ʹ�ù�ϣ�����ٵؽ����Ͳ�������
// ===================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class Node
{
	int val;
	Node next;
	public Node(int val)
	{
		this.val=val;
		this.next=null;
	}
}

public    class CH09_06 extends Object
{
	final static int INDEXBOX=7;   //��ϣ�����Ԫ��
	final static int MAXNUM=13;       //������ݸ���
	static Node indextable[]=new Node[INDEXBOX]; //������̬����

   public static void main(String args[]) throws IOException
      {  
	int i,num;
	int index[]=new int[INDEXBOX];
	int data[]=new int[MAXNUM];
	Random rand=new Random();
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	for(i=0;i<INDEXBOX;i++)         
		indextable[i]=new Node(-1);	 //�����ϣ��
		System.out.print("ԭʼ���ݣ�\n\t");
		for(i=0;i<MAXNUM;i++)       //��ʼ����ֵ
		{
			data[i]=(Math.abs(rand.nextInt(30)))+1;
			System.out.print("["+data[i]+"]");
			if(i%8==7)
				System.out.print("\n\t");
		}
	for(i=0;i<MAXNUM;i++)
		CH09_06.creat_table(data[i]);          //������ϣ��
	System.out.println();
	while(true)
	{  
		System.out.print("�������������(1-30)������������-1��");
		num=Integer.parseInt(keyin.readLine());
		if(num==-1)
			break;
		i=CH09_06.findnum(num);
		if(i==0)
			System.out.print("#####û���ҵ� "+num+" #####\n");
		else
			System.out.print("�ҵ� "+num+"�������� "+i+" ��!\n");
	}
	System.out.print("\n��ϣ��\n");
	for(i=0;i<INDEXBOX;i++)
		CH09_06.print_data(i);                 //��ӡ��ϣ��

	System.out.print("\n");
} 
   
public static void creat_table(int val)              //������ϣ���ӳ���
{  
	Node newnode=new Node(val);
	int hash;
	hash=val%7;                       //��ϣ��������7ȡ����
	Node current=indextable[hash];
   if 
		(current.next==null)   indextable[hash].next=newnode;
   else
		while(current.next!=null)  current=current.next;
	current.next=newnode;	//���ڵ�����б�
}
public static void print_data(int val)        //��ӡ��ϣ���ӳ���
{  
	Node head;
	int i=0;
	head=indextable[val].next;  //��ʼָ��
	System.out.print("   "+val+"��\t");   //������ַ
	while(head!=null)
	{  
		System.out.print("["+head.val+"]-");
		i++;
		if(i%8==7)              //���Ƴ���
			System.out.print("\n\t");
		head=head.next;
	}
	System.out.print("\n");            //������һ��"-"����
}

public static int findnum(int num)     //��ϣ�����ӳ���
{  
	Node ptr;
	int i=0,hash;
	hash=num%7;
	ptr=indextable[hash].next;
	while(ptr!=null)
	{  
		i++;
		if(ptr.val==num)
			return i;
		else
			ptr=ptr.next;
	}
	return 0;
     }
}