//
//  Var.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Editted with Atom
//  https://atom.io/
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.pcalculator.tool;

import com.ruthlessphysics.pcalculator.tool.Debug;
import com.ruthlessphysics.pcalculator.Header;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Var
{
  /* Variable Manager
  // Provides the methods to manage variables
  */
  static String err = "error";

  public static void setup()
  {
    Properties prop = new Properties();
    OutputStream output = null;
    InputStream input = null;
    String state = "";
    try
    {
      input = new FileInputStream("pcalculator-variables.properties");
      prop.load(input);
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,ex.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
    }
    try
    {
      output = new FileOutputStream("pcalculator-variables.properties");
      prop.setProperty("E", Double.toString(Math.E));
      prop.setProperty("PI", Double.toString(Math.PI));
      prop.store(output, null);
    }
    catch (IOException io)
    {
      io.printStackTrace();
    }
    finally
    {
      if (output != null)
      {
        try
        {
          output.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
  }

  public static boolean setVar(String id, String value)
  {
    Properties prop = new Properties();
    OutputStream output = null;
    InputStream input = null;
    String state = "";
    try
    {
      input = new FileInputStream("pcalculator-variables.properties");
      prop.load(input);
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,ex.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
    }
    try
    {
      output = new FileOutputStream("pcalculator-variables.properties");
      prop.setProperty(id,value);
      prop.store(output, null);
      return true;
    }
    catch (IOException io)
    {
      io.printStackTrace();
      return false;
    }
    finally
    {
      if (output != null)
      {
        try
        {
          output.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
          return false;
        }
      }
    }

  }
  public static String getVar(String id)
  {
    id = Header.trim(id);
    Properties prop = new Properties();
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-variables.properties");
      prop.load(input);
      String content = prop.getProperty(id);
      return content;
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
      return err;
    }
    finally
    {
      if (input != null)
      {
        try
        {
          input.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
          if(Debug.displayDebug())
          {
            JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
          }
          return err;
        }
      }
    }
  }
  public static boolean forceSetVar(String id,String value)
  {
    id = Header.trim(id);
    value = Header.trim(value);
    Properties config = new Properties();
    OutputStream output = null;
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-variables.properties");
      config.load(input);
      input.close();
      config.remove(id);
      output = new FileOutputStream("pcalculator-variables.properties");
      config.setProperty(id, value);
      config.store(output, null);
      return true;
    }
    catch (IOException io)
    {
      io.printStackTrace();
      return false;
    }
    finally
    {
      if (output != null)
      {
        try
        {
          output.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
          if(Debug.displayDebug())
          {
            JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    }
  }

  public static boolean removeVar(String id)
  {
    id = Header.trim(id);
    Properties config = new Properties();
    OutputStream output = null;
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-variables.properties");
      config.load(input);
      input.close();
      config.remove(id);
      output = new FileOutputStream("pcalculator-variables.properties");
      config.store(output, null);
      return true;
    }
    catch (IOException io)
    {
      io.printStackTrace();
      return false;
    }
    finally
    {
      if (output != null)
      {
        try
        {
          output.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
          if(Debug.displayDebug())
          {
            JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    }
  }

  public static boolean isValidDouble(String value)
  {
    value = Header.trim(value);
    try
    {
      Double.parseDouble(value);
      return true;
    }
    catch(Exception e)
    {
      return false;
    }
  }

  public static boolean isValidInt(String value)
  {
    value = Header.trim(value);
    try
    {
      Integer.parseInt(value);
      return true;
    }
    catch(Exception e)
    {
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
      return false;
    }
  }

  public static boolean isValidLong(String value)
  {
    value = Header.trim(value);
    try
    {
      Long.parseLong(value);
      return true;
    }
    catch(Exception e)
    {
      return false;
    }
  }

  public static String whatIsValid(String value)
  {
    value = Header.trim(value);
    String r = "";
    boolean check_d = true;
    boolean check_i = true;
    boolean check_l = true;
    try
    {
      Double.parseDouble(value);
    }
    catch(Exception e)
    {
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
      check_d = false;
    }
    try
    {
      Integer.parseInt(value);
    }
    catch(Exception e)
    {
      check_i = false;
    }
    try
    {
      Long.parseLong(value);
    }
    catch(Exception e)
    {
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
      check_l = false;
    }

    if(check_d == false || check_i == false || check_l == false)
    {
      r += "False. ";
    }
    if(check_d == false)
    {
      r += "Variable couldn\'t parse as Double. ";
    }
    if(check_i == false)
    {
      r += "Variable couldn\'t parse as Integer. ";
    }
    if(check_l == false)
    {
      r += "Variable couldn\'t parse as Long. ";
    }
    return r;
  }

  public static boolean isOccupied(String id)
  {
    id = Header.trim(id);
    Properties prop = new Properties();
    InputStream input = null;
    try
    {
      input = new FileInputStream("pcalculator-variables.properties");
      prop.load(input);
      String content = prop.getProperty(id);
      if(content != null)
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,ex.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
      return false;
    }
    finally
    {
      if (input != null)
      {
        try
        {
          input.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
          if(Debug.displayDebug())
          {
            JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
          }
          return false;
        }
      }
    }
  }

  public static double d(String value)
  {
    value = Header.trim(value);
    try
    {
      return Double.parseDouble(value);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
      return 0.0;
    }
  }

  public static int i(String value)
  {
    value = Header.trim(value);
    try
    {
      return Integer.parseInt(value);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
      return 0;
    }
  }

  public static long l(String value)
  {
    value = Header.trim(value);
    try
    {
      return Long.parseLong(value);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
      return 0L;
    }
  }

  public static void menu(String[] c)
  {
    try
    {
      if(c.length < 2)
      {
        Header.alert("You need to enter a command after that!\n");
      }
      else if(c[0].equals("set"))
      {
        if(isOccupied(c[1]))
        {
          String old = getVar(c[1]);
          if(forceSetVar(c[1],c[2]))
          {
            Header.alert("Variable \'"+c[1]+"\' was successfully changed from "+old+
            " to "+c[2]+" .");
          }
        }
        else
        {
          if(setVar(c[1],c[2]))
          {
            Header.alert("Variable \'"+c[1]+"\' was successfully set as "+c[2]+".");
          }
        }
      }
      else if(c[0].equals("remove"))
      {
        if(removeVar(c[1]))
        {
          Header.alert("Variable \'"+c[1]+"\' was successfully removed.");
        }
        else
        {
          Header.alert("A problem removing Variable \'"+c[1]+"\' occured.\n");
        }
      }

      else if(c[0].equals("get"))
      {

        if(isOccupied(c[1]))
        {
          Header.alert("Variable under "+c[1]+" is "+getVar(c[1]));
        }
        else
        {
          Header.alert("Variable under "+c[1]+" doesn\'t exist.");
        }
      }
      else
      {
        Header.alert(c[0]+" isn\'t actually a command. Try \'help\'.");
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
    }
  }

}
