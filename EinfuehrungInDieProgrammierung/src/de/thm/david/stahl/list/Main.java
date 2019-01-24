package de.thm.david.stahl.list;

import de.thm.david.stahl.list.array.StudentArrayList;
import de.thm.david.stahl.list.common.Student;
import de.thm.david.stahl.list.common.StudentList;
import de.thm.david.stahl.list.common.TestData;
import de.thm.david.stahl.list.linked.StudentLinkedList;

public class Main
{
    public static void main(String[] args)
    {
        testList(new StudentArrayList());
        testList(new StudentLinkedList());
    }

    private static void testList(StudentList list)
    {
        list.initTestData();
        list.sort();
        System.out.println(list.toString());

        for(int i = 0; i < TestData.LASTNAMES.length; i++)
        {
            removeStudent(list);
        }
    }

    private static void removeStudent(StudentList list)
    {
        Student student = list.removeFirstStudent();
        System.out.println("Aus der Liste genommen: " + student.toString());
    }
}
