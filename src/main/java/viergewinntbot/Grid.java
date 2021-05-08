package viergewinntbot;

import ch.qos.logback.core.spi.LogbackLock;
import com.vdurmont.emoji.EmojiParser;

public class Grid {
    private String[][] grid = new String[7][6];
    public Grid(){
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String[] pre = new String[7];
        for (int i=0; i<grid.length; i++) {
            for (String cell:grid[i] ) {
                if (cell == null) {
                    result.append(":black_square_button:");
                }else {
                    result.append(cell);
                }
            }
            result.append("\n");
        }
        return EmojiParser.parseToUnicode(result.toString());
    }

    public boolean placeinrow(int row, String emoji) {
        System.out.println(grid.length +" "+ grid[row].length);
        for (int i = grid.length-1; i > -1; i--) {
            if (grid[i][row] == null){
                grid[i][row] = emoji;
                System.out.println("hier");
                return true;

            }
        }
        return false;
    }
}
