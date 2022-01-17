package ch06.CH06_07.src;// =============== Program Description ===============
// �������ƣ� CH06_07.java                               
// ����Ŀ�ģ������������Ľ������������
// ===================================================
//�ڵ��������

import java.io.IOException;
//�����������еĽڵ�����
class ThreadNode {
       int value;
       int left_Thread;
       int right_Thread;
       ThreadNode left_Node;
       ThreadNode right_Node;
       // TreeNode���캯��
       public ThreadNode(int value) {
          this.value=value;
          this.left_Thread=0;
          this.right_Thread=0;
          this.left_Node=null;
          this.right_Node=null;
       }
} 
//������������������
class Threaded_Binary_Tree{
   public ThreadNode rootNode; //�����������ĸ��ڵ�

   //�޴�������Ĺ��캯��
   public Threaded_Binary_Tree() {
      rootNode=null;
   }

   //���캯��:��������������,�������Ϊһ������
   //�����еĵ�һ�������������������������������ڵ�
   public Threaded_Binary_Tree(int data[]) {
      for(int i=0;i<data.length;i++)
         Add_Node_To_Tree(data[i]);
   }
   //��ָ����ֵ���뵽����������
   void Add_Node_To_Tree(int value) {
      ThreadNode newnode=new ThreadNode(value);
      ThreadNode current;
      ThreadNode parent;
      ThreadNode previous=new ThreadNode(value);
      int pos;
      //�趨�����������Ŀ�ͷ�ڵ�
      if(rootNode==null) {
         rootNode=newnode;
         rootNode.left_Node=rootNode;
         rootNode.right_Node=null;
         rootNode.left_Thread=0;
         rootNode.right_Thread=1;
         return;
      }
      //�趨��ͷ�ڵ���ָ�Ľڵ�
      current=rootNode.right_Node;
      if(current==null){
         rootNode.right_Node=newnode;
         newnode.left_Node=rootNode;
         newnode.right_Node=rootNode;
         return ;
      }
      parent=rootNode; //���ڵ��ǿ�ͷ�ڵ�
      pos=0; //�趨�������е��н�����
      while(current!=null) {
         if(current.value>value) {
            if(pos!=-1) {
               pos=-1;
               previous=parent;
            }
            parent=current;
            if(current.left_Thread==1)
               current=current.left_Node;
            else
               current=null;
         }
         else {
            if(pos!=1) {
               pos=1;
               previous=parent;
            }
            parent=current;
            if(current.right_Thread==1)
               current=current.right_Node;
            else
               current=null;
         }
      }
      if(parent.value>value) {
         parent.left_Thread=1;
         parent.left_Node=newnode;
         newnode.left_Node=previous;
         newnode.right_Node=parent;
      }
      else {
         parent.right_Thread=1;
         parent.right_Node=newnode;
         newnode.left_Node=parent;
         newnode.right_Node=previous;
      }
      return ;
   }
   //�����������������
   void print() {
      ThreadNode tempNode;
      tempNode=rootNode;
      do {
         if(tempNode.right_Thread==0)
            tempNode=tempNode.right_Node;
         else
         {
            tempNode=tempNode.right_Node;
            while(tempNode.left_Thread!=0)
               tempNode=tempNode.left_Node;
         }
         if(tempNode!=rootNode)
            System.out.println("["+tempNode.value+"]");
      } while(tempNode!=rootNode);
   } 
}

public class CH06_07 {
   public static void main(String[] args) throws IOException {
      System.out.println("������������������,������׷�����������Ч��");
      System.out.println("���˵�һ��������Ϊ�����������Ŀ�ͷ�ڵ���");
      int[] data1={0,10,20,30,100,399,453,43,237,373,655};
      Threaded_Binary_Tree tree1=new Threaded_Binary_Tree(data1);
      System.out.println("====================================");
      System.out.println("���� 1 ");
      System.out.println("������С���������˳����Ϊ: ");
      tree1.print();
      int[] data2={0,101,118,87,12,765,65};
      Threaded_Binary_Tree tree2=new Threaded_Binary_Tree(data2);
      System.out.println("====================================");
      System.out.println("���� 2 ");
      System.out.println("������С���������˳����Ϊ: ");
      tree2.print();
      }
}
