//
//import com.mycompany.bonusteste.model.Funcionario;
//import com.mycompany.bonusteste.service.CalculadoraBonus;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main1 {
//
//    public static void main(String[] args) throws IOException {
//        Scanner input;
//        ArrayList<Funcionario> funcionarios = new ArrayList<>();
//
//        try {
//            input = new Scanner(Paths.get("funcionarios.csv"));
//
//            input.nextLine();
//
//            while (input.hasNext()) {
//                String[] linha = input.nextLine().split(",");
//                Funcionario funcionario = new Funcionario();
//                //funcionario.setId(Integer.parseInt(linha[0]));
//                funcionario.setNome(linha[1]);
//                funcionario.setCargo(linha[2]);
//                funcionario.setSalarioBase(Double.parseDouble(linha[3]));
//                funcionario.setDistanciaTrabalho(Double.parseDouble(linha[4]));
//                funcionario.setTempoServico(Double.parseDouble(linha[5]));
//                funcionario.setDataAdmissao(linha[6]);
//                funcionarios.add(funcionario);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        CalculadoraBonus calculadora = new CalculadoraBonus();
//        funcionarios.forEach(f -> {
//            calculadora.addFuncionario(f);
//            //            f.calculaSalario();
//            // System.out.println("\n" + f.toString());
//        }
//        );
//
//        calculadora.calcular();
//
//    }
//}
