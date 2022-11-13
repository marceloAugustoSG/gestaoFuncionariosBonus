
import com.gestaoDeFuncionarios.presenter.PrincipalPresenter;

/*import com.gestaoDeFuncionarios.collection.FuncionarioCollection;
import com.gestaoDeFuncionarios.model.Funcionario;
import com.gestaoDeFuncionarios.model.ProcessadoraBonus;*/
public class MainT {

    public static void main(String[] args) {
        new PrincipalPresenter();

        /*FuncionarioCollection funcionarios = new FuncionarioCollection();
        funcionarios.add(new Funcionario("Fulano", 10, 1500, "Programador", 0, "2000-05-20", true, "Generoso"));
        ProcessadoraBonus processa = new ProcessadoraBonus();
        for(Funcionario funcionario : funcionarios.getFuncionarios()) {
            funcionario.setSalario(processa.processar(funcionario)); 
        }
        System.out.println(funcionarios.getFuncionarios().toString());*/
    }

}
