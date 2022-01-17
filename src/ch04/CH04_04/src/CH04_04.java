package ch04.CH04_04.src;// =============== Program Description ===============
// �������ƣ� CH04_04.java                               
// ����Ŀ�ģ����ú�ŵ�����������ͬ�������������ƶ�����
// ===================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public    class CH04_04
{
public static void main(String args[]) throws IOException  
	{  
	int j;
	String str;
	BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
	System.out.print("���������������� ");
	str=keyin.readLine();
	j=Integer.parseInt(str);
	hanoi(j,1, 2, 3);
	}
public static void hanoi(int n, int p1, int p2, int p3)
	{  
	if (n==1)
		System.out.println("���Ӵ� "+p1+" �Ƶ� "+p3);
	else
		{  
		hanoi(n-1, p1, p3, p2);
		System.out.println("���Ӵ� "+p1+" �Ƶ� "+p3);
		hanoi(n-1, p2, p1, p3);
		}
	}
}
