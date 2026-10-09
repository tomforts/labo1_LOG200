import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Board board = new Board();

        // Configuration du test A
        board.play(new Move(0, 0), Mark.X);
        board.play(new Move(0, 1), Mark.O);
        board.play(new Move(1, 0), Mark.X);
        board.play(new Move(1, 1), Mark.O);

        CPUPlayer cpu = new CPUPlayer(Mark.X);

        ArrayList<Move> result = cpu.getNextMoveAB(board);

        System.out.println("Coups retournés :");
        for (Move move : result) {
            System.out.println(
                    "(" + move.getRow() + "," + move.getCol() + ")"
            );
        }

        System.out.println(
                "Noeuds explores : " + cpu.getNumOfExploredNodes()
        );
    }
}
