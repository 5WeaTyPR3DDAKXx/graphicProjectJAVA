/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package grafica;

import Classi.*;
import MainCalled.GlobalGestor;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableColumn;

/**
 *
 * @author predieric
 */
public class DisciplineDialog extends javax.swing.JDialog {

    private int nRighe = 0;
    private String[] columnNames = {"Codice", "Nome", "CFU", "Corso"};
    private Object[][] data = {};
    DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column >= 1;
        }
    };
    static Gestore gestor = new GlobalGestor().gestorone;
    boolean check = false;

    /**
     * Creates new form DisciplineDialog
     */
    public DisciplineDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ArrayList<Object[]> tempList = new ArrayList<>();

        for (Disciplina d : gestor.gd.visualizzaDiscipline()) {
            Object[] row = {d.getCodiceDisciplina(), d.getNomeDisciplina(), d.getCfu(), d.getCorsoDisciplina().getNomeCorso()};
            model.addRow(row);
            nRighe++;
        }
        jTable1.setModel(model);
        ArrayList<String> boxModel = new ArrayList<>();
        boxModel.add("");
        for (Corso c : gestor.gc.visualizzaCorsi()) {
            boxModel.add(c.getNomeCorso());
        }

        String[] comboBoxModel = boxModel.toArray(new String[0]);
        corsoBox.setModel(new DefaultComboBoxModel<>(comboBoxModel));
        boxModel.remove(0);
        String[] boxModelChange = boxModel.toArray(new String[0]);
        JComboBox<String> comboBox = new JComboBox<>(boxModelChange);

        TableColumn colonna = jTable1.getColumnModel().getColumn(3);
        colonna.setCellEditor(new DefaultCellEditor(comboBox));

        model.addTableModelListener((TableModelEvent e) -> {
            if (check|| e.getColumn() == TableModelEvent.ALL_COLUMNS) {
                return;
            }

           
                int row = e.getFirstRow();
                int col = e.getColumn();
                String changed = (String) model.getValueAt(row, col);
                try {
                    check = true;

                    switch (col) {
                        case 1: // Nome
                            if (changed == null || changed.trim().isEmpty() || changed.matches("\\d+")) {
                                model.setValueAt(gestor.gd.cercaDisciplina((String) model.getValueAt(row, 0)).getNomeDisciplina(), row, col);
                            } else {
                                // salva nuovo nome
                                gestor.gd.cambiaNome((String) model.getValueAt(row, 0), changed);
                            }
                            break;
                        case 2: // CFU
                            if (col == 2 && ("".equals(changed) || !changed.matches("\\d+") || Integer.parseInt(changed) < 1)) {
                                model.setValueAt(gestor.gd.cercaDisciplina((String) model.getValueAt(row, 0)).getCfu() + "", row, col);
                            } else {
                                gestor.gd.cambiaCfu((String) model.getValueAt(row, 0), Integer.parseInt(changed));
                            }
                            break;
                        case 3:
                            String selected = (String) comboBox.getSelectedItem();
                            System.out.println(selected);
                            gestor.gd.cambiaCorso((String) model.getValueAt(row, 0), gestor.gc.cercaCorsoNome(selected));
                            break;
                    }
                } finally {
                    check = false;
                }
            
        });

        /*   JComboBox<String> comboBox = new JComboBox<>(nomiCorsi);
        DefaultCellEditor cellEditor = new DefaultCellEditor(comboBox);
        cellEditor.addCellEditorListener(new CellEditorListener() {
    @Override
    public void editingStopped(ChangeEvent e) {
        int row = jTable1.getSelectedRow();  // ottieni la riga selezionata
        String corsoSelezionato = (String) comboBox.getSelectedItem();
        Disciplina disciplina = gestor.gd.cercaDisciplina((String) jTable1.getValueAt(row, 0));
        gestor.gd.assegnaCorso(disciplina,gestor.gc.cercaCorsoNome(corsoSelezionato));
        System.out.println(disciplina.getNomeDisciplina()+" assegnato alla riga " + row + ": " + corsoSelezionato);
    }

    @Override
    public void editingCanceled(ChangeEvent e) {
        // Non serve fare nulla qui normalmente
    }
});
        TableColumn corsoColumn = jTable1.getColumnModel().getColumn(3);
        corsoColumn.setCellEditor(new DefaultCellEditor(comboBox));
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salvabtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codiceInput = new javax.swing.JTextField();
        nomeInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cfuInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buttonInserisci1 = new javax.swing.JButton();
        buttonInserisci = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        corsoBox = new javax.swing.JComboBox<>();
        delete = new javax.swing.JButton();
        salvabtn1 = new javax.swing.JButton();

        salvabtn.setText("Salva");
        salvabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvabtnActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Discipline");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setText("Codice");

        codiceInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codiceInputActionPerformed(evt);
            }
        });

        nomeInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeInputActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setText("Nome");

        cfuInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfuInputActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("CFU");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setText("Corso");

        buttonInserisci1.setBackground(new java.awt.Color(255, 0, 0));
        buttonInserisci1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonInserisci1.setText("EXIT");
        buttonInserisci1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInserisci1ActionPerformed(evt);
            }
        });

        buttonInserisci.setText("Inserisci");
        buttonInserisci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInserisciActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matricola Studente", "Nome", "Cognome", "Corso"
            }
        ));
        jTable1.setMaximumSize(new java.awt.Dimension(500, 80));
        jScrollPane1.setViewportView(jTable1);

        corsoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        corsoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corsoBoxActionPerformed(evt);
            }
        });

        delete.setText("Elimina");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        salvabtn1.setText("Salva");
        salvabtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvabtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(codiceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cfuInput, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(corsoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salvabtn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonInserisci, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonInserisci1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonInserisci1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salvabtn1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cfuInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(corsoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codiceInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(buttonInserisci, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codiceInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codiceInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codiceInputActionPerformed

    private void nomeInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeInputActionPerformed

    private void cfuInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfuInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cfuInputActionPerformed

    private void buttonInserisci1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInserisci1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonInserisci1ActionPerformed

    private void buttonInserisciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInserisciActionPerformed
        boolean error = false;
        String codice = codiceInput.getText();
        String nome = nomeInput.getText();
        String cfu = cfuInput.getText();
        String corso = (String) corsoBox.getSelectedItem();

        if ("".equals(codice)) {
            error = true;
            codiceInput.setBorder(new LineBorder(Color.red, 3));
        } else {
            codiceInput.setBorder(new JTextField().getBorder());
        }

        if ("".equals(nome)) {
            error = true;
            nomeInput.setBorder(new LineBorder(Color.red, 3));
        } else {
            nomeInput.setBorder(new JTextField().getBorder());
        }

        if ("".equals(cfu) || !cfu.matches(".*\\d.*")) {
            error = true;
            cfuInput.setBorder(new LineBorder(Color.red, 3));
        } else {
            cfuInput.setBorder(new JTextField().getBorder());
        }

        if ("".equals(corso)) {
            error = true;
            corsoBox.setBorder(new LineBorder(Color.red, 3));
        } else {
            corsoBox.setBorder(new JComboBox().getBorder());
        }

        if (error) {
            System.out.println("Errore nell'inserimento");

        } else {
            if (gestor.gd.creaDisciplina(codice, nome, Integer.parseInt(cfu), gestor.gc.cercaCorsoNome(corso))) {
                Object[] nuovaRiga = {codice, nome, cfu, corso};
                model.addRow(nuovaRiga);
                jTable1.setRowSelectionInterval(nRighe, nRighe);
                nRighe++;
                if (model.getRowCount() > 1) {
                    delete.setBackground(Color.white);
                }
                codiceInput.setBorder(new JTextField().getBorder());
                cfuInput.setBorder(new JTextField().getBorder());
                nomeInput.setBorder(new JTextField().getBorder());
                corsoBox.setBorder(new JComboBox().getBorder());

            } else {
                codiceInput.setBorder(new LineBorder(Color.red, 3));
                nomeInput.setBorder(new LineBorder(Color.red, 3));
                cfuInput.setBorder(new LineBorder(Color.red, 3));
                corsoBox.setBorder(new LineBorder(Color.red, 3));
            }
        }
        // new Studente(string matricola, string nome, string cognome, corso corsoiscritto)
    }//GEN-LAST:event_buttonInserisciActionPerformed

    private void corsoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corsoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_corsoBoxActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int[] rowsSelected = jTable1.getSelectedRows();
        if (model.getRowCount() > 1 && model.getRowCount() > rowsSelected.length) {

            for (int i = rowsSelected.length; i > 0; i--) {
                String code = (String) model.getValueAt(i, 0);
                System.out.println(code);
                gestor.gd.elimina(code);
                model.removeRow(i);
                nRighe--;
            }
            delete.setBackground(Color.white);
        } else
            delete.setBackground(Color.red);
    }//GEN-LAST:event_deleteActionPerformed

    private void salvabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvabtnActionPerformed

    }//GEN-LAST:event_salvabtnActionPerformed

    private void salvabtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvabtn1ActionPerformed
        // TODO add your handling code here:
        ArrayList<String> csv = new ArrayList<>();
        for (Disciplina i : gestor.gd.visualizzaDiscipline()) {
            csv.add(i.toString());
        }
        gestor.gl.writeFile("discipline.csv", csv);
    }//GEN-LAST:event_salvabtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(DisciplineDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisciplineDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisciplineDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisciplineDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DisciplineDialog dialog = new DisciplineDialog(new javax.swing.JFrame(), true);

                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonInserisci;
    private javax.swing.JButton buttonInserisci1;
    private javax.swing.JTextField cfuInput;
    private javax.swing.JTextField codiceInput;
    private javax.swing.JComboBox<String> corsoBox;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nomeInput;
    private javax.swing.JButton salvabtn;
    private javax.swing.JButton salvabtn1;
    // End of variables declaration//GEN-END:variables
}
