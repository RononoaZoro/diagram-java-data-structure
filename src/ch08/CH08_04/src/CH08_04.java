package ch08.CH08_04.src;// =============== Program Description ===============
// �������ƣ� CH08_04.java                               
// ����Ŀ�ģ���������
// ===================================================

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CH08_04 extends Object
{
	int data[]=new int[6];
	int size=6;
	
	public static void main(String args[])
	{
		CH08_04 test=new CH08_04();
		test.inputarr();
		System.out.print("�������ԭʼ�����ǣ�");		
		test.showdata();
		test.insert();
	}

	void inputarr()
	{
		int i;
		for (i=0;i<size;i++)      //����ѭ�������������ݮ�
		{
			try{
				System.out.print("�������"+(i+1)+"��Ԫ�أ�");
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				data[i]=Integer.parseInt(br.readLine());
			}catch(Exception e){}
		}
	}
	
	void showdata()
	{  
		int i;
		for (i=0;i<size;i++)
		{
			System.out.print(data[i]+" ");   //��ӡ��������
		}
		System.out.print("\n");
	}
	
	void insert()
	{  
		int i;     //iΪɨ�����
		int j;     //��j����λ�Ƚϵ�Ԫ��
		int tmp;   //tmp�����ݴ�����
		for (i=1;i<size;i++)  //ɨ��ѭ������ΪSIZE-1
		{  
			tmp=data[i];
			j=i-1;
			while (j>=0 && tmp<data[j])  //����ڶ�Ԫ��С�ڵ�һԪ��
			{							
			  data[j+1]=data[j]; //�Ͱ�����Ԫ��������һ��λ��
			  j--;
			}
			data[j+1]=tmp;       //��С��Ԫ�طŵ���һ��Ԫ��

			System.out.print("��"+i+"�����ˡG");
			showdata();
		}
	}
	
}
