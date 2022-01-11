import processing.core.PApplet;

public class Sketch extends PApplet {
	
	float[] snowY = new float [50];
  float[] snowFallen = new float [400];
  int [] snowMouseX = new int [25];
  int [] snowMouseY = new int [25];
  

  
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(25, 25, 112);

    for (int i = 0; i < snowFallen.length; i++){
      snowFallen[i] = 400;
    }
    
    for (int i = 0; i < snowY.length; i++){
      snowY[i] = random(height);
    }

   
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    background(25, 25, 112);
	  
    for (int i = 0; i < snowY.length; i++){
      float snowX = width * i/snowY.length;
      noStroke();
      ellipse (snowX, snowY[i], 5, 5);
      

      snowY[i] += 2;

      if (keyPressed){
        if (keyCode == UP){
          snowY[i] -= 1;
        }
        else if (keyCode == DOWN){
          snowY[i] += 3;
        }
      }
      
      for(int j = 0; j < snowFallen.length; j++){
       fill(192, 192, 192);
       rect (j, snowFallen[j], 5, height - snowFallen[j]);  
       if (snowY[i] > height && j == snowX){
         snowFallen[j]-= 2;
       }
     

      }
      if (snowY[i] > height){
        snowY[i] = 0;       
      }
  
    }
    for (int k = 24; k > 0; k--){
      snowMouseX[k] = snowMouseX[k - 1];
      snowMouseY[k] = snowMouseY[k - 1];
    }

    snowMouseX[0] = mouseX;
    snowMouseY[0] = mouseY;

    for (int k = 0; k < snowMouseX.length; k++){
      ellipse(snowMouseX[k], snowMouseY[k], 26 - k, 26 - k);
    }
    
  }
  
}