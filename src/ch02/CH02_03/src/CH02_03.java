package ch02.CH02_03.src;// =============== Program Description ===============
// �������ƣ� CH02_03.java                               
// ����Ŀ�ģ���������������˵Ľ��
// ===================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public    class CH02_03
{
public static void main(String args[]) throws IOException

{
	int M,N,P;
	int i,j;
	String strM;
	String strN;
	String strP;
	String tempstr;
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("���������A��ά��(M,N): ");
	System.out.print("�����������A��Mֵ: ");
	strM=keyin.readLine();
	M=Integer.parseInt(strM);
	System.out.print("�����������A��Nֵ: ");
	strN=keyin.readLine();
	N=Integer.parseInt(strN);
	int A[][]=new int[M][N];
	System.out.println("[���������A�ĸ���Ԫ��]");
	System.out.println("ע�⣡ÿ����һ��ֵ����Enter��ȷ������");
	for(i=0;i<M;i++)
		for(j=0;j<N;j++)
			{
			System.out.print("a"+i+j+"=");
			tempstr=keyin.readLine();
			A[i][j]=Integer.parseInt(tempstr);
			}
	System.out.println("���������B��ά��(N,P): ");
	System.out.print("�����������B��Nֵ: ");
	strN=keyin.readLine();
	N=Integer.parseInt(strN);
	System.out.print("�����������B��Pֵ: ");
	strP=keyin.readLine();
	P=Integer.parseInt(strP);
	int B[][]=new int[N][P];
	System.out.println("[���������B�ĸ���Ԫ��]");
	System.out.println("ע�⣡ÿ����һ��ֵ����Enter��ȷ������");
	for(i=0;i<N;i++)
		for(j=0;j<P;j++)
			{
			System.out.print("b"+i+j+"=");
			tempstr=keyin.readLine();
			B[i][j]=Integer.parseInt(tempstr);
			}
	int C[][]=new int[M][P];
	MatrixMultiply(A,B,C,M,N,P);
	System.out.println("[AxB�Ľ����]");
	for(i=0;i<M;i++)
	{
		for(j=0;j<P;j++)
			{
			System.out.print(C[i][j]);
			System.out.print('\t');
			}
		System.out.println();
	}
}
public static void MatrixMultiply(int arrA[][],int arrB[][],int arrC[][],int M,int N,int P)
{
	int i,j,k,Temp;
	if(M<=0||N<=0||P<=0)
	{
		System.out.println("[����:ά��M,N,P�������0]");
		return;
	}
	for(i=0;i<M;i++)
		for(j=0;j<P;j++)
		{
			Temp = 0;
			for(k=0;k<N;k++)
				Temp = Temp + arrA[i][k]*arrB[k][j];
			arrC[i][j] = Temp;
		}
}
}
