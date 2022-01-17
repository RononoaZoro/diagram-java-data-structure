package ch06.CH06_01.src;// =============== Program Description ===============
// �������ƣ� CH06_01.java                               
// ����Ŀ�ģ�����������
// ===================================================

import java.io.IOException;
public    class CH06_01
{
public static void main(String args[]) throws IOException

   {  
	int i,level;
	int data[]={6,3,5,9,7,8,4,2}; /*ԭʼ����*/
	int btree[]=new int[16];
	for(i=0;i<16;i++) btree[i]=0;
	System.out.print("ԭʼ��������: \n");
	for(i=0;i<8;i++)
	System.out.print("["+data[i]+"] ");
	System.out.println();
	for(i=0;i<8;i++)                    /*��ԭʼ�����е�ֵ��һ�Ա�*/
	{  
		for(level=1;btree[level]!=0;)   /*�Ƚ������������ڵ�ֵ*/
		{  
			if(data[i]>btree[level])    /*��������ڵ�ֵ���������������������Ƚ�*/
				level=level*2+1;
			else                        /*��������ڵ�ֵС�ڻ���������������������Ƚ�*/
				level=level*2;
		}                               /*��������ڵ��ֵ��Ϊ0�������������ڵ�ֵ�Ƚ�һ��*/
		btree[level]=data[i];           /*������ֵ���������*/
	}
	System.out.print("���������ݣ�\n");
	for (i=1;i<16;i++)
		System.out.print("["+btree[i]+"] ");
	System.out.print("\n");
	
   }	
}
