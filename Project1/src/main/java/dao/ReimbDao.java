package dao;

import models.ReimbModel;
import models.ResolveReimbModel;

import java.util.List;

public interface ReimbDao {

    List<ReimbModel> getAllReimb();
    List<ReimbModel> getAllReimbUser(Integer ers_user_id);
    ReimbModel getOneReimb(Integer reimb_id);
    void createReimb(ReimbModel reimb);
    void approveReimb(Integer reimb_resolver, Integer reimb_id);
    void denyReimb(Integer reimb_resolver, Integer reimb_id);
    void resolveReimb(ResolveReimbModel resolveReimbModel);
    void deleteReimb(Integer reimb_id);



}
