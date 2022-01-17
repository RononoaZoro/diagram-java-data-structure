package ch02.CH02_05.src;// =============== Program Description ===============
// �������ƣ� CH02_05.java                               
// ����Ŀ�ģ�ѹ��ϡ�����������
// ===================================================

import java.io.IOException;
public    class CH02_05
{
public static void main(String args[]) throws IOException
  {  
	final int _ROWS =8;		//��������
	final int _COLS =9;		//��������
	final int _NOTZERO =8;		//����ϡ������в�Ϊ0�ĸ���
	int i,j,tmpRW,tmpCL,tmpNZ;
	int temp=1;
	int Sparse[][]=new int[_ROWS][_COLS];	//����ϡ�����
	int Compress[][]=new int[_NOTZERO+1][3];	//����ѹ������
	for (i=0;i<_ROWS;i++)			//��ϡ����������Ԫ����Ϊ0
		for (j=0;j<_COLS;j++)
			Sparse[i][j]=0;
	tmpNZ=_NOTZERO;
	for (i=1;i<tmpNZ+1;i++)
	{
		tmpRW=(int)(Math.random()*100);
		tmpRW = (tmpRW % _ROWS);
		tmpCL=(int)(Math.random()*100);
		tmpCL = (tmpCL % _COLS);
		if(Sparse[tmpRW][tmpCL]!=0)	//����ͬһ��Ԫ���趨������ֵ�����ѹ����������0
			tmpNZ++;
		Sparse[tmpRW][tmpCL]=i; //�������ϡ������з����Ԫ��ֵ
	}
	System.out.println("[ϡ�����ĸ���Ԫ��]"); //��ӡϡ�����ĸ���Ԫ��
	for (i=0;i<_ROWS;i++)
	{  
		for (j=0;j<_COLS;j++)
			System.out.print(Sparse[i][j]+" ");
		System.out.println();
	}
	/*��ʼѹ��ϡ�����*/
	Compress[0][0] = _ROWS;
	Compress[0][1] = _COLS;
	Compress[0][2] = _NOTZERO;
	for (i=0;i<_ROWS;i++)
		for (j=0;j<_COLS;j++)
			if (Sparse[i][j] != 0)
			{  
				Compress[temp][0]=i;
				Compress[temp][1]=j;
				Compress[temp][2]=Sparse[i][j];
				temp++;
			}
System.out.println("[ϡ�����ѹ���������]"); //��ӡѹ������ĸ���Ԫ��
	for (i=0;i<_NOTZERO+1;i++)
	{  
		for (j=0;j<3;j++)
			System.out.print(Compress[i][j]+" ");
		System.out.println();
	}
   }
}
