package hackerrank.advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arbind Negi 27-Mar-2022
 *
 */
public class UsersSort {

    public static void main(String [] args) {
	List<User> users = Arrays.asList(
	            new User("Arbind Negi", 35),
	            new User("Reyaansh Negi", 04),
	            new User("Negi Arbind", 40),
	            new User("Shalini", 30),
		    new User("Rudra", 03));
	/**
	 * User List sorted by Name
	 */
	System.out.println("----------Sorting by Name----------");
	List<User> userSortedList = users.stream()
		                         .sorted(Comparator.comparing(User::getName))
		                         .collect(Collectors.toList());
	
	userSortedList.forEach(System.out::println);
	
	/**
	 * User List sorted by Age
	 */
	System.out.println("----------Sorting by Age----------");
	List<User> userListSortedByAge = users.stream()
		                              .sorted(Comparator.comparingInt(User::getAge)
		                              .reversed())
		                              .collect(Collectors.toList());
	userListSortedByAge.forEach(System.out::println);
    }
    
    
    static class User {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    
}
