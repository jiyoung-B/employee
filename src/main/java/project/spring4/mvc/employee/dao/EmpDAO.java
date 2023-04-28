package project.spring4.mvc.employee.dao;

import project.spring4.mvc.employee.model.EmpVO;

import java.util.List;

public interface EmpDAO {
    int insertEmp(EmpVO emp);
    List<EmpVO> selectEmp();

    EmpVO selectOneEmp(int employee_id);

    int updateEmp(EmpVO emp);


}
