package proba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Rezerve extends javax.swing.JFrame {

    int x;
    int y;
    JLabel p_ime;
    JTextField p_imeTxt;
    JLabel p_brojStola;
    JTextField p_txtBrojStola;
    JLabel p_datum;
    JTextField p_datumTxt;
    JLabel p_pozicijaStola;
    JTextField p_pozicijaStolaTxt;
    JLabel p_brojMesta;
    JTextField p_brojMestaTxt;
    JPanel p2 = new JPanel();
    JDialog d2;
    JFrame frame;
    JDialog prefDialog;
    JDialog dilalogSet;
    JDialog setDialog;
    JPanel panel;

    public Rezerve() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void setFont(String f, int fs) {
        txt_ime.setFont(new Font(f, Font.PLAIN, fs));
    }

    public boolean checkInput() {
        if (txt_brojStola.getText() == null
                || txt_ime.getText() == null
                || txt_datum.getDate() == null
                || txt_pozicijaStola.getText() == null
                || txt_brojMesta.getText() == null) {
            return false;
        } else {
            return true;
        }
    }

    public Connection getConnetion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zakazivanje", "root", "root");
        } catch (SQLException ex) {
            System.out.println("Greska pri konekciji");
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Rezerve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Rezerve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Rezerve.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void ispisiStatusRezervacije() {

        String ime = txt_ime.getText();
        Statement st;
        Connection con = getConnetion();
        try {
            st = con.createStatement();
            st.execute("select * from sto where imePrezime = '" + ime + "'");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                p_imeTxt.setText(rs.getString("imePrezime"));
                String brojSt = String.valueOf(rs.getInt("brojStola"));
                p_txtBrojStola.setText(brojSt);
                p_datumTxt.setText(rs.getString("date"));
                p_pozicijaStolaTxt.setText(rs.getString("pozicijaStola"));
                String brMes = String.valueOf(rs.getInt("brojMesta"));
                p_brojMestaTxt.setText(brMes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rezerve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame1 = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        colorLabel1 = new javax.swing.JLabel();
        color1 = new javax.swing.JComboBox<>();
        fontLabel1 = new javax.swing.JLabel();
        font1 = new javax.swing.JComboBox<>();
        fontSizeLabel1 = new javax.swing.JLabel();
        fontSize1 = new javax.swing.JComboBox<>();
        buttonCancel1 = new javax.swing.JButton();
        buttonSave1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_ime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_brojStola = new javax.swing.JTextField();
        txt_pozicijaStola = new javax.swing.JTextField();
        txt_brojMesta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txt_datum = new com.toedter.calendar.JDateChooser();
        cancel = new javax.swing.JButton();
        info = new javax.swing.JButton();
        pogledaj = new javax.swing.JButton();
        se = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));
        jPanel3.setLayout(new java.awt.GridLayout(4, 2, 1, 1));

        colorLabel1.setText("Color:");
        jPanel3.add(colorLabel1);

        color1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Red", "Green", "Blue", "Cyan", "Magenta", "Yellow" }));
        color1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color1ActionPerformed(evt);
            }
        });
        jPanel3.add(color1);

        fontLabel1.setText("Font:");
        jPanel3.add(fontLabel1);

        font1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arial", "Times New Roman", "Helvetica"}));
        font1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                font1ActionPerformed(evt);
            }
        });
        jPanel3.add(font1);

        fontSizeLabel1.setText("Font size: ");
        jPanel3.add(fontSizeLabel1);

        fontSize1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "18", "25" }));
        jPanel3.add(fontSize1);

        buttonCancel1.setText("Cancel");
        buttonCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancel1ActionPerformed(evt);
            }
        });
        jPanel3.add(buttonCancel1);

        buttonSave1.setText("Save");
        buttonSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSave1ActionPerformed(evt);
            }
        });
        jPanel3.add(buttonSave1);

        javax.swing.GroupLayout frame1Layout = new javax.swing.GroupLayout(frame1.getContentPane());
        frame1.getContentPane().setLayout(frame1Layout);
        frame1Layout.setHorizontalGroup(
            frame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );
        frame1Layout.setVerticalGroup(
            frame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Rezervation");

        txt_ime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_imePerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel2.setText("Ime i Prezime:");

        jLabel3.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel3.setText("Broj Stola:");

        jLabel4.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel4.setText("Datum:");

        jLabel5.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel5.setText("Pozicija stola");

        jLabel6.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel6.setText("Broj mesta: ");

        txt_pozicijaStola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pozicijaStolaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Rezervisi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        info.setText("Info");
        info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoActionPerformed(evt);
            }
        });

        pogledaj.setText("Pogledaj rezervaciju");
        pogledaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pogledajActionPerformed(evt);
            }
        });

        se.setBackground(new java.awt.Color(0, 204, 204));
        se.setText("Settings");
        se.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("  X");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(info)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(se))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_brojStola, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_pozicijaStola, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_brojMesta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_ime, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(pogledaj)
                                    .addGap(82, 82, 82)
                                    .addComponent(cancel)))
                            .addGap(18, 18, 18)
                            .addComponent(jButton1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_brojStola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_pozicijaStola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_brojMesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(cancel)
                    .addComponent(pogledaj))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(info)
                    .addComponent(se))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pozicijaStolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pozicijaStolaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pozicijaStolaActionPerformed

    private void txt_imePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_imePerformed

    }//GEN-LAST:event_txt_imePerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (checkInput() == true) {
            try {
                Connection con = getConnetion();
                PreparedStatement ps = con.prepareStatement("INSERT INTO sto(imePrezime,brojStola,date,pozicijaStola,brojMesta)  VALUES (?,?,?,?,?)");
                ps.setString(1, txt_ime.getText());
                ps.setInt(2, Integer.parseInt(txt_brojStola.getText()));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String addDate = dateFormat.format(txt_datum.getDate());
                ps.setString(3, addDate);
                ps.setString(4, txt_pozicijaStola.getText());
                ps.setInt(5, Integer.parseInt(txt_brojMesta.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Ubaceno u bazu");
            } catch (SQLException ex) {
                Logger.getLogger(Rezerve.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Popunite sva polja");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        txt_ime.setText("");
        txt_brojStola.setText("");
        txt_datum.setDateFormatString("");
        txt_pozicijaStola.setText("");
        txt_brojMesta.setText("");
    }//GEN-LAST:event_cancelActionPerformed

    private void infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoActionPerformed
        JPanel p = new JPanel();
        GridLayout g = new GridLayout();
        JDialog d = new JDialog();
        //Ovde smo mogli iz File da procitamo ,nego sam samo ovako demonstrirao kao example
        JTextArea are = new JTextArea(" Mi smo jedan lepi mali restorancic sa puno ljubavi \n"
                + " i strpljenja.Rezervisite mesto u nasem restoranu! \n Pritiskom na dugme 'Rezervisi' automatski ste izvrsili rezevaciju. \n Hvala Vam na poverenju!");
        are.setFont(new Font("Tahoma", 16, 15));
        are.setVisible(true);
        d.setVisible(true);
        d.setSize(450, 200);
        d.setLocationRelativeTo(null);
        d.add(are);
        are.setBackground(new Color(255, 178, 102));
    }//GEN-LAST:event_infoActionPerformed

    private void pogledajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pogledajActionPerformed
        p_ime = new JLabel("Ime i prezime: ");
        p_imeTxt = new JTextField();
        p_brojStola = new JLabel("Broj stola: ");
        p_txtBrojStola = new JTextField();
        p_datum = new JLabel("Datum: ");
        p_datumTxt = new JTextField();
        p_pozicijaStola = new JLabel("Pozicija stola: ");
        p_pozicijaStolaTxt = new JTextField();
        p_brojMesta = new JLabel("Broj mesta: ");
        p_brojMestaTxt = new JTextField();
        p2 = new JPanel();
        GridLayout g2 = new GridLayout(6, 2);
        p2.setLayout(g2);
        p2.add(p_ime);
        p2.add(p_imeTxt);
        p2.add(p_brojStola);
        p2.add(p_txtBrojStola);
        p2.add(p_datum);
        p2.add(p_datumTxt);
        p2.add(p_pozicijaStola);
        p2.add(p_pozicijaStolaTxt);
        p2.add(p_brojMesta);
        p2.add(p_brojMestaTxt);

        //Smestanje podataka iz baze
        d2 = new JDialog();
        d2.setContentPane(p2);
        d2.getContentPane().setBackground(new Color(255, 178, 102));
        d2.setSize(300, 200);
        d2.setLocationRelativeTo(null);
        d2.setVisible(true);

        ispisiStatusRezervacije();
    }//GEN-LAST:event_pogledajActionPerformed

    private void seActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seActionPerformed
        frame1.setSize(400, 200);
        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);
        frame1.pack();
        frame1.setVisible(true);
    }//GEN-LAST:event_seActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int posx = evt.getXOnScreen();
        int posy = evt.getYOnScreen();
        this.setLocation(posx - x, posy - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MouseMoved

    private void buttonCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCancel1ActionPerformed

    private void color1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_color1ActionPerformed

    private void font1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_font1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_font1ActionPerformed

    private void buttonSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSave1ActionPerformed
        String fontChoose;
        int fontss;
        frame1.setVisible(false);
        if ((String) color1.getSelectedItem() == "Red") {
            txt_ime.setForeground(Color.red);
            jPanel1.setBackground(Color.red);
        } else if ((String) color1.getSelectedItem() == "Green") {
            txt_ime.setForeground(Color.green);
            jPanel1.setBackground(Color.green);
        } else if ((String) color1.getSelectedItem() == "Blue") {
            txt_ime.setForeground(Color.blue);
            jPanel1.setBackground(Color.blue);
        } else if ((String) color1.getSelectedItem() == "Cyan") {
            txt_ime.setForeground(Color.cyan);
            jPanel1.setBackground(Color.cyan);
        } else if ((String) color1.getSelectedItem() == "Magenta") {
            txt_ime.setForeground(Color.magenta);
            jPanel1.setBackground(Color.magenta);
        } else if ((String) color1.getSelectedItem() == "Yellow") {
            txt_ime.setForeground(Color.yellow);
            jPanel1.setBackground(Color.yellow);
        }
        Sett set = new Sett();
        fontChoose = (String) font1.getSelectedItem();
        fontss = Integer.parseInt((String) fontSize1.getSelectedItem());

        txt_ime.setFont(new Font(fontChoose, Font.PLAIN, fontss));
        set.setColorr((String) color1.getSelectedItem());
        set.setFontr(fontChoose);
        set.setFontSizee(fontss);
        try (FileOutputStream fileOut = new FileOutputStream("er.ser");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {
            objectOut.writeObject(set);
        } catch (IOException ioe) {
            System.out.println("I/O error: " + ioe.getMessage());
        }
    }//GEN-LAST:event_buttonSave1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Rezerve().setVisible(true);
            }
        });
        Rezerve r = new Rezerve();
        Sett s;
        try (FileInputStream fileIn = new FileInputStream("er.ser");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);) {
            s = (Sett) objectIn.readObject();
            if (s.getColorr().contains("Red")) {
                r.txt_ime.setForeground(Color.red);
                r.color1.setSelectedItem("Red");
            } else if (s.getColorr().contains("Green")) {
                r.txt_ime.setForeground(Color.green);
                r.color1.setSelectedItem("Green");
            } else if (s.getColorr().contains("Blue")) {
                r.txt_ime.setForeground(Color.blue);
                r.color1.setSelectedItem("Blue");
            } else if (s.getColorr().contains("Cyan")) {
                r.txt_ime.setForeground(Color.cyan);
                r.color1.setSelectedItem("Cyan");
            } else if (s.getColorr().contains("Magenta")) {
                r.txt_ime.setForeground(Color.magenta);
                r.color1.setSelectedItem("Magenta");
            } else if (s.getColorr().contains("Yellow")) {
                r.txt_ime.setForeground(Color.yellow);
                r.color1.setSelectedItem("Yellow");
            } else if (s.getColorr().contains("Black")) {
                r.txt_ime.setForeground(Color.black);
                r.color1.setSelectedItem("Black");
            }
            r.setFont(s.getFontr(), s.getFontSizee());
            r.font1.setSelectedItem(s.getFontr());
            r.fontSize1.setSelectedItem("" + s.getFontSizee());
        } catch (FileNotFoundException ex) {
            r.setFont("Arial", 25);
            r.txt_ime.setForeground(Color.black);
            Logger.getLogger(Rezerve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Rezerve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Rezerve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel1;
    private javax.swing.JButton buttonSave1;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> color1;
    private javax.swing.JLabel colorLabel1;
    private javax.swing.JComboBox<String> font1;
    private javax.swing.JLabel fontLabel1;
    private javax.swing.JComboBox<String> fontSize1;
    private javax.swing.JLabel fontSizeLabel1;
    private javax.swing.JFrame frame1;
    private javax.swing.JButton info;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton pogledaj;
    private javax.swing.JButton se;
    private javax.swing.JTextField txt_brojMesta;
    private javax.swing.JTextField txt_brojStola;
    private com.toedter.calendar.JDateChooser txt_datum;
    private javax.swing.JTextField txt_ime;
    private javax.swing.JTextField txt_pozicijaStola;
    // End of variables declaration//GEN-END:variables
}
