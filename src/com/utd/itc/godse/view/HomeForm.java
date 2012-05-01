/*
 * Collaborators:
 * Avinash Joshi <axj107420@utdallas.edu>
 * Sandeep Shenoy <sxs115220@utdallas.edu>
 * Shishir Krishnaprasad <sxk116430@utdallas.edu>
 * 
 * (c) 2012 GODSe
 */
package com.utd.itc.godse.view;

import com.google.gdata.data.docs.DocumentListEntry;
import com.utd.itc.godse.action.ReadAction;
import com.utd.itc.godse.action.UpdateFormAction;
import com.utd.itc.godse.bean.GoDSeDataStore;
import com.utd.itc.godse.bean.GoDSeDocumentListEntry;
import com.utd.itc.godse.helper.GoDSeHelper;
import com.utd.itc.godse.resource.Messages;
import javax.swing.JList;

public class HomeForm extends javax.swing.JFrame {

    /**
     * Creates new form HomeForm
     */
    public HomeForm() {
        initComponents();
        updateDocList();
        read.addActionListener(new ReadAction(this));
        update.addActionListener(new UpdateFormAction(this));
    }

    public void updateDocList() {

        try {

            String[] docListName = new String[GoDSeDataStore.documentList.size()];
            docList.setListData(docListName);
            for (int i = 0; i < GoDSeDataStore.documentList.size(); i++) {
                docListName[i] = ((GoDSeDocumentListEntry) GoDSeDataStore.documentList.get(i)).getEntry().getTitle().getPlainText();
            }

            docList.setListData(docListName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public boolean validateChoice() {
        errorMsg.setVisible(false);

        if (this.docList.getSelectedIndex() < 0) {
            return false;
        }

        return true;
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        docListPanel = new javax.swing.JScrollPane();
        docList = new javax.swing.JList();
        ApplicationName = new javax.swing.JLabel();
        create = new javax.swing.JButton();
        read = new javax.swing.JButton();
        update = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        deleteDoc = new javax.swing.JButton();
        errorMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GODSe: Home");

        docList.setToolTipText("Your List of Documents");
        docList.setName("docList");
        docListPanel.setViewportView(docList);
        docList.getAccessibleContext().setAccessibleName("docList");

        ApplicationName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ApplicationName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ApplicationName.setText("Google Docs Secured (GoDSe)");

        create.setText("Create");
        create.setToolTipText("Creates a new file");
        create.setName("create");
        create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createMouseClicked(evt);
            }
        });

        read.setText("Read");
        read.setToolTipText("Read a document");
        read.setName("read");

        update.setText("Update");
        update.setToolTipText("Update an existing document");
        update.setName("update");

        logout.setText("Logout");
        logout.setToolTipText("Logout");
        logout.setName("logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.setToolTipText("Refreshes the Document List");
        refresh.setName("refresh");
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });

        deleteDoc.setText("Delete");
        deleteDoc.setToolTipText("Deletes a document");
        deleteDoc.setName("deleteDoc");
        deleteDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteDocMouseClicked(evt);
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
                        .add(154, 154, 154)
                        .add(ApplicationName))
                    .add(layout.createSequentialGroup()
                        .add(21, 21, 21)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(6, 6, 6)
                                .add(errorMsg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 508, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(docListPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 355, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(35, 35, 35)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                            .add(create, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(read, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(update, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, deleteDoc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, refresh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(logout, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(ApplicationName)
                .add(31, 31, 31)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(docListPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 216, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(create)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(read)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(update)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(deleteDoc)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(refresh)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(logout)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(errorMsg, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        System.exit(1);
    }//GEN-LAST:event_logoutMouseClicked

    private void createMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createMouseClicked
        CreateForm createForm = new CreateForm();
        createForm.setVisible(true);

    }//GEN-LAST:event_createMouseClicked

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        hideErrorMessage();
        GoDSeHelper.prepareItems();
        updateDocList();
    }//GEN-LAST:event_refreshMouseClicked

    private void deleteDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteDocMouseClicked
        if (validateChoice()) {
            hideErrorMessage();
            DocumentListEntry entry = GoDSeDataStore.documentList.get(docList.getSelectedIndex()).getEntry();
            GoDSeHelper.deleteDocument(entry);
            GoDSeHelper.prepareItems();
            updateDocList();
        } else {
            showErrorMessage(Messages.NOT_SELECTED);
        }
    }//GEN-LAST:event_deleteDocMouseClicked

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
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new HomeForm().setVisible(true);
            }
        });
    }

    public JList getDocList() {
        return docList;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApplicationName;
    private javax.swing.JButton create;
    private javax.swing.JButton deleteDoc;
    private javax.swing.JList docList;
    private javax.swing.JScrollPane docListPanel;
    private javax.swing.JLabel errorMsg;
    private javax.swing.JButton logout;
    private javax.swing.JButton read;
    private javax.swing.JButton refresh;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
