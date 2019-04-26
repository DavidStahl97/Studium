package de.thm.schule;

import java.util.ArrayList;

import de.thm.schule.repository.access.AccessFactory;
import de.thm.schule.repository.entities.Class;
import de.thm.schule.repository.entities.Group;
import de.thm.schule.repository.entities.Student;
import de.thm.schule.repository.entities.Teacher;

public class SchoolAdministration {
	
	public SchoolAdministration() {
		populateSchool();
	}
	
	private void populateSchool() {
		
		var classes = new ArrayList<Class>();
		
		for(int i = 0; i < 5; i++) {
		
			var cl = DummyFactory.createClass();
			classes.add(cl);
			
			var teacher = DummyFactory.createTeacher();
			cl.setTeacher(teacher);
			
			var groupOne = DummyFactory.createGroup();
			var groupTwo = DummyFactory.createGroup();
			
			var students = new ArrayList<Student>();
			for(int j = 0; j < 20; j++) {
				var student = DummyFactory.createStudent();
				student.setSchoolClass(cl);
				students.add(student);
				
				//student.addGroup(groupOne);
				//student.addGroup(groupTwo);
			}
		
			cl.setStudents(students);			
		}
		
		var classDataAccess = AccessFactory.getClassDataAccess();
		classDataAccess.persist(classes);
	}
}
