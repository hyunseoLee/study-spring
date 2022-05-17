class MyMath2{

    long a,b; 
    long add1(){ // 인스턴스 메서드
        return a+b;
    }

    public static long add2(long a, long b){ // 클래스메서드 = static 메서드
        return a+b;
    }

}
public class Main_220425 {

    public static void main(String[] args){

        System.out.println(MyMath2.add2(200L, 100L)); // 클래스메서드 호출
        MyMath2 mm= new MyMath2(); // 인스턴스 생성
        mm.a= 200L;
        mm.b= 100L;
        //long a= 200L;
        //long b= 100L;

        System.out.println(mm.add1()); // 인스턴스 메서드 호출 

    }

}

