package com.example.datasyncv1.connex;
import java.sql.*;

public class Connexion
{
    Connection con;
    public Statement stat;
    ResultSet res;

    protected static String url = "jdbc:postgresql://containers-us-west-104.railway.app:6092/railway";
    protected static String Username = "postgres";
    protected static String Password = "93owc40E08BF1Ih6aG6m";

    public Connexion(String req)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection(url, Username, Password);
            this.stat= this.con.createStatement();
//  			this.res=stat.executeQuery(req);
            stat.execute(req);
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public Connexion()
    {
        try {
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection(url, Username, Password);
        } catch (Exception e) {
        } finally {
        }
    }


    public Connexion(String req,String ide)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection(url, Username, Password);
            this.stat= this.con.createStatement();
            this.res=stat.executeQuery(req);
            //	stat.execute(req);
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public PreparedStatement prepareStatement(String query) throws SQLException{
        return this.con.prepareStatement(query);
    }
    public ResultSet getResultset()
    {
        return this.res;
    }
    public void getCommit() throws Exception
    {
        this.stat.executeQuery("commit");
    }
    public void getRollBack() throws Exception
    {
        this.stat.executeQuery("rollback");
    }
    public Statement getStat()
    {
        return this.stat;
    }
}

