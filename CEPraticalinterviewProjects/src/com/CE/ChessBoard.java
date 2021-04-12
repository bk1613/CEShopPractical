package com.CE;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {

	public static boolean checkForCastling(char[][] board) {
		
		int row = board.length;
		int col = board[0].length;
		
		for(int i = 0; i < row; i++) {
			
			for(int j = 0; j < col; j++) {
				if(board[i][j] == 'K') {
					int ml = 0;
					int mr = 0;
					int poslr = 0;
					int posrr = 0;
					int poslk = 0;
					int posrk = 0;
					//move the king to the left and find position of the king and rook
					for(int r = j; r > -1; r--) {
						if(ml == 2) {
							poslk = r;
						}
						ml++;
						if(board[i][r] == 'R') {
							poslr = r;
						}
						
					}
					//move the king to the right and find position of the king and rook
					for(int r = j; r < col; r++) {
						if(mr == 2) {
							posrk = r;
						}
						mr++;
						if(board[i][r] == 'R') {
							posrr = r;
						}
					}
					//check to see if position of rook and king is correct for castling
					if(((0 < poslk-poslr && poslk-poslr < 2) || (0 < posrr-posrk && posrr-posrk < 2))) {
						return true;
					}
					
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//R is rook
		//K is king
		//B is empty space
		char[][] board = {
				{'R', 'B', 'B', 'B', 'K', 'B', 'B', 'R'},
				{'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'},
				{'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'},
				{'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'},
				{'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'},
				{'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'},
				{'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'},
				{'R', 'B', 'B', 'B', 'K', 'B', 'B', 'R'}
		};
		
		
		System.out.println(checkForCastling(board));
	}
	
}
