package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Employee;

/**
 * employeesテーブル用のRepositoryクラス
 * 
 * @author rpuser
 *
 */

@Repository
public class EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs,i) ->{
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setAge(rs.getInt("age"));
				employee.setGender(rs.getString("gender"));
				employee.setDepartmentId(rs.getInt("department_id"));
				return employee;
			};
	
	/**
	 * 主キー検索を行う
	 * 
	 * @param id　ID（主キー）
	 * @return　検索された従業員情報
	 */
	public Employee load(Integer id) {
		String sql = 
				"SELECT id,name,age,gender,department_id"
				+ " FROM employees WHERE id = :id";
		SqlParameterSource param = 
				new MapSqlParameterSource().addValue("id", id);
		Employee employee = 
				template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
		return employee;
	}
	
	/**
	 * 全件検索を行う
	 * 
	 * @return　全従業員一覧
	 */
	public List<Employee> findAll(){
		String sql = "SELECT id,name,age,gender,department_id"
				+ " FROM employees ORDER BY age ASC;";
		List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);
		return employeeList;
	}
	
	/**
	 * 渡した従業員情報を保存または更新する
	 * 
	 * @param employee　従業員情報
	 * @return　追加or更新された後の従業員情報
	 */
	public Employee save(Employee employee) {
		//	引数で受け取ったEmployeeドメインオブジェクトを使って、
		//	プレースホルダ用のパラメータのオブジェクトを作成する
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		
		if(employee.getId() == null) {	//	IDが設定されていない→新レコード
			String insertSql = "INSERT INTO employees(name,age,gender,department_id) "
					+ "VALUES(:name,:age,:gender,:department_id);";
			template.update(insertSql, param);
		} else {	//	IDが設定されている→すでにあるレコード
			String updateSql = "UPDATE employees SET name=:name,"
					+ "age=:age,gender=:gender,department_id=:departmentId"
					+ " WHERE id=:id;";
			template.update(updateSql,param);
		}
		return employee;
	}
	
	/**
	 * 主キーを使って1件の従業員情報を削除する
	 * 
	 * @param id　ID（主キー）
	 */
	public void deleteById(Integer id) {
		String deleteSql = "DELETE FROM employees WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		template.update(deleteSql, param);
	}
}
