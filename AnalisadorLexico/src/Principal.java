
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author comp15
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    ManipuladorArquivos marq = new ManipuladorArquivos();
    boolean controle = false;
    String nomeArquivo, textoArquivo, palavra;

    
    private final ManipuladorAutomato maut = new ManipuladorAutomato();

    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaToken = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        arquivoNovo = new javax.swing.JMenuItem();
        arquivoAbrir = new javax.swing.JMenuItem();
        arquivoSalvar = new javax.swing.JMenuItem();
        arquivoSair = new javax.swing.JMenuItem();
        menuExecutar = new javax.swing.JMenu();
        menuAjuda = new javax.swing.JMenu();
        ajudaSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analisador Léxico");

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        tabelaToken.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaToken.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Linha", "Código", "Token"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaToken);

        jMenuBar1.setToolTipText("");

        menuArquivo.setText("Arquivo");

        arquivoNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        arquivoNovo.setText("Novo");
        arquivoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arquivoNovoActionPerformed(evt);
            }
        });
        menuArquivo.add(arquivoNovo);

        arquivoAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        arquivoAbrir.setText("Abrir");
        arquivoAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arquivoAbrirActionPerformed(evt);
            }
        });
        menuArquivo.add(arquivoAbrir);

        arquivoSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        arquivoSalvar.setText("Salvar");
        arquivoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arquivoSalvarActionPerformed(evt);
            }
        });
        menuArquivo.add(arquivoSalvar);

        arquivoSair.setText("Sair");
        arquivoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arquivoSairActionPerformed(evt);
            }
        });
        menuArquivo.add(arquivoSair);

        jMenuBar1.add(menuArquivo);

        menuExecutar.setText("Executar");
        menuExecutar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuExecutarMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuExecutar);

        menuAjuda.setText("Ajuda");

        ajudaSobre.setText("Sobre");
        ajudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajudaSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(ajudaSobre);

        jMenuBar1.add(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void arquivoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arquivoNovoActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Deseja salvar o arquivo atual?") == JOptionPane.OK_OPTION) {

            arquivoSalvar.doClick();
            areaTexto.setText("");
            controle = false;
        } else {
            areaTexto.setText("");
            controle = false;
        }


    }//GEN-LAST:event_arquivoNovoActionPerformed

    private void ajudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajudaSobreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajudaSobreActionPerformed

    private void arquivoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arquivoSalvarActionPerformed

        if (controle == false) {
            controle = true;
            JFileChooser fc = new JFileChooser();
            //Exibe o diálogo. Deve ser passado por parâmetro o JFrame de origem.
            fc.showSaveDialog(arquivoSalvar);
            //Captura o objeto File que representa o arquivo selecionado.
            File selFile = fc.getSelectedFile();
            nomeArquivo = selFile.getAbsolutePath();
            textoArquivo = areaTexto.getText();
            marq.salvarArquivo(nomeArquivo, textoArquivo);

        } else {
            textoArquivo = areaTexto.getText();
            marq.salvarArquivo(nomeArquivo, textoArquivo);
        }


    }//GEN-LAST:event_arquivoSalvarActionPerformed

    private void arquivoAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arquivoAbrirActionPerformed

        JFileChooser fc = new JFileChooser();
        //Exibe o diálogo. Deve ser passado por parâmetro o JFrame de origem.
        fc.showOpenDialog(arquivoAbrir);
        //Captura o objeto File que representa o arquivo selecionado.
        File selFile = fc.getSelectedFile();
        String arq = selFile.getAbsolutePath();
        String text = marq.abrirArquivo(arq);
        areaTexto.setText(text);

    }//GEN-LAST:event_arquivoAbrirActionPerformed

    private void arquivoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arquivoSairActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Deseja salvar o arquivo atual?") == JOptionPane.OK_OPTION) {

            arquivoSair.doClick();
            System.exit(0);
        } else {
            System.exit(0);
        }
    }//GEN-LAST:event_arquivoSairActionPerformed

    private void menuExecutarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuExecutarMouseClicked
        palavra = areaTexto.getText() + "$";     
        gets_sets_Tokens tokenFinal = maut.getToken(palavra);
        
        setTokenTabela(tokenFinal);
        

    }//GEN-LAST:event_menuExecutarMouseClicked

    public void setTokenTabela(gets_sets_Tokens t) {

        DefaultTableModel modeloTok = (DefaultTableModel) tabelaToken.getModel();

        for (int i = 0; i < t.getCodigo().size(); i++) {

            modeloTok.addRow(new Object[]{t.getLinha().get(i), t.getCodigo().get(i), t.getToken().get(i)});
        }
        /*if (t.getErro_linha() != null) {
            gets_sets_Tokens err = t.getErro_linha();
            DefaultTableModel modeloErr = (DefaultTableModel) TabelaErro.getModel();
            for (int i = 0; i < err.getErro().size(); i++) {

                modeloErr.addRow(new Object[]{err.getLinha().get(i), err.getErro().get(i)});

            }
        }*/
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                

}
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ajudaSobre;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JMenuItem arquivoAbrir;
    private javax.swing.JMenuItem arquivoNovo;
    private javax.swing.JMenuItem arquivoSair;
    private javax.swing.JMenuItem arquivoSalvar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuExecutar;
    private javax.swing.JTable tabelaToken;
    // End of variables declaration//GEN-END:variables
}
