public class Cell{
   private int row;
   private int col;
   private boolean alive;
   
   public Cell(int r, int c){
      row = r;
      col = c;
      alive = false;
   }
   public Cell(int r, int c, boolean a){
      row = r;
      col = c;
      alive = a;
   }
   public int getRow(){
      return row;
   }
   public int getCol(){
      return col;
   }
   public boolean getAlive()
   {
      return alive;
   }
   public String toString()
   {
      // String s= "[";
      // s = s + row + ", ";
      // s = s + col;
      // s = s + "]";
      if(alive){
         return "1";
      }
      else{
         return "0";
      }
   }
	public void kill()
	{
		alive = false;
	}
	public void revive()
	{
		alive = true;
	}
}