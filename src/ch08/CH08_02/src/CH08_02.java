package ch08.CH08_02.src;

// =============== Program Description ===============
// �������ƣ� CH08_02.java                               
// ����Ŀ�ģ�����ð������
// ===================================================
public class CH08_02 extends Object
{
	int data[]=new int[]{4,6,2,7,8,9};	//ԭʼ����

	public static void main(String args[])
	{		
		System.out.print("����ð������\nԭʼ����Ϊ��");
		CH08_02 test=new CH08_02();
		test.showdata();
		test.bubble();
	}
	
	public void showdata ()     //����ѭ����ӡ����
    {
    	int i;
    	for (i=0;i<6;i++)
    	{
    		System.out.print(data[i]+" ");
    	}
    	System.out.print("\n");
    }
    
    public void bubble ()
    {
    	int i,j,tmp,flag;    	
    	for(i=5;i>=0;i--)
    	{
    		flag=0;           //flag�����ж��Ƿ���ִ�н����Ķ���
    		for (j=0;j<i;j++)
    		{
    			if (data[j+1]<data[j])
    			{
    				tmp=data[j];
    				data[j]=data[j+1];
    				data[j+1]=tmp;
    				flag++;    //�����ִ�й���������flag��Ϊ0
    			}
    		}
    		if (flag==0)
    		{
    			break;
    		}
			
    		//��ִ����һ��ɨ����ж��Ƿ������������������û�н��������ݣ�
    		//��ʾ��ʱ������������򣬹ʿ�ֱ������ѭ��
			
			System.out.print("��"+(6-i)+"������");
			for (j=0;j<6;j++)
			{
				System.out.print(data[j]+" ");
			}
			System.out.print("\n");
		}
		
	System.out.print("�������Ϊ��");
	showdata ();
	}
}
