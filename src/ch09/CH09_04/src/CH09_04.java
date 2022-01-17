package ch09.CH09_04.src;// =============== Program Description ===============
// �������ƣ� CH09_04.java                               
// ����Ŀ�ģ�����̽�ⷨ
// ===================================================

import java.io.IOException;
import java.util.Random;
public    class CH09_04 extends Object
{
	final static int INDEXBOX=10;   //��ϣ�����Ԫ��
	final static int MAXNUM=7;      //������ݸ���
public static void main(String args[]) throws IOException

   {  
	int i;
	int index[]=new int[INDEXBOX];
	int data[]=new int[MAXNUM];
	Random rand=new Random();
	System.out.print("ԭʼ����ֵ��\n");
	for(i=0;i<MAXNUM;i++)       //��ʼ����ֵ
		data[i]=(Math.abs(rand.nextInt(20)))+1;
		for(i=0;i<INDEXBOX;i++)     //�����ϣ��
			index[i]=-1;
		print_data(data,MAXNUM);    //��ӡ��ʼ����
		System.out.print("��ϣ�����ݣ�\n");
		for(i=0;i<MAXNUM;i++)       //������ϣ��
		{  
			creat_table(data[i],index);
			System.out.print("  "+data[i]+" =>");  //��ӡ��һԪ�صĹ�ϣ��λ��
			print_data(index,INDEXBOX);
		}
		System.out.print("��ɹ�ϣ��\n");     
		print_data(index,INDEXBOX);  //��ӡ�����ɽ��
   }
	public static void print_data(int data[],int max)  //��ӡ�����ӳ���
   {  
		int i;
		System.out.print("\t");
		for(i=0;i<max;i++)
			System.out.print("["+data[i]+"] ");
		System.out.print("\n");
   }
	public static void creat_table(int num,int index[])  //������ϣ���ӳ���
	{  
		int tmp;
		tmp=num%INDEXBOX;    //��ϣ����=����%INDEXBOX
		while(true)
		{  
			if(index[tmp]==-1)      //������ݶ�Ӧ��λ���ǿյ�
			{  
				index[tmp]=num;     //��ֱ�Ӵ�������
				break;
			}
			else
				tmp=(tmp+1)%INDEXBOX;    //����������λ�ô��
        } 
   }
}
