package edu.bhscs;

public class funType {

    public int[][] board = {{0,0,1},{2,1,0},{1,2,2}};


    //public funType() {
        //System.out.println(board[0][0]);
    //}
    void printboard() {
        System.out.println("Col:  1 2 3");
        System.out.println("      v v v");
        System.out.println("Row 1:" + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("      -----");
        System.out.println("Row 2:" + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("      -----");
        System.out.println("Row 3:" + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
    void updboard(int player, int coord_x, int coord_y) {
        board[coord_y - 1][coord_x - 1] = player;
    }
    int checkwin() {
        int Wincon[][][] = { //each of the 8 possible winning sequences
        {{0,0}, {0,1}, {0,2}}, {{1,0}, {1,1}, {1,2}},
        {{2,0}, {2,1}, {2,2}}, {{0,0}, {1,0}, {2,0}},
        {{0,1}, {1,1}, {2,1}}, {{0,2}, {1,2}, {2,2}},
        {{0,0}, {1,1}, {2,2}}, {{0,2}, {1,1}, {2,0}}
    };
    for (int[][] winset : Wincon) { //loops for each wincon
        int winner = 0; //resets win status
            for (int[] coords : winset) { //checks each coordinate for the wincon sets
                if (board[coords[0]][coords[1]] == 0) { //if not occupied, end check
                    winner = 0;
                    break;
                } else if (board[coords[0]][coords[1]] == 1) { //if occupied by 1
                    if (winner == 2) { //if prev identified 2, end check
                        winner = 0;
                        break;
                    } else { //set or keep win identity to 1
                        winner = 1;
                    }
                } else { //if occupied by player 2
                    if (winner == 1) { // if prev identified 1, end check
                        winner = 0;
                        break;
                    } else { // set or keep win identity to 2
                        winner = 2;
                    }
                }
            }
        if (winner != 0) { // returns the winner if one has been identified
           return winner;
            }
        }
        return 0;
    }
}