package ch05.CH05_01.src;// =============== Program Description ===============
// �������ƣ� CH05_01.java                               
// ����Ŀ�ģ�ʵ�ֶ������ݵĴ����ȡ��
// ===================================================


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CH05_01
{
	public static int front=-1,rear=-1,max=20;
	public static int val;
	public static char ch;
	public static int queue[]=new int[max];
	public static void main(String args[]) throws IOException
   {
	String strM;
	int M=0;
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	while(rear<max-1&& M!=3)
	{  
		System.out.print("[1]����һ����ֵ[2]ȡ��һ����ֵ[3]����: ");
		strM=keyin.readLine();
		M=Integer.parseInt(strM);
		switch(M)
		  {
			case 1:
				System.out.print("\n[��������ֵ]: ");
				strM=keyin.readLine();
				val=Integer.parseInt(strM);
				rear++;
				queue[rear]=val;
				break;
			case 2:
				if(rear>front)
				{  
					front++;
					System.out.print("\n[ȡ����ֵΪ]: ["+queue[front]+"]"+"\n");
					queue[front]=0;
				}
				else
				{  
					System.out.print("\n[�����Ѿ�����]\n");
					break;
				}
				break;
			default:
				System.out.print("\n");
				break;
		  }
	}
	if(rear==max-1) System.out.print("�����Ѿ�����]\n");
	System.out.print("\n[Ŀǰ�����е�����]:");
	if (front>=rear)
	{
		System.out.print("û��\n");
		System.out.print("[�����Ѿ�����]\n");
	}
	else
	{
		while (rear>front)
		{  
			front++;
			System.out.print("["+queue[front]+"]");
		}
		System.out.print("\n");
		}
   }

}
