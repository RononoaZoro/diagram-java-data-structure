package ch09.CH09_02.src;// =============== Program Description ===============
// �������ƣ� CH09_02.java                               
// ����Ŀ�ģ����ֲ��ҷ�
// ===================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public    class CH09_02
{
public static void main(String args[]) throws IOException

   {  
	int i,j,val=1,num;
	int data[] =new int[50];
	String strM;
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	for (i=0;i<50;i++)
	{  
		data[i]=val;
		val+=((int)(Math.random()*100)%5+1);
	}
	while (true)
	{  
		num=0;
		System.out.print("��������Ҽ�ֵ(1-150)������-1������");
		strM=keyin.readLine();
		val=Integer.parseInt(strM);
		if(val==-1)
			break;
		num=bin_search(data,val);
		if(num==-1)
			System.out.print("##### û���ҵ�["+val+"] #####\n");
		else
			System.out.print("�ڵ� "+(num+1)+"��λ���ҵ� ["+data[num]+"]\n");
	}
	System.out.print("�������ݣ�\n");
	for(i=0;i<5;i++)
	{ 
		for(j=0;j<10;j++)
			System.out.print((i*10+j+1)+"-"+data[i*10+j]+" ");
		System.out.print("\n");
	}
	System.out.print("\n");
}
public static int bin_search(int data[],int val)
{  
	int low,mid,high;
	low=0;
	high=49;
	System.out.print("���Ҵ�����......\n");
	while(low <= high && val !=-1)
	{  
		mid=(low+high)/2;
		if(val<data[mid])
		{  
			System.out.print(val+" ����λ�� "+(low+1)+"["+data[low]+"]���м�ֵ "+(mid+1)+"["+data[mid]+"]��������\n");
			high=mid-1;	     
		}
		else if(val>data[mid])
		{  
			System.out.print(val+" �����м�ֵλ�� "+(mid+1)+"["+data[mid]+"]�� "+(high+1)+"["+data[high]+"]�����Ұ��\n");
			low=mid+1;   	     
		}
		else
			return mid;
	}
	return -1;
   }
}
