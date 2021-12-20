package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRoleDaoImpl implements UserRoleDao{

    static Logger logger = Logger.getLogger(UserRoleDaoImpl.class);


    String url;
    String username;
    String password;


    public UserRoleDaoImpl(){
        this.url = "jdbc:postgresql://" +System.getenv("AWS_RDS_ENDPOINT")+ "/expensedb";
        this.username = System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public UserRoleDaoImpl(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }


    @Override
    public void createUserRole(String role) {

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "INSERT INTO ers_user_roles VALUES(DEFAULT, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, role);

            ps.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }




}
