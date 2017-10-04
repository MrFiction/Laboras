/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.awt.Color;
import java.awt.event.MouseEvent;
import studijosKTU.ScreenKTU;

/**
 *
 * @author Laptopas
 */
public class TicTacToe extends ScreenKTU {
    
    private final byte X = 1;
    private final byte O = 2;
    
    private Boolean oTurn = false;
    private byte won = 0;private byte [][] playingField;
    private static final int gameSize = 3;

    private static final char X_IMAGE = 0x2613;
    private static final char O_IMAGE = 0x25CB;

    private final byte EMPTY = 0;
    private byte turns = 1;

    private static final Color[] cellColors = {Color.lightGray, Color.gray};
    private static final Color symbolColor = Color.black;
    int startRow = 0, startCol = 0;  
    public TicTacToe(byte[][] board){
        super (200, 3);
        playingField = board;
        setFontColor(symbolColor);
        drawBoard();
      
        
    }
        final void drawBoard(){
        for(int i = 0; i < gameSize; i++) 
            for(int j = 0; j < gameSize; j++){
                setBackColor(cellColors[(i+j)&1]);
                print(startRow+i, startCol+j,' ');
            }
        refresh();
    }
         @Override
    public void mouseClicked(MouseEvent e) {
        if(won == 0) {
        int r = e.getY() / cellH;
        int c = e.getX() / cellW;
        if(r >= startRow && r < startRow + gameSize &&
           c >= startCol && c < startCol + gameSize ) {
            int i = r-startRow;
            int j = c-startCol;
            if(playingField[i][j] == EMPTY) { 
                setBackColor(cellColors[(i+j)&1]);
                if(oTurn) {
                    playingField[i][j] = O;
                    print(r, c, O_IMAGE);
                    checkIfWon(O, O_IMAGE);
                    turns++;
                }
                else { 
                    playingField[i][j] = X;
                    print(r, c, X_IMAGE);
                    checkIfWon(X, X_IMAGE);
                    turns++;
                }
                oTurn = !oTurn;
            }
            refresh();
            }
        }
    }
    void checkIfWon(byte current, char currentImage) {
        for (int i = 0; i < gameSize; i++) {
            if( playingField[i][0] == current &&
                playingField[i][1] == current &&
                playingField[i][2] == current) {
               won = current;
            }
            if( playingField[0][i] == current &&
                playingField[1][i] == current &&
                playingField[2][i] == current) {
               won = current;
            }
        }
        if( ( playingField[0][0] == current &&
            playingField[1][1] == current &&
            playingField[2][2] == current ) ||
            ( playingField[2][0] == current &&
            playingField[1][1] == current &&
            playingField[0][2] == current) ) {
               won = current;
        }
        if(won == current)
            changeScreen(currentImage);
        else if(turns == 9)
            changeScreen('t');
    }
    void changeScreen(char current) {
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                print(startRow+i, startCol+j, " ");
            }
        }
        if(current == 't')
            print(1 ,0 , "tie");
        else {
            print(2 ,0 , "won");
            print(0 ,1 , current);
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TicTacToe game = new TicTacToe(new byte[gameSize] [gameSize]  );
    }
    
}
