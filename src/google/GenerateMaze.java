package google;

import java.util.Stack;

// bug exists
public class GenerateMaze {
	public static class MazeCell{
		public int[] wall = {0, 0, 0, 0};
		// up, down, left, right
		// 0, 1, 2, 3
		public boolean visited = false;
		public int row = -1;
		public int col = -1;
	}
	public static int random(){
		return (int)Math.random() * 4;
	}
	public static void generateDFS(MazeCell[][] maze){
		if(maze.length == 0 || maze[0].length == 0)
			return;
		Stack<MazeCell> path = new Stack<MazeCell>();
		path.push(maze[0][0]);
		maze[0][0].visited = true;
		MazeCell cur = null;
		int direction = -1;
		boolean back = false;
		while(!path.isEmpty()){
			cur = path.peek();
			back = checkNeighbor(cur);
			if(!back){
				path.pop();
				continue;
			}
			direction = random();
			while(cur.wall[direction] == -1)// 同时需要check random出来的邻居是不是可以到达
				direction = random();
			if(direction == 0 && cur.row > 0
					&& !maze[cur.row - 1][cur.col].visited){
				cur.wall[direction] = 1;
				maze[cur.row - 1][cur.col].wall[1] = 1;
				path.push(maze[cur.row - 1][cur.col]);
			}
			else if(direction == 1 && cur.row < maze.length - 1
					&& !maze[cur.row + 1][cur.col].visited){
				cur.wall[direction] = 1;
				path.push(maze[cur.row + 1][cur.col]);
			}
			else if(direction == 2 && cur.col > 0
					&& !maze[cur.row][cur.col - 1].visited){
				cur.wall[direction] = 1;
				path.push(maze[cur.row][cur.col - 1]);
			}
			else if(direction == 3 && cur.col < maze[0].length - 1
					&& !maze[cur.row][cur.col + 1].visited){
				cur.wall[direction] = 1;
				path.push(maze[cur.row][cur.col + 1]);
			}
		}
	}
	public static boolean checkNeighbor(MazeCell cell){
		//check if neighbor is reachable
		cell.visited = true;
		return false;
	}
	public static void generateKruskal(MazeCell[][] maze){
		
	}
	public static void generatePrim(MazeCell[][] maze){

	}
}
