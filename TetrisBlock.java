package tetris;

import java.awt.Color;

/**
 *
 * @author MY
 */
public class TetrisBlock 
{
  private int[][] shape;
  private Color color;
  private int X;
  private int Y;
  private int shapes[][][];
  private int currentRotation;
  public TetrisBlock(int[][] shape, Color color)
  {
      this.shape=shape;
      this.color=color;
      initShapes();
  }
  private void initShapes()
  {
      shapes= new int[4][][];
      for(int i=0;i<4;i++)
      {
          int r=shape[0].length;
          int c=shape.length;
          shapes[i]=new int[r][c];
          for(int y=0;y<r;y++)
          {
              for(int x=0;x<c;x++)
              {
                  shapes[i][y][x]=shape [c-x-1][y];
              }
          }
          shape=shapes[i];
      }
  }
  public void spawn(int gridWidth)
  {   
      currentRotation=0;
      shape=shapes[currentRotation];
      Y=-getHeight();
      X= (gridWidth-getWidth())/2;
  }
  public int[][] getShape(){return shape;}
  public Color getColor(){return color;}
  public int getHeight(){return shape.length;}
  public int getWidth(){return shape[0].length;}
  public int getX(){return X;}
  public int getY(){return Y;}
  public void moveDown(){Y++;}
  public void moveRight(){X++;}
  public void moveLeft(){X--;}
  public void rotate()
  {
      currentRotation++;
      if(currentRotation>3)currentRotation=0;
      shape=shapes[currentRotation];
      
  }
  public int getBottomEdge(){return Y + getHeight();}
  public int getLeftEdge(){return X;}
  // same as getX() but to increase the maintainability of the code and to 
  // enhance the readability of the code and to make it self explanatory
  public int getRightEdge(){return (X + getWidth());}
}
