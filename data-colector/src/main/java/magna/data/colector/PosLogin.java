/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package magna.data.colector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.mysql.cj.log.Log;
import static java.awt.SystemColor.window;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author AlfaUser
 */
public class PosLogin extends javax.swing.JFrame {

    private Integer escolha = 0;
    
    Looca looca = new Looca();
    Sistema sistema = new Sistema();
    Memoria memoria = new Memoria();
    Processador processador = new Processador();
    Temperatura temperatura = new Temperatura();
    DiscosGroup grupoDeDiscos = new DiscosGroup();
    ServicosGroup grupoDeServicos = new ServicosGroup();
    ProcessosGroup grupoDeProcessos = new ProcessosGroup();

    /**
     * Creates new form PosLogin
     */
    public PosLogin() {
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

        jLabel1 = new javax.swing.JLabel();
        btnEncerrar = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnVerificarDados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Magna Security");

        btnEncerrar.setText("Encerrar");
        btnEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarActionPerformed(evt);
            }
        });

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnVerificarDados.setText("Verificar dados atuais");
        btnVerificarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarDadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(btnIniciar)
                .addGap(18, 18, 18)
                .addComponent(btnEncerrar)
                .addGap(0, 132, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(100, 100, 100)
                        .addComponent(btnSair))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVerificarDados)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair))
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnEncerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(btnVerificarDados)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarActionPerformed
        // TODO add your handling code here:
        JLabel textAreaP = new JLabel();

        JFrame window = new JFrame("Informações do sistema");
        JScrollPane scroll = new JScrollPane(textAreaP, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMinimum());
        scroll.setAutoscrolls(false);
        scroll.getMinimumSize();

        String processoI = "<html><p style='width: 175px; color: red; text-align: center'>Processo Encerrado</p></html>";

        textAreaP.setText(processoI);
        window.setSize(250, 250);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.add(scroll);

    }//GEN-LAST:event_btnEncerrarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        Connector con = new Connector();
        JdbcTemplate banco = con.getConnection();

        Date date = new Date();
        SimpleDateFormat momento = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String SO = sistema.getSistemaOperacional();
        Integer arquitetura = sistema.getArquitetura();
        Long totalRam = memoria.getTotal();
        Long frequenciaProcessador = processador.getFrequencia();
        Integer qtdCpusFisicas = processador.getNumeroCpusFisicas();
        Long tamanhoTotalDiscos = grupoDeDiscos.getTamanhoTotal();
        Double usoProcessador = processador.getUso();
        Long usoMemoria = memoria.getEmUso();
        Integer totalProcessos = grupoDeProcessos.getTotalProcessos();

        String dataFormatada = momento.format(date);
        JOptionPane.showMessageDialog(this, dataFormatada);

        banco.update(String.format("INSERT INTO RegistroServer(fk_servidor, ram_em_uso, disco_em_uso, processador_em_uso, data_registro) values(1, %d, %d, %.2f, '%s')",
                usoMemoria,
                tamanhoTotalDiscos,
                usoProcessador,
                dataFormatada.toString())
        );
        
        
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnVerificarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarDadosActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnVerificarDadosActionPerformed

    
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
            java.util.logging.Logger.getLogger(PosLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PosLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PosLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PosLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PosLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncerrar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVerificarDados;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
