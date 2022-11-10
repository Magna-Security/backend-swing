/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magna.data.colector;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;

/**
 *
 * @author mathe
 */
public class Testes {
    public static void main(String[] args) {
        Looca looca = new Looca();
        DiscosGroup grupoDeDiscos = new DiscosGroup();
        
        System.out.println("Discos: " + grupoDeDiscos.getQuantidadeDeDiscos());
        System.out.println("Volumes: " + grupoDeDiscos.getQuantidadeDeVolumes());
    }
}
