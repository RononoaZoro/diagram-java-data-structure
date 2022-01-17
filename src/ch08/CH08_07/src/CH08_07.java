package ch08.CH08_07.src;// =============== Program Description ===============
// �������ƣ� CH08_07.java                               
// ����Ŀ�ģ��ѻ�����
// ===================================================

import java.io.IOException;
public  class CH08_07
{
public static void main(String args[]) throws IOException
   {
	int i,size,data[]={0,5,6,4,8,3,2,7,1};	//ԭʼ��������
	size=9;
	System.out.print("ԭʼ���飺");
	for(i=1;i<size;i++)
		System.out.print("["+data[i]+"] ");
	CH08_07.heap(data,size);			//�����ѻ���
	System.out.print("\n��������");
	for(i=1;i<size;i++)
		System.out.print("["+data[i]+"] ");
	System.out.print("\n");
   }  

public static void heap(int data[] ,int size)
{  
	int i,j,tmp;
	for(i=(size/2);i>0;i--)			    //�����ѻ����ڵ�	
		CH08_07.ad_heap(data,i,size-1);
	System.out.print("\n�ѻ����ݣ�");
	for(i=1;i<size;i++)			    //ԭʼ�ѻ�������
		System.out.print("["+data[i]+"] ");
	System.out.print("\n");
	for(i=size-2;i>0;i--)			    //�ѻ������
	{  
		tmp=data[i+1];			    //ͷβ�ڵ㽻��
		data[i+1]=data[1];
		data[1]=tmp;
		CH08_07.ad_heap(data,1,i);	            //����ʣ��ڵ�
		System.out.print("\n������̣�");
		for(j=1;j<size;j++)
			System.out.print("["+data[j]+"] ");
	}
}
public static void ad_heap(int data[],int i,int size)
   {  
        int j,tmp,post;
	j=2*i;
	tmp=data[i];
	post=0;
	while(j<=size && post==0)
	{  
		if(j<size)
		{
			if(data[j]<data[j+1])		//�ҳ����ڵ�
				j++;
		}
		if(tmp>=data[j])			//�������ϴ󣬽����ȽϹ���
			post=1;
		else
		{  
			data[j/2]=data[j];		//��������С��������Ƚ�
			j=2*j;
		}   
   }
   data[j/2]=tmp;					//ָ������Ϊ���ڵ�
   }
} 
