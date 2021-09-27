# SPRING

Banuprakash C

Full Stack Architect,

Co-founder Lucida Technologies Pvt Ltd.,

Corporate Trainer,

Email: banuprakashc@yahoo.co.in

https://www.linkedin.com/in/banu-prakash-50416019/


https://github.com/BanuPrakash/SPRING

===================================

Softwares Required:
1) Java 8+
	https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html

2) Eclipse for JEE  
	https://www.eclipse.org/downloads/packages/release/2021-09/m1/eclipse-ide-enterprise-java-and-web-developers

3) MySQL  [ Prefer on Docker]

Install Docker Desktop

Docker steps:

a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i <container_name> /bin/bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit

=============================================================================

Day 1

-------

Spring Framework:

Lightweight Container for building enterprise applications.


containers are layers on JVM.

Spring provids Dependency Injection and Life Cycle Management with its Core container.

What is DI?

Spring Core Module provides Dependency Injection.

Modules provided by Spring:
1) Core Module
2) JDBC ==> Simpilify using JDBC
3) ORM ==> using Spring with ORM frameworks like Hibernate, TopLink, OpenJPA, EclipseLink
4) Web ==> simplifies building web application development [ Traditional or RESTful or GraphQL]
5) Transaction ==> simplifies transaction managment
6) AOP ==> Aspect Oriented Programming
....

Spring uses metadata to manage lifecycle of beans and wiring of beans

// entity class / Domain / Model
public class Employee {
	fields / getters / setters
}

public interface EmployeeDao {
	public void addEmployee(Employee e);
}

public class EmployeeDaoFileImpl implements EmployeeDao {
	public void addEmployee(Employee e) {
		...
	}	
}

public class EmployeeDaoJdbcImpl implements EmployeeDao {
	public void addEmployee(Employee e) {
		...
	}
}


public class AppService {
	private EmployeeDao empDao; // dependency

	public void setEmpDao(EmployeeDao dao) {
		this.empDao = dao;
	}

	public void insert(Employee e) {
		empDao.addEmployee(e);
	}
}


XML as Metadata:

<bean id="jdbcImpl" class="pkg.EmployeeDaoJdbcImpl" />

<bean id="fileImpl" class="pkg.EmployeeDaoFileImpl" />

<bean id="appService" class="pkg.AppService">
	<property name="empDao" ref="fileImpl" />
</bean>



=======================

Java 1.5 version introduced Annotations

Spring Framework creates beans which has one of these annotations at classlevel.

1) @Component
2) @Repository
3) @Service
4) @Configuration
5) @Controller
6) @RestController

https://github.com/spring-projects/spring-framework/blob/main/spring-jdbc/src/main/resources/org/springframework/jdbc/support/sql-error-codes.xml

public interface EmployeeDao {
	public void addEmployee(Employee e);
}

@Repository
public class EmployeeDaoFileImpl implements EmployeeDao {
	public void addEmployee(Employee e) {
		...
	}	
}

@Service
public class AppService {
	@Autowired
	private EmployeeDao empDao; // dependency

 	public void insert(Employee e) {
		empDao.addEmployee(e);
	}
}


==

try {
	.. code ...
} catch(SQLException ex) {
	if(ex.getErrorCode() == 1) {
		thrown new DataAcessException("Duplicate key")
	} 
}


@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {
	public void addEmployee(Employee e) {
		...
	}	
}

=============

Creating a Spring Container:

1) ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
