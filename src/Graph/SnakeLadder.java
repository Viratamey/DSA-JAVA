package Graph;

import java.util.Scanner;

public class SnakeLadder {
    int V;
    Graph graph;
    int[][] snakes;
    int[][] ladders;

    SnakeLadder(int V, int lad, int sn) {
        this.V = V;
        this.graph = new Graph(V);
        this.ladders = new int[lad][2];
        this.snakes = new int[sn][2];
    }

    static int[] createBoard(int v, int[][] ladders, int[][] snakes) {
        int[] board = new int[v];
        for(int i=0; i<ladders.length; ++i) {
            board[ladders[i][0]] = ladders[i][1]-ladders[i][0];
        }
        for(int i=0; i<snakes.length; ++i) {
            board[snakes[i][0]] = snakes[i][1]-snakes[i][0];
        }
        return board;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter number of blocks in game: ");
        int v = sc.nextInt();
        System.out.println("please enter number of ladders in game: ");
        int lad = sc.nextInt();
        System.out.println("please enter number of snakes in game: ");
        int sn = sc.nextInt();
        SnakeLadder game = new SnakeLadder(v, lad, sn);
        System.out.println("please enter ladder paths: ");
        for(int i=0; i<lad; ++i) {
            game.ladders[i][0] = sc.nextInt();
            game.ladders[i][1] = sc.nextInt();
        }
        System.out.println("please enter snake paths: ");
        for(int i=0; i<sn; ++i) {
            game.snakes[i][0] = sc.nextInt();
            game.snakes[i][1] = sc.nextInt();
        }
        int[] board = createBoard(v, game.ladders, game.snakes);
        for(int i=0; i<v; ++i) {
            if(board[i]==0){
                for(int dice=1; dice<=6; dice++){
                    if(i+dice >= 36 || i+dice+board[i+dice] >= v) {
                        continue;
                    }
                    game.graph.addEdge(i, i+dice+board[i+dice], true);
                }
            } else {
                continue;
            }
        }
        game.graph.showAdjList();
        System.out.println("#########################################################");
        game.graph.BFS(0);
    }
}
