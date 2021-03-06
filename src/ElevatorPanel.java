
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ElevatorPanel extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	private int elevator;
	private int floor;
	private int destination;
	private JButton floor2_B;
	private JButton floor2_1;
	private JButton floor1_B;
	private JButton floor1_2;
	private JButton floorB_1;
	private JButton floorB_2;
	private JLabel floor2label;
	private JLabel floor1label;
	private JLabel floorBlabel;
	private JLabel elevatorlabel;

//-----------------------------------------------------------------
//      Sets up the GUI.
//-----------------------------------------------------------------
	public ElevatorPanel() {

		setPreferredSize(new Dimension(500, 200));
		setLayout(new GridLayout(0, 3));
		setBackground(Color.gray);

		
		elevator = 0;  //Elevator Starting Point
		floor = 0;  //Default floor value of person

		//Create Text for all labels and Buttons
		floor2_1 = new JButton("1");
		floor2_B = new JButton("B");
		floor1_2 = new JButton("2");
		floor1_B = new JButton("B");
		floorB_2 = new JButton("2");
		floorB_1 = new JButton("1");
		elevatorlabel = new JLabel("Evlevator Location " + elevator);
		floor2label = new JLabel("Floor 2 Controls ");
		floor1label = new JLabel("Floor 1 Controls ");
		floorBlabel = new JLabel("Basement Controls");
		elevatorlabel.setText("Evlevator Starts on Floor " + elevator);
		
		//Add Floor 2 Controls
		add(floor2label);
		add(floor2_1);
		add(floor2_B);

		//Add Floor 1 Controls
		add(floor1label);
		add(floor1_2);
		add(floor1_B);

		//Add Floor 0 Controls
		add(floorBlabel);
		add(floorB_2);
		add(floorB_1);

		add(elevatorlabel);


		//Listener actions for buttons
		floor2_1.addActionListener(new floorlistner2_1());
		floor2_B.addActionListener(new floorlistner2_B());
		floor1_2.addActionListener(new floorlistner1_2());
		floor1_B.addActionListener(new floorlistner1_B());
		floorB_2.addActionListener(new floorlistnerB_2());
		floorB_1.addActionListener(new floorlistnerB_1());
	}

//Action for  Listener//
	private class floorlistner2_1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			floor = 2;
			destination = 1;
			new motorget(); 
		}
	}

	private class floorlistner2_B implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			floor = 2;
			destination = 0;
			new motorget(); 
		}
	}

	private class floorlistner1_2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			floor = 1;
			destination = 2;
			new motorget();
		}
	}

	private class floorlistner1_B implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			floor = 1;
			destination = 0;
			new motorget();
		}
	}

	private class floorlistnerB_2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			floor = 0;
			destination = 2;
			new motorget();
		}
	}

	private class floorlistnerB_1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			floor = 0;
			destination = 1;
			new motorget();
		}
	}

	public class motorget {
		public motorget() {
			System.out.println("Elevator Starts on Floor " + elevator);
			while (floor > elevator)

			{
				elevator++;
				System.out.println("Elevator goes up to Floor" + elevator);
			}
			while (floor < elevator) {
				elevator--;
				System.out.println("Elevator goes down to Floor" + elevator);
			}
			System.out.println("Doors Open...Luke Gets On...Doors Close on Floor " + elevator

			);
			new motordrop();  //Call Motor Drop Off
		}

		public class motordrop {
			public motordrop() {
				while (destination > elevator) {
					elevator++;
					System.out.println("Elevator goes up to Floor " + elevator);

				}
				while (destination < elevator) {
					elevator--;
					System.out.println("Elevator goes down to Floor " + elevator);
				}
				System.out.println("Doors Open...Luke Gets Off...Doors Close on Floor " + elevator
						+ "\nElevator Ends on Floor " + elevator + 
						"\n**********************************************"); //Visual break in command line
				elevatorlabel.setText("Evlevator is now on Floor " + elevator);
			}
		}
	}
}
