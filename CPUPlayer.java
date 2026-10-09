import java.util.ArrayList;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class CPUPlayer
{

    // Contient le nombre de noeuds visités (le nombre
    // d'appel à la fonction MinMax ou Alpha Beta)
    // Normalement, la variable devrait être incrémentée
    // au début de votre MinMax ou Alpha Beta.
    private int numExploredNodes;
    private final Mark mark;
    // Le constructeur reçoit en paramètre le
    // joueur MAX (X ou O)
    public CPUPlayer(Mark cpu){
        mark = cpu;
    }

    // Ne pas changer cette méthode
    public int  getNumOfExploredNodes(){
        return numExploredNodes;
    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveMinMax(Board board)
    {
        //haut en bas - gauche a droite
        //évaluer sur le nombre de noeud explorés
        numExploredNodes = 0;
        return null;
    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveAB(Board board){
        numExploredNodes = 0;
        if(board.isBoardFinal()){
            return new ArrayList<>();
        }
        var possibleMoves = board.getMoves();
        ArrayList<Move> moves = new ArrayList<>();

        Mark opposite = mark == Mark.X ? Mark.O : Mark.X;
        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;
        int bestScore = Integer.MIN_VALUE;
        int value;
        for(var move : possibleMoves){
            board.play(move, mark);
            value = scoreAlphaBeta(board, opposite, alpha, beta);
            board.unplay(move);

            if(value >= bestScore){
                if(value > bestScore){
                    bestScore = value;
                    moves.clear();
                }
                moves.add(move);
            }
        }
        return moves;
    }

    private int scoreAlphaBeta(Board board, Mark player, int alpha, int beta){
        Mark opposite = player == Mark.X ? Mark.O : Mark.X;
        numExploredNodes++;
        if(board.isBoardFinal()){
            return board.evaluate(mark);
        }
        var moves = board.getMoves();
        var value = 0;
        if(player == mark){
            value = Integer.MIN_VALUE;
           for(Move move : moves){
               board.play(move, player);
               var score = scoreAlphaBeta(board, opposite, alpha, beta);
               board.unplay(move);
               value = Math.max(value, score);
               alpha = Math.max(alpha, value);
               if(alpha >= beta){
                   break;
               }
           }
           return value;
        }else{
            value = Integer.MAX_VALUE;
            for(Move move : moves){
                board.play(move, player);
                var score = scoreAlphaBeta(board, opposite, alpha, beta);
                board.unplay(move);
                value = Math.min(value, score);
                beta = Math.min(beta, value);
                if(alpha >= beta){
                    break;
                }
            }
            return value;
        }
    }

}
