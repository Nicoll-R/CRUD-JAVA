package Modelo;

import java.sql.*;
public class Conexion {
    Connection con;
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto","root","");
            System.out.println("Connected succesfull");
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
    }
    public Connection getConnection() {
        return con;
    }
}


