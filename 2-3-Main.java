
import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer staffNumber = scan.nextInt();
		Integer recordNumber = scan.nextInt();
		String record = scan.nextLine();
		
		HashMap<BaseStaff, Integer> map = new HashMap<BaseStaff, Integer>();
		
		for (int i=0; i<staffNumber; i++) {
			record = scan.nextLine();
			String[] items = record.split(" ");
			switch(items[0]) {
			case "Teacher":
				map.put(new Teacher(Integer.parseInt(items[1]), items[2], Integer.parseInt(items[3]), items[4]), 0);
				break;
			case "Student":
				map.put(new Student(Integer.parseInt(items[1]), items[2], items[3], Integer.parseInt(items[4]), Integer.parseInt(items[5])), 0);
				break;
			}
		}
		
		for (int i=0; i<recordNumber; i++) {
			record = scan.nextLine();
			String[] items = record.split(" ");
			switch(items[0]) {
			case "T":
				Teacher teacher = new Teacher(Integer.parseInt(items[1]));
				Integer oldCountT = map.get(teacher);
				map.put(teacher, oldCountT+1);
				break;
			case "S":
				Student student = new Student(Integer.parseInt(items[1]));
				Integer oldCountS = map.get(student);
				map.put(student, oldCountS+1);
				break;
			}
		}
		
		scan.close();
		
		Iterator<HashMap.Entry<BaseStaff, Integer>> iter = map.entrySet().iterator();
		Integer maxRecord = 0;
		BaseStaff maxStaff = null;
		
		while(iter.hasNext()) {
			HashMap.Entry<BaseStaff, Integer> entry = iter.next();
			if (entry.getValue()>maxRecord) {
				maxRecord = entry.getValue();
				maxStaff = entry.getKey();
			}
		}
		
		if (maxStaff.getType()=="Teacher") {
			Teacher teacher = (Teacher)maxStaff;
			teacher.print();
		}
		else {
			Student student = (Student)maxStaff;
			student.print();
		}
	}
}

class Student extends BaseStaff{
	private static final String type = "Student";
	
	private Integer id;
	private String name;
	private String gender;
	private Integer age;
	private Integer year;
	
	public Student(Integer id, String name, String gender, Integer age, Integer year) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.year = year;
	}
	public Student(Integer id) {
		this.id = id;
	}

	@Override
	public String getType() {
		return Student.type;
	}

	@Override
	public int getNumber() {
		return this.id;
	}
	
	public void print() {
		System.out.println(Student.type +" "+ this.id.toString() +" "+ this.name +" "+ this.gender +" "+ this.age.toString() +" "+ this.year.toString());
	}
	
}


class Teacher extends BaseStaff{
	private static final String type = "Teacher";
	
	private Integer id;
	private String gender;
	private Integer age;
	private String major;
	
	public Teacher(Integer id, String gender, Integer age, String major) {
		this.id = id;
		this.gender = gender;
		this.age = age;
		this.major = major;
	}
	public Teacher(Integer id) {
		this.id = id;
	}
	
	@Override
	public String getType() {
		return Teacher.type;
	}

	@Override
	public int getNumber() {
		return this.id;
	}
	
	public void print() {
		System.out.println(Teacher.type +" "+ this.id.toString()  +" "+ this.gender +" "+ this.age.toString() +" "+ this.major);
	}

}
