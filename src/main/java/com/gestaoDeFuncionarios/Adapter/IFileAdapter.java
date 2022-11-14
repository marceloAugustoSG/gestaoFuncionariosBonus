/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestaoDeFuncionarios.Adapter;

import com.gestaoDeFuncionarios.model.Funcionario;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author matheus
 */
public interface IFileAdapter {
    public ArrayList<Funcionario> read(String fileName) throws IOException;
}
