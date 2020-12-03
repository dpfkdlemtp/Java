# 자바 리플렉션(Java Reflection)



### 리플렉션

자바에서 제공하는 리플렉션은 C, C++과 같은 언어를 비롯한 다른 언어에서는 볼 수 없는 기능이다. 

이미 로딩이 완료된 클래스에서 또 다른 클래스를 동적으로 로딩하여 생성자, 멤버 필드 그리고 멤버 메소드 등을 사용할 수 있도록 한다.

다시 말하면, 컴파일 시간이 아닌 실행 시간에 동적으로 특정 클래스의 정보를 객체화로 분석 및 추출해낼 수 있는 프로그래밍 기법이다.



### 리플렉션 사용

동적으로 클래스를 사용해야할 때 필요하다. 

작성 시점에서는 어떤 클래스를 사용할지 모르는 경우, 런타임 시점에서 클래스를 가져와서 실행해야 하는 경우에 사용한다.

자바 클래스 파일은 프로그램 생성 시에 힙 영역에 저장된다.

따라서, 클래스 이름만 알고있다면 언제든 이 영역에 들어가서 클래스의 정보를 가져올 수 있다.



### 리플렉션 예제

Object.getClass() 메소드를 통해 클래스의 정보를 로드한다.

```java
    //임의의 클래스
    Class c = "foo".getClass();
    System.out.println(c);      //class java.lang.String 출력

    //Array는 객체이므로 Array 인스턴스에서 클래스 정보를 로드할 수 있습니다.
    byte[] b = new byte[1024];
    Class c1 = b.getClass();
    System.out.println(c1);     //class [B 출력

    Integer[] i = new Integer[3];
    Class c2 = i.getClass();
    System.out.println(c1);		//class [Ljava.lang.Integer; 출력

    Set<String> s = new HashSet<>();
    Class c3 = s.getClass();
    System.out.println(c2);     //class java.util.HashSet 출력
```



.class 문법을 사용한다.

```java
    byte b = 0;
    //Class c3 = b.getClass();
    //System.out.println(c3);

    Class c4 = boolean.class.getClass();
    System.out.println(c4);     //class java.lang.Class 출력

    Class c5 = java.io.PrintStream.class;
    System.out.println(c5);     //class java.io.PrintStream

    Class c6 = int[][].class;
    System.out.println(c6);     //class [[I
```

byte형과 같은 원시 유형은 b.getClass()를 사용하면 컴파일 에러가 발생한다.

변수 c5는 java.io 유형에 해당하는 PrintStream이 된다.

다차원 배열도 .class 구문을 사용할 수 있다.



TYPE Field를 통해 원시형 클래스를 반환할 수 있다.

```java
    Class c8 = Double.TYPE;
    Class c9 = Void.TYPE;
    System.out.println(c8);     //double 출력
    System.out.println(c9);     //void 출력
```



Class.forName() 문법을  사용한다.

```java
    try {
            Class c7 = Class.forName("hello.bb");// 패키지 명으로 클래스를 로드할 수 있습니다.
            Class doubleArray = Class.forName("[D");    //class [D
            Class stringArray = Class.forName("[[Ljava.lang.String;");  //class [[Ljava.lang.String;
            System.out.println(c7); // class hello.bb 출력
            System.out.println(doubleArray); //class [D 출력
            System.out.println(stringArray); //class [[Ljava.lang.String; 출력
        }catch(ClassNotFoundException e1){ //클래스를 찾지못했을 경우에 대한 예외사항
            System.out.println("클래스가 존재하지 않습니다.");
        }
```

변수 doubleArray는 double형 배열의 클래스를 로드한 것과 같고, 변수 stringArray는 2차원 문자열 배열의 클래스를 로드한 것과 같다.



c가 bb의 인스턴스인지 확인하는 예제이다.

```java
import hello.bb;

class aa {
    public static void main(String args[]) {
        try{
            Class c = Class.forName("hello.bb");
            boolean b = c.isInstance(new Integer(22));
            System.out.println(b);  //false
            boolean b1 = c.isInstance(new bb());
            System.out.println(b1); //true
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
```



Method를 활용한 클래스 반환 방법.

- class.getSuperClass() : 슈퍼 클래스를 반환한다.
- class.getClass() : 상속된 클래스를 포함하여 모든 공용 클래스, 인터페이스 및 열거형을 반환한다.
- class.getDeclaredClass() : 명시적으로 선언된 모든 클래스 및 인터페이스, 열거형을 반환한다.
- class.getDeclaringClass() : 클래스에 구성된 클래스(명시적으로 선언된)를 반환한다.
- class.getEnclosingClass() : 클래스의 즉시 동봉된 클래스를 반환한다.





클래스와 클래스의 메소드 정보를 로드한다.

```java
import java.lang.reflect.Method;

class aa {
    public int sum(int a, int b) throws NoSuchFieldException{
        return a+b;
    }

    public static void main(String[] args) {
        try{
            Class c = Class.forName("aa");

            Method[] m = c.getDeclaredMethods();
            for(int i=0; i<m.length; i++){
                Method m1 = m[i];
                System.out.println("name: " + m1.getName());
                System.out.println("declare Class: " + m1.getDeclaringClass());

                Class[] gpt = m1.getParameterTypes();

                for(int j=0; j<gpt.length; j++){
                    System.out.println("Param: " + gpt[i]);
                }

                Class[] ept = m1.getExceptionTypes();

                for(int z=0; z<ept.length; z++){
                    System.out.println("Exception: " + ept[z]);
                }

                System.out.println("ReturnType: " + m1.getReturnType());
            }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

/* 출력 결과
name: main
declare Class: class aa
Param: class [Ljava.lang.String;
ReturnType: void
name: sum
declare Class: class aa
Param: int
Param: int
Exception: class java.lang.NoSuchFieldException
ReturnType: int
*/
```



생성자에 대한 정보를 로드한다.

```java
import java.lang.reflect.Constructor;

public class aa {
    public aa(){

    }

    protected aa(String s, int b){

    }

    public static void main(String[] args) {
        try{
            Class c = Class.forName("aa");

            Constructor[] cs = c.getDeclaredConstructors(); //선언된 생성자의 정보를 받아온다.

            for(int i=0; i<cs.length; i++){
                Constructor c1 = cs[i];
                System.out.println("name: " + c1.getName());
                System.out.println("declare Class: " + c1.getDeclaringClass());

                Class[] gpt = c1.getParameterTypes();

                for(int j=0; j<gpt.length; j++){
                    System.out.println("Param: " + gpt[j]);
                }
            }

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
/* 출력 결과
name: aa
declare Class: class aa
name: aa
declare Class: class aa
Param: class java.lang.String
Param: int
*/
```



클래스의 필드에 대한 정보를 로드한다.

```java
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class aa {
    private double b;
    public static final int a = 7;
    String s = "Hi";

    public static void main(String[] args) {
        try{
            Class c = Class.forName("aa");
            Field[] f = c.getDeclaredFields();

            for(int i=0; i<f.length; i++){
                Field f1 = f[i];
                System.out.println("name: " + f1.getName());
                System.out.println("declare Class: " + f1.getDeclaringClass());
                System.out.println("type: " + f1.getType());
                int mod = f1.getModifiers();
                System.out.println("modifiers: " + Modifier.toString(mod));
            }

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
/* 출력 결과
name: b
declare Class: class aa
type: double
modifiers: private
name: a
declare Class: class aa
type: int
modifiers: public static final
name: s
declare Class: class aa
type: class java.lang.String
modifiers: 
*/
```



필드의 값을 변경한다.

```java
import java.lang.reflect.Field;

public class aa {
    public int num = 5;

    public static void main(String[] args) {
        try{
            Class c = Class.forName("aa");
            Field f = c.getField("num");
            aa demo = new aa();
            System.out.println("num: " + demo.num);
            f.setInt(demo, 7);
            System.out.println("num: " + demo.num);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (NoSuchFieldException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
/* 출력 결과
num: 5
num: 7
*/
```

