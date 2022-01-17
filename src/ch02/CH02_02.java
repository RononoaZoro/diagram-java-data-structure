package ch02;// =============== Program Description ===============
// �{���W�١G CH02_02.java                               
// �{���ت��G��ӯx�}�ۥ[���B��
// ===================================================

import java.io.IOException;
public    class CH02_02
{
public static void MatrixAdd(int arrA[][],int arrB[][],int arrC[][],int dimX,int dimY)
{
	int row,col;
	if(dimX<=0||dimY<=0)
	{
		System.out.println("����ά���������0");
		return;
	}
	for(row=1;row<=dimX;row++)
		{
		for(col=1;col<=dimY;col++)
			{
			arrC[(row-1)][(col-1)]=arrA[(row-1)][(col-1)]+arrB[(row-1)][(col-1)];
			}
		}
}
public static void main(String args[]) throws IOException

{
	int i;
	int j;
	final int ROWS = 3;
	final int COLS =3;
	int [][] A= {{1,3,5},
						{7,9,11},
						{13,15,17}};
	int [][] B= {{9,8,7},
						{6,5,4},
						{3,2,1}};
	int [][] C= new int[ROWS][COLS];
		System.out.println("[����A�ĸ���Ԫ��]");  //��ӡ����A������
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		System.out.print(A[i][j]+" \t");
		System.out.println();
	}
	System.out.println("����B�ĸ���Ԫ��]");	  //��ӡ����B������
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		System.out.print(B[i][j]+" \t");
		System.out.println();
	}
	MatrixAdd(A,B,C,3,3);
	System.out.println("[��ʾ����A�;���B��ӵĽ��]");	//ӡA+B������
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		System.out.print(C[i][j]+" \t");
		System.out.println();
	}
}
}