package ch08.CH08_01.src;// =============== Program Description ===============
// �������ƣ� CH08_01.java                               
// ����Ŀ�ģ���ͳð������
// ===================================================

public class CH08_01 extends Object
{
	public static void main(String args[])
	{
		int i,j,tmp;
		int data[]={6,5,9,7,2,8};	//ԭʼ����
		
		System.out.println("ð�����򷨣�");
		System.out.print("ԭʼ����Ϊ��");
		for(i=0;i<6;i++)
		{
			System.out.print(data[i]+" ");
		}
		System.out.print("\n");
		
		for (i=5;i>0;i--)		//ɨ�����
		{
			for (j=0;j<i;j++)   	//�Ƚϡ���������
			{
				// �Ƚ��������������һ���ϴ��򽻻�
				if (data[j]>data[j+1])
				{
			    	tmp=data[j];
			    	data[j]=data[j+1];
			    	data[j+1]=tmp;
			   }
		    }
		    
			//�Ѹ���ɨ���Ľ����ӡ�X
		    System.out.print("��"+(6-i)+"�������Ľ���ǣ�"); 
		    for (j=0;j<6;j++)
		    {
		    	System.out.print(data[j]+" ");
		    }		    
		    System.out.print("\n");
		}
		 
		System.out.print("�������Ϊ��");
		for (i=0;i<6;i++)
		{
		 	System.out.print(data[i]+" ");
		}
		System.out.print("\n");
	}
}
