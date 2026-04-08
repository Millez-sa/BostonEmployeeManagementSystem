/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bostonemployeemanagementsystem;

import java.sql.*; 
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Millez Faranani Matsa
 */
public class AdminPortal extends javax.swing.JFrame {

    /**
     * Creates new form AdminPortal
     */
    public AdminPortal() {
        initComponents();
    }

    Boolean boolRecordExists=false;
    Boolean boolEdit=false;
    Boolean boolCreate=false;
    String strFirstName=null;
    String strLastName=null;
    String strDepartment=null;
    String strDateOfBirth=null;
    String strPhoneNumber=null;
    String strJobTitle=null;
    String strUserName=null;
    String strPassword=null;
    int intEmployeeID;
    
    private void mGetValuesFromGUI()
        {
         strFirstName = txtFirstName.getText();
         strLastName = txtLastName.getText();
         strDepartment = txtDepartment.getText();
         strDateOfBirth = txtDateOfBirth.getText();
         strPhoneNumber = txtPhoneNumber.getText();
         strJobTitle = txtJobTitle.getText();
         strUserName = txtUserName.getText();
         strPassword = txtPassword.getText();
         
        }
    
    private void mSetValuesToUpperCase()
    {
        strFirstName = txtFirstName.getText();
         strLastName = txtLastName.getText();
         strDepartment = txtDepartment.getText();
         strDateOfBirth = txtDateOfBirth.getText();
         strPhoneNumber = txtPhoneNumber.getText();
         strJobTitle = txtJobTitle.getText();
         strUserName = txtUserName.getText();
         strPassword = txtPassword.getText();
    }
    
    private void mCheckIfItemsExistInTable()
    {
        String strDBConnectionString="jdbc:mysql://localhost:3306/employee_management_system";
        String strDBUser="root";
        String strDBPassword="password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
         conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
         stStatement = conMySQLConnectionString.createStatement();
         String strQuery = " Select * from employee_information where First_Name='" + strFirstName + "' and Last_Name'" + strLastName + "' and Department'" + strDepartment + "' and Date_Of_Birth'" + strDateOfBirth + "' and Phone_Number'" + strPhoneNumber + "'";
         stStatement.execute(strQuery);
         rs=stStatement.getResultSet();
         boolRecordExists=rs.next();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try{
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Connection String not closed" + " " + e);
            }
        }
    }
    
    private void mCreateActor()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL= "jdbc:mysql://localhost:3306/employee_management_system";
        String User="root";
        String Password="password";
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(URL,User,Password);
            Statement myStatement = conMySQLConnectionString.createStatement();
            String sqlinsert = " insert into employee_information"+" (First_Name,Last_Name,Department,Date_Of_Birth,Phone_Number)"+"values('" + strFirstName + "', '" + strLastName + "', '" + strDepartment +  "', '" + strDateOfBirth + "')";
            myStatement.executeUpdate(sqlinsert);
            myStatement.close();
            lblOutput.setText("Employee Successfully Added");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     private void mClearTextFields()
        {
            txtFirstName.setText("");
            txtLastName.setText("");
            txtDateOfBirth.setText("");
            txtDepartment.setText("");
            txtPhoneNumber.setText("");
            txtUserName.setText("");
            txtPassword.setText("");
            txtJobTitle.setText("");
        }
     
     private void mSetValuesToUpperCaseFromGUI()
    {
        strFirstName=strFirstName.toUpperCase();
        strLastName=strLastName.toUpperCase();
        strDateOfBirth=strDateOfBirth.toUpperCase();
        strDepartment=strDepartment.toUpperCase();
        strPhoneNumber=strPhoneNumber.toUpperCase();
        strUserName=strUserName.toUpperCase();
        strPassword=strPassword.toUpperCase();
        strJobTitle=strJobTitle.toUpperCase();
        strFirstName=txtFirstName.getText();
        strLastName=txtLastName.getText();
        strDateOfBirth=txtDateOfBirth.getText();
        strDepartment=txtDepartment.getText();
        strPhoneNumber=txtPhoneNumber.getText();
        strUserName=txtUserName.getText();
        strPassword=txtPassword.getText();
        strJobTitle=txtJobTitle.getText();
        
    }
    
    private void mSetValuesInGUI()
    {
        txtFirstName.setText(strFirstName);
        txtLastName.setText(strLastName);
        txtDateOfBirth.setText(strDateOfBirth);
        txtDepartment.setText(strDepartment);
        txtPhoneNumber.setText(strPhoneNumber);
        txtUserName.setText(strUserName);
        txtPassword.setText(strPassword);
        txtJobTitle.setText(strJobTitle);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Designer = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        lblAdministrator = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblEmployeeInformation = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblJobTitle = new javax.swing.JLabel();
        txtJobTitle = new javax.swing.JTextField();
        lblDepartment = new javax.swing.JLabel();
        txtDepartment = new javax.swing.JTextField();
        lblDateOfBirth = new javax.swing.JLabel();
        txtDateOfBirth = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        spTable = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();
        lblCommands = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnDeleteAll = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        lblOutput = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Designer.setBackground(java.awt.Color.white);

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblAdministrator.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblAdministrator.setForeground(new java.awt.Color(102, 102, 102));
        lblAdministrator.setText("Employee Management System: Admin Portal");

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblEmployeeInformation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmployeeInformation.setText("Employee Information");

        lblFirstName.setText("First Name");

        lblLastName.setText("Last Name");

        lblJobTitle.setText("Job Title");

        lblDepartment.setText("Department");

        lblDateOfBirth.setText("Date of Birth");

        lblPhoneNumber.setText("Phone Number");

        lblUserName.setText("User Name");

        lblPassword.setText("Paassword");

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Department", "DOB", "Phone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableMouseClicked(evt);
            }
        });
        spTable.setViewportView(tblTable);

        lblCommands.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCommands.setText("Commands");

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnDeleteAll.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteAll.setText("Delete All");
        btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblOutput.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOutput.setToolTipText("");

        javax.swing.GroupLayout DesignerLayout = new javax.swing.GroupLayout(Designer);
        Designer.setLayout(DesignerLayout);
        DesignerLayout.setHorizontalGroup(
            DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesignerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DesignerLayout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DesignerLayout.createSequentialGroup()
                        .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(DesignerLayout.createSequentialGroup()
                                    .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblPhoneNumber)
                                        .addComponent(lblDateOfBirth)
                                        .addComponent(lblUserName)
                                        .addComponent(lblPassword))
                                    .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(DesignerLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtPassword)
                                                .addComponent(txtUserName)
                                                .addComponent(txtPhoneNumber)))
                                        .addGroup(DesignerLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(DesignerLayout.createSequentialGroup()
                                    .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblDepartment))
                                    .addGap(31, 31, 31)
                                    .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                        .addComponent(txtLastName)
                                        .addComponent(txtJobTitle)
                                        .addComponent(txtDepartment))))
                            .addComponent(lblEmployeeInformation)
                            .addComponent(lblFirstName)
                            .addComponent(lblLastName))
                        .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DesignerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(613, 613, 613))
                            .addGroup(DesignerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spTable, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(DesignerLayout.createSequentialGroup()
                                        .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(DesignerLayout.createSequentialGroup()
                                                .addComponent(lblCommands)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblOutput))
                                            .addGroup(DesignerLayout.createSequentialGroup()
                                                .addComponent(btnAdd)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnUpdate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnDelete)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnDeleteAll)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnRefresh)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnCancel)))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(DesignerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblAdministrator)))
                .addGap(53, 53, 53))
        );
        DesignerLayout.setVerticalGroup(
            DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesignerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdministrator)
                .addGap(43, 43, 43)
                .addComponent(lblEmployeeInformation)
                .addGap(18, 18, 18)
                .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DesignerLayout.createSequentialGroup()
                        .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirstName)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLastName)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJobTitle)
                            .addComponent(txtJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDepartment)
                            .addComponent(txtDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDateOfBirth)
                            .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhoneNumber)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCommands)
                    .addComponent(lblOutput))
                .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DesignerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(btnDeleteAll)
                            .addComponent(btnCancel)
                            .addComponent(btnRefresh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesignerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(DesignerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnBack))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Designer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Designer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        WelcomePage WelcomePage = new WelcomePage();
        WelcomePage.show();
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
DefaultTableModel model = (DefaultTableModel) tblTable.getModel();
model.addRow(new Object[] {txtFirstName.getText(),txtLastName.getText(),txtDepartment.getText(),txtDateOfBirth.getText(),txtPhoneNumber.getText()});
        
String firstname = txtFirstName.getText();
String lastname = txtLastName.getText();
String department = txtDepartment.getText();
String dateofbirth = txtDateOfBirth.getText();
String phonenumber = txtPhoneNumber.getText();
String jobtitle = txtJobTitle.getText();
String username = txtUserName.getText();
String password = txtPassword.getText();


if (txtFirstName.getText().equals("")){
    JOptionPane.showMessageDialog(null, "Enter your First Name");
   
}
else if(txtLastName.getText().equals("")){
    JOptionPane.showMessageDialog(null, "Enter your Last Name");
    
}
else if(txtDepartment.getText().equals("")){
    JOptionPane.showMessageDialog(null, "Enter your Department");
    
}
else if(txtDateOfBirth.getText().equals("")){
    JOptionPane.showMessageDialog(null, "Enter your Date of Birth");
    
}
else if(txtPhoneNumber.getText().equals("")){
    JOptionPane.showMessageDialog(null, "Enter your Phone Number");
    
}
else if(txtJobTitle.getText().equals("")){
    JOptionPane.showMessageDialog(null, "Enter your Job Title");
    
}
else if(txtUserName.getText().equals("")){
    JOptionPane.showMessageDialog(null, "Enter your User Name");
    
}
else if(txtPassword.getText().equals("")){
    JOptionPane.showMessageDialog(null, "Enter your Password");
    
}
else{
    JOptionPane.showMessageDialog(null, "Information Added Successfully");
    mGetValuesFromGUI();
        mSetValuesToUpperCase();
        mCheckIfItemsExistInTable();
        if(boolRecordExists==true)
           {
             boolRecordExists=false;
             lblOutput.setText("Employee already exists");
           }
        else if(boolRecordExists=false)
           {
              mCreateActor();
              mClearTextFields();
           }
}
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
mGetValuesFromGUI();
    mSetValuesToUpperCase();
    mUpdateActor();
    mLoadEmployeeInformation();
    boolEdit=true;
    DefaultTableModel model = (DefaultTableModel) tblTable.getModel();
model.addRow(new Object[] {txtFirstName.getText(),txtLastName.getText(),txtDepartment.getText(),txtDateOfBirth.getText(),txtPhoneNumber.getText()});
lblOutput.setText("Successfully Updated");// TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
 int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(p==0){
         DefaultTableModel model = (DefaultTableModel) tblTable.getModel();
if(tblTable.getSelectedRowCount()==1){
    model.removeRow(tblTable.getSelectedRow());
}else{
     if(tblTable.getRowCount()==0){
        JOptionPane.showMessageDialog(this, "Table is Empty");
    }else{
         JOptionPane.showMessageDialog(this, "Please select single Row to Delete");
     }
}
        try{
        }catch(Exception e){
        }finally {
            try{    
            }
            catch(Exception e){
            }
        }
        
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllActionPerformed
  int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete All Record?","Delete All Record",JOptionPane.YES_NO_OPTION);
        if(p==0){
         tblTable.setModel(new DefaultTableModel(null,new String[]{"First Name","Last Name","Department","DOB","Phone Number"}));
if(tblTable.getSelectedRowCount()==1){
    
}else{
     if(tblTable.getRowCount()==0){
        JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
    }else{
         
     }
}
        try{
        }catch(Exception e){
        }finally {
            try{    
            }
            catch(Exception e){
            }
        }
        
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteAllActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to Cancel?","Cancel",JOptionPane.YES_NO_OPTION);
        if(p==0){
         txtFirstName.setText("");
         txtLastName.setText("");
         txtDateOfBirth.setText("");
         txtDepartment.setText("");
         txtJobTitle.setText("");
         txtPhoneNumber.setText("");
         txtDepartment.setText("");
         txtUserName.setText("");
         txtPassword.setText("");
        try{
        }catch(Exception e){
        }finally {
            try{    
            }
            catch(Exception e){
            }
        }
        
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
    mReadActorDetails();
    mSetValuesInGUI();
    lblOutput.setText("Refreshing");// TODO add your handling code here:
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableMouseClicked
DefaultTableModel model = (DefaultTableModel)tblTable.getModel();
int selectedRowIndex = tblTable.getSelectedRow();

txtFirstName.setText(model.getValueAt(selectedRowIndex, 0).toString());
txtLastName.setText(model.getValueAt(selectedRowIndex, 1).toString());
txtDepartment.setText(model.getValueAt(selectedRowIndex, 2).toString());
txtDateOfBirth.setText(model.getValueAt(selectedRowIndex, 3).toString());
txtPhoneNumber.setText(model.getValueAt(selectedRowIndex, 4).toString());// TODO add your handling code here:
    }//GEN-LAST:event_tblTableMouseClicked

    private void mLoadEmployeeInformation()
    {
        String strDBConnectionString="jdbc:mysql://localhost:3306/employee_management_system";
        String strDBUser="root";
        String strDBPassword="password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
         conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
         stStatement = conMySQLConnectionString.createStatement();
         String strQuery = " Select first_name from employee_information";
         stStatement.execute(strQuery);
         rs=stStatement.getResultSet();
         while(rs.next())
         {
             
         }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try{
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Connection String not closed" + " " + e);
            }
        }
    }
    private void mReadActorDetails()
    {
        String strDBConnectionString="jdbc:mysql://localhost:3306/employee_management_system";
        String strDBUser="root";
        String strDBPassword="password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
         conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
         stStatement = conMySQLConnectionString.createStatement();
         String strQuery = " Select first_name,last_name,department, date_of_birth, phone_number from employee_information where movie_title='"+ tblTable.getModel().toString()+"'";
         stStatement.execute(strQuery);
         rs=stStatement.getResultSet();
         while(rs.next())
         {
             strFirstName = rs.getString(1);
             strLastName = rs.getString(2);
             strDepartment = rs.getString(3);
             strDateOfBirth= rs.getString(4);
             strPhoneNumber= rs.getString(5);
         }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try{
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Connection String not closed" + " " + e);
            }
        }
    }
    
    //Updating Employee Information from database
    private void mUpdateActor()
    {
        String strDBConnectionString="jdbc:mysql://localhost:3306/employee_management_system";
        String strDBUser="root";
        String strDBPassword="password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
         conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
         stStatement = conMySQLConnectionString.createStatement();
         String strQuery = " Update employee_information SET first_name='"+ strFirstName+ "',last_name='" +strLastName+ "', department='" +strDepartment+ "', date_of_birth='" +strDateOfBirth+ "', phone_number='" +strPhoneNumber+ "' WHERE employee_id=" +intEmployeeID;
         stStatement.executeUpdate(strQuery);
         rs=stStatement.getResultSet();
         while(rs.next())
         {
             
             strFirstName = rs.getString(1);
             strLastName = rs.getString(2);
             strDepartment = rs.getString(3);
             strDateOfBirth = rs.getString(4);
             strPhoneNumber = rs.getString(5);
         }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try{
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Connection String not closed" + " " + e);
            }
        }
    }
    
    //Deleting Employee from the database
    private void mDeleteActor()
    {
        String strDBConnectionString="jdbc:mysql://localhost:3306/employee_managemt_system";
        String strDBUser="root";
        String strDBPassword="password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
         conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
         String strQuery = "Delete from employee_information where first_name='" + strFirstName+ "'and last_name'" + strLastName + "'and Department'" + strDepartment + "'and date_of_birth'" + strDateOfBirth + "'and phone_number'" + strPhoneNumber + "'and job_title'" + strJobTitle + "'and user_name'" + strUserName + "'and password'" + strPassword + "'and employee_id = " + intEmployeeID;
         stStatement = conMySQLConnectionString.prepareStatement(strQuery);
         stStatement.execute(strQuery);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try{
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Connection String not closed" + " " + e);
            }
        }
    }
    private void mClearTable()
    {
        String[] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        tblTable.setModel(new DefaultTableModel(null,new String[]{"First","Last Name","Department","DOB","Phone Number",}));
    }
    
    private void mClearVariables()
    {
        strFirstName="";
        strLastName="";
        strDepartment="";
        strDateOfBirth="";
        strPhoneNumber="";
        strJobTitle="";
        strUserName="";
        strPassword="";
    }
    
    
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
            java.util.logging.Logger.getLogger(AdminPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPortal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Designer;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteAll;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel lblAdministrator;
    private javax.swing.JLabel lblCommands;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblEmployeeInformation;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblJobTitle;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JTable tblTable;
    private javax.swing.JTextField txtDateOfBirth;
    private javax.swing.JTextField txtDepartment;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtJobTitle;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
