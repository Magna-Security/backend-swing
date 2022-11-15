/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magna.data.colector;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mathe
 */
public class DadosDTO {

    private Integer qtdProcessos;
    private Integer qtdThreads;
    private Double usoProcessador;
    private Long usoMemoria;
    private List<Long> qtdDiscoEmUso;
    private String dataAtual;

    public DadosDTO(Integer qtdProcessos, Integer qtdThreads, Double usoProcessador, Long usoMemoria, List<Long> qtdDiscoEmUso, String dataAtual) {
        this.qtdProcessos = qtdProcessos;
        this.qtdThreads = qtdThreads;
        this.usoProcessador = usoProcessador;
        this.usoMemoria = usoMemoria;
        this.qtdDiscoEmUso = qtdDiscoEmUso;
        this.dataAtual = dataAtual;
    }

    public Integer getQtdProcessos() {
        return qtdProcessos;
    }

    public void setQtdProcessos(Integer qtdProcessos) {
        this.qtdProcessos = qtdProcessos;
    }

    public Integer getQtdThreads() {
        return qtdThreads;
    }

    public void setQtdThreads(Integer qtdThreads) {
        this.qtdThreads = qtdThreads;
    }

    public Double getUsoProcessador() {
        return usoProcessador;
    }

    public void setUsoProcessador(Double usoProcessador) {
        this.usoProcessador = usoProcessador;
    }

    public Long getUsoMemoria() {
        return usoMemoria;
    }

    public void setUsoMemoria(Long usoMemoria) {
        this.usoMemoria = usoMemoria;
    }

    public List<Long> getQtdDiscoEmUso() {
        while (qtdDiscoEmUso.size() < 4) {
            qtdDiscoEmUso.add(null);
        }
        return qtdDiscoEmUso;
    }

    public void setQtdDiscoEmUso(List<Long> qtdDiscoEmUso) {
        this.qtdDiscoEmUso = qtdDiscoEmUso;
    }

    public String getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

        
    
}
