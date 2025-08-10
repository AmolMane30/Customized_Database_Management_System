//--------------------------------------------------------------------------------------------------------------------------------------------//
//        Project Title: Virtual Customized Database Management System
//
//        Description  : -> Implements a Database Management System without using actual Database Management System.
//                       -> Implemented own logic for all the SQL Queries.
//                       -> We can perform CRUD operations as well as Aggregate operations.
//                       -> Implemented Java's Collections Framework.
//                       -> Virtual Database is created (on RAM).
//
//        Author       : Amol R. Mane
//        Date         : 11 August 2025
//--------------------------------------------------------------------------------------------------------------------------------------------//

//----------------------------------------------------------------------------------------------------------------------------------//
//                                        [ VIRTUAL CUSTOMIZED DATABASE MANAGEMENT SYSTEM ]
//----------------------------------------------------------------------------------------------------------------------------------//

import java.util.*;

class Employee 
{
    public int Eid;
    public String Ename;
    public int Eage;
    public String Eaddress;
    public int Esalary;

    public static int Counter;

    static
    {
        Counter = 1;
    }

    public Employee(String B, int C, String D, int E)
    {
        Eid = Counter++;
        Ename = B;
        Eage = C;
        Eaddress = D;
        Esalary = E;
    }

    // Displays formatted employee information.
    public void DisplayInformation()
    {
        System.out.printf("%-5d %-15s %-20s %-5d %-10d\n",Eid,Ename,Eaddress,Eage,Esalary);
    }
}

// Customized Database Management System that stores and manages Employee records.
// Provides functionalities like SQL queries.
class CustomizedDBMS
{
    public LinkedList <Employee>lobj;

    // Constructor initializes the DBMS.
    public CustomizedDBMS()
    {
        System.out.println("Customized DBMS started successfully..");
        lobj = new LinkedList<Employee>();
    }

    protected void finalize()
    {
        System.out.println("Deallocating all resources of Customized DBMS...");
        lobj.clear();
        lobj = null;
    }

    // insert into employee values(1,"Piyush",34,"Pune",11000);
    public void InsertIntoTable(String name, int age, String address, int salary)
    {
        Employee eobj = new Employee(name,age,address,salary);
        lobj.addLast(eobj);
        System.out.println("Record inserted successfully into the table");
    }

    // select * from Employee;
    public void SelectStarFrom()
    {
        if(lobj.isEmpty())
        {
            System.out.println("No records found");
            return;
        }

        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-20s %-5s %-10s\n", "ID", "Name", "Address", "Age", "Salary");
        System.out.println("-----------------------------------------------------------------");

        for(Employee eref : lobj)
        {
            eref.DisplayInformation();
        }

        System.out.println("-----------------------------------------------------------------");
    }

    // Select * from employee where Eid = 3
    public void SelectSpecific(int id)
    {
        boolean bFlag = false;
        for(Employee eref : lobj)
        {
            if(eref.Eid == id)
            {
                System.out.println("-----------------------------------------------------------------");
                System.out.printf("%-5s %-15s %-20s %-5s %-10s\n", "ID", "Name", "Address", "Age", "Salary");
                System.out.println("-----------------------------------------------------------------");

                eref.DisplayInformation();
                bFlag = true;
                break;
            }
        }
        if(bFlag == false)
        {
            System.out.println("Employee not found with ID :"+id);
        }
    }

    // Select * from employee where Ename = "Amit"
    public void SelectSpecific(String str)
    {
        boolean bFlag = false;
        for(Employee eref : lobj)
        {
            if(str.equalsIgnoreCase(eref.Ename))
            {
                System.out.println("-----------------------------------------------------------------");
                System.out.printf("%-5s %-15s %-20s %-5s %-10s\n", "ID", "Name", "Address", "Age", "Salary");
                System.out.println("-----------------------------------------------------------------");

                eref.DisplayInformation();
                bFlag = true;
                break;
            }
        }

        if(bFlag == false)
        {
            System.out.println("Employee not found with the name : "+str);
        }
    }

    // delete from Employee where Eid = 2
    public void DeleteData(int ID)
    {
        int index = 0;
        boolean bFlag = false;

        for(Employee eref : lobj)
        {
            if(eref.Eid == ID)
            {
                bFlag = true;
                break;
            }
            index++;
        }

        if(bFlag == false)
        {
            System.out.println("Unable to delete the record as ID : "+ID+" is not there in database");
        }
        else
        {
            lobj.remove(index);
            System.out.println("Record deleted successfully of ID :"+ID);
        }
    }

    // delete from Employee where Ename = "Sagar"
    public void DeleteData(String str)
    {
        int index = 0;
        boolean bFlag = false;

        for(Employee eref : lobj)
        {
            if(str.equalsIgnoreCase(eref.Ename))
            {
                bFlag = true;
                break;
            }
            index++;
        }

        if(bFlag == false)
        {
            System.out.println("Unable to delete the record as "+str+" is not there in database");
        }
        else
        {
            lobj.remove(index);
            System.out.println("Record deleted successfully of name :"+str);
        }
    }

    // select Count(Eno) from Employee 
    public void AggregateCount()
    {
        System.out.println("Number of records in the Employee table : "+lobj.size());
    }

    // select Sum(ESalary) from Employee
    public void AggregateSum()
    {
        int iSum = 0;
        if(lobj.isEmpty())
        {
            System.out.println("No records in the table.");
            return;
        }

        for(Employee eref : lobj)
        {
            iSum = iSum + eref.Esalary;
        }

        System.out.println("Summation of records in the Employee table : "+iSum);
    }

    // select Avg(ESalary) from Employee
    public void AggregateAvg()
    {
        int iSum = 0;

        if(lobj.isEmpty())
        {
            System.out.println("No records found in the table.");
            return;
        }

        for(Employee eref : lobj)
        {
            iSum = iSum + eref.Esalary;
        }

        System.out.println("Average of records in the Employee table : "+(iSum / lobj.size()));
    }

    // select Max(ESalary) from Employee
    public void AggregateMax()
    {
        if(lobj.isEmpty())
        {
            System.out.println("No records found in the table.");
            return;
        }

        int iMax = lobj.get(0).Esalary;

        for(Employee eref : lobj)
        {
            if(eref.Esalary > iMax)
            {
                iMax = eref.Esalary;
            }
        }

        System.out.println("Maximum of records in the Employee table : "+iMax);
    }

    // select Min(Esalary) from Employee
    public void AggregateMin()
    {
        if(lobj.isEmpty())
        {
            System.out.println("No records found in the table.");
            return;
        }

        int iMin = lobj.get(0).Esalary;

        for(Employee eref : lobj)
        {
            if(eref.Esalary < iMin)
            {
                iMin = eref.Esalary;
            }
        }

        System.out.println("Minimum of records in the Employee table : "+iMin);
    }

    // Update Employee Set Address = "Sangli" where Eid = 3;
    public void UpdateRecord(int id, String address)
    {
        int index = 0;
        boolean bRet = false;

        for(Employee eref : lobj)
        {
            if(eref.Eid == id)
            {
                eref.Eaddress = address;
                lobj.set(index,eref);
                bRet = true;
                break;
            }
            index++;
        }

        if(bRet == false)
        {
            System.out.println("Unable to update the record as ID "+id+" is not present in the table");
        }
        else
        {
            System.out.println("Address : "+address+" updated successfully in the Employee ID : "+id);
        }
    }
}

//----------------------------------------------------------------------------------------------------------------------------------//
//                                        [ MAIN FUNCTION ]
//----------------------------------------------------------------------------------------------------------------------------------//
// Main Class for the Virtual_Customized DBMS
// Provides a console menu for performing DBMS operations.
class Virtual_Customized_Database_Management_System
{
    public static void main(String Arg[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Welcome to Customized DBMS");
        
        CustomizedDBMS cobj = new CustomizedDBMS();

        int iOption = 0;
        String name = "";
        int age = 0, salary = 0;
        String address = "";
        int id = 0;

        // Menu Driven CLI
        while(true)
        {
            try
            {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Please select your option based on your requirement");

                System.out.println("1  : Insert new record");
                System.out.println("2  : Display all records");
                System.out.println("3  : Display specific record by ID");
                System.out.println("4  : Display specific record by Name");
                System.out.println("5  : Delete specific record by ID");
                System.out.println("6  : Delete specific record by Name");
                System.out.println("7  : Count number of records in the table");
                System.out.println("8  : Summation of all records salary");
                System.out.println("9  : Average of all records salary");
                System.out.println("10 : Maximum of all records salary");
                System.out.println("11 : Minimum of all records salary");
                System.out.println("12 : Update the existing record address by ID");
                System.out.println("13 : Delete the table");
                System.out.println("14 : Terminate the Customized DBMS");

                System.out.println("-----------------------------------------------------------------");
            
                iOption = sobj.nextInt();

                if(iOption == 1)
                {
                    System.out.println("Enter the name of employee");
                    name = sobj.next();

                    System.out.println("Enter the age of employee");
                    age = sobj.nextInt();

                    System.out.println("Enter the salary of employee");
                    salary = sobj.nextInt();

                    System.out.println("Enter the address of employee");
                    address = sobj.next();

                    cobj.InsertIntoTable(name,age,address,salary);
                }
                else if(iOption == 2)
                {
                    cobj.SelectStarFrom();
                }
                else if(iOption == 3)
                {
                    System.out.println("Enter the employee ID whose data you want to display");
                    id = sobj.nextInt();

                    cobj.SelectSpecific(id);
                }
                else if(iOption == 4)
                {
                    System.out.println("Enter the employee name whose data you want to display");
                    name = sobj.next();
                    cobj.SelectSpecific(name);
                }
                else if(iOption == 5)
                {
                    System.out.println("Enter the employee ID that you want to delete");
                    id = sobj.nextInt();

                    cobj.DeleteData(id);
                }
                else if(iOption == 6)
                {
                    System.out.println("Enter the employee name that you want to delete");
                    name = sobj.next();

                    cobj.DeleteData(name);
                }
                else if(iOption == 7)
                {
                    cobj.AggregateCount();
                }
                else if(iOption == 8)
                {
                    cobj.AggregateSum();
                }
                else if(iOption == 9)
                {
                    cobj.AggregateAvg();
                }
                else if(iOption == 10)
                {
                    cobj.AggregateMax();
                }
                else if(iOption == 11)
                {
                    cobj.AggregateMin();
                }
                else if(iOption == 12)
                {
                    System.out.println("Enter the ID of employee that you want to update");
                    id = sobj.nextInt();

                    System.out.println("Enter the new address");
                    address = sobj.next();
                    cobj.UpdateRecord(id,address);
                }
                else if(iOption == 13)
                {
                    cobj.lobj.clear();
                    System.gc();
                    System.out.println("Database deleted successfully");
                    Employee.Counter = 1;
                }
                else if(iOption == 14)
                {
                    System.out.println("Thank you for using Customized DBMS");
                    break;
                }
                else 
                {
                    System.out.println("Invalid Option");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input type. Please enter valid input type.");
                sobj.nextLine(); // clear buffer
            } 
            catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}

//----------------------------------------------------------------------------------------------------------------------------------//
//----------------------------------------------------------------------------------------------------------------------------------//