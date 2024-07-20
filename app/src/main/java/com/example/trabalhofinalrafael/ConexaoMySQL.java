package com.example.trabalhofinalrafael;

import android.app.AlertDialog;
import android.content.Context;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySQL {
    private Statement stmt; //executar consultas DML
    private ResultSet rs; //gerenciar consultas DQL
    private Connection c;
    private Context context;

    public ConexaoMySQL(Context context) {
        this.context = context;
        String Server = "trabalho-final.mysql.uhserver.com";
        String Database = "trabalho_final";
        String user = "alunos_ads_pdm";
        String password = "Entrega@App2";

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://" + Server + ":3306/" + Database + "?serverTimezone=UTC";

        //permite conexão com a Internet na Thread principal
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Abrir conexão
        try {
            Class.forName(driver).newInstance();
            c = DriverManager.getConnection(url, user, password);
            stmt = c.createStatement();

            //Deletar alert depois do teste
            setAlert("Conectado");
        }
        catch (Exception e) {
            setAlert(e.getMessage());
        }
    }

    private void setAlert(String Msg) {
        AlertDialog.Builder a = new AlertDialog.Builder(context);
        a.setTitle("Banco de dados");
        a.setCancelable(false);
        a.setMessage(Msg);
        a.setPositiveButton("Ok", null);
        a.show();
    }

    public boolean SQLExecute(String SQL) {
        try {
            this.stmt.execute(SQL);
            return true;
        }
        catch(SQLException e) {
            setAlert(e.getMessage());
            return false;
        }
    }

    public boolean setResultSet(String Query) {
        try {
            this.rs = this.stmt.executeQuery(Query);
            return true;
        }
        catch(SQLException e) {
            setAlert(e.getMessage());
            return false;
        }
    }

    public ResultSet getResultSet() {
        return rs;
    }

}
