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

    private SqlSession sqlSession;
    @Autowired
    public EmpDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;}
    @Override
    public int insertEmp(EmpVO emp) {
        return sqlSession.insert("employee.insertsql", emp);}

    @Override
    public List<EmpVO> selectEmp() {
        return sqlSession.selectList("employee.selectsql");}

    @Override
    public EmpVO selectOneEmp(int employee_id) {
        return sqlSession.selectOne("employee.selectonesql", employee_id);}

    @Override
    public int updateEmp(EmpVO emp) {
        return sqlSession.update("employee.updatesql", emp);}




}
