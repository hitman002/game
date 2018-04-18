package util;

public class ChessCalculation {
	
	public static String judgeChessType(int a[],int type){
		if(a[5] != type) throw new RuntimeException("错误");
		
		String cheseeType = "其他";
		
		//判断连子
		boolean leftSame = true ;
		boolean rightSame = true ;
		
		int lianzi = 1;
		int begin = 0 ;
		int end = 0 ;
		for (int i = 1; i < 5; i++) {
			 if(!leftSame){
				 
			 }else if(a[5-i] == type){
				 lianzi ++; 
			 }else{
				 begin = 5 - i + 1 ;
				 leftSame = false;
			 }
			 
			 if(!rightSame){
				 
			 }else if(a[5+i] == type ){
				 lianzi ++; 
			 }else{
				 rightSame = false;
				 end = 5 +i - 1;
			 }
		}
		
		
		int leftChess = 0;
		if(begin - 1 <0){
			leftChess = 3;
		}else{
			leftChess = a[begin - 1] ;
		}
		
		
		int rightChess  = 0 ;
		if(begin + 1  > 15){
			rightChess = 3;
		}else{
			rightChess = a[end + 1] ;
		}
		
		if(lianzi == 5) {
			cheseeType = "连5" ;
		}
		
		
		if(lianzi == 4) {
			if(leftChess == 0 && rightChess == 0){
				cheseeType = "活4";
			}
			
			if(leftChess == 0 && ( rightChess != type && rightChess != 0)){
				cheseeType = "冲4";
			}
			
			if(rightChess == 0 && ( leftChess != type && leftChess != 0)){
				cheseeType = "冲4";
			}
		}
		
		if(lianzi == 3) {
			if(leftChess == 0 && rightChess == 0){
				cheseeType = "活3";
			}
			
			if( ( a[begin - 2] == 0   &&  leftChess == 0 ) && ( rightChess != type && rightChess != 0)   ){
				cheseeType = "眠3";
			}
			
			if( ( a[end + 2] == 0   &&  rightChess == 0 ) && ( leftChess != type && leftChess != 0)  ){
				cheseeType = "眠3";
			}
			
			if( leftChess == 0 && rightChess == 0 && a[ begin - 2 ] == type ){
				cheseeType = "冲4";
			}
			
			if( rightChess == 0 && leftChess == 0 && a[ end + 2 ] == type ){
				cheseeType = "冲4";
			}
			
			if(( a[ begin - 2 ]  != type && a[ begin - 2 ]  != 0) &&  ( a[ end + 2 ] != type && a[ end + 2 ] != 0)  ){
				cheseeType = "眠3";
			}
			
		}
		
		if(lianzi == 2) {
			if(leftChess == 0  && a[ begin - 2 ]  == 0  && a[ end + 2 ]  == 0 && rightChess == 0  ){
				cheseeType = "活2";
			}
			
			
			if(leftChess == 0 && a[ begin - 2 ]  == type && a[ begin - 3 ]  == type ){
				cheseeType = "冲4";
			}
			
			if(rightChess == 0 && a[ end + 2 ]  == type && a[ end + 3 ]  == type ){
				cheseeType = "冲4";
			}
			
			if(leftChess == 0 && a[ begin - 2 ]  == type && a[ begin - 3 ]  == 0  && rightChess == 0){
				cheseeType = "活3";
			}
			
			if(rightChess == 0 && a[ end + 2 ]  == type && a[ end + 3 ]  == 0 && leftChess == 0){
				cheseeType = "活3";
			}
			
			if(leftChess == 0 && a[ begin - 2 ]  == type && a[ begin - 3 ]  == 0  && ( rightChess != type && rightChess != 0) ){
				cheseeType = "眠3";
			}
			
			if(rightChess == 0 && a[ end + 2 ]  == type && a[ end + 3 ]  == 0 && ( leftChess != type && leftChess != 0)){
				cheseeType = "眠3";
			}
			
			if(rightChess == 0 && leftChess == 0&& a[ end + 2 ]  == type  && ( a[ end + 3 ] != type && a[ end + 3 ] != 0)){
				cheseeType = "眠3";
			}
			
			if(rightChess == 0 && leftChess == 0&& a[ begin - 2 ]  == type  && ( a[ begin - 3 ] != type && a[ begin - 3 ] != 0)){
				cheseeType = "眠3";
			}
			
			if(rightChess == 0 && leftChess == 0&& a[ begin - 2 ]  == 0 && a[begin -3] == 0 && a[begin -4] == type ){
				cheseeType = "眠3";
			}
			
			if(rightChess == 0 && leftChess == 0&& a[ end + 2 ]  == 0 && a[ end + 3] == 0 && a[end + 4] == type ){
				cheseeType = "眠3";
			}
			
			if(leftChess == 0  && a[ begin - 2 ]  == 0  && a[ begin - 3 ]  == 0 && ( rightChess != type && rightChess != 0)  ){
				cheseeType = "活2";
			}
			
			if(rightChess == 0  && a[ end + 2 ]  == 0  && a[ end + 3 ]  == 0 && ( leftChess != type && leftChess != 0)  ){
				cheseeType = "活2";
			}
			
		}
		
		if(lianzi == 1){
			if(rightChess == 0 && leftChess == 0&& a[ end + 2 ]  == type && a[ end + 3] == 0 && a[end + 4] == type ){
				cheseeType = "眠3";
			}
			if(rightChess == 0 && leftChess == 0&& a[ begin - 2 ]  == type && a[begin -3] == 0 && a[begin -4] == type ){
				cheseeType = "眠3";
			}
		}
		
		
		return cheseeType;
		
	}
	
	
	
	
	
}
