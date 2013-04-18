package graph;

import java.io.*; 
import java.net.URL; 
import java.util.Random; 

// program to solve the puzzle at http://www.hacker.org/coil/ 
public class MortalCoilSolver { 
    private static int[][] offsets = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; 
    private static char[] offNames = {'L', 'D', 'R', 'U'}; 
    private Random r = new Random(); 
    private static String name, pw; 
    private int targetFill, boardX, boardY, startX = -1, startY = -1, board[][]; 
    private String boardString; 

    public static void main(String[] args) throws Exception { 
    	/*
        if (args.length != 2) { 
            System.out.println("usage:\nMortalCoilSolver name pw\n"); 
            return; 
        } 
        */
        name = "hajitest"; pw = "hajitest"; 
        MortalCoilSolver mcs = new MortalCoilSolver(); 
        //while (true) 
        { 
            mcs.go(); 
            Thread.sleep(2000); 
        } 
    } 

    private void go() throws Exception { 
        URL u; 
        u = new URL("http://www.hacker.org/coil/index.php?name=" + name + "&password=" + pw); 
        System.out.println("http://www.hacker.org/coil/index.php?name=" + name + "&password=" + pw); 
        InputStream is = u.openStream(); 
        input2level(is); 
        System.out.println(this); 
        solve(); 
    } 

    public String toString() { 
        String s = ""; 
        for (int j = 0; j < boardY; j++) { 
            for (int i = 0; i < boardX; i++) { 
                s += board[i][j] > 0 ? 'X' : '.'; 
            } 
            if (j < boardY - 1) s += '\n'; 
        } 
        return s; 
    } 

    public boolean solve() throws Exception { 
        String path = findSolutionPath(); 
        System.out.println("solved at (" + startX + ", " + startY + ") : " + path); 
        URL u; 
        u = new URL("http://www.hacker.org/coil/index.php?name=" + name + 
                "&password=" + pw + "&path=" + path + "&x=" + startX + "&y=" + startY); 
        InputStream is = u.openStream(); 
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        while ((in.readLine()) != null) { } 
        is.close(); 
        return false; 
    } 
    
    private String findSolutionPath() { 
        while (true) { // search until done 
            parseBoardString(); // reset board 
            startX = r.nextInt(boardX); startY = r.nextInt(boardY); // random start 
            if (!goodSquare(startX, startY)) continue; 
            int x = startX, y = startY, fill = 1; 
            String path = ""; // remember our path 
            loop: while (true) { 
                int tdir = r.nextInt(4); // choose random direction 
                for (int dloop = 0; dloop < 3; dloop++) { 
                    int dir = (dloop + tdir) % 4; 
                    int offx = offsets[dir][0]; 
                    int offy = offsets[dir][1]; 
                    if (!goodSquare(x + offx, y + offy)) continue; // blocked 
                    path += offNames[dir]; 
                    while (true) { // move until we hit something 
                        board[x][y] = 2; 
                        x += offx; y += offy; 
                        if (!goodSquare(x, y)) break; 
                        if (++fill == targetFill) return path; // got it 
                    } 
                    x -= offx; y -= offy; // we went one too far! 
                    continue loop; 
                } 
                break; 
            }
        } 
    } 
    
    private boolean goodSquare(int x, int y) { 
        if (x < 0 || y < 0 || x >= boardX || y >= boardY) return false; 
        return (board[x][y] == 0); 
    } 
    
    private void input2level(InputStream is) throws IOException { 
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String line; 
        while ((line = in.readLine()) != null) { 
            if (!line.contains("<param name=\"FlashVars\"")) continue; 
            line = line.split("\"")[3]; // get just the value 
            String[] ss = line.split("(=|&)"); // split up the name value pairs 
            boardX = Integer.parseInt(ss[1]); boardY = Integer.parseInt(ss[3]); 
            board = new int[boardX][boardY]; 
            boardString = ss[5]; 
            parseBoardString(); 
        } 
        in.close(); 
    } 

    private void parseBoardString() { 
        int cnt = 0; 
        for (int x = 0; x < boardX; x++) 
            for (int y = 0; y < boardY; y++) { 
                int a = boardString.charAt(x + y * boardX) == 'X' ? 1 : 0;
                board[x][y] = a; 
                cnt += a; 
            } 
        targetFill = (boardX * boardY) - cnt; // how many squares we need to fill 
    } 
} 
