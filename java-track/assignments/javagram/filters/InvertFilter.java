package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class InvertFilter implements Filter{

	@Override
	public Picture process(Picture original) {
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          int newRed = 255 - r;
	          int newGreen = 255 - g;
	          int newBlue = 255 - b;
	          
	          Color color = new Color(newRed, newGreen, newBlue);
	          processed.set(i, j, color);  
	      }
	    }
		
		return processed;
	}

}
