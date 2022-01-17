package ch04.CH04_07.src;// =============== Program Description ===============
// �������ƣ� CH04_07.java                               
// ����Ŀ�ģ�����ѧ���ʽ�������ʾ��תΪ�����ʾ��
// ===================================================

import java.io.DataInputStream;
import java.io.IOException;
//����ת����������
class CH04_07 
{
	static int MAX=50;
	static char[] infix_q = new char[MAX];
	//���캯��
	CH04_07 () 
	{
		int i=0;

		for (i=0; i<MAX; i++)
			infix_q[i]='\0';
	}    
	 // ���������Ȩ�ıȽϣ������������С�ڶ�ջ����������򷵻�ֵΪ1������Ϊ0
	public static int compare(char stack_o, char infix_o)
	{
		// �������ʾ�����м��ݴ��ջ�У�����������ȼ���������ȨֵΪINDEX/2
		char[] infix_priority = new char[9] ; 
		char[] stack_priority = new char[8] ;
		int index_s=0, index_i=0;

		infix_priority[0]='q';infix_priority[1]=')';
		infix_priority[2]='+';infix_priority[3]='-';
		infix_priority[4]='*';infix_priority[5]='/';
		infix_priority[6]='^';infix_priority[7]=' ';
		infix_priority[8]='(';      

		stack_priority[0]='q';stack_priority[1]='(';
		stack_priority[2]='+';stack_priority[3]='-';
		stack_priority[4]='*';stack_priority[5]='/';
		stack_priority[6]='^';stack_priority[7]=' ';

		while (stack_priority[index_s] != stack_o)
			index_s++;
		while (infix_priority[index_i] != infix_o)
			index_i++;
		return ((int)(index_s/2) >= (int)(index_i/2) ? 1 : 0);
	}
	//����תǰ��ķ���
	public static void infix_to_postfix()
	{
		new DataInputStream(System.in);
		int rear=0, top=0, flag=0,i=0;
		char[] stack_t = new char[MAX];  

		for (i=0; i<MAX; i++)
			stack_t[i]='\0';

		while (infix_q[rear] !='\n')  {		 
			System.out.flush();
			try {
				infix_q[++rear] = (char)System.in.read();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		infix_q[rear-1] = 'q';  // �ڶ����м���qΪ��������
		System.out.print("\t�����ʾ�� : ");
		stack_t[top]  = 'q';  // �ڶ�ջ�м���#Ϊ��������
		for (flag = 0; flag <= rear; flag++) {		
			switch (infix_q[flag]) {
				// ����Ϊ)���������ջ���������ֱ����ջ��Ϊ(
				case ')':
					while(stack_t[top]!='(')
					System.out.print(stack_t[top--]);
					top--;
					break;
				// ����Ϊq���򽫶�ջ�ڻ�δ�������������
				case 'q':
					while(stack_t[top]!='q')
					System.out.print(stack_t[top--]);
					break;
				// ����Ϊ���������С��TOP�ڶ�ջ����ָ��������򽫶�ջ��ָ��������
				// �����ڵ���TOP�ڶ�ջ����ָ������������������������ջ
				case '(':
				case '^':
				case '*':
				case '/':
				case '+':
				case '-': 
					while (compare(stack_t[top], infix_q[flag])==1)                       
						System.out.print(stack_t[top--]);			
					stack_t[++top] = infix_q[flag];
					break;
				// ����Ϊ����������ֱ�����
				default :
					System.out.print(infix_q[flag]);
					break;
			}
		}
	}

	
        //�D��ƫŧi
	public static void main (String args[]) 		
	{ 
		new CH04_07();
		System.out.print("\t==========================================\n");
		System.out.print("\t������Ὣ��ת�ɺ�����ʽ\n");
                System.out.print("\t������������ʽ\n");
                System.out.print("\t����:(9+3)*8+7*6-12/4 \n");
                System.out.print("\t����ʹ�õ����������:^,*,+,-,/,(,)��\n");
                System.out.print("\t==========================================\n");
                System.out.print("\t�뿪ʼ����������ʽ: ");
		        CH04_07.infix_to_postfix();
                System.out.print("\t==========================================\n");
	}
}
