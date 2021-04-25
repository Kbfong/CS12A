import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

/*
 * Exception performing whole class analysis ignored.
 */
class TTT3Dp {
    static int[][][] board = new int[4][4][4];
    static int[] sums = new int[76];
    static final int[][][] lines = new int[][][]{{{0, 0, 0}, {0, 0, 1}, {0, 0, 2}, {0, 0, 3}}, {{0, 1, 0}, {0, 1, 1}, {0, 1, 2}, {0, 1, 3}}, {{0, 2, 0}, {0, 2, 1}, {0, 2, 2}, {0, 2, 3}}, {{0, 3, 0}, {0, 3, 1}, {0, 3, 2}, {0, 3, 3}}, {{1, 0, 0}, {1, 0, 1}, {1, 0, 2}, {1, 0, 3}}, {{1, 1, 0}, {1, 1, 1}, {1, 1, 2}, {1, 1, 3}}, {{1, 2, 0}, {1, 2, 1}, {1, 2, 2}, {1, 2, 3}}, {{1, 3, 0}, {1, 3, 1}, {1, 3, 2}, {1, 3, 3}}, {{2, 0, 0}, {2, 0, 1}, {2, 0, 2}, {2, 0, 3}}, {{2, 1, 0}, {2, 1, 1}, {2, 1, 2}, {2, 1, 3}}, {{2, 2, 0}, {2, 2, 1}, {2, 2, 2}, {2, 2, 3}}, {{2, 3, 0}, {2, 3, 1}, {2, 3, 2}, {2, 3, 3}}, {{3, 0, 0}, {3, 0, 1}, {3, 0, 2}, {3, 0, 3}}, {{3, 1, 0}, {3, 1, 1}, {3, 1, 2}, {3, 1, 3}}, {{3, 2, 0}, {3, 2, 1}, {3, 2, 2}, {3, 2, 3}}, {{3, 3, 0}, {3, 3, 1}, {3, 3, 2}, {3, 3, 3}}, {{0, 0, 0}, {0, 1, 0}, {0, 2, 0}, {0, 3, 0}}, {{0, 0, 1}, {0, 1, 1}, {0, 2, 1}, {0, 3, 1}}, {{0, 0, 2}, {0, 1, 2}, {0, 2, 2}, {0, 3, 2}}, {{0, 0, 3}, {0, 1, 3}, {0, 2, 3}, {0, 3, 3}}, {{1, 0, 0}, {1, 1, 0}, {1, 2, 0}, {1, 3, 0}}, {{1, 0, 1}, {1, 1, 1}, {1, 2, 1}, {1, 3, 1}}, {{1, 0, 2}, {1, 1, 2}, {1, 2, 2}, {1, 3, 2}}, {{1, 0, 3}, {1, 1, 3}, {1, 2, 3}, {1, 3, 3}}, {{2, 0, 0}, {2, 1, 0}, {2, 2, 0}, {2, 3, 0}}, {{2, 0, 1}, {2, 1, 1}, {2, 2, 1}, {2, 3, 1}}, {{2, 0, 2}, {2, 1, 2}, {2, 2, 2}, {2, 3, 2}}, {{2, 0, 3}, {2, 1, 3}, {2, 2, 3}, {2, 3, 3}}, {{3, 0, 0}, {3, 1, 0}, {3, 2, 0}, {3, 3, 0}}, {{3, 0, 1}, {3, 1, 1}, {3, 2, 1}, {3, 3, 1}}, {{3, 0, 2}, {3, 1, 2}, {3, 2, 2}, {3, 3, 2}}, {{3, 0, 3}, {3, 1, 3}, {3, 2, 3}, {3, 3, 3}}, {{0, 0, 0}, {1, 0, 0}, {2, 0, 0}, {3, 0, 0}}, {{0, 0, 1}, {1, 0, 1}, {2, 0, 1}, {3, 0, 1}}, {{0, 0, 2}, {1, 0, 2}, {2, 0, 2}, {3, 0, 2}}, {{0, 0, 3}, {1, 0, 3}, {2, 0, 3}, {3, 0, 3}}, {{0, 1, 0}, {1, 1, 0}, {2, 1, 0}, {3, 1, 0}}, {{0, 1, 1}, {1, 1, 1}, {2, 1, 1}, {3, 1, 1}}, {{0, 1, 2}, {1, 1, 2}, {2, 1, 2}, {3, 1, 2}}, {{0, 1, 3}, {1, 1, 3}, {2, 1, 3}, {3, 1, 3}}, {{0, 2, 0}, {1, 2, 0}, {2, 2, 0}, {3, 2, 0}}, {{0, 2, 1}, {1, 2, 1}, {2, 2, 1}, {3, 2, 1}}, {{0, 2, 2}, {1, 2, 2}, {2, 2, 2}, {3, 2, 2}}, {{0, 2, 3}, {1, 2, 3}, {2, 2, 3}, {3, 2, 3}}, {{0, 3, 0}, {1, 3, 0}, {2, 3, 0}, {3, 3, 0}}, {{0, 3, 1}, {1, 3, 1}, {2, 3, 1}, {3, 3, 1}}, {{0, 3, 2}, {1, 3, 2}, {2, 3, 2}, {3, 3, 2}}, {{0, 3, 3}, {1, 3, 3}, {2, 3, 3}, {3, 3, 3}}, {{0, 0, 0}, {0, 1, 1}, {0, 2, 2}, {0, 3, 3}}, {{0, 3, 0}, {0, 2, 1}, {0, 1, 2}, {0, 0, 3}}, {{1, 0, 0}, {1, 1, 1}, {1, 2, 2}, {1, 3, 3}}, {{1, 3, 0}, {1, 2, 1}, {1, 1, 2}, {1, 0, 3}}, {{2, 0, 0}, {2, 1, 1}, {2, 2, 2}, {2, 3, 3}}, {{2, 3, 0}, {2, 2, 1}, {2, 1, 2}, {2, 0, 3}}, {{3, 0, 0}, {3, 1, 1}, {3, 2, 2}, {3, 3, 3}}, {{3, 3, 0}, {3, 2, 1}, {3, 1, 2}, {3, 0, 3}}, {{0, 0, 0}, {1, 0, 1}, {2, 0, 2}, {3, 0, 3}}, {{3, 0, 0}, {2, 0, 1}, {1, 0, 2}, {0, 0, 3}}, {{0, 1, 0}, {1, 1, 1}, {2, 1, 2}, {3, 1, 3}}, {{3, 1, 0}, {2, 1, 1}, {1, 1, 2}, {0, 1, 3}}, {{0, 2, 0}, {1, 2, 1}, {2, 2, 2}, {3, 2, 3}}, {{3, 2, 0}, {2, 2, 1}, {1, 2, 2}, {0, 2, 3}}, {{0, 3, 0}, {1, 3, 1}, {2, 3, 2}, {3, 3, 3}}, {{3, 3, 0}, {2, 3, 1}, {1, 3, 2}, {0, 3, 3}}, {{0, 0, 0}, {1, 1, 0}, {2, 2, 0}, {3, 3, 0}}, {{3, 0, 0}, {2, 1, 0}, {1, 2, 0}, {0, 3, 0}}, {{0, 0, 1}, {1, 1, 1}, {2, 2, 1}, {3, 3, 1}}, {{3, 0, 1}, {2, 1, 1}, {1, 2, 1}, {0, 3, 1}}, {{0, 0, 2}, {1, 1, 2}, {2, 2, 2}, {3, 3, 2}}, {{3, 0, 2}, {2, 1, 2}, {1, 2, 2}, {0, 3, 2}}, {{0, 0, 3}, {1, 1, 3}, {2, 2, 3}, {3, 3, 3}}, {{3, 0, 3}, {2, 1, 3}, {1, 2, 3}, {0, 3, 3}}, {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}, {3, 3, 3}}, {{3, 0, 0}, {2, 1, 1}, {1, 2, 2}, {0, 3, 3}}, {{0, 3, 0}, {1, 2, 1}, {2, 1, 2}, {3, 0, 3}}, {{3, 3, 0}, {2, 2, 1}, {1, 1, 2}, {0, 0, 3}}};

    TTT3D() {
    }

    static void printBoardRaw() {
        for (int i = 3; i >= 0; --i) {
            for (int j = 3; j >= 0; --j) {
                for (int k = 0; k < 4; ++k) {
                    System.out.printf("%1d ", board[i][j][k]);
                }
                System.out.printf("\n", new Object[0]);
            }
            System.out.printf("\n", new Object[0]);
        }
    }

    static char marker(int n) {
        switch (n) {
	case 0: {
	    return '_';
	}
	case 1: {
	    return 'O';
	}
	case 5: {
	    return 'X';
	}
        }
        return '?';
    }

    static void printBoardMarkers() {
        for (int i = 3; i >= 0; --i) {
            System.out.printf("\n", new Object[0]);
            for (int j = 3; j >= 0; --j) {
                int n;
                for (n = j; n >= 0; --n) {
                    System.out.printf(" ", new Object[0]);
                }
                System.out.printf("%d%1d  ", i, j);
                for (n = 0; n < 4; ++n) {
                    System.out.printf("%1c ", Character.valueOf(TTT3D.marker((int)board[i][j][n])));
                }
                System.out.printf("\n", new Object[0]);
            }
        }
        System.out.printf("\n   0 1 2 3\n", new Object[0]);
    }

    static void printSums() {
        for (int i = 0; i < sums.length; ++i) {
            System.out.println("line " + i + "is " + sums[i]);
        }
    }

    static boolean isEmpty(int[] arrn) {
        if (board[arrn[0]][arrn[1]][arrn[2]] == 0) {
            return true;
        }
        return false;
    }

    static void move(int[] arrn, int n) {
        TTT3D.move((int)arrn[0], (int)arrn[1], (int)arrn[2], (int)n);
    }

    static void move(int n, int n2, int n3, int n4) {
        TTT3D.board[n][n2][n3] = n4;
    }

    static void setAll(int n) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    TTT3D.move((int)i, (int)j, (int)k, (int)n);
                }
            }
        }
    }

    static boolean isEqual(int[] arrn, int[] arrn2) {
        for (int i = 0; i < arrn.length; ++i) {
            if (arrn[i] == arrn2[i]) continue;
            return false;
        }
        return true;
    }

    static int[] findEmptyCel(int[][] arrn) {
        for (int i = 0; i < 4; ++i) {
            if (!TTT3D.isEmpty((int[])arrn[i])) continue;
            return arrn[i];
        }
        return null;
    }

    static int[] findComMtCel(int[][] arrn, int[][] arrn2) {
        for (int i = 0; i < arrn.length; ++i) {
            for (int j = 0; j < arrn.length; ++j) {
                if (!TTT3D.isEqual((int[])arrn[i], (int[])arrn2[j]) || !TTT3D.isEmpty((int[])arrn[i]) || !TTT3D.isEmpty((int[])arrn2[j])) continue;
                return arrn[i];
            }
        }
        return null;
    }

    static void compLineSums() {
        for (int i = 0; i < sums.length; ++i) {
            TTT3D.sums[i] = 0;
            for (int j = 0; j < 4; ++j) {
                int[] arrn = sums;
                int n = i;
                arrn[n] = arrn[n] + board[lines[i][j][0]][lines[i][j][1]][lines[i][j][2]];
            }
        }
    }

    static int findLineSum(int n) {
        for (int i = 0; i < sums.length; ++i) {
            if (sums[i] != n) continue;
            return i;
        }
        return -1;
    }

    static int[] findFork(int n, int[][][] arrn, int[] arrn2) {
        int[] arrn3 = new int[3];
        for (int i = 0; i < arrn2.length - 1; ++i) {
            if (arrn2[i] != 2 * n) continue;
            for (int j = i + 1; j < arrn2.length; ++j) {
                if (arrn2[j] != 2 * n || (arrn3 = TTT3D.findComMtCel((int[][])arrn[i], (int[][])arrn[j])) == null) continue;
                return arrn3;
            }
        }
        return null;
    }

    public static void main(String[] arrstring) throws FileNotFoundException {
        int n;
        int n2;
        int n3;
        int n4;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(1234);
        int[] arrn = new int[3];
        int[] arrn2 = new int[3];
        int[] arrn3 = new int[3];
        int n5 = 0;
        if (arrstring.length != 0) {
            System.out.println("getting initial setup from file");
            Scanner scanner2 = new Scanner(new FileInputStream(arrstring[0]));
            n3 = scanner2.nextInt();
            for (n4 = 0; n4 < n3; ++n4) {
                n = scanner2.nextInt() % 4;
                n2 = scanner2.nextInt() % 4;
                int n6 = scanner2.nextInt() % 4;
                int n7 = scanner2.nextInt();
                TTT3D.move((int)n, (int)n2, (int)n6, (int)n7);
            }
        } else {
            TTT3D.setAll((int)0);
        }
        boolean bl = false;
        while (!bl) {
            TTT3D.printBoardMarkers();
            n3 = 0;
            while (n3 == 0) {
                System.out.println("Type your move as one three digit number(lrc)");
                n4 = scanner.nextInt();
                arrn2[2] = n4 % 10 % 4;
                arrn2[1] = n4 / 10 % 10 % 4;
                arrn2[0] = n4 / 100 % 4;
                if (TTT3D.isEmpty((int[])arrn2)) {
                    n3 = 1;
                    TTT3D.move((int[])arrn2, (int)5);
                    continue;
                }
                System.out.println("Sorry that cell is occupied.");
            }
            TTT3D.compLineSums();
            if (TTT3D.findLineSum((int)20) != -1) {
                TTT3D.printBoardMarkers();
                System.out.println("Congradulations you won!");
                bl = true;
                continue;
            }
            n5 = TTT3D.findLineSum((int)3);
            if (n5 != -1) {
                TTT3D.move((int[])TTT3D.findEmptyCel((int[][])lines[n5]), (int)1);
                TTT3D.printBoardMarkers();
                System.out.println("Computer wins again!");
                bl = true;
                continue;
            }
            n5 = TTT3D.findLineSum((int)15);
            if (n5 != -1) {
                TTT3D.move((int[])TTT3D.findEmptyCel((int[][])lines[n5]), (int)1);
                continue;
            }
            arrn = TTT3D.findFork((int)1, (int[][][])lines, (int[])sums);
            if (arrn != null) {
                TTT3D.move((int[])arrn, (int)1);
                continue;
            }
            arrn = TTT3D.findFork((int)5, (int[][][])lines, (int[])sums);
            if (arrn != null) {
                TTT3D.move((int[])arrn, (int)1);
                continue;
            }
            n4 = random.nextInt(sums.length);
            n = 0;
            for (n2 = 0; n2 < sums.length && n == 0; ++n2) {
                switch (sums[n4]) {
		case 0: 
		case 1: 
		case 2: 
		case 5: 
		case 10: {
		    n = 1;
		    TTT3D.move((int[])TTT3D.findEmptyCel((int[][])lines[n4]), (int)1);
		}
                }
                n4 = (n4 + 1) % sums.length;
            }
            if (n != 0) continue;
            System.out.println("game is a draw");
            bl = true;
        }
    }

    static {
    } {1, 3, 1}, {2, 3, 2}, {3, 3, 3}}, {{3, 3, 0}, {2, 3, 1}, {1, 3, 2}, {0, 3, 3}}, {{0, 0, 0}, {1, 1, 0}, {2, 2, 0}, {3, 3, 0}}, {{3, 0, 0}, {2, 1, 0}, {1, 2, 0}, {0, 3, 0}}, {{0, 0, 1}, {1, 1, 1}, {2, 2, 1}, {3, 3, 1}}, {{3, 0, 1}, {2, 1, 1}, {1, 2, 1}, {0, 3, 1}}, {{0, 0, 2}, {1, 1, 2}, {2, 2, 2}, {3, 3, 2}}, {{3, 0, 2}, {2, 1, 2}, {1, 2, 2}, {0, 3, 2}}, {{0, 0, 3}, {1, 1, 3}, {2, 2, 3}, {3, 3, 3}}, {{3, 0, 3}, {2, 1, 3}, {1, 2, 3}, {0, 3, 3}}, {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}, {3, 3, 3}}, {{3, 0, 0}, {2, 1, 1}, {1, 2, 2}, {0, 3, 3}}, {{0, 3, 0}, {1, 2, 1}, {2, 1, 2}, {3, 0, 3}}, {{3, 3, 0}, {2, 2, 1}, {1, 1, 2}, {0, 0, 3}}};

TTT3D() {
}

static void printBoardRaw() {
    for (int i = 3; i >= 0; --i) {
	for (int j = 3; j >= 0; --j) {
	    for (int k = 0; k < 4; ++k) {
		System.out.printf("%1d ", board[i][j][k]);
	    }
	    System.out.printf("\n", new Object[0]);
	}
	System.out.printf("\n", new Object[0]);
    }
}

static char marker(int n) {
    switch (n) {
    case 0: {
	return '_';
    }
    case 1: {
	return 'O';
    }
    case 5: {
	return 'X';
    }
    }
    return '?';
}

static void printBoardMarkers() {
    for (int i = 3; i >= 0; --i) {
	System.out.printf("\n", new Object[0]);
	for (int j = 3; j >= 0; --j) {
	    int n;
	    for (n = j; n >= 0; --n) {
		System.out.printf(" ", new Object[0]);
	    }
	    System.out.printf("%d%1d  ", i, j);
	    for (n = 0; n < 4; ++n) {
		System.out.printf("%1c ", Character.valueOf(TTT3D.marker((int)board[i][j][n])));
	    }
	    System.out.printf("\n", new Object[0]);
	}
    }
    System.out.printf("\n   0 1 2 3\n", new Object[0]);
}

static void printSums() {
    for (int i = 0; i < sums.length; ++i) {
	System.out.println("line " + i + "is " + sums[i]);
    }
}

static boolean isEmpty(int[] arrn) {
    if (board[arrn[0]][arrn[1]][arrn[2]] == 0) {
	return true;
    }
    return false;
}

static void move(int[] arrn, int n) {
    TTT3D.move((int)arrn[0], (int)arrn[1], (int)arrn[2], (int)n);
}

static void move(int n, int n2, int n3, int n4) {
    TTT3D.board[n][n2][n3] = n4;
}

static void setAll(int n) {
    for (int i = 0; i < 4; ++i) {
	for (int j = 0; j < 4; ++j) {
	    for (int k = 0; k < 4; ++k) {
		TTT3D.move((int)i, (int)j, (int)k, (int)n);
	    }
	}
    }
}

static boolean isEqual(int[] arrn, int[] arrn2) {
    for (int i = 0; i < arrn.length; ++i) {
	if (arrn[i] == arrn2[i]) continue;
	return false;
    }
    return true;
}

static int[] findEmptyCel(int[][] arrn) {
    for (int i = 0; i < 4; ++i) {
	if (!TTT3D.isEmpty((int[])arrn[i])) continue;
	return arrn[i];
    }
    return null;
}

static int[] findComMtCel(int[][] arrn, int[][] arrn2) {
    for (int i = 0; i < arrn.length; ++i) {
	for (int j = 0; j < arrn.length; ++j) {
	    if (!TTT3D.isEqual((int[])arrn[i], (int[])arrn2[j]) || !TTT3D.isEmpty((int[])arrn[i]) || !TTT3D.isEmpty((int[])arrn2[j])) continue;
	    return arrn[i];
	}
    }
    return null;
}

static void compLineSums() {
    for (int i = 0; i < sums.length; ++i) {
	TTT3D.sums[i] = 0;
	for (int j = 0; j < 4; ++j) {
	    int[] arrn = sums;
	    int n = i;
	    arrn[n] = arrn[n] + board[lines[i][j][0]][lines[i][j][1]][lines[i][j][2]];
	}
    }
}

static int findLineSum(int n) {
    for (int i = 0; i < sums.length; ++i) {
	if (sums[i] != n) continue;
	return i;
    }
    return -1;
}

static int[] findFork(int n, int[][][] arrn, int[] arrn2) {
    int[] arrn3 = new int[3];
    for (int i = 0; i < arrn2.length - 1; ++i) {
	if (arrn2[i] != 2 * n) continue;
	for (int j = i + 1; j < arrn2.length; ++j) {
	    if (arrn2[j] != 2 * n || (arrn3 = TTT3D.findComMtCel((int[][])arrn[i], (int[][])arrn[j])) == null) continue;
	    return arrn3;
	}
    }
    return null;
}

public static void main(String[] arrstring) throws FileNotFoundException {
    int n;
    int n2;
    int n3;
    int n4;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random(1234);
    int[] arrn = new int[3];
    int[] arrn2 = new int[3];
    int[] arrn3 = new int[3];
    int n5 = 0;
    if (arrstring.length != 0) {
	System.out.println("getting initial setup from file");
	Scanner scanner2 = new Scanner(new FileInputStream(arrstring[0]));
	n3 = scanner2.nextInt();
	for (n4 = 0; n4 < n3; ++n4) {
	    n = scanner2.nextInt() % 4;
	    n2 = scanner2.nextInt() % 4;
	    int n6 = scanner2.nextInt() % 4;
	    int n7 = scanner2.nextInt();
	    TTT3D.move((int)n, (int)n2, (int)n6, (int)n7);
	}
    } else {
	TTT3D.setAll((int)0);
    }
    boolean bl = false;
    while (!bl) {
	TTT3D.printBoardMarkers();
	n3 = 0;
	while (n3 == 0) {
	    System.out.println("Type your move as one three digit number(lrc)");
	    n4 = scanner.nextInt();
	    arrn2[2] = n4 % 10 % 4;
	    arrn2[1] = n4 / 10 % 10 % 4;
	    arrn2[0] = n4 / 100 % 4;
	    if (TTT3D.isEmpty((int[])arrn2)) {
		n3 = 1;
		TTT3D.move((int[])arrn2, (int)5);
		continue;
	    }
	    System.out.println("Sorry that cell is occupied.");
	}
	TTT3D.compLineSums();
	if (TTT3D.findLineSum((int)20) != -1) {
	    TTT3D.printBoardMarkers();
	    System.out.println("Congradulations you won!");
	    bl = true;
	    continue;
	}
	n5 = TTT3D.findLineSum((int)3);
	if (n5 != -1) {
	    TTT3D.move((int[])TTT3D.findEmptyCel((int[][])lines[n5]), (int)1);
	    TTT3D.printBoardMarkers();
	    System.out.println("Computer wins again!");
	    bl = true;
	    continue;
	}
	n5 = TTT3D.findLineSum((int)15);
	if (n5 != -1) {
	    TTT3D.move((int[])TTT3D.findEmptyCel((int[][])lines[n5]), (int)1);
	    continue;
	}
	arrn = TTT3D.findFork((int)1, (int[][][])lines, (int[])sums);
	if (arrn != null) {
	    TTT3D.move((int[])arrn, (int)1);
	    continue;
	}
	arrn = TTT3D.findFork((int)5, (int[][][])lines, (int[])sums);
	if (arrn != null) {
	    TTT3D.move((int[])arrn, (int)1);
	    continue;
	}
	n4 = random.nextInt(sums.length);
	n = 0;
	for (n2 = 0; n2 < sums.length && n == 0; ++n2) {
	    switch (sums[n4]) {
	    case 0: 
	    case 1: 
	    case 2: 
	    case 5: 
	    case 10: {
		n = 1;
		TTT3D.move((int[])TTT3D.findEmptyCel((int[][])lines[n4]), (int)1);
	    }
	    }
	    n4 = (n4 + 1) % sums.length;
	}
	if (n != 0) continue;
	System.out.println("game is a draw");
	bl = true;
    }
}

static {
}
