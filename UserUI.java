
package DPIT121.Insurance_Policies1;

import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class UserUI extends javax.swing.JFrame {

    User user;
    GUI login;
    ArrayList<String> cities;
    boolean admin;
    AdminUI adminUI;
    
    public UserUI(ArrayList<String> cities, User user, GUI login) {
        initComponents();
        this.setVisible(true);
        this.user = user;
        this.login = login;
        this.cities=cities;
        
        setEditUserDetailsInfo();
        setAddress();
        setAddPolicyTab();
        setTable();
        admin = false;
    }
    
        public UserUI(ArrayList<String> cities, User user, AdminUI admin) {
        initComponents();
        
        adminUI = admin;
        this.setVisible(true);
        this.user = user;
        this.login = login;
        this.cities=cities;
        
        setEditUserDetailsInfo();
        setAddress();
        setAddPolicyTab();
        setTable();
        this.admin = true;
        setAdminInterface();
    }
        
    public void setAdminInterface()
    {
        logout.setText("Go Back");
        name.setEnabled(true);
        
    }
    
    public void setAddress()
    {
        newCity.setVisible(false);
        suburb.setText(user.getAddress().getSuburb());
        street.setText(user.getAddress().getStreetName());
        streetNum.setText(user.getAddress().getStreetNum() + "");
    }
    
    public void setEditUserDetailsInfo()
    {
        userID.setText(user.getUserID()+"");
        name.setText(user.getName());
        password.setText(user.getPass());
        populateCityComboBox();
    }
    
    public void setAddPolicyTab()
    {
        headingAddPolicy.setText("Add policy for " + user.getName()); //for add policy tab
        for (CarType type : CarType.values())
        {
            carType.addItem(type.toString());
        }
    }
    
    public void populateCityComboBox()
    {
        for(String city : cities)
        {
            citiesList.addItem(city);
        }
        citiesList.setSelectedItem(user.getCity());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        userID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        citiesList = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        passCheck = new javax.swing.JCheckBox();
        changeCity = new javax.swing.JCheckBox();
        newCity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        streetNum = new javax.swing.JTextField();
        street = new javax.swing.JTextField();
        suburb = new javax.swing.JTextField();
        model = new javax.swing.JPanel();
        thirdPartyPolicy = new javax.swing.JRadioButton();
        compPolicy = new javax.swing.JRadioButton();
        headingAddPolicy = new javax.swing.JLabel();
        addPolicy = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        carYear = new javax.swing.JTextField();
        carPrice = new javax.swing.JTextField();
        carModel = new javax.swing.JTextField();
        carType = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        claims = new javax.swing.JTextField();
        driverAge = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        day = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        month = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        findID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        found = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        filterTable = new javax.swing.JTable();
        sort = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        xDate = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        xModel = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        logout = new javax.swing.JMenu();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);

        jTabbedPane6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane6MouseClicked(evt);
            }
        });

        jLabel1.setText("User name");

        jLabel2.setText("City");

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        name.setEnabled(false);

        userID.setEditable(false);
        userID.setEnabled(false);

        jLabel3.setText("User ID");

        jLabel4.setText("Password");

        password.setToolTipText("");
        password.setEnabled(false);

        passCheck.setText("Change Password");
        passCheck.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                passCheckStateChanged(evt);
            }
        });
        passCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passCheckActionPerformed(evt);
            }
        });

        changeCity.setText(" New City");
        changeCity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                changeCityStateChanged(evt);
            }
        });
        changeCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeCityActionPerformed(evt);
            }
        });

        jLabel5.setText("___Address Details___");

        jLabel6.setText("Street Number");

        jLabel7.setText("Street Name");

        jLabel9.setText("Suburb");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(suburb)
                                    .addComponent(streetNum, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(street, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(citiesList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newCity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(userID, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passCheck)
                            .addComponent(changeCity))
                        .addGap(187, 187, 187)
                        .addComponent(update))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passCheck))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5)
                        .addGap(126, 126, 126)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(citiesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(newCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(34, 34, 34)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(streetNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(street, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(suburb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(changeCity)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(update)
                .addGap(31, 31, 31))
        );

        jTabbedPane6.addTab("Edit", jPanel1);

        buttonGroup1.add(thirdPartyPolicy);
        thirdPartyPolicy.setText("ThirdParthPolicy");
        thirdPartyPolicy.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thirdPartyPolicyStateChanged(evt);
            }
        });
        thirdPartyPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirdPartyPolicyActionPerformed(evt);
            }
        });

        buttonGroup1.add(compPolicy);
        compPolicy.setText("ComprehensivePolicy");
        compPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compPolicyActionPerformed(evt);
            }
        });

        addPolicy.setText("Add");
        addPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPolicyActionPerformed(evt);
            }
        });

        jLabel10.setText("Car Details");

        jLabel11.setText("Model");

        jLabel12.setText("Manufactured Year");

        jLabel13.setText("Type");

        jLabel14.setText("Price");

        carType.setToolTipText("");

        jLabel15.setText("$");

        jLabel16.setText("Policy Details");

        jLabel17.setText("Number of Claims");

        ageLabel.setText("Driver's Age");

        jLabel18.setText("Expiry Date");

        jLabel19.setText("Day");

        jLabel20.setText("Month");

        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });

        jLabel21.setText("Year");

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modelLayout = new javax.swing.GroupLayout(model);
        model.setLayout(modelLayout);
        modelLayout.setHorizontalGroup(
            modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modelLayout.createSequentialGroup()
                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modelLayout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(headingAddPolicy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(modelLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(modelLayout.createSequentialGroup()
                                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, modelLayout.createSequentialGroup()
                                        .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel13))
                                        .addGap(90, 90, 90)
                                        .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(carPrice)
                                            .addComponent(carType, 0, 71, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, modelLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(86, 86, 86)
                                        .addComponent(carModel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15))
                            .addGroup(modelLayout.createSequentialGroup()
                                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(modelLayout.createSequentialGroup()
                                        .addComponent(carYear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 498, Short.MAX_VALUE))
                                    .addGroup(modelLayout.createSequentialGroup()
                                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(modelLayout.createSequentialGroup()
                        .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(modelLayout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(thirdPartyPolicy)
                                .addGap(18, 18, 18)
                                .addComponent(compPolicy))
                            .addGroup(modelLayout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel18)))
                            .addGroup(modelLayout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(ageLabel))
                                .addGap(35, 35, 35)
                                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(claims, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(driverAge, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 335, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addPolicy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(13, 13, 13))
        );
        modelLayout.setVerticalGroup(
            modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(headingAddPolicy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thirdPartyPolicy)
                    .addComponent(compPolicy))
                .addGap(31, 31, 31)
                .addComponent(jLabel10)
                .addGap(4, 4, 4)
                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(carModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(carType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(carPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(carYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(claims, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ageLabel)
                    .addComponent(driverAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPolicy)
                    .addComponent(jButton1))
                .addGap(17, 17, 17))
        );

        jTabbedPane6.addTab("Add Poilicy", model);

        jLabel22.setText("Policy ID");

        findID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findIDActionPerformed(evt);
            }
        });

        found.setBackground(new java.awt.Color(153, 255, 153));
        found.setColumns(20);
        found.setRows(5);
        jScrollPane1.setViewportView(found);

        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(findID, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(76, 76, 76))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(findID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Find Policy", jPanel3);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Policy ID", "Car Model", "Car TYPE", "Year Made", "Price", "Total Claims", "Expiry Date"
            }
        ));
        jScrollPane2.setViewportView(table);

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 435, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(66, 66, 66)
                        .addComponent(jButton4)
                        .addGap(170, 170, 170))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(25, 25, 25))
        );

        jTabbedPane6.addTab("Policies Information", jPanel2);

        filterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Policy ID", "Car Model", "Car TYPE", "Year Made", "Price", "Total Claims", "Expiry Date"
            }
        ));
        jScrollPane4.setViewportView(filterTable);

        sort.setText("Sort by Car Model");
        sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortActionPerformed(evt);
            }
        });

        jLabel23.setText("Filter by Expirt Date");

        jButton6.setText("Filter");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel24.setText("Filter by Car Model");

        xModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xModelActionPerformed(evt);
            }
        });
        xModel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xModelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                xModelKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(153, 153, 153)
                        .addComponent(sort)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(xDate, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xModel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(xDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(xModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(sort)
                        .addContainerGap())))
        );

        jTabbedPane6.addTab("Filter Plans", jPanel5);

        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        logout.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        logout.setLabel("LogOut");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(logout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        if(admin)
        {
            adminUI.setVisible(true);
        }
        else
        {
            login.setVisible(true);
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        try {
        user.setPass(password.getText());
        
        updateAddress();
        
        JOptionPane.showMessageDialog(this,"Updated Successfull!");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this,"Error Updating record   "+e);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void updateAddress()
    {
        user.setSuburb(suburb.getText());
        if (changeCity.isSelected())
        {
            user.setCity(newCity.getText());
        }else
        {
            user.setCity(citiesList.getSelectedItem().toString());
        }
        user.setStreetName(street.getText());
        try{
        user.setStreetNum((Integer.parseInt(streetNum.getText())));
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Plase try entering correct Street number   "+e);
        }
    }
    
    private void passCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passCheckActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_passCheckActionPerformed

    private void passCheckStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_passCheckStateChanged
        // TODO add your handling code here:
        if (passCheck.isSelected())
        {
            password.setEnabled(true);
        }
        else
        {
            password.setEnabled(false);
        }
    }//GEN-LAST:event_passCheckStateChanged

    private void changeCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeCityActionPerformed

    private void changeCityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_changeCityStateChanged
        // TODO add your handling code here:
        if (changeCity.isSelected())
        {
            citiesList.setVisible(false);
            newCity.setVisible(true);
        }
        else
        {
            citiesList.setVisible(true);
            newCity.setVisible(false);
        }
    }//GEN-LAST:event_changeCityStateChanged

    private void addPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPolicyActionPerformed
        // TODO add your handling code here:
        int mYear=0;
        double price=0;
        int claim=0;
        int dayx=0;
        int monthx=0;
        int yearx=0;
        
        
        String model = carModel.getText();
        CarType type = CarType.valueOf(carType.getSelectedItem().toString());
        try{
            mYear = Integer.parseInt(carYear.getText());
        }catch(Exception e)
        {JOptionPane.showMessageDialog(this,"Invalid Manufacturing year entry try Again   "+e);}
        try{
            price = Double.valueOf(carPrice.getText());
        }catch(Exception e)
        {JOptionPane.showMessageDialog(this,"Invalid price entry try Again   "+e);}
        try{
            claim = Integer.parseInt(claims.getText());
        }catch(Exception e)
        {JOptionPane.showMessageDialog(this,"Invalid number of claims entry try Again   "+e);}
        int age = 0;
        try{
        dayx = Integer.parseInt(day.getText());
        monthx = Integer.parseInt(month.getText());
        yearx = Integer.parseInt(year.getText());
        }catch(Exception e)
        {JOptionPane.showMessageDialog(this,"Invalid Expiry Date entry try Again   "+e);}
        
        if (thirdPartyPolicy.isSelected())
        {
            user.createThirdPartyPolicy(user.getName(), new Car(model,mYear,price,type), new MyDate(yearx,monthx,dayx), claim);
            JOptionPane.showMessageDialog(this,"Added Successfully");
        }else
        {
            try
            {
            age = Integer.parseInt(driverAge.getText());
            user.createComprehensivePolicy(user.getName(), new Car(model,mYear,price,type), new MyDate(yearx,monthx,dayx), claim,age);
            JOptionPane.showMessageDialog(this,"Added Successfully");
            }catch(Exception e){JOptionPane.showMessageDialog(this,"Invalid age entry try Again   "+e);}
        }
        
        
        clearPolicyTab();
        
    }//GEN-LAST:event_addPolicyActionPerformed

    public void clearPolicyTab()
    
    {
        carModel.setText("");
        carYear.setText("");
        carPrice.setText("");
        claims.setText("");
        driverAge.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
    
    }
    
    private void jTabbedPane6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane6MouseClicked
        // TODO add your handling code here:
        
        filter(user.getPolicies());
    }//GEN-LAST:event_jTabbedPane6MouseClicked

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearPolicyTab();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void findIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findIDActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        found.setText("");
        try
        {
            found.setText(user.findPolicy(Integer.parseInt(findID.getText())).toString());
        }catch (NullPointerException e)
        {
            found.setText("Policy Donot Exist"+e);
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(this,"Invalid Entry"+e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int policyId = (int)table.getValueAt(table.getSelectedRow(), 0); //getting value of first coloum at selected row.
        InsurancePolicy policy = user.findPolicy(policyId);
        
        new Edit(policy,this);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        int poilicyId = (int)table.getValueAt(table.getSelectedRow(), 0); //getting value of first coloum at selected row.
        
        if (user.deletePolicy(poilicyId))
        {
            setTable();
            JOptionPane.showMessageDialog(this,"Deleted Successfuly");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void thirdPartyPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirdPartyPolicyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thirdPartyPolicyActionPerformed

    private void thirdPartyPolicyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thirdPartyPolicyStateChanged
        // TODO add your handling code here:
        if (thirdPartyPolicy.isSelected())
        {
            driverAge.setVisible(false);
            ageLabel.setVisible(false);
        }else
        {
            driverAge.setVisible(true);
            ageLabel.setVisible(true);
        }
    }//GEN-LAST:event_thirdPartyPolicyStateChanged

    private void compPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compPolicyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compPolicyActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        setTable();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortActionPerformed
        // TODO add your handling code here:
        if (sort.isSelected())
        {
            ArrayList<InsurancePolicy> policies = new ArrayList<>(user.getPolicies());
            Collections.sort(policies);
            filter(policies);
        }
    }//GEN-LAST:event_sortActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String[] fDate = xDate.getText().split("/");
        
        MyDate date = new MyDate(Integer.parseInt(fDate[2]),Integer.parseInt(fDate[1]),Integer.parseInt(fDate[0]));
        
        filter(user.filterByExpiryDate(date));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void xModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xModelActionPerformed

    private void xModelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xModelKeyTyped
        // TODO add your handling code here:
        //filter(user.filterByCarModel(xModel.getText()));
    }//GEN-LAST:event_xModelKeyTyped

    private void xModelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xModelKeyReleased
        // TODO add your handling code here:
        filter(user.filterByCarModel(xModel.getText()));
    }//GEN-LAST:event_xModelKeyReleased

    public void setTable()
    {
        DefaultTableModel modelx = (DefaultTableModel)table.getModel();
        modelx.setRowCount(0); //clears any thing remaining.
        user.getPolicies().forEach((policy) -> {
            modelx.addRow(new Object[]{
                policy.id, policy.getCarModel(), policy.car.getCarType(), policy.car.getManufacturingYear(),policy.car.getPrice(),policy.numberOfClaims,policy.expiryDate
            });
        });
    }
    
    public void filter(ArrayList<InsurancePolicy> policies)
    {
        DefaultTableModel model2 = (DefaultTableModel)filterTable.getModel();
        model2.setRowCount(0); //clears any thing remaining.
        policies.forEach((policy) -> {
            model2.addRow(new Object[]{
                policy.id, policy.getCarModel(), policy.car.getCarType(), policy.car.getManufacturingYear(),policy.car.getPrice(),policy.numberOfClaims,policy.expiryDate
            });
        });
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPolicy;
    private javax.swing.JLabel ageLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField carModel;
    private javax.swing.JTextField carPrice;
    private javax.swing.JComboBox<String> carType;
    private javax.swing.JTextField carYear;
    private javax.swing.JCheckBox changeCity;
    private javax.swing.JComboBox<String> citiesList;
    private javax.swing.JTextField claims;
    private javax.swing.JRadioButton compPolicy;
    private javax.swing.JTextField day;
    private javax.swing.JTextField driverAge;
    private javax.swing.JTable filterTable;
    private javax.swing.JTextField findID;
    private javax.swing.JTextArea found;
    private javax.swing.JLabel headingAddPolicy;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JMenu logout;
    private javax.swing.JPanel model;
    private javax.swing.JTextField month;
    private javax.swing.JTextField name;
    private javax.swing.JTextField newCity;
    private javax.swing.JCheckBox passCheck;
    private javax.swing.JTextField password;
    private javax.swing.JCheckBox sort;
    private javax.swing.JTextField street;
    private javax.swing.JTextField streetNum;
    private javax.swing.JTextField suburb;
    private javax.swing.JTable table;
    private javax.swing.JRadioButton thirdPartyPolicy;
    private javax.swing.JButton update;
    private javax.swing.JTextField userID;
    private javax.swing.JTextField xDate;
    private javax.swing.JTextField xModel;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables

}
