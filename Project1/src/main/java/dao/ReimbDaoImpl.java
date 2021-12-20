package dao;

import io.javalin.http.Context;
import models.ReimbModel;
import models.ResolveReimbModel;
import models.UserModel;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import util.ReimbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbDaoImpl implements ReimbDao {

    static Logger logger = Logger.getLogger(ReimbDaoImpl.class);

    String url;
    String username;
    String password;


    public ReimbDaoImpl(){
        this.url = "jdbc:postgresql://" +System.getenv("AWS_RDS_ENDPOINT")+ "/expensedb";
        this.username = System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public ReimbDaoImpl(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }


    @Override
    public List<ReimbModel> getAllReimb() {

        logger.setLevel(Level.ALL);
        List<ReimbModel> reimbList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "SELECT * FROM ers_reimbursement ORDER BY reimb_status_id, reimb_id;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();



            while(rs.next()){
                reimbList.add(new ReimbModel(rs.getInt(1),rs.getDouble(2),rs.getTimestamp(3),
                        rs.getTimestamp(4),rs.getString(5),rs.getBytes(6),rs.getInt(7),
                        rs.getInt(8),rs.getInt(9),rs.getInt(10)));
            }
            logger.trace(rs);
        }
        catch(SQLException e){
            logger.error(e);
        }
        return reimbList;
    }

    @Override
    public List<ReimbModel> getAllReimbUser(Integer ers_user_id) {
        logger.setLevel(Level.ALL);
        List<ReimbModel> reimbList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ? ORDER BY reimb_status_id, reimb_id;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ers_user_id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                reimbList.add(new ReimbModel(rs.getInt(1),rs.getDouble(2),rs.getTimestamp(3),
                        rs.getTimestamp(4),rs.getString(5),rs.getBytes(6),rs.getInt(7),
                        rs.getInt(8),rs.getInt(9),rs.getInt(10)));
            }
            logger.trace(rs);
        }
        catch(SQLException e){
            logger.error(e);
        }
        return reimbList;
    }

    @Override
    public ReimbModel getOneReimb(Integer reimb_id) {

        logger.setLevel(Level.ALL);
        ReimbModel reimb = null;

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, reimb_id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                reimb = new ReimbModel(rs.getInt(1),rs.getDouble(2),rs.getTimestamp(3),
                        rs.getTimestamp(4),rs.getString(5),rs.getBytes(6),rs.getInt(7),
                        rs.getInt(8),rs.getInt(9),rs.getInt(10));
            }
            logger.trace(rs);

        }
        catch(SQLException e){
            logger.error(e);
        }
        return reimb;
    }

    @Override
    public void createReimb(ReimbModel reimb) {

        logger.setLevel(Level.ALL);

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "INSERT INTO ers_reimbursement VALUES(DEFAULT, ?, DEFAULT, NULL, ?, NULL, ?, NULL, DEFAULT, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, reimb.getReimb_amount());
            ps.setString(2, reimb.getReimb_description());
            ps.setInt(3, reimb.getReimb_author());

            ps.setInt(4, reimb.getReimb_type_id());


            ps.executeUpdate();

            logger.trace(ps);

        }
        catch(SQLException e){
            logger.error(e);
        }

    }

    @Override
    public void approveReimb(Integer reimb_resolver, Integer reimb_id) {

        logger.setLevel(Level.ALL);

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "UPDATE ers_reimbursement SET reimb_status_id = 2, reimb_resolver = ?, reimb_resolved = now() WHERE reimb_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, reimb_resolver);
            ps.setInt(2, reimb_id);

            ps.executeUpdate();
            logger.trace(ps);

        }
        catch(SQLException e){
            logger.error(e);
        }

    }

    @Override
    public void denyReimb(Integer reimb_resolver, Integer reimb_id) {

        logger.setLevel(Level.ALL);

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "UPDATE ers_reimbursement SET reimb_status_id = 3, reimb_resolver = ?, reimb_resolved = now() WHERE reimb_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, reimb_resolver);
            ps.setInt(2, reimb_id);

            ps.executeUpdate();
            logger.trace(ps);

        }
        catch(SQLException e){
            logger.error(e);
        }

    }

    @Override
    public void resolveReimb(ResolveReimbModel resolveReimbModel) {

        logger.setLevel(Level.ALL);

        try (Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "";

            if(resolveReimbModel.getReimb_type().equals("approve"))
            {
                sql = "UPDATE ers_reimbursement SET reimb_status_id = 2, reimb_resolver = ?, reimb_resolved = now() WHERE reimb_id = ?;";
            }
            else if (resolveReimbModel.getReimb_type().equals("deny")){
                sql = "UPDATE ers_reimbursement SET reimb_status_id = 3, reimb_resolver = ?, reimb_resolved = now() WHERE reimb_id = ?;";
            }
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, resolveReimbModel.getReimb_resolver());
            ps.setInt(2, resolveReimbModel.getReimb_id());

            ps.executeUpdate();
            logger.trace(ps);

        }
        catch(SQLException e){
            logger.error(e);
        }


    }

    @Override
    public void deleteReimb(Integer reimb_id) {
        logger.setLevel(Level.ALL);

        try (Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, reimb_id);

            ps.executeUpdate();
            logger.trace(ps);

        }
        catch(SQLException e){
            logger.error(e);
        }
    }
}
