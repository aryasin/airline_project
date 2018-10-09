/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_airline;

import java.awt.Label;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Nimish
 */
public class booking extends javax.swing.JFrame {

    /**
     * Creates new form booking
     */
    public booking() {
        initComponents();
         
            jComboBox1.removeAllItems();
            
    
    loadsource();
    this.setTitle("FlightDetails...");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    
    }
    
    int routeid;
    String source;
    String destination;
    String status;
    int flightid;
    String flightname;
    int childfare;
    int adultfare;
  int availableTickets;
        void loadFlight()
    {
        try
        {
            //drivers for os
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //one dsn points to one database
           Connection conn=DriverManager.getConnection("jdbc:odbc:project", "sa","abc");
           
           String query=" select fname,dtime,atime,flightdays from flights,routees,flightroutes where flights.fid=flightroutes.fid and flightroutes.rid=routees.rid and Source=? and Destination=? ";
           
           
           
           PreparedStatement pst = conn.prepareStatement(query);
         
           pst.setString(1, jComboBox1.getSelectedItem().toString());
           pst.setString(2, jComboBox2.getSelectedItem().toString());
           
           ResultSet rs = pst.executeQuery();
           
//            Statement st = conn.createStatement();
//           
//           
//           ResultSet rs = st.executeQuery(query2);
        
           
           
           ResultSetMetaData rsmt = rs.getMetaData();
           
           DefaultTableModel model = 
                   (DefaultTableModel) jTable1.getModel();
           
           Object rowdata[] = new Object[rsmt.getColumnCount()];
            model.setNumRows(0);
           while (rs.next())
           {
               for(int i=1;i<=rsmt.getColumnCount();i++)
               {
                   rowdata[i-1] = rs.getString(i);
               }
               model.addRow(rowdata);
           }
           
           jTable1.setModel(model);
         
           
         
           
        }catch(Exception ex)
        {JOptionPane.showMessageDialog(this, ex);
            
        }}
    
    
void loadsource()
        
{
try
        {
            //drivers for os
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //one dsn points to one database
           Connection conn = 
                   DriverManager.getConnection("jdbc:odbc:project", "sa", "abc");
           
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("select distinct source from routees");
           while (rs.next())
           {
               
               jComboBox1.addItem(rs.getString("source"));
               
           }

} catch(Exception ex)
{
    JOptionPane.showMessageDialog(this, ex);
    
}}
void loaddest()
        
{
    String query="select distinct destination from routees where source=?";
try
        {
            //drivers for os
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //one dsn points to one database
           Connection conn = 
                   DriverManager.getConnection("jdbc:odbc:project", "sa", "abc");
           
           PreparedStatement pst = conn.prepareStatement(query);
         
           pst.setString(1, jComboBox1.getSelectedItem().toString());
           
           ResultSet rs = pst.executeQuery();
           source=jComboBox1.getSelectedItem().toString(); 
           while (rs.next())
           {
               jComboBox2.addItem(rs.getString("destination"));
           
           }

} catch(Exception ex)
{
    JOptionPane.showMessageDialog(null, ex);
    
}}



void totalseats(){
    int rowselected= jTable1.getSelectedRow();
        
         flightname= jTable1.getValueAt(rowselected,0).toString();
        
        
         status="";
         if (jRadioButton1.isSelected())
             status="Economy";
         if (jRadioButton2.isSelected())
             status="Business";
         
                    try
        {
            //drivers for os
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //one dsn points to one database
           Connection conn = 
                   DriverManager.getConnection("jdbc:odbc:project", "sa", "abc");
           String query = "{call sp_totalFlightSeats(?,?,?)}";
                 
           CallableStatement st = conn.prepareCall(query);
        
           st.setString(1, flightname);
           st.setString(2, status);
           st.setString(3,jTextField1.getText());
          
           ResultSet rs = st.executeQuery();
           
           if(rs.next());{
           jLabel3.setText(rs.getString("total").trim());
        
        }
           
           
           
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "total"+ex);
        }

    
    }


int genpnr()
{ 
int pnrno=0;
                    try
        {
          
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         
           Connection conn = 
                   DriverManager.getConnection("jdbc:odbc:project", "sa", "abc");
           
           String query="(select ISNULL(MAX(pnr),0)'pnr1' from booking)";
            Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery(query);
         rs.next();
           
           pnrno=rs.getInt("pnr1");
          
           return pnrno;

        }
                    
                    catch(Exception ex)
                    {
                  JOptionPane.showMessageDialog(this, ex);
                    
                    }
                    return 0;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ticketsRequired = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight", "Departure", "Arrival", "Flight days"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Economy");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Business");

        jLabel1.setText("Date");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel2.setText("Seats avilable:");

        jLabel3.setText("Select Flight");

        jLabel4.setText("Adult fare");

        jLabel5.setText("Rs");

        jLabel6.setText("Source");

        jLabel7.setText("Destination");

        jLabel8.setText("(DD/MM/YYYY)");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Book");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Tickets required");

        jLabel10.setText("Child fare");

        jLabel11.setText("Rs");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_airline/booking.jpg"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Flight Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ticketsRequired)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jButton2)
                                        .addGap(80, 80, 80))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jButton1))
                        .addGap(124, 124, 124))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel13)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(28, 28, 28)
                .addComponent(jLabel12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(ticketsRequired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        
      if (jComboBox1.getSelectedItem()!=null)
      { jComboBox2.removeAllItems();   
              
        loaddest();
      }// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        destination=jComboBox2.getSelectedItem().toString();
        loadFlight();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

      totalseats();
//        int rowselected= jTable1.getSelectedRow();
//        
//         flightname= jTable1.getValueAt(rowselected,0).toString();
//        
//        
//         status="";
//         if (jRadioButton1.isSelected())
//             status="Economy";
//         if (jRadioButton2.isSelected())
//             status="Business";
         
    try
        {
            //drivers for os
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //one dsn points to one database
           Connection conn = 
                   DriverManager.getConnection("jdbc:odbc:project", "sa", "abc");
           
           String query="{call sp_showFlightFare(?,?)}";
           CallableStatement cs = conn.prepareCall(query);
           
           cs.setString(1,flightname);
           cs.setString(2,status);
            
           ResultSet rec = cs.executeQuery();
           
           
         rec.next();
       
            jLabel5.setText(rec.getString("fare"));
        
        
        
         rec.next();
           
               jLabel11.setText(rec.getString("fare"));
             
          
    
} catch(Exception ex)
{
    JOptionPane.showMessageDialog(null, ex);
    
}    
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        variables.Flightname=flightname;
        variables.source=source;
        variables.destination=destination;
        variables.category=status;
        variables.adultfare=Integer.parseInt(jLabel5.getText());
        variables.childfare=Integer.parseInt(jLabel11.getText());
        variables.date_of_flight=jTextField1.getText();
        variables.ticketsRequired=Integer.parseInt(ticketsRequired.getText());
        availableTickets=Integer.parseInt(jLabel3.getText());
         variables.count=0;
      
        if (availableTickets>variables.ticketsRequired)
         {
        
        
        int pnrno;
        pnrno=genpnr();
        pnrno++;
        variables.prno=pnrno;
        
        
        Ticketbooking obj=new Ticketbooking();
        obj.setVisible(true);
 obj.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
         }
         else
         {JOptionPane.showMessageDialog(this,"Insufficient Seats");
         }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new booking().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField ticketsRequired;
    // End of variables declaration//GEN-END:variables
}
