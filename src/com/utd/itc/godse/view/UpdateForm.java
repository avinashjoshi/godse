/*
 * Collaborators:
 * Avinash Joshi <axj107420@utdallas.edu>
 * Sandeep Shenoy <sxs115220@utdallas.edu>
 * Shishir Krishnaprasad <sxk116430@utdallas.edu>
 * 
 * (c) 2012 GODSe
 */
package com.utd.itc.godse.view;

import com.google.gdata.data.acl.AclFeed;
import com.google.gdata.data.docs.DocumentListEntry;
import com.utd.itc.godse.action.UpdateGDocAction;
import com.utd.itc.godse.bean.GoDSeDocumentListEntry;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UpdateForm extends javax.swing.JFrame {

    /**
     * Creates new form UpdateForm
     */
    public UpdateForm() {
        initComponents();
        myInitComponents();
    }

    public UpdateForm(String fPath, DocumentListEntry gEnt, AclFeed aFeed, String cKey, String dData) {
        filePath = fPath;
        gEntry.setEntry(gEnt);
        gEntry.setAclFeeds(aFeed);
        dEntry = gEnt;
        currKey = cKey;
        documentData = dData;
        initComponents();
        myInitComponents();
        update.addActionListener(new UpdateGDocAction(this, dEntry, currKey));
    }

    public int validateForm() {
        if (changeKey.isSelected()) {
            if (!key.getText().equals(confirmKey.getText())) {
                return -1;
            }
            if ("".equalsIgnoreCase(key.getText()) || "".equalsIgnoreCase(confirmKey.getText())) {
                return -2;
            }

        }
        if ("".equalsIgnoreCase(docData.getText())) {
            return -3;
        }
        return 1;
    }

    public void myInitComponents() {

        try {
            key.setVisible(false);
            KeyLbl.setVisible(false);
            confirmKey.setVisible(false);
            ConfirmKeyLbl.setVisible(false);


            docData.setText(documentData);
        } catch (Exception ex) {
            ex.printStackTrace();
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

        ApplicationName = new javax.swing.JLabel();
        docDataScrollPane = new javax.swing.JScrollPane();
        docData = new javax.swing.JTextArea();
        key = new javax.swing.JTextField();
        KeyLbl = new javax.swing.JLabel();
        ConfirmKeyLbl = new javax.swing.JLabel();
        confirmKey = new javax.swing.JTextField();
        close = new javax.swing.JButton();
        update = new javax.swing.JButton();
        changeKey = new javax.swing.JCheckBox();
        errorMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GODSe: Update Encrypted Document");
        setLocation(new java.awt.Point(75, 75));
        setSize(new java.awt.Dimension(800, 560));

        ApplicationName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ApplicationName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ApplicationName.setText("Google Docs Secured (GoDSe)");
        ApplicationName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        docData.setColumns(0);
        docData.setLineWrap(true);
        docData.setRows(0);
        docData.setName("docData");
        docDataScrollPane.setViewportView(docData);

        key.setToolTipText("Key");
        key.setName("key");

        KeyLbl.setText("New Key");

        ConfirmKeyLbl.setText("Confirm New Key");

        confirmKey.setToolTipText("Confirm Key");
        confirmKey.setName("confirmKey");

        close.setText("Close");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        update.setText("Update");

        changeKey.setText("Change Key?");
        changeKey.setToolTipText("Do you want to change your key?");
        changeKey.setName("changeKey");
        changeKey.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                changeKeyItemStateChanged(evt);
            }
        });

        errorMsg.setForeground(new java.awt.Color(255, 0, 0));
        errorMsg.setToolTipText("Error Message");
        errorMsg.setName("errorMsg");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(250, 250, 250)
                        .add(ApplicationName))
                    .add(layout.createSequentialGroup()
                        .add(52, 52, 52)
                        .add(changeKey)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(docDataScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 784, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                            .add(518, 518, 518)
                            .add(close, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 113, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(27, 27, 27)
                            .add(update, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(layout.createSequentialGroup()
                            .add(57, 57, 57)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(errorMsg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 455, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(layout.createSequentialGroup()
                                    .add(KeyLbl)
                                    .add(18, 18, 18)
                                    .add(key, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 185, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(43, 43, 43)
                                    .add(ConfirmKeyLbl)
                                    .add(29, 29, 29)
                                    .add(confirmKey, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 169, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                .add(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(ApplicationName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(52, 52, 52)
                .add(docDataScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 336, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(changeKey)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(KeyLbl)
                    .add(key, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ConfirmKeyLbl)
                    .add(confirmKey, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(update)
                            .add(close))
                        .add(0, 30, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(errorMsg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        errorMsg.getAccessibleContext().setAccessibleName("errorMsg");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        this.dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void changeKeyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_changeKeyItemStateChanged

        if (evt.getStateChange() == 1) {
            key.setVisible(true);
            KeyLbl.setVisible(true);
            confirmKey.setVisible(true);
            ConfirmKeyLbl.setVisible(true);
        } else if (evt.getStateChange() == 2) {
            key.setVisible(false);
            KeyLbl.setVisible(false);
            confirmKey.setVisible(false);
            ConfirmKeyLbl.setVisible(false);
        }
    }//GEN-LAST:event_changeKeyItemStateChanged

    public JTextField getConfirmKey() {
        return confirmKey;
    }

    public void setConfirmKey(JTextField confirmKey) {
        this.confirmKey = confirmKey;
    }

    public JTextArea getDocData() {
        return docData;
    }

    public void setDocData(JTextArea docData) {
        this.docData = docData;
    }

    public JTextField getKey() {
        return key;
    }

    public void setKey(JTextField key) {
        this.key = key;
    }

    public JCheckBox getChangeKey() {
        return changeKey;
    }

    public void setChangeKey(JCheckBox changeKey) {
        this.changeKey = changeKey;
    }

    public void showErrorMessage(String message) {

        errorMsg.setVisible(true);
        errorMsg.setText("");
        errorMsg.setText("* " + message);
    }

    public void hideErrorMessage() {
        errorMsg.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UpdateForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApplicationName;
    private javax.swing.JLabel ConfirmKeyLbl;
    private javax.swing.JLabel KeyLbl;
    private javax.swing.JCheckBox changeKey;
    private javax.swing.JButton close;
    private javax.swing.JTextField confirmKey;
    private javax.swing.JTextArea docData;
    private javax.swing.JScrollPane docDataScrollPane;
    private javax.swing.JLabel errorMsg;
    private javax.swing.JTextField key;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
    private String filePath;
    private GoDSeDocumentListEntry gEntry = new GoDSeDocumentListEntry();
    private DocumentListEntry dEntry;
    private String currKey;
    private String documentData;
}
