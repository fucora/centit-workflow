package com.centit.workflow.dao;

import com.centit.framework.jdbc.dao.BaseDaoImpl;
import com.centit.framework.jdbc.dao.DatabaseOptUtils;
import com.centit.workflow.po.OptVariable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by chen_rj on 2017-10-9.
 */
@Repository
public class OptVariableDao extends BaseDaoImpl<OptVariable,Long> {
    @Override
    public Map<String, String> getFilterField() {
        return null;
    }

    @Transactional(propagation= Propagation.MANDATORY)
    public String getNextOptVariableId(){
        return String.valueOf(DatabaseOptUtils.getSequenceNextValue(this,"S_OPTVARIABLE"));
    }

    @Transactional(propagation= Propagation.MANDATORY)
    public void saveNewObject(OptVariable o) {
        if(o.getOptVariableId() == null || "".equals(o.getOptVariableId())){
            o.setOptVariableId(getNextOptVariableId());
        }
        super.saveNewObject(o);
    }

    @Transactional(propagation= Propagation.MANDATORY)
    public List<OptVariable> getOptNodeByOptId(String optId){
        return this.listObjectsByFilter("where opt_id = ?",new Object[]{optId});
    }
}
