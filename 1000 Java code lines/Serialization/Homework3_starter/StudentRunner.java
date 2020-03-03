import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StudentRunner{
	public static void main(String[] args){
		
		 StudentDatabaseCSVFileReader.openFile("studentJUnitTestData.csv");
         StudentDatabase db = StudentDatabaseCSVFileReader.readData();
         StudentDatabaseCSVFileReader.closeFile();
 
         StudentDatabaseSerializedFileWriter.openFile("studentJUnitTestData_out2.ser");
         StudentDatabaseSerializedFileWriter.writeData(db);
         StudentDatabaseSerializedFileWriter.closeFile();

         StudentDatabaseSerializedFileReader.openFile("studentJUnitTestData_out2.ser");
         StudentDatabase db2  = StudentDatabaseSerializedFileReader.readData();
         StudentDatabaseSerializedFileReader.closeFile();

         StudentDatabaseCSVFileWriter.openFile("studentJUnitTestData_out3.csv");
         StudentDatabaseCSVFileWriter.writeData(db2);
         StudentDatabaseCSVFileWriter.closeFile();

         StudentDatabaseCSVFileReader.openFile("studentJUnitTestData_out3.csv");
         StudentDatabase db3 = StudentDatabaseCSVFileReader.readData();
         StudentDatabaseCSVFileReader.closeFile();
		 int a = db.getNumStudents();
		 int b = db3.getNumStudents();
		 System.out.println(a);
		 
	}

}