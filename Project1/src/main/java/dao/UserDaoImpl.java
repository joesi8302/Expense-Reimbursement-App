package dao;

import models.ReimbModel;
import models.UserLoginModel;
import models.UserModel;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.*;

public class UserDaoImpl implements UserDao{


    static Logger logger = Logger.getLogger(UserDaoImpl.class);


    String url;
    String username;
    String password;


    public UserDaoImpl(){
        this.url = "jdbc:postgresql://" +System.getenv("AWS_RDS_ENDPOINT")+ "/expensedb";
        this.username = System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public UserDaoImpl(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }



    @Override
    public UserModel userLogin(UserLoginModel user) {
        logger.setLevel(Level.ALL);

        UserModel checkUser = null;

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "SELECT * FROM ers_users WHERE ers_username = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());


            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                checkUser = new UserModel(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
            }
            logger.trace(rs);


        }
        catch(SQLException e){
            logger.error(e);
        }
        return checkUser;
    }

    @Override
    public void createUser(UserModel user) {
        logger.setLevel(Level.ALL);
        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "INSERT INTO ers_users VALUES(DEFAULT, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getErs_username());
            ps.setString(2, user.getErs_password());
            ps.setString(3, user.getUser_first_name());
            ps.setString(4, user.getUser_last_name());
            ps.setString(5, user.getUser_email());
            ps.setInt(6, user.getUser_role_id());


            ps.executeUpdate();
            logger.trace(ps);
        }
        catch(SQLException e){
            logger.error(e);
        }
    }

    @Override
    public void deleteUser(Integer ers_user_id) {

    }
}
