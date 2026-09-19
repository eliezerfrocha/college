package aula2.Prog1OrientadoObjetos.src.prog1orientadoobjetos;

import javax.swing.JOptionPane;

public class Prog1OrientadoObjetos {

    public static int le(){
        int num;
        num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:"));
        return num;
    }
    
    public static void exibeSoma(int a, int b, int s){
         JOptionPane.showMessageDialog(null,"A soma de "+a+" com "+b+" vale: "+s,"SAIDA",1);
    }
    
    public static void exibeSubtracao(int a, int b, int s){
        JOptionPane.showMessageDialog(null,"A subtração de "+a+" com "+b+" vale: "+s,"SAIDA",1); 
    }
    
    public static void main(String[] args) {
        int a, b, s;        
        a = le();
        b = le();
        SomaDoisInteiros adicao = new SomaDoisInteiros(a,b);        
        s = adicao.soma();
        exibeSoma(a,b,s);
        SubtraiDoisInteiros subtracao = new SubtraiDoisInteiros(a,b);        
        s = subtracao.subtrai();
        exibeSubtracao(a,b,s);
    }
    
}








