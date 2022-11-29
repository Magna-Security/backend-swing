/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magna.data.colector;



import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author AlfaUser
 */
public class Teste {

    Looca looca = new Looca();
    Sistema sistema = new Sistema();
    Memoria memoria = new Memoria();
    Processador processador = new Processador();
    Temperatura temperatura = new Temperatura();
    DiscosGroup grupoDeDiscos = new DiscosGroup();
    ServicosGroup grupoDeServicos = new ServicosGroup();
    ProcessosGroup grupoDeProcessos = new ProcessosGroup();

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

   
    private void enviarDados(JdbcTemplate banco) {

        qtdProcessos = grupoDeProcessos.getTotalProcessos();
        qtdThreads = grupoDeProcessos.getTotalThreads();
        cpuEmUso = processador.getUso();
        ramEmUso = memoria.getEmUso();
        Integer teste = grupoDeDiscos.getQuantidadeDeDiscos();
        for (Integer j = 0; j < teste; j++) {
            
            qtdDiscoEmUso.add(grupoDeDiscos.getVolumes().get(j).getTotal() - grupoDeDiscos.getVolumes().get(j).getDisponivel());
        }

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

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
                        dados.getQtdDiscoEmUso().get(1),
                        dados.getQtdDiscoEmUso().get(2),
                        dados.getQtdDiscoEmUso().get(3),
                        dados.getDataAtual()));

                System.out.println(String.format("[%s] Dados inseridos com sucesso.", dados.getDataAtual()));

            }
        }, 0, 5000);

    }
    
    private void enviarDadosMySql(JdbcTemplate banco) {

        qtdProcessos = grupoDeProcessos.getTotalProcessos();
        qtdThreads = grupoDeProcessos.getTotalThreads();
        cpuEmUso = processador.getUso();
        ramEmUso = memoria.getEmUso();
        Integer teste = grupoDeDiscos.getQuantidadeDeDiscos();
        for (Integer j = 0; j < teste; j++) {
            
            qtdDiscoEmUso.add(grupoDeDiscos.getVolumes().get(j).getTotal() - grupoDeDiscos.getVolumes().get(j).getDisponivel());
        }

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

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
                        dados.getQtdDiscoEmUso().get(1),
                        dados.getQtdDiscoEmUso().get(2),
                        dados.getQtdDiscoEmUso().get(3),
                        dados.getDataAtual()));

                System.out.println(String.format("[%s] Dados inseridos com sucesso.", dados.getDataAtual()));

            }
        }, 0, 5000);

    }

    public static void main(String[] args) {
        try {
            Connector con = new Connector();
            Connector con2 = new Connector();
            
            JdbcTemplate banco = con.getConnection();
            JdbcTemplate bancoMySql = con.getConnection();
            
            Teste teste = new Teste();
            
            teste.enviarDados(banco);
            teste.enviarDadosMySql(bancoMySql);

            
        } catch (Exception e) {
           
        }
    }
}
