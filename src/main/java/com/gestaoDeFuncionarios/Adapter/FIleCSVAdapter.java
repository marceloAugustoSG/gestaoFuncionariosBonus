package com.gestaoDeFuncionarios.Adapter;


import com.gestaoDeFuncionarios.impl.CSVRead;
import com.gestaoDeFuncionarios.model.Funcionario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matheus
 */
public class FIleCSVAdapter implements IFileAdapter {
    
    private CSVRead read;

    public FIleCSVAdapter(String nomeArquivo) throws FileNotFoundException {
        if (!nomeArquivo.toLowerCase().endsWith("csv")) {
            throw new RuntimeException("Informe um arquivo CSV válido");
        }
        
        read = new CSVRead(nomeArquivo);
    }

    @Override
    public ArrayList<Funcionario> read(String fileName) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
