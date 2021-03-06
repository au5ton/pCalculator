//
//  Count.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.pcalculator.function;

import com.ruthlessphysics.util.Debug;

public class Count
{
  /* Count
  // Used for counting, duh
  */
  public static String calculate(String[] c)
  {
    String r = ""; //Result
    try
    {
      double from = Double.parseDouble(c[0]); //Supposedly a smaller number
      double to = Double.parseDouble(c[1]); //Supposedly a larger number
      double inc = Double.parseDouble(c[2]); //Doesn't matter the size
      r += "Counting from "+from+" to "+to+", incrementing "+inc+" each time...\n\n";
      for(double i = from; i < to; i += inc)
      {
          r += Double.toString(i)+", ";
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      Debug.displayError(e);
    }
    return r;
  }
}
