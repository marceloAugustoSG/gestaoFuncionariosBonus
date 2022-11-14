/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoDeFuncionarios.impl;

import com.gestaoDeFuncionarios.model.Funcionario;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author matheus
 */
public class CSVRead {
    private String fileName;

    public CSVRead() {
    }

    public CSVRead(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Funcionario> read() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            Scanner input = new Scanner(Paths.get(this.fileName));

            input.nextLine();

            while (input.hasNext()) {
                String[] linha = input.nextLine().split(",");
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(linha[1]);
                funcionario.setCargo(linha[2]);
                funcionario.setSalarioBase(Double.parseDouble(linha[3]));
                funcionario.setDistanciaTrabalho(Double.parseDouble(linha[4]));
                funcionario.setTempoServico(Double.parseDouble(linha[5]));
                funcionario.setDataAdmissao(linha[6]);
                funcionarios.add(funcionario);
            }
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível abrir o arquivo");
        }
        
        return funcionarios;
    }
}
