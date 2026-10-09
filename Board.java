import java.lang.reflect.Array;
import java.util.ArrayList;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class Board
{
    private Mark[][] board;

    // Ne pas changer la signature de cette méthode
    public Board() {
        //initialisation
        board = new Mark[][] {
                {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
                {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY}
        };

    }

    // Place la pièce 'mark' sur le plateau, à la
    // position spécifiée dans Move
    //
    // Ne pas changer la signature de cette méthode
    public void play(Move m, Mark mark){
        board[m.getRow()][m.getCol()] = mark;
    }

    public void unplay(Move m){
        board[m.getRow()][m.getCol()] = Mark.EMPTY;
    }

    // retourne  100 pour une victoire
    //          -100 pour une défaite
    //           0   pour un match nul
    // Ne pas changer la signature de cette méthode
    public int evaluate(Mark mark){
        Mark opposite = mark == Mark.X ? Mark.O : Mark.X;
        if(Win(mark)){
            return 100;
        }else if(Win(opposite)){
            return -100;
        }
        return 0;
    }

    public ArrayList<Move> getMoves(){
        ArrayList<Move> moves = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == Mark.EMPTY){
                    moves.add(new Move(i, j));
                }
            }
        }
        return moves;
    }

    //vérifie si le board est plein
    public boolean isBoardFinal(){
        if(Win(Mark.X) || Win(Mark.O)){
            return true;
        }
        return isBoardFull();
    }

    //retourne les move possible (cases vides)
    private boolean isBoardFull(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == Mark.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    //est ce que le board est gagnant pour cette mark
    private boolean Win(Mark mark){
        if(board[0][0] == mark){
            if(board[0][1] == mark && board[0][2] == mark){
                return true;
            }else if(board[1][0] == mark && board[2][0] == mark){
                return true;
            }else if(board[1][1] == mark && board[2][2] == mark){
                return true;
            }
        }
        if(board[0][1] == mark){
            if(board[1][1] == mark && board[2][1] == mark){
                return true;
            }
        }
        if(board[0][2] == mark){
            if(board[1][2] == mark && board[2][2] == mark){
                return true;
            }else if(board[1][1] == mark && board[2][0] == mark){
                return true;
            }
        }
        if(board[1][0] == mark && board[1][1] == mark && board[1][2] == mark){
            return true;
        }
        if(board[2][0] == mark && board[2][1] == mark && board[2][2] == mark){
            return true;
        }
        return false;
    }
}
