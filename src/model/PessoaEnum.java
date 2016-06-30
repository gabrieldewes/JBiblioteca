/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dewes
 */
public enum PessoaEnum {
    aluno(1, "Aluno(a)"), 
    prof(2, "Professor(a)"), 
    func(3, "Funcionário(a)"),
    dir(4, "Diretor(a)");
    
    private final int value;
    private final String desc;
    
    PessoaEnum(int optionValue, String descript){
        value = optionValue;
        desc = descript;
    }
    
    @Override
    public String toString() {
        return desc;
    }
    
    public static PessoaEnum get(String desc) {
        for (PessoaEnum it: PessoaEnum.values()) {
            if (it.toString().contentEquals( desc )) {
                return it;
            }
        }
        return null;
    }

}
