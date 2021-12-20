package services;

import dao.ReimbDao;
import dao.ReimbDaoImpl;
import models.ReimbModel;
import models.ResolveReimbModel;

import java.util.List;

public class ReimbDaoService {
    ReimbDao reimbDao;

    public ReimbDaoService(ReimbDao reimbDao){this.reimbDao = reimbDao;}

    public ReimbDaoService() {this.reimbDao = new ReimbDaoImpl();}


    public List<ReimbModel> getAllReimb() {
        return reimbDao.getAllReimb();
    }

    public List<ReimbModel> getAllReimbUser(Integer ers_user_id) {
        return reimbDao.getAllReimbUser(ers_user_id);
    }

    public ReimbModel getOneReimb(Integer reimb_id) {
        return reimbDao.getOneReimb(reimb_id);
    }

    public void createReimb(ReimbModel reimb) {
        reimbDao.createReimb(reimb);
    }

    public void approveReimb(Integer reimb_resolver, Integer reimb_id) {
        reimbDao.approveReimb(reimb_resolver, reimb_id);
    }

    public void denyReimb(Integer reimb_resolver, Integer reimb_id) {
        reimbDao.denyReimb(reimb_resolver, reimb_id);
    }

    public void resolveReimb(ResolveReimbModel resolveReimbModel) { reimbDao.resolveReimb(resolveReimbModel);}

    public void deleteReimb(Integer reimb_id) {
        reimbDao.deleteReimb(reimb_id);
    }
}
