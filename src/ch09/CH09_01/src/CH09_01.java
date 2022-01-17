package ch09.CH09_01.src;// =============== Program Description ===============
// �������ƣ� CH09_01.java                               
// ����Ŀ�ģ�˳����ҷ�
// ===================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public    class CH09_01
{
public static void main(String args[]) throws IOException
   {  
	String strM;
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	int data[] =new int[100];
	int i,j,find,val=0;
	for (i=0;i<80;i++)
		data[i]=(((int)(Math.random()*150))%150+1);
	while (val!=-1)
	{  
		find=0;
		System.out.print("������Ҽ�ֵ(1-150)������-1�뿪��");
		strM=keyin.readLine();
		val=Integer.parseInt(strM);
		for (i=0;i<80;i++)
		{  
			if(data[i]==val)
			{  
				System.out.print("�ڵ�"+(i+1)+"��λ���ҵ���ֵ ["+data[i]+"]\n");
				find++;
			}
		}
		if(find==0 && val !=-1)
			System.out.print("######û���ҵ� ["+val+"]######\n");
	}
	System.out.print("��������: \n");
	for(i=0;i<10;i++)
	{ 
		for(j=0;j<8;j++)
			System.out.print(i*8+j+1+"["+data[i*8+j]+"]  ");
		System.out.print("\n");
	}
   }
}
