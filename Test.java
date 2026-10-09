public class Test {
    public static void main(String[] args) {
        CPUPlayer player1 = new CPUPlayer(Mark.O);
        CPUPlayer player2 = new CPUPlayer(Mark.X);
        Board board = new Board();
        System.out.println("Joueur O : " + board.evaluate(player1.mark));
        System.out.println("Joueur X : " + board.evaluate(player2.mark));
    }
}
