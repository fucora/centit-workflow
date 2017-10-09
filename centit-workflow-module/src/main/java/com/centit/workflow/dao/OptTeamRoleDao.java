package com.centit.workflow.dao;

import com.centit.framework.jdbc.dao.BaseDaoImpl;
import com.centit.framework.jdbc.dao.DatabaseOptUtils;
import com.centit.workflow.po.OptTeamRole;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by chen_rj on 2017-10-9.
 */
@Repository
public class OptTeamRoleDao extends BaseDaoImpl<OptTeamRole,Long>{
    @Override
    public Map<String, String> getFilterField() {
        return null;
    }

    @Transactional(propagation= Propagation.MANDATORY)
    public String getNextOptTeamRoleId(){
        return String.valueOf(DatabaseOptUtils.getSequenceNextValue(this,"S_OPTTEAMROLE"));
    }

    @Transactional(propagation= Propagation.MANDATORY)
    public void saveNewObject(OptTeamRole o) {
        if(o.getOptTeamRoleId() == null || "".equals(o.getOptTeamRoleId())){
            o.setOptTeamRoleId(getNextOptTeamRoleId());
        }
        super.saveNewObject(o);
    }

    @Transactional(propagation= Propagation.MANDATORY)
    public List<OptTeamRole> getOptNodeByOptId(String optId){
        return this.listObjectsByFilter("where opt_id = ?",new Object[]{optId});
    }
}
