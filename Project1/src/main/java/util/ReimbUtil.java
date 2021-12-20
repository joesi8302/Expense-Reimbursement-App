package util;

import dao.ReimbDaoImpl;
import org.apache.log4j.Logger;

import java.sql.*;

public class ReimbUtil {
    public static String url = "jdbc:h2:./h2/db";
    public static String username = "sa";
    public static String password = "sa";

    static Logger logger = Logger.getLogger(ReimbUtil.class);

    public static void createReimbTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            Timestamp date = Timestamp.valueOf("2021-12-10 14:35:44.865");

            String sql = "CREATE TABLE ERS_REIMBURSEMENT(\n" +
                    "\tREIMB_ID serial PRIMARY KEY,\n" +
                    "\tREIMB_AMOUNT double PRECISION NOT NULL,\n" +
                    "\tREIMB_SUBMITTED timestamp DEFAULT NULL,\n" +
                    "\tREIMB_RESOLVED timestamp,\n" +
                    "\tREIMB_DESCRIPTION varchar(250),\n" +
                    "\tREIMB_RECEIPT bytea ,\n" +
                    "\tREIMB_AUTHOR int NOT NULL REFERENCES ERS_USERS(ERS_USERS_ID),\n" +
                    "\tREIMB_RESOLVER int DEFAULT NULL REFERENCES ERS_USERS(ERS_USERS_ID),\n" +
                    "\tREIMB_STATUS_ID int NOT NULL DEFAULT 1 REFERENCES ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID),\n" +
                    "\tREIMB_TYPE_ID int NOT NULL REFERENCES ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID)\n" +
                    ");";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (Exception e){
            logger.error(e);
        }
    }

    public static void createReimbTypeTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "CREATE TABLE ERS_REIMBURSEMENT_TYPE(\n" +
                    "\tREIMB_TYPE_ID serial PRIMARY KEY,\n" +
                    "\tREIMB_TYPE varchar(10) NOT NULL\n" +
                    ");";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (Exception e){
            logger.error(e);
        }
    }
    public static void createReimbStatusTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "CREATE TABLE ERS_REIMBURSEMENT_STATUS(\n" +
                    "\tREIMB_STATUS_ID serial PRIMARY KEY,\n" +
                    "\tREIMB_STATUS varchar(10) NOT NULL\n" +
                    ");";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (Exception e){
            logger.error(e);
        }
    }

    public static void createUserRolesTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "CREATE TABLE ERS_USER_ROLES(\n" +
                    "\tERS_USER_ROLE_ID serial PRIMARY KEY,\n" +
                    "\tUSER_ROLE varchar(10) NOT NULL\n" +
                    ");";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (Exception e){
            logger.error(e);
        }
    }

    public static void createUsersTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "CREATE TABLE ERS_USERS(\n" +
                    "\tERS_USERS_ID serial PRIMARY KEY,\n" +
                    "\tERS_USERNAME varchar(50) NOT NULL UNIQUE,\n" +
                    "\tERS_PASSWORD varchar(50) NOT NULL,\n" +
                    "\tUSER_FIRST_NAME varchar(100) NOT NULL,\n" +
                    "\tUSER_LAST_NAME varchar(100) NOT NULL,\n" +
                    "\tUSER_EMAIL varchar(150) NOT NULL UNIQUE,\n" +
                    "\tUSER_ROLE_ID int NOT NULL REFERENCES ERS_USER_ROLES(ERS_USER_ROLE_ID)\n" +
                    ");";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (Exception e){
            logger.error(e);
        }
    }

    public static void dropReimbTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "DROP TABLE ers_reimbursement;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (Exception e){
            logger.error(e);
        }
    }

    public static void dropReimbStatusTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "DROP TABLE ers_reimbursement_status;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (Exception e){
            logger.error(e);
        }
    }

    public static void dropReimbTypeTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "DROP TABLE ers_reimbursement_type;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (Exception e){
            logger.error(e);
        }
    }

    public static void dropUserRolesTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "DROP TABLE ers_user_roles;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (Exception e){
            logger.error(e);
        }
    }

    public static void dropUsersTable(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "DROP TABLE ers_users;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();


        }catch (Exception e){
            logger.error(e);
        }
    }



}
