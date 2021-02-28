import java.util.ArrayList;
import java.util.List;

public class HippodromeGame {
    static HippodromeGame game;
    private List<Horse> horses;

    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(100);
        }
    }

    void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 9; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse result = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > result.getDistance())
                result = horse;
        }
        return result;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public HippodromeGame(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new HippodromeGame(new ArrayList<>());
        game.getHorses().add(new Horse("Horse1", 3, 0));
        game.getHorses().add(new Horse("Horse2", 3, 0));
        game.getHorses().add(new Horse("Horse3", 3, 0));
        game.getHorses().add(new Horse("Horse4", 3, 0));
        game.getHorses().add(new Horse("Horse5", 3, 0));

        game.run();
        game.printWinner();
    }
}
