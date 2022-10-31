package game;
import java.util.Random;


public class Computer extends Player{
    public Board board;
    public Computer(Board boardComputer){
        this.board = boardComputer;
    }

    @Override
    public void attack() {
        rndAttack();
       this.board.getBoard();
        //TODO: if rndAttack() successful --> calculateMove()
    }

    public void rndAttack() {
        Random r = new Random();
        char posX = (char)(r.nextInt(10) + 'A');
        int posY = r.nextInt(0, 10);
    }

    public void calculateMove() {



        //TODO: ===== TARGET GRID =====
        //TODO:    A  B  C  D  E  F  G  H   I  J
        //TODO: 0(|  |  |  |  |  |  | x| x| x|  |)
        //TODO: 1(|  |  |  |  | s|  | x| x| x|  |)
        //TODO: 2(|  |  | x| x| x|  | x| x| x|  |)
        //TODO: 3(|  |  |  |  | s|  | x| x| x|  |)
        //TODO: 4(|  |  |  |  |  |  | x| x| x|  |)
        //TODO: 5(|  |  |  |  |  |  |  |  |  |  |)
        //TODO: 6(|  |  | b| b| b| b|  |  |  |  |)
        //TODO: 7(|  |  |  |  |  |  |  |  |  |  |)







    }

}
