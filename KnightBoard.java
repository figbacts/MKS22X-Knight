public class KnightBoard{
  private int board[][];
  //private int move[][];
  public KnightBoard(int startingRows, int startingCols){
    //if (startingCols <= 0 || startingRows <= 0){
    //  throw new IllegalArgumentException e;
    //}
  board = new int[startingRows][startingCols];
  //move = new int[2][2];
  //move[0][0] = 1;
  //move[0][1] = -1;
  //move[1][0] = 2;
  //move[1][1] = -2;
}
  public String toString(){
    String ans = "";
    for(int r = 0; r < board.length; r ++){
      for(int c = 0; c <board[r].length; c ++){
        if (board[r][c] == 0){
          ans += "  _";
        }
        if (board[r][c] < 10 && board[r][c] > 0){
          ans += "  " + board[r][c];
        }
        if (board[r][c] > 9){
          ans += " " + board[r][c];
        }
      }
    ans += "\n";
    }
    //ans += move[0][0] + move[0][1] + move[1][0] + move[1][1];
    return ans;
  }

  public boolean solve(int startingRows, int startingCols){
    board[startingRows][startingCols] = 1;
    return helper(startingRows, startingCols, 2);
  }
  public boolean helper(int row, int col, int index){
    return true;
  }
  private boolean add(int row, int col, int index){
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length){
      return false;
    }
    board[row][col] = index;
    return true;
  }
  private boolean remove(int row, int col){
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length){
      return false;
    }
    board[row][col] = 0;
    return true;
  }
  public static void main(String[] args) {
    KnightBoard board = new KnightBoard(5,5);
    board.add(0,0,1);
    board.add(0,1,21);
    //board.remove(0,1);
    System.out.println(board);
  }
}
