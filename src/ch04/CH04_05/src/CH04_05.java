package ch04.CH04_05.src;// =============== Program Description ===============
// �������ƣ� CH04_05.java                               
// ����Ŀ�ģ��������Թ�
// ===================================================

import java.io.IOException;
public    class CH04_05
{
public static int ExitX= 8;			//������ڵ�X�����ڵڰ���
public static int ExitY= 10;		//������ڵ�Y�����ڵ�ʮ�� 
public static int [][] MAZE= {{1,1,1,1,1,1,1,1,1,1,1,1},	//�����Թ�����
		            	  {1,0,0,0,1,1,1,1,1,1,1,1},
				  {1,1,1,0,1,1,0,0,0,0,1,1},
				  {1,1,1,0,1,1,0,1,1,0,1,1},
				  {1,1,1,0,0,0,0,1,1,0,1,1},			  		
                                  {1,1,1,0,1,1,0,1,1,0,1,1},
				  {1,1,1,0,1,1,0,1,1,0,1,1},
				  {1,1,1,1,1,1,0,1,1,0,1,1},
			          {1,1,0,0,0,0,0,0,1,0,0,1},
			          {1,1,1,1,1,1,1,1,1,1,1,1}};
public static void main(String args[]) throws IOException
   {
	int i,j,x,y;
	TraceRecord path=new TraceRecord();
	x=1;	
	y=1;   
	System.out.print("[�Թ���·��(0�Ĳ���)]\n"); 
	for(i=0;i<10;i++)
	{
		for(j=0;j<12;j++)
			System.out.print(MAZE[i][j]);
		System.out.print("\n");
	}
	while(x<=ExitX&&y<=ExitY)
	{
		MAZE[x][y]=2;
		if(MAZE[x-1][y]==0)
		{
			x -= 1;		
			path.insert(x,y);
		}
		else if(MAZE[x+1][y]==0)
		{
			x+=1;
			path.insert(x,y);
		}
		else if(MAZE[x][y-1]==0)
		{
			y-=1;
			path.insert(x,y);
		}
		else if(MAZE[x][y+1]==0)
		{
			y+=1;
			path.insert(x,y);
		}
		else if(chkExit(x,y,ExitX,ExitY)==1) 
			break;
		else
		{
			MAZE[x][y]=2;
			path.delete();
			x=path.last.x;
			y=path.last.y;
		}
	}
	System.out.print("[�����߹���·��(2�Ĳ���)]\n"); 
	for(i=0;i<10;i++)
	{
		for(j=0;j<12;j++)
			System.out.print(MAZE[i][j]);
		System.out.print("\n");
	}
   }

public static int chkExit(int x,int y,int ex,int ey)
{
	if(x==ex&&y==ey)
	{
		if(MAZE[x-1][y]==1||MAZE[x+1][y]==1||MAZE[x][y-1] ==1||MAZE[x][y+1]==2)
			return 1;
		if(MAZE[x-1][y]==1||MAZE[x+1][y]==1||MAZE[x][y-1] ==2||MAZE[x][y+1]==1)
			return 1;
		if(MAZE[x-1][y]==1||MAZE[x+1][y]==2||MAZE[x][y-1] ==1||MAZE[x][y+1]==1)
			return 1;
		if(MAZE[x-1][y]==2||MAZE[x+1][y]==1||MAZE[x][y-1] ==1||MAZE[x][y+1]==1)
			return 1;
    }
	return 0;
}
}
