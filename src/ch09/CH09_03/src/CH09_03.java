package ch09.CH09_03.src;// =============== Program Description ===============
// �������ƣ� CH09_03.java                               
// ����Ŀ�ģ���ֵ���ҷ�
// ===================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public    class CH09_03
{
public static void main(String args[]) throws IOException
   {  
	int i,j,val=1,num;
	int data[]=new int[50];
	String strM;
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	for (i=0;i<50;i++)
	{  
		data[i]=val;
		val+=((int)(Math.random()*100)%5+1);
		
	}
	while(true)
	{  
		num=0;
		System.out.print("��������Ҽ�ֵ(1-"+data[49]+")������-1������");
		strM=keyin.readLine();
		val=Integer.parseInt(strM);
		if(val==-1)
			break;
		num=interpolation(data,val);
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
   }
public static int interpolation(int data[],int val)
   {  
	int low,mid,high;
	low=0;
	high=49;
	int tmp;
	System.out.print("���Ҵ�����......\n");
	while(low<= high && val !=-1 )
	{  
		tmp=(int)((float)(val-data[low])*(high-low)/(data[high]-data[low]));
		mid=low+tmp; 		//��ֵ����ʽ
		if (mid>50 || mid<-1)
			return -1;
		if (val<data[low] && val<data[high])
			return -1;
		else if (val>data[low] && val>data[high])
			return-1;
		if (val==data[mid])
			return mid;
		else if (val < data[mid])
		{  
			System.out.print(val+" ����λ�� "+(low+1)+"["+data[low]+"]���м�ֵ "+(mid+1)+"["+data[mid]+"]��������\n");
				high=mid-1;	    
		}
		else if(val > data[mid])
		{  
			System.out.print(val+" �����м�ֵλ�� "+(mid+1)+"["+data[mid]+"]�� "+(high+1)+"["+data[high]+"]�����Ұ��\n");
				low=mid+1;  
		}
	}
	return -1;
   }
}
