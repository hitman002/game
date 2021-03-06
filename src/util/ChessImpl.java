package util;

import java.util.HashMap;
import java.util.Map;

public class ChessImpl implements IChess {
	private int i, j, k, m, n, icount;
	// 白子为1，黑子为2,初始为0；
	private int[][] wnum = new int[15][15]; // 白棋在棋盘上各个位置的分值
	private int[][] bnum = new int[15][15]; // 黑棋在棋盘上各个位置的分值
	private int wgrade, bgrade;
	private boolean start;
	private int wmat, wnat, bmde, bnde;
	private static int h = 17; // chess[0][type+14] chess[1][type+14]
								// 保留黑子最近下的2颗棋
	private static int w = 17; // chess[2][15]标记当前最新下的棋子颜色
	public static int[][] chess = new int[h][w];
	private int[][] oldwnum = new int[15][15]; // 旧白棋在棋盘上各个位置的分值
	private int[][] oldbnum = new int[15][15]; // 旧黑棋在棋盘上各个位置的分值
	

	boolean white = false;
	boolean black = false;

	
	public void printChessType(int x ,int y,int type){
		String[] chessTypes = findChessTypes(x, y, type);
		int count = countCoure(chessTypes);
		
		
		if(type == 1){
			System.out.println(this.wnum[x][y]);
		}else{
			System.out.println(this.bnum[x][y]);
		}
		
		System.out.println(count);
		for (String t : chessTypes) {
			System.out.println(t);
		}
	}
	
	public boolean add(int x, int y, int type) {
		if (chess[x][y] != 0) {
			System.out.println("这个位置已经放过棋子了");
			return false;
		} else {
			if (type == 1)
				System.out.println("在" + x + "," + y + "处下了一个白棋");
			else {
				System.out.println("在" + x + "," + y + "处下了一个黑棋");
			}
			// 白棋為1，黑棋為2；
			// chessx[1]chessy[1]紀録上次白棋下子位置
			// chessx[2]chessy[2]紀録上次黑棋下子位置
			chess[0][type + 14] = x;
			chess[1][type + 14] = y;
			chess[x][y] = type;
			chess[2][15] = type;

		}
		return true;
	}

	public void delete(int type) {
		int flag = 0;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (chess[i][j] == 1) {
					flag = 1;
				}
			}
			if (flag == 1) {
				break;
			}
		}
		if (flag == 0) {
			return;
		}
		// 刪除棋子類型位tupe的棋子上次下的棋子
		System.out.println("===============" + type);
		System.out.println(chess[2][15]);
		if (chess[2][15] != type) {
			chess[chess[0][15]][chess[1][15]] = 0;
			chess[chess[0][16]][chess[1][16]] = 0;
//			for (int i = 0; i < 15; i++) {
//				for (int j = 0; j < 15; j++) {
//					for (int z = 0; z < 572; z++) {
//						blacktable[i][j][z] = oldblacktable[i][j][z];
//						whitetable[i][j][z] = oldwhitetable[i][j][z];
//					}
//				}
//			}
//			for (int i = 0; i < 3; i++) {
//				for (int j = 0; j < 572; j++) {
//					win[i][j] = oldwin[i][j];
//				}
//			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					wnum[i][j] = oldwnum[i][j];
					bnum[i][j] = oldbnum[i][j];
				}
			}

		} else {
			chess[chess[0][type + 14]][chess[1][type + 14]] = 0;
//			for (int i = 0; i < 15; i++) {
//				for (int j = 0; j < 15; j++) {
//					for (int z = 0; z < 572; z++) {
//						blacktable[i][j][z] = oldblacktable[i][j][z];
//						whitetable[i][j][z] = oldwhitetable[i][j][z];
//					}
//				}
//			}
//			for (int i = 0; i < 3; i++) {
//				for (int j = 0; j < 572; j++) {
//					win[i][j] = oldwin[i][j];
//				}
//			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					wnum[i][j] = oldwnum[i][j];
					bnum[i][j] = oldbnum[i][j];
				}
			}

			// if (type == 1)
			// System.out.println("在" + i + "," + j + "处删了一个白棋");
			// else {
			// System.out.println("在" + i + "," + j + "处删了一个黑棋");
			// }
		}

	}

	public boolean compare(int x, int y, int type) {

		// System.out.println(white+""+black);
		// for(int a=8,b=6;b<10;a++,b++){
		// chess[a][b]=2;

		// }
		// System.out.println(chess[5][10]+" 9");

		// 纵向判断
		for (int i = x, j = 0; j <= 10; j++) {
			int s = 0, z = 0;
			for (int a = j; a < j + 5; a++) {
				if (chess[x][a] == 1) {
					s++;

				}
				if (chess[x][a] == 2)
					z++;
			}
			if (s == 5) {
				white = true;

			}
			if (z == 5) {
				black = true;

			}

		}
		// System.out.println(white);
		// if(white==true){
		// System.out.println("白色");
		// }
		// 横向判断
		for (int i = 0, j = y; i <= 10; i++) {
			int s = 0, z = 0;
			for (int a = i; a < i + 5; a++) {
				if (chess[a][y] == 1) {
					s++;
				}
				if (chess[a][y] == 2)
					z++;
			}
			if (s == 5) {
				white = true;

			}
			if (z == 5) {
				black = true;

			}
		}
		// 二四象限判断
		if (x > y) {
			for (int i = x - y, j = 0; i < 15 - x + y; i++, j++) {
				int s = 0, z = 0;
				for (int a = i, b = j; a < i + 5 && a < 15; a++, b++) {
					if (chess[a][b] == 1) {
						s++;
					}
					if (chess[a][b] == 2)
						z++;
				}
				if (s == 5) {
					white = true;

				}
				if (z == 5) {
					black = true;

				}
			}
		} else {
			for (int i = 0, j = y - x; j <= 15 - y + x; i++, j++) {
				int s = 0, z = 0;
				for (int a = i, b = j; a < i + 5 && b < 15; a++, b++) {
					// System.out.println(a);
					if (chess[a][b] == 1) {
						s++;
						// System.out.println(s);
					}
					if (chess[a][b] == 2) {
						z++;
						// System.out.println(z);
					}
				}
				if (s == 5) {
					white = true;

				}
				if (z == 5) {
					black = true;

				}
			}

		}
		// 一三象限判断
		if (x + y < 15) {
			for (int i = x + y, j = 0; j <= x + y; i--, j++) {
				int s = 0, z = 0;
				for (int a = i, b = j; b < j + 5 && a >= 0; a--, b++) {
					if (chess[a][b] == 1) {
						s++;
					}
					if (chess[a][b] == 2)
						z++;
				}
				if (s == 5) {
					white = true;

				}
				if (z == 5) {
					black = true;

				}
			}
		} else {
			for (int i = 14, j = x + y - i; j < 15; i--, j++) {
				int s = 0, z = 0;
				for (int a = i, b = j; b < j + 5 && b < 15; a--, b++) {
					if (chess[a][b] == 1) {
						s++;

					}
					if (chess[a][b] == 2)
						z++;
				}
				if (s == 5) {
					white = true;

				}
				if (z == 5) {
					black = true;

				}
			}
		}
		// 返回ture，贏了，返回false，沒人贏。
		if (white == true && type == 1) {
			return true;
		}
		if (black == true && type == 2) {
			return true;
		}
		return false;

	}

	public void ResetGame() {
		this.icount = 0;
		this.start = true;
		// 初始化棋盘
		for (i = 0; i < 15; i++)
			for (j = 0; j < 15; j++) {
				this.bnum[i][j] = 0;
				this.wnum[i][j] = 0;
				chess[i][j] = 0;
			}

		white = false;
		black = false;

	}

	public int[] ComTurn(int x, int y) { // 找出电脑（白子）最佳落子点
		// 最佳下棋位置
		int index[] = new int[2];
		reComTurn();
		if (this.start) { // 开始时白子落子坐标
			if (chess[7][7] == 0) {
				m = 7;
				n = 7;
			} else {
				m = 7;
				n = 8;
			}

			this.start = false;
		} else {
			for (i = 0; i < 15; i++)
				for (j = 0; j < 15; j++)
					if (chess[i][j] == 0) { // 找出棋盘上可落子点的黑子白子的各自最大权值，找出各自的最佳落子点
						if (this.wnum[i][j] >= this.wgrade) {
							this.wgrade = this.wnum[i][j];
							this.wmat = i;
							this.wnat = j;
						}
						if (this.bnum[i][j] >= this.bgrade) {
							this.bgrade = this.bnum[i][j];
							this.bmde = i;
							this.bnde = j;
						}
					}
			if (this.wgrade >= this.bgrade) { // 如果白子的最佳落子点的权值比黑子的最佳落子点权值大，则电脑的最佳落子点为白子的最佳落子点，否则相反
				m = wmat;
				n = wnat;
			} else {
				m = bmde;
				n = bnde;
			}
		}
		
		System.out.println(wgrade);
		System.out.println(bgrade);
		
		this.wgrade = 0;
		this.bgrade = 0;
		// 电脑下子位置
		System.out.println("电脑下在了" + m + "," + n);
		add(m, n, 1);
		compare(m, n, 1);

		index[0] = m;
		index[1] = n;
		
		return index;
	}

	private void reComTurn() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				oldwnum[i][j] = wnum[i][j];
				oldbnum[i][j] = bnum[i][j];
			}
		}
		
		
		for (i = 0; i < 15; i++){
			for (j = 0; j < 15; j++){
				if (chess[i][j] == 0) { // 找出棋盘上可落子点的黑子白子的各自最大权值，找出各自的最佳落子点
					
					wnum[i][j] = countThisCoure(i,j,2);
					bnum[i][j] = countThisCoure(i,j,1);
				}
			}
		}
	}

	private int countThisCoure(int x,int y,int type) {
		String[] chessTypes = findChessTypes(x, y, type);
		int count = countCoure(chessTypes);
		return count;
	}

	private String[] findChessTypes(int x, int y, int type) {
		int a[] = getLine(chess,x,y,type); 
		String[] chessTypes = new String[4];
		chessTypes[0] = ChessCalculation.judgeChessType(a, type);

		a = getVertical(chess,x,y,type); 
		chessTypes[1] = ChessCalculation.judgeChessType(a, type);
		
		a = getLeftVertical(chess,x,y,type); 
		chessTypes[2] = ChessCalculation.judgeChessType(a, type);

		a= getRightVertical(chess,x,y,type); 
		chessTypes[3] = ChessCalculation.judgeChessType(a, type);
		return chessTypes;
	}

	private int countCoure(String[] chessTypes) {
		int count = 0;
		
		Map<String,Integer> types = new HashMap<String,Integer>();
		types.put("连5",0);
		types.put("活4",0);
		types.put("冲4",0);
		types.put("活3",0);
		types.put("眠3",0);
		types.put("活2",0);
		types.put("眠2",0);
		types.put("其他",0);
		
		for (String chessType : chessTypes) {
			types.put(chessType, types.get(chessType) + 1) ;
		}
		
		if(types.get("连5") >= 1)
			count += 1000000;
		if( types.get("活4") >= 2)
			count += 500000;	
		if(types.get("活4") == 1 || ( types.get("冲4") >= 2)  || ( types.get("冲4") == 1 && types.get("活3") == 1 ) )
			count += 100000;
		if( types.get("活3") >= 2  )
			count += 5000;
		if( types.get("活3") == 1  )
			count += 3000;
		if( types.get("眠3") >=1 && types.get("活3") == 1  )
			count += 1000;
		if( types.get("冲4") ==1   )
			count += 500;
		if(  types.get("活3") == 1  )
			count += 100;
		if(  types.get("活2") >= 2  )
			count += 50;
		if(  types.get("活2") == 1  )
			count += 10;
		if(  types.get("眠3") >= 1  )
			count += 5;
		if(  types.get("眠2") >= 1  )
			count += 2;
		
		
		return count;
	}

	
	private int[] getRightVertical(int[][] chess, int i, int j, int type) {
		int a[] = new int[11];
		a[5] = type ;
		for (int k = 1; k <= 5; k++) {
			if( i+k <15  && j-k>0 ){
				a[5-k] = chess[i+k][j-k] ;
			}else{
				a[5-k] = 3 ;
			}
			if(i-k >0 && j+k < 15){
				a[5+k] = chess[i-k][j+k] ;
			}else{
				a[5+k] = 3 ;
			}
		}
		return a;
	}
	
	
	
	private int[] getLeftVertical(int[][] chess, int i, int j, int type) {
		int a[] = new int[11];
		a[5] = type ;
		for (int k = 1; k <= 5; k++) {
			if(i-k>0 && j-k>0 ){
				a[5-k] = chess[i-k][j-k] ;
			}else{
				a[5-k] = 3 ;
			}
			if(i+k <15 && j+k < 15){
				a[5+k] = chess[i+k][j+k] ;
			}else{
				a[5+k] = 3 ;
			}
		}
		return a;
	}
	

	private int[] getVertical(int[][] chess, int i, int j, int type) {
		int a[] = new int[11];
		a[5] = type ;
		for (int k = 1; k <= 5; k++) {
			if(i-k>0){
				a[5-k] = chess[i-k][j] ;
			}else{
				a[5-k] = 3 ;
			}
			if(i+k <15){
				a[5+k] = chess[i+k][j] ;
			}else{
				a[5+k] = 3 ;
			}
		}
		return a;
	}

	private int[] getLine(int[][] chess, int i, int j, int type) {
		int a[] = new int[11];
		a[5] = type ;
		for (int k = 1; k <= 5; k++) {
			if(j-k>0){
				a[5-k] = chess[i][j-k] ;
			}else{
				a[5-k] = 3 ;
			}
			if(j+k <15){
				a[5+k] = chess[i][j+k] ;
			}else{
				a[5+k] = 3 ;
			}
		}
		return a;
	}

	
	
	
	
	
}
