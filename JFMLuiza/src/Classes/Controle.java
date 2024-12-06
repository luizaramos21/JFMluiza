package Classes;

import java.util.ArrayList;


public class Controle {
    
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    
    //Função para salvar funcionarios
    public boolean salvar(Funcionario f) {
        if (f != null) {
            funcionarios.add(f);
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<Funcionario> exibirlista(){
        return funcionarios;
    }

    
}
