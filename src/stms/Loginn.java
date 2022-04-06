package stms;

import java.awt.Checkbox;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class Loginn extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Loginn() {
        super("Login Page");
        initComponents();
    }
    
    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    void validate_login(String username, String password, String schoolID)
    {
        
        if(rbAdmin.isSelected())
        {
            Statement stmt=null;
            String query1 = ("select * from admin_details,principal_details where admin_details.username='"+username+"' and admin_details.password='"+password+"' and principal_details.school_id= '"+schoolID+"' ");
            //String query2 = ("select * from principal_details where school_id= '"+schoolID+"' ");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transaction_mgmt", "root", "");
                stmt=conn.createStatement();
                ResultSet rs1=stmt.executeQuery(query1);
                boolean status1=rs1.next();
                if(status1)
                {
//                    ResultSet rs2=stmt.executeQuery(query2);
//                    boolean status2=rs2.next();
//                    if(status2)
//                    {
                        AdminDashboard ad= new AdminDashboard();
                        ad.setVisible(true);
                        close();
//                    }
//                    else
//                        lblError.setText("Incorrect School ID");
                }
                else
                    JOptionPane.showMessageDialog(this,"Login unsuccessful");

                conn.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(rbPrincipal.isSelected())
        {
            Statement stmt=null;
            String query3 = ("select * from principal_details where username='"+username+"' and password='"+password+"' and school_id= '"+schoolID+"' ");
            //String query4 = ("select * from principal_details where school_id= '"+schoolID+"' ");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/transaction_mgmt", "root", "");
                stmt=conn.createStatement();
                ResultSet rs3=stmt.executeQuery(query3);
                boolean status3=rs3.next();
                if(status3)
                {
//                    ResultSet rs4=stmt.executeQuery(query4);
//                    boolean status4=rs4.next();
//                    if(status4)
//                    {
                        PrincipalDashboard pd= new PrincipalDashboard();
                        pd.setVisible(true);
                        close();
//                    }
//                    else
//                        lblError.setText("Incorrect School ID");
                }
                else
                    JOptionPane.showMessageDialog(this,"Login unsuccessful");

                conn.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            lblError.setText("Select your user account type");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblSID = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtSID = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        rbPrincipal = new javax.swing.JRadioButton();
        rbAdmin = new javax.swing.JRadioButton();
        btnLogin = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(18, 44, 70));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSID.setFont(new java.awt.Font("SansSerif", 0, 40)); // NOI18N
        lblSID.setForeground(new java.awt.Color(255, 255, 255));
        lblSID.setText("School ID");
        jPanel1.add(lblSID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 180, -1));

        lblUsername.setFont(new java.awt.Font("SansSerif", 0, 40)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username");
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 220, -1));

        lblPassword.setFont(new java.awt.Font("SansSerif", 0, 40)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password");
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 180, -1));

        txtSID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 32)); // NOI18N
        txtSID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txtSID, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 580, 50));

        txtUsername.setFont(new java.awt.Font("Segoe UI Semibold", 0, 32)); // NOI18N
        txtUsername.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 580, 50));

        rbPrincipal.setBackground(new java.awt.Color(18, 44, 70));
        buttonGroup.add(rbPrincipal);
        rbPrincipal.setFont(new java.awt.Font("SansSerif", 0, 39)); // NOI18N
        rbPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        rbPrincipal.setText(" Principal");
        rbPrincipal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rbPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPrincipalActionPerformed(evt);
            }
        });
        jPanel1.add(rbPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 490, -1, -1));

        rbAdmin.setBackground(new java.awt.Color(18, 44, 70));
        buttonGroup.add(rbAdmin);
        rbAdmin.setFont(new java.awt.Font("SansSerif", 0, 39)); // NOI18N
        rbAdmin.setForeground(new java.awt.Color(255, 255, 255));
        rbAdmin.setText(" Admin");
        rbAdmin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rbAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAdminActionPerformed(evt);
            }
        });
        jPanel1.add(rbAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, -1, -1));

        btnLogin.setBackground(new java.awt.Color(34, 32, 46));
        btnLogin.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login2.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 570, 230, 110));

        lblError.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 204, 204));
        lblError.setText("Please enter valid username and password");
        jPanel1.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 620, 620, -1));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jPasswordField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 580, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1580, 710));

        jPanel2.setBackground(new java.awt.Color(6, 22, 38));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 90)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/key.png"))); // NOI18N
        jLabel2.setText(" Login");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, 140));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void rbPrincipalActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void rbAdminActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         
       String username = txtUsername.getText();
       String password = jPasswordField1.getText();
       String schoolID= txtSID.getText();
       if (username.trim().equals("")||password.trim().equals(""))
       {
           lblError.setText("Please enter login details");
       }
       else
       {
           validate_login(username, password, schoolID);
       }
        
    }                                        

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loginn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnLogin;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSID;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JRadioButton rbAdmin;
    private javax.swing.JRadioButton rbPrincipal;
    private javax.swing.JTextField txtSID;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration                   
}
