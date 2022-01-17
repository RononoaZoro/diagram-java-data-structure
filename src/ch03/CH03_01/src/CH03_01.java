package ch03.CH03_01.src;// =============== Program Description ===============
// �������ƣ� CH03_01.java                               
// ����Ŀ�ģ�����5��ѧ���ɼ��ĵ�������
//            ������ÿһ���ڵ�����ӡ�ɼ�
// ===================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CH03_01 
{
   public static void main(String args[]) throws IOException
   {
	   BufferedReader buf;
	   buf=new BufferedReader(new InputStreamReader(System.in));
	   int num;
	   String name;
	   int score;
	
	   System.out.println("������5��ѧ�����ݣ� ");
	   LinkedList list=new LinkedList();
	   for (int i=1;i<6;i++)
	   {
		   System.out.print("���������ţ� ");
		   num=Integer.parseInt(buf.readLine());
		   System.out.print("������������ ");
		   name=buf.readLine();
		   System.out.print("������ɼ��� ");
		   score=Integer.parseInt(buf.readLine());
		   list.insert(num,name,score);
		   System.out.println("-------------");
	   }
	   System.out.println(" ѧ���ɼ�  ");
	   System.out.println(" ѧ�������ɼ� ===========");
	   list.print();
    }
}
