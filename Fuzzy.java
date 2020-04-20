/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy;

import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 *
 * @author lauradamacenodealmeida
 */
public class Fuzzy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a umidade \n");
        double umidade = teclado.nextDouble();
        System.out.println("Digite a temperatura \n");
        double temperatura = teclado.nextDouble();
        //String caminho = "//Users//lauradamacenodealmeida//NetBeansProjects//Fuzzy//src//fuzzy//padraoFCL.fcl";
        String caminho = "/Users/lauradamacenodealmeida/NetBeansProjects/Fuzzy/src/fuzzy/irrigacao.fcl";
        FIS fuzzy = FIS.load(caminho);
        fuzzy.setVariable("temperatura", temperatura);
        fuzzy.setVariable("umidade", umidade);
        fuzzy.evaluate();
        Variable irrigacao = fuzzy.getVariable("irrigacao");
        JFuzzyChart.get().chart(irrigacao, irrigacao.getDefuzzifier(),true);
        JFuzzyChart.get().chart(fuzzy);  
    }
    
}
