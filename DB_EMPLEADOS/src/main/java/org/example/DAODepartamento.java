package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAODepartamento {
    static Connection conn;

    public DAODepartamento() {
        conn = DB.getConn();
    }

    public ArrayList<DTODepartamento> getAllDepartamentos() throws SQLException {
        ArrayList<DTODepartamento> departamentos = new ArrayList<>();

        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM departamento");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String nombre = rs.getString("Nombre");
            DTODepartamento dpto = new DTODepartamento(nombre);
            dpto.setId(rs.getInt("id"));
            departamentos.add(dpto);
        }
        return departamentos;
    }

    public DTODepartamento getDepartamentoById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM departamento WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String nombre = rs.getString("Nombre");
            DTODepartamento dpto = new DTODepartamento(nombre);
            dpto.setId(rs.getInt("id"));
            return dpto;
        }
        return null;
    }

    public int addDepartamento(DTODepartamento dpto) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO departamento (nombre) VALUES (?)");
        stmt.setString(1, dpto.getNombre());
        return stmt.executeUpdate();
    }

    public int deleteDepartamentoById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM departamento WHERE id = ?");
        stmt.setInt(1, id);
        return stmt.executeUpdate();
    }

    public int deleteDepartamentoByNombre(String nombre) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM departamento WHERE nombre = ?");
        stmt.setString(1, nombre);
        return stmt.executeUpdate();
    }

    public int deleteAllDepartamentos() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM departamento");
        return stmt.executeUpdate();
    }

    public int updateNombreDepartamento(int id, DTODepartamento dpto) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("UPDATE departamento SET nombre = ? WHERE id = ?");
        stmt.setString(1, dpto.getNombre());
        stmt.setInt(2, id);
        return stmt.executeUpdate();
    }
}
