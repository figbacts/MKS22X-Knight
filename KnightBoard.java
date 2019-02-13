public class KnightBoard{
  private int board[][];
  public KnightBoard(int startingRows, int startingCols){
    //if (startingCols <= 0 || startingRows <= 0){
    //  throw new IllegalArgumentException e;
    //}
  board = new int[startingRows][startingCols];
  for(int r = 0; r < board.length; r ++){
    for(int c = 0; c <board[r].length; c ++){
      board[r][c] = r + 2 *c;
  }
}
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
    return ans;
  }
  public static void main(String[] args) {
    KnightBoard board = new KnightBoard(5,5);
    System.out.println(board);
  }
}
