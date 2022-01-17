package ch06.CH06_04.src;

// =============== Program Description ===============
// �������ƣ� CH06_04.java                               
// ����Ŀ�ģ�������ʵ�ֶ���������
// ===================================================
//�ڵ���������ŧi
class TreeNode {
       int value;
       TreeNode left_Node;
       TreeNode right_Node;
       // TreeNode���캯��
       public TreeNode(int value) {
          this.value=value;
          this.left_Node=null;
          this.right_Node=null;
       }
    } 
//�����������������ŧi
class Binary_Search_Tree {
   public TreeNode rootNode; //�������ĸ��ڵ�
   //���캯��:�����յĶ���������
   public Binary_Search_Tree() { rootNode=null; }
   //���캯��:���ô���һ������Ĳ���������������
   public Binary_Search_Tree(int[] data) {
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
         if (value<currentNode.value) { //��������жϱ�ʾ�˽ڵ���������
            if(currentNode.left_Node==null) {
              currentNode.left_Node=new TreeNode(value);
              return;
            }
            else currentNode=currentNode.left_Node;
         }
         else { //��������жϱ�ʾ�˽ڵ���������
            if(currentNode.right_Node==null) {
              currentNode.right_Node=new TreeNode(value);
              return;
            }
            else currentNode=currentNode.right_Node;
         }
       }
   }
}

class Expression_Tree extends Binary_Search_Tree{
	// ���캯��
   public Expression_Tree(char[] information, int index) {
      // ��Ϊ�ݹ���õĳ�������
      rootNode = create(information, index);
   }
   // create�������Խ��������������ʾ��ת���������ʾ��
   public TreeNode create(char[] sequence,int index) {
      TreeNode tempNode;            
      if ( index >= sequence.length )   // ��Ϊ�ݹ���õĳ����������X�f����
         return null;
      else  { 
         tempNode = new TreeNode((int)sequence[index]);
         // ����������
         tempNode.left_Node = create(sequence, 2*index);
         // ����������
         tempNode.right_Node = create(sequence, 2*index+1);
         return tempNode;
      }
   }
   // preOrder(ǰ�����)�����ĳ�������
   public void preOrder(TreeNode node) {
      if ( node != null ) {
         System.out.print((char)node.value);
         preOrder(node.left_Node);  
         preOrder(node.right_Node); 
      }
   }
   // inOrder(�������)�����ĳ�������
   public void inOrder(TreeNode node) {
      if ( node != null ) {
         inOrder(node.left_Node);  
         System.out.print((char)node.value);
         inOrder(node.right_Node); 
      }
   }
   // postOrder(�������)�����ĳ�������
   public void postOrder(TreeNode node) {
      if ( node != null ) {
         postOrder(node.left_Node);  
         postOrder(node.right_Node); 
         System.out.print((char)node.value);
      }
   }
   // �жϱ��ʽ�������ķ�����������
   public int condition(char oprator, int num1, int num2) {
      switch ( oprator ) {
         case '*': return ( num1 * num2 ); // �˷���ش�num1 * num2
         case '/': return ( num1 / num2 ); // ������ش�num1 / num2
         case '+': return ( num1 + num2 ); // �ӷ���ش�num1 + num2
         case '-': return ( num1 - num2 ); // ������ش�num1 - num2
         case '%': return ( num1 % num2 ); // ȡ��������ش�num1 % num2
      }
      return -1;
   }
   // ������ڵ�,��������˶�����������ֵ����
   public int answer(TreeNode node) {
      int firstnumber = 0;       
      int secondnumber = 0;      
      // �ݹ���õĳ�������
      if ( node.left_Node == null && node.right_Node == null )
    	// ���ڵ��ֵת������ֵ�󷵻�
        return Character.getNumericValue((char)node.value);
      else {
	        firstnumber = answer(node.left_Node);  // �������������ʽ��ֵ
	        secondnumber = answer(node.right_Node); // �������������ʽ��ֵ
        return condition((char)node.value, firstnumber, secondnumber);
      }
   }
 }
public class CH06_04 {
   public static void main(String[] args) {
	      // ������������������ķ�ʽ������
	      // ��һ�����ʽ
      char[] information1 = {' ','+','*','%','6','3','9','5' };
      // �ڶ������ʽ
      char[] information2 = {' ','+','+','+','*','%','/','*',
                            '1','2','3','2','6','3','2','2' };
	      Expression_Tree exp1 = new Expression_Tree(information1, 1);
	      System.out.println("====������������ֵ���㷶�� 1: ====");
	      System.out.println("=================================");
	      System.out.print("===ת����������ʽ===:  ");
      exp1.inOrder(exp1.rootNode);     
	      System.out.print("\n===ת����ǰ����ʽ===:  ");
	      exp1.preOrder(exp1.rootNode);    
	      System.out.print("\n===ת���ɺ�����ʽ===:  ");
	      exp1.postOrder(exp1.rootNode);   
	      // ������������ʽ��������
	      System.out.print("\n�˶���������,������������õ��Ľ��ֵ: ");
	      System.out.println(exp1.answer(exp1.rootNode));
	      // �����ڶ��ö�������������
	      Expression_Tree exp2 = new Expression_Tree(information2, 1);
	      System.out.println();
	      System.out.println("====������������ֵ���㷶�� 2: ====");
	      System.out.println("=================================");
	      System.out.print("===ת����������ʽ===:  ");
	      exp2.inOrder(exp2.rootNode);     
	      System.out.print("\n===ת����ǰ����ʽ===:  ");
	      exp2.preOrder(exp2.rootNode);    
	      System.out.print("\n===ת���ɺ�����ʽ===:  ");
	      exp2.postOrder(exp2.rootNode);   
	      // ������������ʽ��������
	      System.out.print("\n�˶���������,������������õ��Ľ��ֵ: ");
	      System.out.println(exp2.answer(exp2.rootNode));
  
   }
}