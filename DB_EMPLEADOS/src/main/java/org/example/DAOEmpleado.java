package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOEmpleado {

    static Connection conn;

    public DAOEmpleado() {
        conn = DB.getConn();
    }

    public ArrayList<DTOEmpleado> getAll() throws SQLException {
        ArrayList<DTOEmpleado> empleados = new ArrayList<>();

        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM empleados");
        stmt.executeQuery();
        ResultSet rs = stmt.getResultSet();
        while (rs.next()) {

            String nombre = rs.getString("nombre");
            int edad = rs.getInt("edad");
            int dpt_Id = rs.getInt("dpto_id");

            DTOEmpleado empleado = new DTOEmpleado(nombre, edad, dpt_Id);
            empleado.setId(rs.getInt("id"));
            empleados.add(empleado);
        }
        return empleados;
    }

    public DTOEmpleado getById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM empleados WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.getResultSet();

        if (rs.next()) {
            DTOEmpleado emp = new DTOEmpleado(rs.getString("nombre"), rs.getInt("edad"), rs.getInt("dpto_id"));
            return emp;
        }
        return null;
    }

    public ArrayList<DTOEmpleado> getByName(String nombre) throws SQLException {
        ArrayList<DTOEmpleado> empleados = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM empleados WHERE nombre = ?");
        stmt.setString(1, nombre);
        ResultSet rs = stmt.getResultSet();
        while (rs.next()) {
            DTOEmpleado emp = new DTOEmpleado(rs.getString("nombre"), rs.getInt("edad"), rs.getInt("dpto_id"));
            empleados.add(emp);
        }

        return empleados;
    }

    public ArrayList<DTOEmpleado> getByDptoID(int dptoId) throws SQLException {
        ArrayList<DTOEmpleado> empleados = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM empleados WHERE dpto_id = ?");
        stmt.setInt(1, dptoId);
        ResultSet rs = stmt.getResultSet();
        while (rs.next()) {
            DTOEmpleado emp = new DTOEmpleado(rs.getString("nombre"), rs.getInt("edad"), rs.getInt("dpto_id"));
            empleados.add(emp);
        }
        return empleados;
    }

    public int addEmpleado(DTOEmpleado empleado) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO empleados (nombre, edad, dpto_id) VALUES (?, ?, ?)");
        stmt.setString(1, empleado.getNombre());
        stmt.setInt(2, empleado.getEdad());
        stmt.setInt(3, empleado.getDpt_Id());
        return stmt.executeUpdate();
    }

    public int deleteEmpleadoById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM empleados WHERE id = ?");
        stmt.setInt(1, id);
        return stmt.executeUpdate();
    }

    public int deleteAllEmpleados() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM empleados");
        return stmt.executeUpdate();
    }

    public int deleteEmpleadosByNombre(String nombre) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM empleados WHERE nombre = ?");
        stmt.setString(1, nombre);
        return stmt.executeUpdate();
    }

    public int deleteEmpleadosByDptoId(int dptoId) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM empleados WHERE dpto_id = ?");
        stmt.setInt(1, dptoId);
        return stmt.executeUpdate();
    }

    public int updateNombreEmpleado(int id, DTOEmpleado empleado) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("UPDATE empleados SET nombre = ? WHERE id = ?");
        stmt.setString(1, empleado.getNombre());
        stmt.setInt(2, id);
        return stmt.executeUpdate();
    }

    public int updateEdadEmpleado(int id, DTOEmpleado empleado) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("UPDATE empleados SET edad = ? WHERE id = ?");
        stmt.setInt(1, empleado.getEdad());
        stmt.setInt(2, id);
        return stmt.executeUpdate();
    }

    public int updateDptoEmpleado(int id, DTOEmpleado empleado) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("UPDATE empleados SET dpto_id = ? WHERE id = ?");
        stmt.setInt(1, empleado.getDpt_Id());
        stmt.setInt(2, id);
        return stmt.executeUpdate();
    }

}
