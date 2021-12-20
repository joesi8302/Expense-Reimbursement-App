package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReimbStatusDaoImpl implements ReimbStatusDao{

    static Logger logger = Logger.getLogger(ReimbStatusDaoImpl.class);


    String url;
    String username;
    String password;


    public ReimbStatusDaoImpl(){
        this.url = "jdbc:postgresql://" +System.getenv("AWS_RDS_ENDPOINT")+ "/expensedb";
        this.username = System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public ReimbStatusDaoImpl(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public void createReimbStatus(String status) {

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "INSERT INTO ers_reimbursement_status VALUES(DEFAULT, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, status);

            ps.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
