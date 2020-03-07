import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
public class StudentDatabaseSerializedFileWriter extends StudentDatabaseCSVFileWriter{
	
	private static ObjectOutputStream outputStudentDb = null;
	private static ObjectInputStream inputStudentDb = null;
	
	
	public static void serializeStudent(StudentDatabase db){
	try {
		outputStudentDb = new ObjectOutputStream(new FileOutputStream("D:\\studentFileWriter.ser"));
			outputStudentDb.writeObject(db);
			outputStudentDb.close();
		} catch (IOException e) {
			System.out.println("An IOException was caught: " + e.getMessage());
		}
	}
	
	public static StudentDatabase deserializeStudent() {
		StudentDatabase dbDes = new StudentDatabase();
		try {
			inputStudentDb = new ObjectInputStream(new FileInputStream("D:\\studentFileWriter.ser"));
			dbDes = (StudentDatabase)inputStudentDb.readObject();
			
		} catch (IOException e) {
			System.out.println("An IOException was caught: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("A ClassNotFoundException was caught: " + e.getMessage());
		}
		return dbDes;
	}
	
}