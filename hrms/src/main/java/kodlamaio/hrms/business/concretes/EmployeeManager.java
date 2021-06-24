package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;


@Service
public class EmployeeManager implements EmployeeService {

	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll(),"Data listed");
	}

	@Override
	public Result insert(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Employee added");
	}

	@Override
	public DataResult<Employee> getById(int id) {
		return new SuccessDataResult<Employee>(this.employeeDao.getById(id),"Data listed");
	}

	@Override
	public Result update(Employee employee) {
		Employee updateemployee=this.employeeDao.getById(employee.getId());
		updateemployee.setFirstName(employee.getFirstName());
		updateemployee.setLastName(employee.getLastName());
		updateemployee.setEmail(employee.getEmail());
		updateemployee.setPassword(employee.getPassword());
		this.employeeDao.save(updateemployee);
		return new SuccessResult("Employee updated");
		
	}

	

}
