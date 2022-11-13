package com.gestaoDeFuncionarios.DAO;

import com.gestaoDeFuncionarios.Factory.Conexao;
import com.gestaoDeFuncionarios.model.Funcionario;
import com.gestaoDeFuncionarios.presenter.IObserver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioSQLDAO extends FuncionarioDAO {

    private Conexao conexao = new Conexao();

    @Override
    public boolean create(Funcionario funcionario) {

        conexao.conectar();
        String sql = "INSERT INTO Funcionario("
                + "nome,idade,salario,bonus,cargo,dataAdmissao,numeroFaltas,funcionarioMes)"
                + ""
                + "VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getIdade());
            stmt.setDouble(3, funcionario.getSalarioBase());
            stmt.setString(4, funcionario.getTipoBonus());
            stmt.setString(5, funcionario.getCargo());
            stmt.setString(6, funcionario.getDataAdmissao());
            stmt.setInt(7, funcionario.getNumFaltas());
            stmt.setBoolean(8, funcionario.isFuncionarioDoMes());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.desconectar();
        System.out.println("chegou aqui");
        return true;

    }

    public boolean update(Funcionario funcionario) {

        conexao.conectar();
        String sql = "UPDATE funcionario SET nome = ?,idade= ?,salario = ?,bonus = ?,cargo = ? where idFuncionario = '" + funcionario.getIdFuncionario() + "'";
        PreparedStatement stmt = null;

        try {
            stmt = conexao.criarPreparedStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getIdade());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setString(4, funcionario.getTipoBonus());
            stmt.setString(5, funcionario.getCargo());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.desconectar();
        System.out.println("chegou aqui");
        return true;

    }

    public List<Funcionario> getFuncionarios() {

        List<Funcionario> listaFuncionarios = new ArrayList<>();
        Funcionario funcionario;
        conexao.conectar();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Funcionario";
        try {
            stmt = conexao.criarPreparedStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setIdade(rs.getInt(3));
                funcionario.setSalario(rs.getDouble(4));
                funcionario.setTipoBonus(rs.getString(5));
                funcionario.setCargo(rs.getString(6));
                listaFuncionarios.add(funcionario);

            }

        } catch (Exception e) {
            System.err.println(e);
        }
        conexao.desconectar();
        return listaFuncionarios;

    }

    @Override
    public List<Funcionario> getFuncionarios(String nome) {
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        Funcionario funcionario = new Funcionario();
        conexao.conectar();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM Funcionario where nome = '" + nome + "'";
        try {

            stmt = conexao.criarPreparedStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setIdade(rs.getInt(3));
                funcionario.setSalario(rs.getDouble(4));
                funcionario.setTipoBonus(rs.getString(5));
                funcionario.setCargo(rs.getString(6));
                listaFuncionarios.add(funcionario);

            }
        } catch (Exception e) {
            System.err.println(e);

        }
        conexao.desconectar();
        return listaFuncionarios;

    }

    public Funcionario getFuncionario(int idFuncionario) {

        Funcionario funcionario = new Funcionario();
        conexao.conectar();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM Funcionario where idFuncionario = '" + idFuncionario + "'";
        try {

            stmt = conexao.criarPreparedStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setIdade(rs.getInt(3));
                funcionario.setSalario(rs.getDouble(4));
                funcionario.setTipoBonus(rs.getString(5));
                funcionario.setCargo(rs.getString(6));

            }
        } catch (Exception e) {
            System.err.println(e);

        }
        conexao.desconectar();
        return funcionario;

    }

    public boolean delete(Funcionario funcionario) {
        conexao.conectar();
        PreparedStatement stmt;
        String sql = "DELETE FROM Funcionario WHERE idFuncionario ='" + funcionario.getIdFuncionario() + "'";
        stmt = conexao.criarPreparedStatement(sql);

        try {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        conexao.desconectar();
        return true;
    }

    @Override
    public void notificar() {

    }

    @Override
    public void add(IObserver observer
    ) {
        super.observers.add(observer);
    }

}
