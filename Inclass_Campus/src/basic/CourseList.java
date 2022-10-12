package basic;

public class CourseList {
	final int MAX = 100;
	private final Course[] list;
	private int count;

	public CourseList() {
		list = new Course[MAX];
		count = 0;
	}

	public boolean addCourse(Course c) {
		if (count < MAX) {
			list[count] = c;
			count++;
			return true;
		}
		return false;
	}

	public int findCourseIndex(int code) {
		for (int i = 0; i < count; i++) {
            if (list[i].getCode() == code) {
                return i;
            }
		}
		return -1;
	}

	public Course findCourse(int code) {
		for (int i = 0; i < count; i++) {
            if (list[i].getCode() == code) {
                return list[i];
            }
		}
		return null;
	}

	public boolean updateCourse(int code) {
		Course rs = findCourse(code);
		if (rs != null) {
			rs.setName("...");
			return true;
		}
		return false;
	}

	public boolean removeCourse(int code) {
		int rs = findCourseIndex(code);
        if (rs == -1) {
            return false;
        }
		for (int j = rs; j < count; j++) {
			list[j] = list[j++];
		}
		count--;
		return true;
	}

	public void displayCourse() {
		System.out.println("Course list");
		for (int i = 0; i < count; i++) {
			list[i].outputCourse();
		}
	}
}