package ch06.CH06_02.src;// =============== Program Description ===============
// �������ƣ� CH06_02.java                               
// ����Ŀ�ģ�������ʵ�ֶ�����
// ===================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//�������ڵ��������i
class TreeNode {
       int value;
       TreeNode left_Node;
       TreeNode right_Node;
       // TreeNode���캯���l
       public TreeNode(int value) {
          this.value=value;
          this.left_Node=null;
          this.right_Node=null;
       }
    } 
//�������������ŧi
class BinaryTree {
   public TreeNode rootNode; //�������ĸ��ڵ�
   //���캯��:���ô���һ������Ĳ���������������
   public BinaryTree(int[] data) {
      for(int i=0;i<data.length;i++) 
         Add_Node_To_Tree(data[i]);
   }
   //��ָ����ֵ���뵽���������ʵ��Ľڵ�
   void Add_Node_To_Tree(int value) {
      TreeNode currentNode=rootNode;
      if(rootNode==null) { //��������
         rootNode=new TreeNode(value);
         return;
      }
    //����������
      while(true) {
         if (value<currentNode.value) { //��������
            if(currentNode.left_Node==null) {
              currentNode.left_Node=new TreeNode(value);
              return;
            }
            else currentNode=currentNode.left_Node;
         }
         else { //��������
            if(currentNode.right_Node==null) {
              currentNode.right_Node=new TreeNode(value);
              return;
            }
            else currentNode=currentNode.right_Node;
         }
       }
   }
}
public class CH06_02 {   
	//������
   public static void main(String args[]) throws IOException {
      int ArraySize=10;
      int tempdata;
      int[] content=new int[ArraySize];
      BufferedReader keyin=new BufferedReader(new InputStreamReader(System.in));
      System.out.println("����������"+ArraySize+"������"); 
      for(int i=0;i<ArraySize;i++) {
      System.out.print("�������"+(i+1)+"������: ");       
      tempdata=Integer.parseInt(keyin.readLine());
      content[i]=tempdata;
      }
      new BinaryTree(content);
      System.out.println("===������ʽ����������,�ɹ�!!!===");
   }       
}
