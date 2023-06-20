import java.util.*;

public class SlotGame {
    private final int reelsCount;
    private final int rowsCount;
    private final int[][] reels;
    private final int[][] lines;
    private final Map<Integer, int[]> symbols;

    public SlotGame(int reelsCount, int rowsCount, int[][] reels, int[][] lines, Map<Integer, int[]> symbols) {
        this.reelsCount = reelsCount;
        this.rowsCount = rowsCount;
        this.reels = reels;
        this.lines = lines;
        this.symbols = symbols;
    }

    public void play() {
        // Setting reels positions and symbols on the screen
        int[][] screen = new int[rowsCount][reelsCount];
        Random random = new Random();
        for (int reel = 0; reel < reelsCount; reel++) {
            for (int row = 0; row < rowsCount; row++) {
                int index = random.nextInt(reels[reel].length);
                screen[row][reel] = reels[reel][index];
            }
        }

        // Calculating line payouts
        for (int[] line : lines) {
            int symbol = screen[line[0]][0];
            int count = 1;
            for (int reel = 1; reel < reelsCount; reel++) {
                if (screen[line[reel]][reel] == symbol) {
                    count++;
                } else {
                    break;
                }
            }
            if (count > 1) {
                int payout = symbols.get(symbol)[count - 1];
                System.out.println("Line payout: " + payout);
            }
        }
    }

    public static void main(String[] args) {
        int reelsCount = 5;
        int rowsCount = 3;

        int[][] reels = {
                {
                        1, 1, 2, 2, 9, 9, 3, 3, 1, 1, 8, 8, 8, 3, 3, 6, 6, 1, 1, 7, 7, 2, 2, 6, 6, 1, 1, 8, 8, 2, 2, 5, 5, 4, 4, 4, 1,
                        1, 4, 4, 2, 2, 3, 3, 4, 4, 9, 9, 3, 3, 2, 2, 1, 1, 9, 9, 1, 1, 4, 4, 8, 8, 2, 2, 5, 5, 5, 3, 3, 1, 1, 7, 7, 3,
                        3, 6, 6, 7, 7, 2, 2, 6, 6, 6, 1, 1, 8, 8, 2, 2, 7, 7, 5, 5, 5, 1, 1, 6, 6, 4, 4, 3, 3, 4, 4, 5, 5, 3, 3, 2,
                        2, 1, 1, 1, 1, 2, 2, 9, 9, 3, 3, 1, 1, 8, 8, 8, 3, 3, 6, 6, 1, 1, 7, 7, 2, 2, 6, 6, 1, 1, 8, 8, 2, 2, 5, 5,
                        4, 4, 4, 1, 1, 4, 4, 2, 2,
                },
                {
                        1, 1, 5, 5, 3, 3, 1, 1, 7, 7, 7, 4, 4, 9, 9, 5, 5, 1, 1, 4, 4, 9, 9, 3, 3, 6, 6, 7, 7, 2, 2, 6, 6, 6, 2, 2, 2,
                        3, 3, 4, 4, 8, 8, 8, 3, 3, 2, 2, 1, 1, 4, 4, 1, 1, 8, 8, 2, 2, 5, 5, 1, 1, 5, 5, 9, 9, 3, 3, 1, 1, 7, 7, 4,
                        4, 5, 5, 1, 1, 4, 4, 4, 4, 3, 3, 6, 6, 7, 7, 2, 2, 6, 6, 2, 2, 2, 3, 3, 4, 4, 3, 3, 2, 2, 1, 1, 1, 1, 8, 8,
                        2, 2, 5, 5, 6, 6, 2, 2, 2, 3, 3, 4, 4, 3, 3, 2, 2, 1, 1, 1, 1, 8, 8, 2, 2, 5, 5,
                },
                {
                        1, 1, 9, 9, 2, 2, 2, 5, 5, 8, 8, 3, 3, 1, 1, 7, 7, 3, 3, 6, 6, 7, 7, 2, 2, 6, 6, 6, 1, 1, 8, 8, 2, 2, 5, 5, 4,
                        4, 4, 5, 5, 1, 1, 4, 4, 3, 3, 4, 4, 3, 3, 2, 2, 9, 9, 1, 1, 1, 1, 2, 2, 2, 5, 5, 3, 3, 1, 1, 7, 7, 3, 3, 6, 6,
                        7, 7, 2, 2, 6, 6, 6, 1, 1, 8, 8, 2, 2, 5, 5, 7, 7, 4, 4, 5, 5, 1, 1, 4, 4, 3, 3, 4, 4, 3, 3, 9, 9, 2, 2, 1, 1,
                        6, 6, 6, 1, 1, 8, 8, 2, 2, 5, 5, 7, 7, 4, 4, 5, 5, 1, 1, 4, 4, 3, 3, 4, 4, 3, 3, 9, 9, 2, 2, 1, 1,
                },
                {
                        1, 1, 8, 8, 8, 2, 2, 4, 4, 3, 3, 9, 9, 9, 2, 2, 2, 5, 5, 7, 7, 2, 2, 5, 5, 3, 3, 1, 1, 7, 7, 3, 3, 6, 6, 6, 1,
                        1, 4, 4, 4, 5, 5, 5, 1, 1, 4, 4, 8, 8, 3, 3, 6, 6, 2, 2, 1, 1, 9, 9, 1, 1, 8, 8, 2, 2, 4, 4, 3, 3, 2, 2, 2, 5,
                        5, 5, 7, 7, 2, 2, 9, 9, 3, 3, 1, 1, 7, 7, 3, 3, 6, 6, 1, 1, 7, 7, 5, 5, 1, 1, 4, 4, 3, 3, 8, 8, 6, 6, 2, 2, 1,
                        1, 9, 9, 3, 3, 1, 1, 7, 7, 3, 3, 6, 6, 1, 1, 7, 7, 5, 5, 1, 1, 4, 4, 3, 3, 8, 8, 6, 6, 2, 2, 1, 1,
                },
                {
                        1, 1, 5, 5, 7, 7, 3, 3, 9, 9, 9, 1, 1, 3, 3, 2, 2, 2, 7, 7, 2, 2, 6, 6, 6, 1, 1, 8, 8, 2, 2, 4, 4, 3, 3, 4, 4,
                        4, 5, 5, 1, 1, 6, 6, 4, 4, 8, 8, 3, 3, 6, 6, 2, 2, 1, 1, 8, 8, 1, 1, 5, 5, 3, 3, 9, 9, 1, 1, 7, 7, 3, 3, 2, 2,
                        2, 5, 5, 1, 1, 7, 7, 7, 2, 2, 6, 6, 6, 1, 1, 8, 8, 8, 2, 2, 4, 4, 3, 3, 5, 5, 1, 1, 4, 4, 3, 3, 9, 9, 9, 6, 6,
                        2, 2, 1, 1, 2, 2, 6, 6, 6, 1, 1, 8, 8, 8, 2, 2, 4, 4, 3, 3, 5, 5, 1, 1, 4, 4, 3, 3, 9, 9, 9, 6, 6, 2, 2, 1, 1,
                },
        };

        int[][] lines = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {0, 1, 0, 1, 0},
                {1, 2, 1, 2, 1},
        };

        Map<Integer, int[]> symbols = new HashMap<>();
        symbols.put(1, new int[]{0, 0, 10, 20, 50});
        symbols.put(2, new int[]{0, 0, 20, 40, 100});
        symbols.put(3, new int[]{0, 0, 30, 60, 150});
        symbols.put(4, new int[]{0, 0, 40, 80, 200});
        symbols.put(5, new int[]{0, 0, 50, 100, 250});
        symbols.put(6, new int[]{0, 0, 100, 200, 500});
        symbols.put(7, new int[]{0, 0, 150, 300, 800});
        symbols.put(8, new int[]{0, 0, 200, 400, 1000});
        symbols.put(9, new int[]{0, 0, 300, 600, 2000});

        SlotGame game = new SlotGame(reelsCount, rowsCount, reels, lines, symbols);
        game.play();
    }
}
