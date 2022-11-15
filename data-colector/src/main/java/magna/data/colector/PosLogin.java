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
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
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
    
    JLabel textArea = new JLabel();
    JFrame window = new JFrame("Informações do sistema");
    String info = "";
    JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    String SO = sistema.getSistemaOperacional();
    Integer arquitetura = sistema.getArquitetura();
    Long frequenciaProcessador = processador.getFrequencia();
    Integer qtdCpusFisicas = processador.getNumeroCpusFisicas();
    Integer qtdCpusLogicas = processador.getNumeroCpusLogicas();
    Long tamanhoTotalDiscos = grupoDeDiscos.getTamanhoTotal();
    List<Long> qtdDiscoEmUso = new ArrayList<Long>();
    List<Long> qtdTotalCadaDisco = new ArrayList<Long>();
    Double cpuEmUso = null;
    Long qtdTotalRam = memoria.getTotal();
    Long ramEmUso = null;
    Integer qtdProcessos = null;
    Integer qtdThreads = null;
    String dataFormatada = "";
    
    Boolean encerrarIsClicked = false;
    
    /**
     * Creates new form PosLogin
     */
    public PosLogin() {
        initComponents();
        txtIniciadoOuEncerrado.setText("");
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
        btnIniciar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnVerificarDados = new javax.swing.JButton();
        txtIniciadoOuEncerrado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Magna Security");

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

        txtIniciadoOuEncerrado.setText("Iniciado");
        txtIniciadoOuEncerrado.setAlignmentY(0.0F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtIniciadoOuEncerrado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(100, 100, 100)
                            .addComponent(btnSair))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnVerificarDados)
                            .addContainerGap()))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIniciar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair))
                .addGap(95, 95, 95)
                .addComponent(btnIniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerificarDados)
                    .addComponent(txtIniciadoOuEncerrado))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        encerrarIsClicked = false;
        
        txtIniciadoOuEncerrado.setText("Iniciando processo de coleta.");

        
        Connector con = new Connector();
        JdbcTemplate banco = con.getConnection();

        qtdProcessos = grupoDeProcessos.getTotalProcessos();
        qtdThreads = grupoDeProcessos.getTotalThreads();
        cpuEmUso = processador.getUso();
        ramEmUso = memoria.getEmUso();

        for (Integer j = 0; j < grupoDeDiscos.getQuantidadeDeDiscos(); j++) {
            qtdDiscoEmUso.add(grupoDeDiscos.getVolumes().get(j).getDisponivel());
        }
        
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                
                System.out.println("Coletando dados...");

                Date date = new Date();
                SimpleDateFormat momento = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dataFormatada = momento.format(date);

                DadosDTO dados = new DadosDTO(qtdProcessos, qtdThreads, cpuEmUso, ramEmUso, qtdDiscoEmUso, dataFormatada);

                banco.update(String.format("INSERT INTO RegistroServer(fk_servidor, qtd_processos, qtd_threads, cpu_em_uso, ram_em_uso, disco_em_uso_1, disco_em_uso_2, disco_em_uso_3, disco_em_uso_4, dt_registro) values(1, %d, %d, %s, %d, %d, %d, %d, %d, '%s')",
                dados.getQtdProcessos(),
                dados.getQtdThreads(),
                dados.getUsoProcessador().toString().replace(",", "."),
                dados.getUsoMemoria(),
                dados.getQtdDiscoEmUso().get(0),
                grupoDeDiscos.getDiscos().size() > 1 ? dados.getQtdDiscoEmUso().get(1) : null,
                grupoDeDiscos.getDiscos().size() > 2 ? dados.getQtdDiscoEmUso().get(2) : null,
                grupoDeDiscos.getDiscos().size() > 3 ? dados.getQtdDiscoEmUso().get(3) : null,
                dados.getDataAtual()));
                
//                FileInputStream arq = new FileInputStream("C:\\Users\\guilherme.anastacio\\Documents\\logDoMagna");
            }
        },0, 5000);

        

//        info = "<html><p style='width: 300px;'><b>Informações do sistema:</b> " + SO + " x" + arquitetura.toString()
//                + "<br><br>"
//                + "<b>Informações do hardware:</b>"
//                + "<br>"
//                + "RAM total: " + qtdTotalRam.toString()
//                + "<br>"
//                + "Informações processador <br>"
//                + "Frequência do processador: " + frequenciaProcessador.toString()
//                + "<br>"
//                + "Quantidade CPUs físicas: " + qtdCpusFisicas.toString()
//                + "<br>"
//                + "HardDisk: " + grupoDeDiscos.getTamanhoTotal().floatValue()
//                + "<br><br>"
//                + "Processos em tempo real: <br> "
//                + "<b>CPU: </b>" + String.format("%.2f", cpuEmUso) + "<br>"
//                + "<b>Memória em uso: </b>" + ramEmUso.toString() + "<br>"
//                + "<b>Total de processos: </b>" + qtdProcessos.toString()
//                + "<br>"
//                + "</p></html>";
//        textArea.setText(info);

//        SwingUtilities.updateComponentTreeUI(window);
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnVerificarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarDadosActionPerformed
        // TODO add your handling code here:

        scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMinimum());
        scroll.setAutoscrolls(false);
        scroll.getMinimumSize();
        
        window.add(scroll);
        window.setSize(500, 500);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
        qtdProcessos = grupoDeProcessos.getTotalProcessos();
        qtdThreads = grupoDeProcessos.getTotalThreads();
        cpuEmUso = processador.getUso();
        ramEmUso = memoria.getEmUso();
        
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                info = "<html><p style='width: 300px;'><b>Informações do sistema:</b> " + SO + " x" + sistema.getArquitetura().toString()
                    + "<br><br>"
                    + "<b>Informações do hardware:</b>"
                    + "<br>"
                    + "RAM total: " + memoria.getTotal().toString()
                    + "<br>"
                    + "Informações processador <br>"
                    + "Frequência do processador: " + String.format("%.2f", Double.valueOf(processador.getFrequencia().toString()))
                    + "<br>"
                    + "Quantidade CPUs físicas: " + processador.getNumeroCpusFisicas().toString()
                    + "<br>"
                    + "HardDisk: " + grupoDeDiscos.getTamanhoTotal() + " bytes"
                    + "<br><br>"
                    + "Processos em tempo real: <br> "
                    + "<b>CPU: </b>" + String.format("%.2f", processador.getUso()) + "<br>"
                    + "<b>Memória em uso: </b>" + memoria.getEmUso().toString() + "<br>"
                    + "<b>Total de processos: </b>" + grupoDeProcessos.getTotalProcessos().toString()
                    + "<br>"
                    + "</p></html>";
                textArea.setText(info);
            }
        }, 0, 1000);
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
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVerificarDados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtIniciadoOuEncerrado;
    // End of variables declaration//GEN-END:variables
}
