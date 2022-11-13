package com.gestaoDeFuncionarios.log;

import com.gestaoDeFuncionarios.model.Funcionario;
import com.gestaoDeFuncionarios.presenter.IObserver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class FuncionarioLogTXT implements IObserver {

    public FuncionarioLogTXT() {

    }

    public void geraLog(Funcionario funcionario) {
        File logTXT = new File("logs/teste.txt");

        if (!logTXT.exists()) {
            try {
                logTXT.createNewFile();
                FileWriter writer = new FileWriter(logTXT);
                writer.write("Arquivo Criado" + " " + LocalTime.now() + "\n");
                writer.write("Nome | Salario | Cargo" + "\n");
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileReader reader = new FileReader(logTXT);
                BufferedReader br = new BufferedReader(reader);
                String linha = br.readLine();
                FileWriter writer = new FileWriter(logTXT);

                while (linha != null) {
                    writer.write(linha + "\n");
                    br.readLine();
                    linha = br.readLine();
                }

                br.close();
                reader.close();

                writer.write(funcionario.getNome() + " " + funcionario.getSalario() + " " + funcionario.getCargo() + " " + LocalTime.now() + "\n");
                writer.close();
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
