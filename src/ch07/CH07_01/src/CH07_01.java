package ch07.CH07_01.src;// =============== Program Description ===============
// �������ƣ� CH07_01.java                               
// ����Ŀ�ģ�����ͼ�ξ���
// ===================================================

import java.io.IOException;
public    class CH07_01
{
public static void main(String args[]) throws IOException

   {  
	int [][] data={{1,2},{2,1},{1,5},{5,1}, //ͼ�θ��ߵ����ֵ���յ�ֵ
					{2,3},{3,2},{2,4},{4,2},
					{3,4},{4,3},{3,5},{5,3},
					{4,5},{5,4}};
	//��������arr
	int arr[][] =new int[6][6];
	int i,j,k,tmpi,tmpj;            
	
	for (i=0;i<6;i++)          //�Ѿ�������
		for (j=0;j<6;j++)
			arr[i][j]=0;
	for (i=0;i<14;i++)         //��ȡͼ������
		for (j=0;j<6;j++)      //����arr����
			for (k=0;k<6;k++)
			{  
				tmpi=data[i][0];    //tmpiΪ��ʼ����
				tmpj=data[i][1];    //tmpjΪ��ֹ����
				arr[tmpi][tmpj]=1;  //�бߵĵ�����1
			}
	System.out.print("����ͼ�ξ���\n");

	for (i=1;i<6;i++)
	{  
		for (j=1;j<6;j++)
	    System.out.print("["+arr[i][j]+"] ");   //��ӡ��������
		System.out.print("\n");
	}
   }
}
