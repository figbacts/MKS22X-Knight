public class KnightBoard{
  private int board[][];
  private int move[][];
  private int opt[][];
  private int optmove[][];


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
  opt = new int [startingRows][startingCols];
  optmove = new int[3][8];
for(int r = 0; r < startingRows; r ++){
  for (int c = 0; c < startingCols; c ++){
    if ((r - 2 < 0) || r + 2 >= startingRows || c - 2 < 0 || c + 2 >= startingCols){
      int placement = 0;
      for (int m = 0; m < 8; m ++){
        if (add(r + move[0][m], c + move[1][m],0)){
          placement += 1;
          remove(r+move[0][m],c+move[1][m]);
        }
        opt[r][c] = placement;
      }
      //opt[r][c]= 9;
    }
  }


}
//opt[0][0] = 10;
for(int r = 0; r < startingRows; r ++){
  for (int c = 0; c < startingCols; c ++){
    if (opt[r][c] == 0){
      opt[r][c] =8;
    }
}
}
}
  public String toString(){
    String ans = "";
    for(int r = 0; r < opt.length; r ++){
      for(int c = 0; c <opt[r].length; c ++){
        if (opt[r][c] == 0){
          ans += "  _";
        }
        if (opt[r][c] < 10 && opt[r][c] > 0){
          ans += "  " + opt[r][c];
        }
        if (opt[r][c] > 9 || opt[r][c] < 0){
          ans += " " + opt[r][c];
        }
      }
    ans += "\n";
    }
    //ans += move[0][0] + move[0][1] + move[1][0] + move[1][1];
    return ans;
  }

  public boolean solve(int startingRows, int startingCols){
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if (board[row][col] != 0) {
          throw new IllegalStateException("Invalid Board");
        }
      }
    }
    if (startingCols < 0 || startingRows < 0 || startingRows > board.length-1 || startingCols > board[0].length-1) {
      throw new IllegalArgumentException("Invalid parameters");
    }
    add(startingRows, startingCols, 1);
    return helper(startingRows, startingCols, 2);
  }
  public boolean helper(int row, int col, int index){
    if (index > board.length * board[0].length){
      return true;
    }

    for (int i = 0; i < 8; i ++){
      //System.out.println(Text.go(1,1));
      //System.out.println(this);Text.wait(1);
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
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if (board[row][col] != 0) {
          throw new IllegalStateException("Invalid Board");
        }
      }
    }
    add(startingRows, startingCols, 1);
    return helper1(startingRows, startingCols,2,0);
  }
  private int helper1(int row, int col, int index, int ans ){
    if (index > board.length * board[0].length){
      remove(row,col);
      return ans + 1;
    }
    //for (int i =0; i < 8; i ++){
    //  if (add(row + move[0][i], col + move[1][i], index)){
    //    optmove[]
    //}
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
    for (int m = 0; m < 8; m ++){
      if ((row + move[0][m] < 0 || col + move[1][m] < 0 || row + move[0][m]>= board.length || col + move[1][m]>= board[0].length)){

      }
      else{
        opt[row + move[0][m]][col + move[1][m]] -= 1;
      }
    }
    return true;
  }
  private boolean remove(int row, int col){
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length){
      return false;
    }
    board[row][col] = 0;
    for (int m = 0; m < 8; m ++){
      if ((row + move[0][m] < 0 || col + move[1][m] < 0 || row + move[0][m]>= board.length || col + move[1][m]>= board[0].length)){

      }
      else{
        opt[row + move[0][m]][col + move[1][m]] += 1;
      }
    }
    return true;
  }
  private static void insertionSort(int [] ary){
    int spotholder = 0;
    for (int i = 1; i < ary.length; i ++){
      spotholder = ary[i];
      int c = i-1;
      while(c > -1 && spotholder < ary[c]){
        ary[c+1]= ary[c];
        c--;
        }
        ary[c+1] = spotholder;
      }
      }
  public static void main(String[] args) {
    runTest(0);
    runTest(1);
    runTest(2);
    runTest(3);
    runTest(4);
    //KnightBoard board = new KnightBoard(5,5);
    //System.out.println(board.add(0 + board.move[0][5],0 + board.move[1][5],1));
    //System.out.println(board.solve(0,0));
    //System.out.println(board.countSolutions(0,0));
    //System.out.println(board);
    //runTest(2);
  }
  public static void runTest(int i){

  KnightBoard b;
  int[]m =   {4,5,5,5,5};
  int[]n =   {4,5,4,5,5};
  int[]startx = {0,0,0,1,2};
  int[]starty = {0,0,0,1,2};
  int[]answers = {0,304,32,56,64};
  if(i >= 0 ){
    try{
      int correct = answers[i];
      b = new KnightBoard(m[i%m.length],n[i%m.length]);

      int ans  = b.countSolutions(startx[i],starty[i]);

      if(correct==ans){
        System.out.println("PASS board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans);
      }else{
        System.out.println("FAIL board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans+" vs "+correct);
      }
    }catch(Exception e){
      System.out.println("FAIL Exception case: "+i);

    }
  }
}
}
