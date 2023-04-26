package project.spring4.mvc.employee.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring4.mvc.employee.dao.EmpDAO;
import project.spring4.mvc.employee.model.EmpVO;

import java.util.List;
@Service("empsrv")
public class EmpServiceImpl implements EmpService{
    private EmpDAO empdao = null;
    private static final Logger logger = LogManager.getLogger(EmpServiceImpl.class);

    @Autowired
    public EmpServiceImpl(EmpDAO empdao) {
        this.empdao = empdao;
    }

    @Override
    public boolean newEmp(EmpVO emp) {
        boolean result = false;

        if(empdao.insertEmp(emp) > 0) result = true;
        logger.info(result);
        logger.info("newEmp로거"+result);

        return result;
    }

    @Override
    public List<EmpVO> readEmp() {
        return empdao.selectEmp();
    }
}
