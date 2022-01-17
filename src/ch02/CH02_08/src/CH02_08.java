package ch02.CH02_08.src;// =============== Program Description ===============
// �������ƣ� CH02_08.java                               
// ����Ŀ�ģ���������ߴη���ȵĶ���ʽ��Ӻ�������
// ===================================================

import java.io.IOException;
public    class CH02_08
{
final static int ITEMS=6;
public static void main(String args[]) throws IOException
   {  
	int [] PolyA={4,3,7,0,6,2};		//��������ʽA
	int [] PolyB={4,1,5,2,0,9};		//��������ʽB
	System.out.print("����ʽA=> ");
	PrintPoly(PolyA,ITEMS);			//��ӡ����ʽA
	System.out.print("����ʽB=> ");
	PrintPoly(PolyB,ITEMS);			//��ӡ����ʽB
	System.out.print("A+B => ");
	PolySum(PolyA,PolyB);			//����ʽA+����ʽB
}
public static void PrintPoly(int Poly[],int items)
{  
	int i,MaxExp;
	MaxExp=Poly[0];
	for(i=1;i<=Poly[0]+1;i++)
	{  
		MaxExp--;
		if(Poly[i]!=0)				//�������ʽΪ0������
		{  
			if((MaxExp+1)!=0)
				System.out.print(Poly[i]+"X^"+(MaxExp+1));
			else
				System.out.print(Poly[i]);
			if(MaxExp>=0)
				System.out.print('+');      
		}
	}
	System.out.println();
}
public static void PolySum(int Poly1[],int Poly2[])
{  
	int i;
	int result[]= new int [ITEMS];
	result[0] = Poly1[0];
	for(i=1;i<=Poly1[0]+1;i++)
		result[i]=Poly1[i]+Poly2[i];		//���ݵ�ϵ�����
	PrintPoly(result,ITEMS);
   }
}
