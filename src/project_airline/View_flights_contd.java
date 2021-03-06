/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_airline;

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
public class View_flights_contd extends javax.swing.JFrame {

    /**
     * Creates new form View_flights_contd
     */
    public View_flights_contd() {
        initComponents();
 this.setTitle("Flights with us...");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        loadcid();
        loadflights();
    }

    int companyid;
    
    
    void loadcid()
        
{
try
        {
            //drivers for os
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //one dsn points to one database
           Connection conn = 
                   DriverManager.getConnection("jdbc:odbc:project", "sa", "abc");
           
           PreparedStatement st = conn.prepareCall("select cid from company where cname=?");
           st.setString(1,variables.companyName);
           ResultSet rs = st.executeQuery();
           while (rs.next())
           {
               
               companyid =  Integer.parseInt(rs.getString("cid").trim());
               
               
              
              
           }

} catch(Exception ex)
{
    JOptionPane.showMessageDialog(null, ex);
    
}}
    
  void loadflights()
    {
        try
        {
            //drivers for os
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //one dsn points to one database
           Connection conn = 
                   DriverManager.getConnection("jdbc:odbc:project", "sa", "abc");
           
           PreparedStatement st = conn.prepareCall("select fid,fname,sname from flights,flightstatus  where flights.statusid=flightstatus.statusid and cid=?");
          st.setInt(1,companyid);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Flights Associated with us");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight id", "Flight Name", "Status"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
loadflights();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(View_flights_contd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_flights_contd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_flights_contd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_flights_contd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_flights_contd().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
