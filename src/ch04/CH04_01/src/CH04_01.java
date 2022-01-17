package ch04.CH04_01.src;// =============== Program Description ===============
// �������ƣ� CH04_01.java                               
// ����Ŀ�ģ�������ģ���ջ
// ===================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackByArray { //������ģ���ջ��������
   private int[] stack; //��������������
   private int top;  //ָ���ջ���˵�����
   //StackByArray�๹�캯��
   public StackByArray(int stack_size) {
	      stack=new int[stack_size]; //��������
	      top=-1;
   }
      //�෽����push
   //��Ŷ������ݣ��������¶�ջ������
	   public boolean push(int data) {
      if (top>=stack.length) { //�ж϶�ջ���˵������Ƿ���������С
         System.out.println("��ջ�������޷��ټ���");
         return false;
      }
      else {
         stack[++top]=data; //�����ݴ����ջ
         return true;
      }
   }
   //�෽����empty
   //�ж϶�ջ�Ƿ�Ϊ�ն�ջ�����򷵻�true�������򷵻�false
   public boolean empty() {
      if (top==-1) return true;
      else         return false;
   }
   //�෽����pop
   //�Ӷ�ջȡ������
   public int pop() {
      if(empty()) //�ж϶�ջ�Ƿ�Ϊ�գ�������򷵻�-1ֵ
        return -1;
      else
        return stack[top--]; //�Ƚ�����ȡ�����ٽ���ջָ��������
   }
}
//���������
public class CH04_01 {
   public static void main(String args[]) throws IOException {
      BufferedReader buf;
      int value;
      StackByArray stack =new StackByArray(10);
      buf=new BufferedReader(
                   new InputStreamReader(System.in));
      System.out.println("����������10�����ݣ�");
      for (int i=0;i<10;i++) {
         value=Integer.parseInt(buf.readLine());
         stack.push(value);
      }
      System.out.println("=============================");
      while (!stack.empty()) //����ջ����½���Ӷ��˵����X
         System.out.println("��ջ������˳��Ϊ:"+stack.pop());
   }
}