public class KnightBoard{
  private int board[][];
  public int move[][];
  public KnightBoard(int startingRows, int startingCols){
    //if (startingCols <= 0 || startingRows <= 0){
    //  throw new IllegalArgumentException e;
    //}
  board = new int[startingRows][startingCols];
  move = new int[2][8];
  move[0][0] = -2;
  move[0][1] = -2;
  move[0][2] = -1;
  move[0][3] = -1;
  move[0][4] =  1;
  move[0][5] =  1;
  move[0][6] =  2;
  move[0][7] =  2;

  move[1][0] = -1;
  move[1][1] =  1;
  move[1][2] = -2;
  move[1][3] =  2;
  move[1][4] = -2;
  move[1][5] =  2;
  move[1][6] = -1;
  move[1][7] =  1;
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
    add(startingRows, startingCols, 1);
    return helper(startingRows, startingCols, 2);
  }
  public boolean helper(int row, int col, int index){
    if (index > board.length * board[0].length){
      return true;
    }
    for (int i = 0; i < 8; i ++){
      System.out.println(Text.go(1,1));
      System.out.println(this);Text.wait(1);
      if (add(row + move[0][i], col + move[1][i], index)){
        if (helper(row + move[0][i], col + move[1][i], index + 1)){
          //System.out.println(Text.go(1,1));
          //System.out.println(this);Text.wait(50); //adjust this delay
          return true;
        }
      remove(row+move[0][i],col+move[1][i]);
      }
      //remove(row,col);
    }
    return false;
  }
  public int countSolutions(int startingRows, int startingCols){
    add(startingRows, startingCols, 1);
    return helper1(startingRows, startingCols,2,0);
  }
  private int helper1(int row, int col, int index, int ans ){
    if (index > board.length * board[0].length){
      remove(row,col);
      return ans + 1;
    }
    for (int i = 0; i < 8; i ++){
      //System.out.println(Text.go(1,1));
      //System.out.println(this);Text.wait(1);
      if (add(row + move[0][i], col + move[1][i], index)){
        ans = helper1(row + move[0][i], col + move[1][i], index + 1,ans);
        remove(row+move[0][i],col+move[1][i]);
    }
  }
  remove(row,col);
  return ans;
}
  private boolean add(int row, int col, int index){
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length){
      return false;
    }
    if (board[row][col] != 0){
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
    //System.out.println(board.add(0 + board.move[0][5],0 + board.move[1][5],1));
    //System.out.println(board.solve(0,0));
    System.out.println(board.countSolutions(0,0));
    System.out.println(board);
  }
}
