/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dewes
 *
public enum TurmaEnum {
    pri(1, "Primeiro"), 
    seg(2, "Segundo"), 
    ter(3, "Terceiro"), 
    qua(4, "Quarto"), 
    qui(5, "Quinto"), 
    sex(6, "Sexto"), 
    set(7, "Sétimo"), 
    oit(8, "Oitavo"), 
    non(9, "Nono"),
    primseg(10, "Primeiro, 2º Grau"),
    segseg(11, "Segundo, 2º Grau"),
    terseg(12, "Terceiro, 2º Grau");
    
    private final int value;
    private final String desc;
    
    TurmaEnum(int optionValue, String descript){
        value = optionValue;
        desc = descript;
    }
    
    @Override
    public String toString() {
        return desc;
    }
    
    public static TurmaEnum get(String desc) {
        for (TurmaEnum it: TurmaEnum.values()) {
            if (it.toString().contentEquals( desc )) {
                return it;
            }
        }
        return null;
    }

}
*/