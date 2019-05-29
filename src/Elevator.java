
//****************************************************************//
 //				TITLE:  ELEVATOR SIMULATOR						 //
  //			AUTHOR: BENJAMIN HUMPHREY	
   //            
    //******************************************************//

import javax.swing.JFrame;


public class Elevator {

	public static void main(String[] args) {

		JFrame frame = new JFrame ("Elevator Simultor for Luke");  
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ElevatorPanel());

		frame.pack();
		frame.setVisible(true);
	}

}

