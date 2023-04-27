package project.spring4.mvc.employee.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import project.spring4.mvc.employee.model.EmpVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("empdao")
public class EmpDAOImpl implements EmpDAO{
    private static final Logger logger = LogManager.getLogger(EmpDAOImpl.class);

    @Value("#{jdbc['selectSQL']}") private String selectSQL;
    @Value("#{jdbc['insertSQL']}") private String insertSQL;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public EmpDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertEmp(EmpVO emp) {
        int cnt = -1;


        try {
            Object[] params = new Object[]{
                    emp.getEmployee_id(),
                    emp.getFirst_name(),
                    emp.getLname(),
                    emp.getEmail(),
                    emp.getPhone(),
                    emp.getHdate(),
                    emp.getJob_id(),
                    emp.getSal(),
                    emp.getComm(),
                    emp.getMgrid(),
                    emp.getDepartment_id()
            };
            cnt = jdbcTemplate.update(insertSQL, params);

        } catch (Exception ex) {
            logger.info("insertEmp 인포");
            logger.error("insertEmp 에러");
            logger.info(ex.getMessage());

        }

        return cnt;
    }

    @Override
    public List<EmpVO> selectEmp() {
        RowMapper<EmpVO> mapper = new EmpMapper();
        return jdbcTemplate.query(selectSQL, mapper);
    }
    private class EmpMapper implements RowMapper<EmpVO> {
        @Override
        public EmpVO mapRow(ResultSet rs, int num) throws SQLException {
            EmpVO emp = new EmpVO(rs.getInt(1),rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getInt(5));

            return emp;
        }
    }


}
