package ch08.CH08_09.src;// =============== Program Description ===============
// �������ƣ� CH08_09.java                               
// ����Ŀ�ģ�ֱ�Ӻϲ�����
//            �����ļ�����data1.txt,data2.txt��
//            �ϲ����ļ���data.txt
// ===================================================
import java.io.*;
public class CH08_09
{	
	public static void main (String args[])throws Exception 
	{
		String filep="data.txt";
		String filep1="data1.txt";
		String filep2="data2.txt";
		File fp=new File(filep);	//�������ļ� ���ļ�ָ�� fp
		File fp1=new File(filep1);	//���������ļ�1ָ�� fp1
		File fp2=new File(filep2);	//���������ļ�2ָ�� fp2
		BufferedReader pfile=new BufferedReader(new FileReader(fp)); 
		BufferedReader pfile1=new BufferedReader(new FileReader(fp1)); 		
		BufferedReader pfile2=new BufferedReader(new FileReader(fp2)); 	
		if(!fp.exists())
			System.out.print("�������ļ�ʧ��\n");
		else if(!fp1.exists())        
			System.out.print("���������ļ� 1 ʧ��\n"); //�����ļ��ɹ�ʱ��ָ��᷵��FILE�ļ�
		else if(!fp2.exists())		                 //ָ�룬����ʧ���򷵻�NULLֵ
			System.out.print("���������ļ� 2 ʧ��\n");
		else
		{  
			System.out.print("����������......\n");
	        merge(fp,fp1,fp2);
			System.out.print("���ݴ������!!\n");
		}

		System.out.print("data1.txt��������Ϊ��\n");
		char str;
		int str1;
		while (true)
		{  
			str1=pfile1.read();
			str=(char)str1;		
			if(str1==-1)
				 break;
			System.out.print("["+str+"]");	
		}
		System.out.print("\n");
		System.out.print("data2.txt��������Ϊ��\n");
		while (true)
		{  
			str1=pfile2.read();		
			str=(char)str1;		
			if(str1==-1)
				 break;
			System.out.print("["+str+"]");	
		}
		System.out.print("\n");
		System.out.print("�����data.txt��������Ϊ��\n");
		while (true)
		{  
			str1=pfile.read();		
			str=(char)str1;		
			if(str1==-1)
				 break;
			System.out.print("["+str+"]");	
		}
		System.out.print("\n");
		pfile.close();		//�ر��ļ���
		pfile1.close();
		pfile2.close();
	}
	public static void merge(File p, File p1, File p2)throws Exception 
	{  
		char str1,str2;
		int n1,n2;	//��������n1��n2�ݴ������ļ�data1��data2�ڵ�Ԫ��ֵ
		BufferedWriter pfile=new BufferedWriter(new FileWriter(p)); 
		BufferedReader pfile1=new BufferedReader(new FileReader(p1)); 		
		BufferedReader pfile2=new BufferedReader(new FileReader(p2)); 	
		n1=pfile1.read();	
		n2=pfile2.read();
		while(n1!=-1 && n2!=-1)		//�ж��Ƿ��ѵ��ļ�β
		{  
			if (n1 <= n2)
			{  
				str1=(char)n1;
				pfile.write(str1); //���n1�Ƚ�С�����n1�浽fp��
				n1=pfile1.read();  //���Ŷ���һ�� n1 ������
			}
			else
			{  
				str2=(char)n2;
				pfile.write(str2); //���n2�Ƚ�С�����n2�浽fp��
	            n2=pfile2.read();	//���Ŷ���һ�� n2������
			}
		}
		if(n2!=-1)		
		{ 
			while (true)
			{  
				if(n2==-1)
					 break;
				str2=(char)n2;
				pfile.write(str2);	
				n2=pfile2.read();		
			}
		}
		else if (n1!=-1)
		{ 
			while (true)
			{  
				if(n1==-1)
					 break;
				str1=(char)n1;
				pfile.write(str1);	
				n1=pfile1.read();		
			}
		}	 
		pfile.close();
		pfile1.close();
		pfile2.close();
	}
}
