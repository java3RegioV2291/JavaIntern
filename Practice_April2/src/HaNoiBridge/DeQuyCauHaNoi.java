package HaNoiBridge;

import java.util.ArrayList;

public class DeQuyCauHaNoi {
	  
	  public static int size = 8;
	  
	  public static String source = "Col 1";
	  
	  public static String target = "Col 3";
	  
	  public static String transfer = "Col 2";
	  
	  public static void main(String[] args) {
	    
	    play(source, target, transfer, size);
	    
	  }

	  private static void play(String _source, String _target, String _transfer, int _size) {
	    if (_size == 1) {
	      moveBase(_source, _target);  // move từ source qua target
	    }else {
	      play(_source, _transfer, _target, _size - 1);
	      moveBase(_source, _target);
	      play(_transfer, _target, _source,l
	    }
	    
	  }
	  
	  private static void moveBase(String _source, String _target) {
	    System.out.println("move from " + _source + " to " + _target);
	  }
	  
	}



