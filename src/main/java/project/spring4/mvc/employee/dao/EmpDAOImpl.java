package project.spring4.mvc.employee.dao;

import oracle.jdbc.proxy.oracle$1jdbc$1replay$1driver$1NonTxnReplayableBase$2oracle$1jdbc$1OracleParameterMetaData$$$Proxy;
import org.apache.ibatis.session.SqlSession;
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
//
//    @Value("#{jdbc['selectSQL']}") private String selectSQL;
//    @Value("#{jdbc['insertSQL']}") private String insertSQL;
//    @Value("#{jdbc['updateSQL']}") private String updateSQL;
//    @Value("#{jdbc['selectOneSQL']}") private String selectOneSQL;
//    private JdbcTemplate jdbcTemplate;
//@Autowired
//public EmpDAOImpl(JdbcTemplate jdbcTemplate) {
//    this.jdbcTemplate = jdbcTemplate;
//}
    private SqlSession sqlSession;
    @Autowired
    public EmpDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int insertEmp(EmpVO emp) {
        return sqlSession.insert("employee.insertsql", emp);
    }

    @Override
    public List<EmpVO> selectEmp() {
//        RowMapper<EmpVO> mapper = new EmpMapper();
//        return jdbcTemplate.query(selectSQL, mapper);
        return sqlSession.selectList("employee.selectsql");
    }

    @Override
    public EmpVO selectOneEmp(int employee_id) {
        return sqlSession.selectOne("employee.selectonesql", employee_id);
    }

    private class EmpOneMapper implements RowMapper<EmpVO> {
        @Override
        public EmpVO mapRow(ResultSet rs, int num) throws SQLException {
            EmpVO emp = new EmpVO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getInt(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getDouble(10),
                    rs.getInt(11)

            );
            return emp;
        }
    }

    @Override
    public int updateEmp(EmpVO emp) {
        //updateSQL = update employees set first_name = ?, first_name = ?, email = ?, job_id = ?, department_id = ?, \
//        lname = ?, phone = ?, hdate = ?, sal = ?, comm = ?, mgrid = ?where employee_id = ?
// updateSQL = update employees set job_id = ?, manager_id = ?, department_id = ? where employee_id = ?
        Object[] param = new Object[]{
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

        return jdbcTemplate.update(updateSQL, param);
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
