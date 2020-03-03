import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class StudentDatabaseSerializedFileReader extends StudentDatabaseCSVFileReader{
	
	private static ObjectOutputStream outputStudentDbReader = null;
	private static ObjectInputStream inputStudentDbReader = null;
	
	public static void serializeStudent(StudentDatabase dbReader){
		try {
			outputStudentDbReader = new ObjectOutputStream(new FileOutputStream("D:\\studentFileReader.ser"));
			outputStudentDbReader.writeObject(dbReader);
			outputStudentDbReader.close();
		} catch (IOException e) {
			System.out.println("An IOException was caught: " + e.getMessage());
		}
	}
	public static StudentDatabase deserializeStudent() {
		StudentDatabase dbDesReader = new StudentDatabase();
		try {
			inputStudentDbReader = new ObjectInputStream(new FileInputStream("D:\\studentFileReader.ser"));
			dbDesReader = (StudentDatabase)inputStudentDbReader.readObject();
		} catch (IOException e) {
			System.out.println("An IOException was caught: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("A ClassNotFoundException was caught: " + e.getMessage());
		}
		return dbDesReader;
	}
}