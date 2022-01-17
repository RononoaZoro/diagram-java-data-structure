package ch05.CH05_03.src;// =============== Program Description ===============
// �������ƣ� ch05_03.java                               
// ����Ŀ�ģ�ʵ�ֻ��ζ������ݵĴ����ȡ��
// ===================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public    class CH05_03
{
public static int front=-1,rear=-1,val;
public static int queue[] =new int[5];
public static void main(String args[]) throws IOException

   {  
	String strM;
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	while(rear<5&&val!=-1)
	{  
		System.out.print("������һ��ֵ�Դ�����У�Ҫȡ��ֵ������0��(��������-1)��");
		strM=keyin.readLine();
		val=Integer.parseInt(strM);
		if(val==0)
		{  
			if(front==rear)
			{  
				System.out.print("[�����Ѿ�����]\n");
				break;
			}
			front++;
			if (front==5)
				front=0;
			System.out.print("ȡ������ֵ["+queue[front]+"]\n");
			queue[front]=0;
		}
		else if(val!=-1&&rear<5)
		{  
			if(rear+1==front||rear==4&&front<=0)
			{  
				System.out.print("[�����Ѿ�����]\n");
				break;
			}
			rear++;
			if(rear==5)
				rear=0;
			queue[rear]=val;
		}
	}
	System.out.print("\n����ʣ�����ݣ�\n");
	if (front==rear)
		System.out.print("�����ѿ�!!\n");
	else 
	{ 
		while(front!=rear)
		{  
			front++;
			if (front==5)
				front=0;
			System.out.print("["+queue[front]+"]");
			queue[front]=0;
		}
	}
	System.out.print("\n");

   }
}
