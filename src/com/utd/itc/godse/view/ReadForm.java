/*
 * Collaborators:
 * Avinash Joshi <axj107420@utdallas.edu>
 * Sandeep Shenoy <sxs115220@utdallas.edu>
 * Shishir Krishnaprasad <sxk116430@utdallas.edu>
 * 
 * (c) 2012 GODSe
 */
package com.utd.itc.godse.view;

import com.utd.itc.godse.action.ConvertAction;
import com.utd.itc.godse.action.UpdateFormAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class ReadForm extends javax.swing.JFrame {

    /**
     * Creates new form ReadForm
     */
    public ReadForm() {
        initComponents();
    }

    public ReadForm(String fPath, String key, int sIndex, String dData, boolean btnFlag) {
        filePath = fPath;
        currKey = key;
        selectedIndex = sIndex;
        documentData = dData;
        initComponents();
        myInitComponents();
        if (btnFlag) {
            convert.setVisible(false);
            update.addActionListener(new UpdateFormAction(this, currKey, selectedIndex));
        } else {
            update.setVisible(false);
            convert.addActionListener(new ConvertAction(this, selectedIndex, currKey, filePath));
        }
    }

    public void myInitComponents() {
        try {

            docData.setText(documentData);

        } catch (Exception ex) {
            Logger.getLogger(ReadForm.class.getName()).log(Level.SEVERE, null, ex);
            docData.setText(documentData);

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

        docDataPane = new javax.swing.JScrollPane();
        docData = new javax.swing.JTextArea();
        ApplicationName = new javax.swing.JLabel();
        convert = new javax.swing.JButton();
        update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GODSe: Read Document");
        setLocation(new java.awt.Point(100, 75));
        setPreferredSize(new java.awt.Dimension(800, 600));

        docData.setColumns(12);
        docData.setEditable(false);
        docData.setRows(300
        );
        docData.setTabSize(16);
        docData.setToolTipText("Content of your document");
        docData.setMinimumSize(new java.awt.Dimension(0, 8));
        docData.setName("docData");
        docData.setPreferredSize(new java.awt.Dimension(10, 20));
        docData.setSize(new java.awt.Dimension(10, 20));
        docDataPane.setViewportView(docData);
        docData.getAccessibleContext().setAccessibleName("docData");

        ApplicationName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ApplicationName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ApplicationName.setText("Google Docs Secured (GoDSe)");
        ApplicationName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        convert.setText("Convert to Encrypted Doc");
        convert.setToolTipText("Converts normal doc to encrypted doc");
        convert.setName("convert");

        update.setText("Update");
        update.setToolTipText("Update content of doc");
        update.setName("update");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(147, 147, 147)
                        .add(ApplicationName)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(6, 341, Short.MAX_VALUE)
                                .add(convert, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 205, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(update, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 224, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(docDataPane))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(ApplicationName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(docDataPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(convert)
                    .add(update))
                .add(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getCurrKey() {
        return currKey;
    }

    public void setCurrKey(String currKey) {
        this.currKey = currKey;
    }

    public JTextArea getDocData() {
        return docData;
    }

    public void setDocData(JTextArea docData) {
        this.docData = docData;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
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
            java.util.logging.Logger.getLogger(ReadForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReadForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReadForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReadForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ReadForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApplicationName;
    private javax.swing.JButton convert;
    private javax.swing.JTextArea docData;
    private javax.swing.JScrollPane docDataPane;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
    private String filePath;
    private String currKey;
    private int selectedIndex;
    private String documentData;
}
