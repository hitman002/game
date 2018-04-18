package util;

import org.junit.Test;

import junit.framework.Assert;

public class ChessCalculationTest {

	
	
	
	
	@Test
	public void testLian5(){
			Assert.assertEquals("活3",ChessCalculation.judgeChessType(genereateChess("00202200000"), 2));
			Assert.assertEquals("冲4",ChessCalculation.judgeChessType(genereateChess("00222210000"), 2));
			Assert.assertEquals("活4",ChessCalculation.judgeChessType(genereateChess("00022220000"), 2));
			Assert.assertEquals("眠3",ChessCalculation.judgeChessType(genereateChess("00022210000"), 2));
			Assert.assertEquals("活3",ChessCalculation.judgeChessType(genereateChess("00202202000"), 2));
			
	}

	private int[] genereateChess(String a) {
		char[] chars = a.toCharArray() ;
		
		int chess[] = new int[11];
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			chess[i] = Integer.parseInt(c+"");
		}
		return chess;
	}
	
}
