import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

/*
 * Author: Kody Fong ( kbfong@ucsc.edu)
 * 
 */
class TTT3D 
{
    static int[][][] board = new int[4][4][4]; 
    static int[] sums = new int[76]; //all the possible lines of victory
    static final int[][][] lines = new int[][][]{
	{{0, 0, 0}, {0, 0, 1}, {0, 0, 2}, {0, 0, 3}}, {{0, 1, 0}, {0, 1, 1}, {0, 1, 2}, {0, 1, 3}}, {{0, 2, 0}, {0, 2, 1}, {0, 2, 2}, {0, 2, 3}}, {{0, 3, 0}, {0, 3, 1}, {0, 3, 2}, {0, 3, 3}}, {{1, 0, 0}, {1, 0, 1}, {1, 0, 2}, {1, 0, 3}}, {{1, 1, 0}, {1, 1, 1}, {1, 1, 2}, {1, 1, 3}}, {{1, 2, 0}, {1, 2, 1}, {1, 2, 2}, {1, 2, 3}}, {{1, 3, 0}, {1, 3, 1}, {1, 3, 2}, {1, 3, 3}}, {{2, 0, 0}, {2, 0, 1}, {2, 0, 2}, {2, 0, 3}}, {{2, 1, 0}, {2, 1, 1}, {2, 1, 2}, {2, 1, 3}}, {{2, 2, 0}, {2, 2, 1}, {2, 2, 2}, {2, 2, 3}}, {{2, 3, 0}, {2, 3, 1}, {2, 3, 2}, {2, 3, 3}}, {{3, 0, 0}, {3, 0, 1}, {3, 0, 2}, {3, 0, 3}}, {{3, 1, 0}, {3, 1, 1}, {3, 1, 2}, {3, 1, 3}}, {{3, 2, 0}, {3, 2, 1}, {3, 2, 2}, {3, 2, 3}}, {{3, 3, 0}, {3, 3, 1}, {3, 3, 2}, {3, 3, 3}}, {{0, 0, 0}, {0, 1, 0}, {0, 2, 0}, {0, 3, 0}}, {{0, 0, 1}, {0, 1, 1}, {0, 2, 1}, {0, 3, 1}}, {{0, 0, 2}, {0, 1, 2}, {0, 2, 2}, {0, 3, 2}}, {{0, 0, 3}, {0, 1, 3}, {0, 2, 3}, {0, 3, 3}}, {{1, 0, 0}, {1, 1, 0}, {1, 2, 0}, {1, 3, 0}}, {{1, 0, 1}, {1, 1, 1}, {1, 2, 1}, {1, 3, 1}}, {{1, 0, 2}, {1, 1, 2}, {1, 2, 2}, {1, 3, 2}}, {{1, 0, 3}, {1, 1, 3}, {1, 2, 3}, {1, 3, 3}}, {{2, 0, 0}, {2, 1, 0}, {2, 2, 0}, {2, 3, 0}}, {{2, 0, 1}, {2, 1, 1}, {2, 2, 1}, {2, 3, 1}}, {{2, 0, 2}, {2, 1, 2}, {2, 2, 2}, {2, 3, 2}}, {{2, 0, 3}, {2, 1, 3}, {2, 2, 3}, {2, 3, 3}}, {{3, 0, 0}, {3, 1, 0}, {3, 2, 0}, {3, 3, 0}}, {{3, 0, 1}, {3, 1, 1}, {3, 2, 1}, {3, 3, 1}}, {{3, 0, 2}, {3, 1, 2}, {3, 2, 2}, {3, 3, 2}}, {{3, 0, 3}, {3, 1, 3}, {3, 2, 3}, {3, 3, 3}}, {{0, 0, 0}, {1, 0, 0}, {2, 0, 0}, {3, 0, 0}}, {{0, 0, 1}, {1, 0, 1}, {2, 0, 1}, {3, 0, 1}}, {{0, 0, 2}, {1, 0, 2}, {2, 0, 2}, {3, 0, 2}}, {{0, 0, 3}, {1, 0, 3}, {2, 0, 3}, {3, 0, 3}}, {{0, 1, 0}, {1, 1, 0}, {2, 1, 0}, {3, 1, 0}}, {{0, 1, 1}, {1, 1, 1}, {2, 1, 1}, {3, 1, 1}}, {{0, 1, 2}, {1, 1, 2}, {2, 1, 2}, {3, 1, 2}}, {{0, 1, 3}, {1, 1, 3}, {2, 1, 3}, {3, 1, 3}}, {{0, 2, 0}, {1, 2, 0}, {2, 2, 0}, {3, 2, 0}}, {{0, 2, 1}, {1, 2, 1}, {2, 2, 1}, {3, 2, 1}}, {{0, 2, 2}, {1, 2, 2}, {2, 2, 2}, {3, 2, 2}}, {{0, 2, 3}, {1, 2, 3}, {2, 2, 3}, {3, 2, 3}}, {{0, 3, 0}, {1, 3, 0}, {2, 3, 0}, {3, 3, 0}}, {{0, 3, 1}, {1, 3, 1}, {2, 3, 1}, {3, 3, 1}}, {{0, 3, 2}, {1, 3, 2}, {2, 3, 2}, {3, 3, 2}}, {{0, 3, 3}, {1, 3, 3}, {2, 3, 3}, {3, 3, 3}}, {{0, 0, 0}, {0, 1, 1}, {0, 2, 2}, {0, 3, 3}}, {{0, 3, 0}, {0, 2, 1}, {0, 1, 2}, {0, 0, 3}}, {{1, 0, 0}, {1, 1, 1}, {1, 2, 2}, {1, 3, 3}}, {{1, 3, 0}, {1, 2, 1}, {1, 1, 2}, {1, 0, 3}}, {{2, 0, 0}, {2, 1, 1}, {2, 2, 2}, {2, 3, 3}}, {{2, 3, 0}, {2, 2, 1}, {2, 1, 2}, {2, 0, 3}}, {{3, 0, 0}, {3, 1, 1}, {3, 2, 2}, {3, 3, 3}}, {{3, 3, 0}, {3, 2, 1}, {3, 1, 2}, {3, 0, 3}}, {{0, 0, 0}, {1, 0, 1}, {2, 0, 2}, {3, 0, 3}}, {{3, 0, 0}, {2, 0, 1}, {1, 0, 2}, {0, 0, 3}}, {{0, 1, 0}, {1, 1, 1}, {2, 1, 2}, {3, 1, 3}}, {{3, 1, 0}, {2, 1, 1}, {1, 1, 2}, {0, 1, 3}}, {{0, 2, 0}, {1, 2, 1}, {2, 2, 2}, {3, 2, 3}}, {{3, 2, 0}, {2, 2, 1}, {1, 2, 2}, {0, 2, 3}}, {{0, 3, 0}, {1, 3, 1}, {2, 3, 2}, {3, 3, 3}}, {{3, 3, 0}, {2, 3, 1}, {1, 3, 2}, {0, 3, 3}}, {{0, 0, 0}, {1, 1, 0}, {2, 2, 0}, {3, 3, 0}}, {{3, 0, 0}, {2, 1, 0}, {1, 2, 0}, {0, 3, 0}}, {{0, 0, 1}, {1, 1, 1}, {2, 2, 1}, {3, 3, 1}}, {{3, 0, 1}, {2, 1, 1}, {1, 2, 1}, {0, 3, 1}}, {{0, 0, 2}, {1, 1, 2}, {2, 2, 2}, {3, 3, 2}}, {{3, 0, 2}, {2, 1, 2}, {1, 2, 2}, {0, 3, 2}}, {{0, 0, 3}, {1, 1, 3}, {2, 2, 3}, {3, 3, 3}}, {{3, 0, 3}, {2, 1, 3}, {1, 2, 3}, {0, 3, 3}}, {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}, {3, 3, 3}}, {{3, 0, 0}, {2, 1, 1}, {1, 2, 2}, {0, 3, 3}}, {{0, 3, 0}, {1, 2, 1}, {2, 1, 2}, {3, 0, 3}}, {{3, 3, 0}, {2, 2, 1}, {1, 1, 2}, {0, 0, 3}}
    }; //all of the possible coordinate combinations
    public static void main(String[] arrstring) throws FileNotFoundException {
        int n =  0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(999); 
        int[] fork = new int[3];
        int[] cord = new int[3];
        //int[] arrn3 = new int[3];
        int move = 0;
        if (arrstring.length != 0) 
	    {
		System.out.println("getting initial setup from file");
		Scanner scanner2 = new Scanner(new FileInputStream(arrstring[0])); //allows for using a setup file on the command line
		n3 = scanner2.nextInt(); //input
		for (n4 = 0; n4 < n3; n4++) {
		    n = scanner2.nextInt() % 4;
		    n2 = scanner2.nextInt() % 4;
		    int n6 = scanner2.nextInt() % 4;
		    int n7 = scanner2.nextInt();
		    TTT3D.move((int)n, (int)n2, (int)n6, (int)n7);
		}
	    } 
        else 
	    {
		TTT3D.setAll((int)0); //reset the board to 0s
	    }
        boolean gg = false;
        while (!gg)  
	    {
		TTT3D.printBoardWithMarkers(); //print the board;
		n3 = 0;
		while (n3 ==0) //while its the players turn 
		    {
			System.out.println("Type your move as one three digit number(lrc)"); //asks for user input to enter the level row and column
			n4 = scanner.nextInt(); //user input
			cord[2] = n4 % 10;
			cord[1] = n4 / 10 % 10;
			cord[0] = n4 / 100 % 10;
			if (TTT3D.isEmpty((int[])cord)) //makes sure the slot is empty for the move
			    {
				n3 = 1;
				TTT3D.move((int[])cord, (int)5);
				continue;
			    }
			System.out.println("Sorry that cell is occupied.");
		    }
		TTT3D.compLineSums(); //compute the line sums
		if (TTT3D.findLineSum((int)20) != -1) //if the sum of the line = 20 the player has won 
		    {
			TTT3D.printBoardWithMarkers();
			System.out.println("Congratz you won!");
			gg = true;
			continue;
		    }
		move = TTT3D.findLineSum((int)3);
		if (move != -1) //if the sum of the line = 5 the cpu wins; 
		    {
			TTT3D.move((int[])TTT3D.findEmptyCell((int[][])lines[move]), (int)1);
			TTT3D.printBoardWithMarkers(); //prints the board
			System.out.println("Computer wins again!");
			gg = true;
			continue;
		    }
		move = TTT3D.findLineSum((int)15);
		if (move != -1) //the cpu must make a move to avoid losing 
		    {
			TTT3D.move((int[])TTT3D.findEmptyCell((int[][])lines[move]), (int)1);
			continue;
		    }
		fork = TTT3D.findFork((int)1, (int[][][])lines, (int[])sums);
		if (fork != null) //finds a fork that results in a win for the cpu 
		    {
			TTT3D.move((int[])fork, (int)1);
			continue;
		    }
		fork = TTT3D.findFork((int)5, (int[][][])lines, (int[])sums);
		if (fork != null) //finds a fork that the cpu must block in order to not lose
		    {
			TTT3D.move((int[])fork, (int)1);
			continue;
		    }
		n4 = random.nextInt(sums.length); //creates a random row to play
		n = 0;
		for (n2 = 0; n2 < sums.length && n == 0; n2++) 
		    {
			switch (sums[n4]) {
			case 0: 
			case 1: 
			case 2: 
			case 5: 
			case 10: 
			    {
				n = 1;
				TTT3D.move((int[])TTT3D.findEmptyCell((int[][])lines[n4]), (int)1);
			    }
			}
			n4 = (n4 + 1) % sums.length; //tests if line is full
		    }
		if (n != 0) //if this keeps going, it means the board is full and the game is a draw
		    continue;
		System.out.println("game is a draw");
		gg = true;
	    }
    }
    public static void printBoard() //prints the board out without any markers
    {
	for(int i = 3; i >=0; i--)
            {

                for(int j = 0; j <4; j++)
                    {

                        for(int k = 0; k <4; k++)
                            {
                                System.out.printf("%1d ", board[i][j][k]);
                            }
                        System.out.printf("\n");
                    }
                System.out.printf("\n");
            }

    }

    public static char marker(int n) {
	if(n == 0)
            {
                return '_'; //if slot is unoccupied which is represented by 0, it will return an underscore
            }
        if(n== 1)
            {
                return 'O'; // if slot is occupied by user which equals 1, it will return an O
            }
        if(n == 5)
            {
                return 'X'; //if slow is occcupied by computer which equals 5, it will return an X
            }
        return '*';

    }

    public static void printBoardWithMarkers() //prints board with the markers 
    {
	for (int i = 3; i >=0; i--) 
	    {
		System.out.printf("\n");
		for (int j = 3; j>=0; j--) 
		    {
                
			for (int k = j; k>=0; k--) 
			    {
				System.out.printf(" "); 
			    }
			System.out.printf("%d%1d  ", i, j);
			for (int n = 0; n < 4; n++) 
			    {
				System.out.printf("%1c ", Character.valueOf(TTT3D.marker((int)board[i][j][n]))); //had to get the value of the character 
			    }
			System.out.printf("\n");
		    }
	    }
        System.out.printf("\n");
    }

    public static void printSums() //prints the sum of the line 
    {
        for(int i = 0; i < sums.length; i ++)
            {
                System.out.println("The sum of line " + i + "is" + sums[i]);
            }

    }

    public static boolean isEmpty(int[] arrn) //checks to see if a slot is empty
    {
        if (board[arrn[0]][arrn[1]][arrn[2]] == 0) {
            return true;
        }
        return false;
    }

    public static void move(int[] celAdr, int val) //places a move on the board through cell adr
    {
        TTT3D.move((int)celAdr[0], (int)celAdr[1], (int)celAdr[2], val);
    }

    public static void move(int lev, int row, int col, int val) //places a move on the board at certain coordinates 
    {
        TTT3D.board[lev][row][col] = val;
    }

    public static void setAll(int n) //clears board to a specific value 
    {
        for(int i = 0; i < 4; i ++)
            {
                for( int j = 0; j<4; j++)
                    {
                        for(int k = 0; k<4; k++)
                            {
                                TTT3D.move(i,j,k,n);
                            }
                    }
            }

    }

    public static boolean isEqual(int[] arrn, int[] arrn2) //checks if two cells are the same
    {
        for(int i = 0; i < arrn.length; i++)
            {
                if(arrn[i] == arrn2[i])
                    {
                        return false;
                    }

            }
        return true;

    }

    public static int[] findEmptyCell(int[][] arrn) //checks if a cell is empty in a line 
    {
        for (int i = 0; i < 4; ++i) 
	    {
		if (!TTT3D.isEmpty((int[])arrn[i]))
        
		    continue;
		return arrn[i];
        
	    }
        return null;
    }

    public static int[] findComEmptyCell(int[][] arrn, int[][] arrn2) //checks if there is an empty cell in two lines
    {
        for (int i = 0; i < arrn.length; i++) {
            for (int j = 0; j < arrn.length; j++) {
                if (!TTT3D.isEqual((int[])arrn[i], (int[])arrn2[j]) || !TTT3D.isEmpty((int[])arrn[i]) || !TTT3D.isEmpty((int[])arrn2[j])) 
		    continue;
                return arrn[i];
            }
        }
        return null;
    }

    static void compLineSums()  //computes the sums of the lines
    {
        for (int i = 0; i < sums.length; i++) 
	    {
		TTT3D.sums[i] = 0;
		for (int j = 0; j < 4; j++) 
		    {
			int[] arrn = sums;
			int n = i;
			arrn[n] = arrn[n] + board[lines[i][j][0]][lines[i][j][1]][lines[i][j][2]];
		    }
	    }
    }

    static int findLineSum(int sum) //finds a line with a specific sum
    {
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] == sum) 
		return i;
        }
        return -1; 
    }

    static int[] findFork(int n, int[][][] arrn, int[] arrn2) //checks if there is a fork within a line; two markers in a row within a line
    {
	int[] arrn3 = new int[3];
	for(int i = 0; i < arrn2.length - 1; i++)
	    {
		if(arrn2[i] != 2 * n) 
                    continue;
		for(int j = i+1; j < arrn2.length; j++)
		    {
			if (arrn2[j] != 2 * n || (arrn3 = TTT3D.findComEmptyCell((int[][])arrn[i], (int[][])arrn[j])) == null)  
			    continue;
                        return arrn3; 
		    }



	    }
	return null;
    }

   
}
