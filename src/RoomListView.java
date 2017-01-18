import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;

import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Jan 18 13:19:06 EET 2017
 */



/**
 * @author Kranas Charalampos
 */
public class RoomListView extends JFrame {
	
	 private static RoomListView INSTANCE = null;
	 private int currentRow = -1;
	 ArrayList<String> roomDbIds ;
		
		
		
		
		
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
		 Long tsLong = System.currentTimeMillis() / 1000;
	        Room r = new Room(""+tsLong,"",0);
	        int rv = DBManager.addRoom(r);
	        if (rv != 0)
	            JOptionPane.showMessageDialog(null, "Unable to create new Room", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        loadTable();
	
	
	}

	private void buttonDeleteActionPerformed(ActionEvent e) {
		int selected = table1.getSelectedRow();

        if (selected == -1){
            JOptionPane.showMessageDialog(null, "Please first select one Room from table!", "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
        else {
            String selctedRoomId = roomDbIds.get(selected);
            int rv = DBManager.deleteRoomType(selctedRoomId);
            if (rv != 0)
                JOptionPane.showMessageDialog(null, "Unable to delete selected Room", "Error",
                        JOptionPane.ERROR_MESSAGE);
            else
                currentRow =-1;

        }
        loadTable();
	}

	

	private void buttonOkActionPerformed(ActionEvent e) {
		   INSTANCE.close();
 }
 
 private void close() {
     INSTANCE.setVisible(false);
 }

	

	private void table1PropertyChange(PropertyChangeEvent e) {
		// TODO add your code here
		
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - babis naskre
		JScrollPane scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		label1 = new JLabel();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(table1);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(10, 40, 490, 365);

		//---- button1 ----
		button1.setText("Add");
		button1.addActionListener(e -> buttonAddActionPerformed(e));
		contentPane.add(button1);
		button1.setBounds(500, 45, 90, 22);

		//---- button2 ----
		button2.setText("Delete");
		button2.addActionListener(e -> buttonDeleteActionPerformed(e));
		contentPane.add(button2);
		button2.setBounds(505, 80, 83, 37);

		//---- button3 ----
		button3.setText("Ok");
		button3.addActionListener(e -> buttonOkActionPerformed(e));
		contentPane.add(button3);
		button3.setBounds(515, 305, 55, 37);

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
		 loadTable();
	}
	
	
	
	private void loadTable() {
		roomDbIds = new ArrayList<>();

        ArrayList<Room> rl;

        rl = DBManager.getRoomList();

        Object rowData[][] = new Object[rl.size()][2];

        Object columnNames[] = { "Room Id", "Type"};

        int i=0;

        for (Room r: rl) {

            roomDbIds .add(r.getId());

            rowData[i][0]=r.getId();

            rowData[i][1]=r.getType();

            

            i++;

        }

        table1 = new JTable(

        new javax.swing.table.DefaultTableModel(

                rowData,

                columnNames) {

            public boolean isCellEditable(int rowIndex, int columnIndex) {

                if (currentRow!=-1){

                    if (currentRow!=rowIndex){

                      //  saveThePreviewsCollumn();

                        currentRow = rowIndex;

                    }

                }

                else

                    currentRow = rowIndex;

                if (columnIndex==0)

                    return false;

                else

                    return  true;

            }

        });

        //======== scrollPane1 ========

        {

        	scrollPane1.setViewportView(table1);
        }
		
	}
	
	
 
	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - babis naskre
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel label1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
