package hackerrank.advanced;

public class JavaLangDemo {

	public static void main(String[] args) {
//	short s = 2;
//	s = s+5;// compile error, need type cast to int.
//	s+=5; // no issues
 //     System.out.println(s); //output will be 7 
        
		JavaLangDemo obj = new JavaLangDemo();
		obj.print(1);
		obj.print(2L);
		obj.print(3.0F);
		obj.print(4.0);
		obj.print(Integer.valueOf(5));
		obj.print(Long.valueOf(5));
		obj.print(Float.valueOf(5));
		obj.print(Double.valueOf(5));
	}

	void print(Integer num){
		System.out.println("JavaLangDemo.print() Integer:" + num);
	}
	
	void print(int num){
		System.out.println("JavaLangDemo.print() Int:" + num);
	}
	
	void print(Long num){
		System.out.println("JavaLangDemo.print() Long:" + num);
	}
	
	void print(long num){
		System.out.println("JavaLangDemo.print() long:" + num);
	}
	
	void print(Double num){
		System.out.println("JavaLangDemo.print() Double:" + num);
	}
	
	void print(double num){
		System.out.println("JavaLangDemo.print() double:" + num);
	}
	
	void print(Float num){
		System.out.println("JavaLangDemo.print() Float:" + num);
	}
	
	void print(float num){
		System.out.println("JavaLangDemo.print() float:" + num);
	}
}
