/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.awt.Color;
import studijosKTU.ScreenKTU;

/**
 *
 * @author Laptopas
 */
public class TicTacToe extends ScreenKTU {
private byte [][] playingField;
private static final int gameSize = 3;

    private static final Color[] cellColors = {Color.lightGray, Color.gray};
    private static final Color[] drColors = {Color.yellow, Color.black};
    int startRow = 0, startCol = 0;  
    public TicTacToe(byte[][] board){
        super (200, 3);
        playingField = board;
        drawBoard();
        
    }
        final void drawBoard(){
        setBackColor(Color.GREEN);
        //print(0, 0, "PLAY");
        for(int i = 0; i < gameSize; i++) 
            for(int j = 0; j < gameSize; j++){
                setColors(cellColors[(i+j)&1], drColors[(playingField[i][j]+2)/2-1]);
                print(startRow+i, startCol+j,' ');
            }
        refresh();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TicTacToe game = new TicTacToe(new byte[gameSize] [gameSize]  );
    }
    
}
