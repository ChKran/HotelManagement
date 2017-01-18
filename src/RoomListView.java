import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Jan 18 13:19:06 EET 2017
 */



/**
 * @author babis naskre
 */
public class RoomListView extends JFrame {
	
	 private static RoomListView INSTANCE = null;
		
		
		
		
		
		public RoomListView() {
			initComponents();
		}
		
		  public static RoomListView getInstance() {
		        if (INSTANCE == null) INSTANCE = new RoomListView();
		        INSTANCE.updateTable();
		        return INSTANCE;
		    }

		    private void updateTable() {
			// TODO Auto-generated method stub
			
		}

			private void thisWindowClosing(WindowEvent e) {
		        INSTANCE.close();
		    }	

	private void buttonAddActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void buttonDeleteActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void buttonEditActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void buttonOkActionPerformed(ActionEvent e) {
		   INSTANCE.close();
 }
 
 private void close() {
     INSTANCE.setVisible(false);
 }

	private void scrollPane1PropertyChange(PropertyChangeEvent e) {
		// TODO add your code here
	}

	private void table1PropertyChange(PropertyChangeEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - babis naskre
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		label1 = new JLabel();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== scrollPane1 ========
		{
			scrollPane1.addPropertyChangeListener(e -> scrollPane1PropertyChange(e));

			//---- table1 ----
			table1.addPropertyChangeListener(e -> table1PropertyChange(e));
			scrollPane1.setViewportView(table1);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(5, 35, 295, 200);

		//---- button1 ----
		button1.setText("Add");
		button1.addActionListener(e -> buttonAddActionPerformed(e));
		contentPane.add(button1);
		button1.setBounds(325, 45, 55, button1.getPreferredSize().height);

		//---- button2 ----
		button2.setText("Delete");
		button2.addActionListener(e -> buttonDeleteActionPerformed(e));
		contentPane.add(button2);
		button2.setBounds(new Rectangle(new Point(325, 85), button2.getPreferredSize()));

		//---- button3 ----
		button3.setText("Ok");
		button3.addActionListener(e -> buttonOkActionPerformed(e));
		contentPane.add(button3);
		button3.setBounds(325, 210, 50, button3.getPreferredSize().height);

		//---- button4 ----
		button4.setText("Edit");
		button4.addActionListener(e -> buttonEditActionPerformed(e));
		contentPane.add(button4);
		button4.setBounds(325, 120, 55, button4.getPreferredSize().height);

		//---- label1 ----
		label1.setText("Room List");
		contentPane.add(label1);
		label1.setBounds(10, 10, 75, label1.getPreferredSize().height);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - babis naskre
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JLabel label1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
