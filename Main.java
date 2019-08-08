import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		Employee employee;
		Employee emp;
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session1 = factory.openSession();
		Session session2 = factory.openSession();
		Session session3 = factory.openSession();
		
		Transaction transaction1 = session1.beginTransaction();
		Transaction transaction2 = session2.beginTransaction();
		Transaction transaction3 = session3.beginTransaction();
		
//		Create
		employee = new Employee(101, "Nitin");
		session1.save(employee);
		employee = new Employee(102, "Ankit");
		session1.save(employee);
		employee = new Employee(103, "Gangu");
		session1.save(employee);
		transaction1.commit();
		
//		Read
		emp = session1.get(Employee.class, 101);
		System.out.println("Name: " +emp.getName());
		
//		Update
		emp = session2.get(Employee.class, 103);
		emp.setName("Gagan");
		session2.update(emp);
		transaction2.commit();
		
//		Delete
		emp = session3.get(Employee.class, 103);
		session3.delete(emp);
		transaction3.commit();
		
	}
}