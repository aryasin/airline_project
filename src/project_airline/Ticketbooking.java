/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_airline;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tushar
 */
public class Ticketbooking extends javax.swing.JFrame {

    /**
     * Creates new form Ticketbooking
     */
    public Ticketbooking() {
        initComponents();
        this.setTitle("Ticket Booking...");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        
 prno.setText(Integer.toString(variables.prno));
 jLabel9.setText(variables.date_of_flight);
    }
 int fare;
    int age;
    String gender;
    String flightName;
    String flightid;
    int seatid;
    int cnt=0;
String loadflights()
        
{
try
        {
            //drivers for os
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //one dsn points to one database
           Connection conn = 
                   DriverManager.getConnection("jdbc:odbc:project", "sa", "abc");
           
           PreparedStatement st = conn.prepareCall("select fid from flights where fname=?");
           st.setString(1,variables.Flightname);
           ResultSet rs = st.executeQuery();
           if (rs.next())
           {
               flightid=rs.getString("fid");
               return flightid;
           }}
           catch(Exception ex)
           {
               JOptionPane.showMessageDialog(this, ex);
           }
return "";}


int loadcat()
        
{
try
        {
            //drivers for os
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //one dsn points to one database
           Connection conn = 
                   DriverManager.getConnection("jdbc:odbc:project", "sa", "abc");
           
           PreparedStatement st = conn.prepareCall("select seatid from flightseatstatus where seatstatusname=?");
           st.setString(1,variables.category );
           ResultSet rs = st.executeQuery();
           if (rs.next())
           {
               seatid=rs.getInt("seatid");
        return seatid;
           }}
           catch(Exception ex)
           {
               JOptionPane.showMessageDialog(this, ex);
           }
return 0;
}


void entries()
    {String query="select custname,contact,gender,age,fare from booking where  pnr=?";
       
        try
        {
            
          
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      
           Connection conn=DriverManager.getConnection("jdbc:odbc:project", "sa","abc");
           
           PreparedStatement st = conn.prepareCall(query);
           st.setInt(1,variables.prno);
           ResultSet rs = st.executeQuery();
           
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
    





void addcust()
{ String query = "{call sp_booking(?,?,?,?,?,?,?,?,?,?,?)}";
try
        {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      
             Connection conn=DriverManager.getConnection("jdbc:odbc:project", "sa","abc"); 
           CallableStatement cs = conn.prepareCall(query);
     
           cs.setInt(1, variables.prno);
           cs.setString(2, loadflights());
           cs.setString(3,jTextField1.getText());
           cs.setString(4,variables.date_of_flight);
           cs.setString(5,variables.source);
           cs.setString(6,variables.destination);
           cs.setInt(7, loadcat());
           cs.setInt(8, Integer.parseInt(jTextField7.getText()));
           cs.setInt(9, Integer.parseInt(jTextField2.getText()));
           cs.setString(10,gender);     
           cs.setInt(11, fare);
                 
             
           
            int rec = cs.executeUpdate();
           if (rec >0)
           {
               
        entries();
        }
           
           
           
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex);
        }

}

void sum()
{String query="select SUM(fare)'sum' from booking where pnr=?";

 try
        {
            
          
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      
           Connection conn=DriverManager.getConnection("jdbc:odbc:project", "sa","abc");
           PreparedStatement st = conn.prepareCall(query);
           st.setInt(1,variables.prno);
           ResultSet rs = st.executeQuery();

        
          if (rs.next())
           {
             jLabel8.setText(rs.getString("sum"));
                           
           }
           
        
        }
 catch(Exception ex)
 {
 JOptionPane.showMessageDialog(this, ex);
 }
        
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jLabel5 = new javax.swing.JLabel();
        prno = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Contact", "Gender", "Age", "Fare"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Name");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Male");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton2.setText("Add Passenger");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Passenger Age:");

        jLabel3.setText("Gender:");

        jLabel5.setText("PNR No");

        prno.setText("jLabel6");

        jLabel7.setText("Total fare");

        jLabel8.setText("Rs");

        jLabel10.setText("Contact Number:");

        jLabel6.setText("Date of Flight:");

        jLabel9.setText("jLabel9");

        jButton3.setText("Remove All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_airline/airticket1.jpg"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Passenger's Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(792, 792, 792))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(121, 121, 121)
                                        .addComponent(jRadioButton1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGap(59, 59, 59)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(prno))))
                                .addGap(54, 54, 54))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jRadioButton2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(78, 78, 78)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(jButton2)
                        .addGap(112, 112, 112)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(prno))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
if(variables.count<variables.ticketsRequired){
        
        age=Integer.parseInt(jTextField2.getText());
if (age<18)
{
    fare=variables.childfare;
}
else 
{
    fare=variables.adultfare;
}
  if(jRadioButton1.isSelected())
      gender="Male";
  else if(jRadioButton2.isSelected())
      gender="Female";
      

    
    addcust();
sum();
jTextField1.setText("");
jTextField2.setText("");
jTextField7.setText("");
variables.count++;}

else
{
    JOptionPane.showMessageDialog(this, "no more entries can be added");
}
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try
        {
            
          
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      
           Connection conn=DriverManager.getConnection("jdbc:odbc:project", "sa","abc");
           PreparedStatement st = conn.prepareCall("delete booking where pnr=?");
           st.setInt(1,variables.prno);
           int rs = st.executeUpdate();

        
           if(rs>0)
           {
                entries();
           JOptionPane.showMessageDialog(this, "deleted");
           variables.count=0;
           sum();
           }
                           
           
           
        
        }
 catch(Exception ex)
 {
 JOptionPane.showMessageDialog(this, ex);
 
        
 }      
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Ticketbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticketbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticketbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticketbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticketbooking().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel prno;
    // End of variables declaration//GEN-END:variables
}
