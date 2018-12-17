package de.thm.david.stahl.list;

import de.thm.david.stahl.list.array.StudentArrayList;
import de.thm.david.stahl.list.common.Student;
import de.thm.david.stahl.list.common.TestData;

public class Main
{
    public static void main(String[] args)
    {
        StudentArrayList list = new StudentArrayList();
        list.initTestData();
        list.sort();
        System.out.println(list.toString());

        for(int i = 0; i < TestData.LASTNAMES.length; i++)
        {
            removeStudent(list);
        }
    }

    private static void removeStudent(StudentArrayList list)
    {
        Student student = list.removeFirstStudent();
        System.out.println("Aus der Liste genommen: " + student.toString());
        System.out.println(list.toString());
    }
}
