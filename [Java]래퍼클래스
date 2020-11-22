## [Java] 래퍼 클래스(Wrapper Class)

자바의 자료형은 크게 기본형(privitive type), 참조형(reference type)으로 나누어진다.

대표적으로 기본형은 char, int, float, boolean 등이 있고 참조형은 class, interface 등이 있다. 

프로그래밍을 하다 보면 기본형의 데이터를 객체로 표현해야 하는 경우가 있다. 

이럴 때에 **기본형을 객체로 다루기 위해서 사용하는 클래스들을 래퍼클래스(wrapper class)**라고 한다.

자바의 모든 기본형은 값을 갖는 객체를 생성할 수 있다. 

이런 객체를 포장 객체라고 하는데 그 이유는 기본형의 값을 내부에 두고 포장하기 때문이다.

래퍼 클래스로 감싸고 있는 기본형의 값은 외부에서 변경할 수 없다.

값을 변경하기 위해서는 새로운 포장 객체를 만들어야 한다.

#### 래퍼 클래스의 종류

| 기본형  | 래퍼클래스 |
| ------- | ---------- |
| byte    | Byte       |
| char    | Charcter   |
| int     | Integer    |
| float   | Float      |
| double  | Double     |
| boolean | Boolean    |
| long    | Long       |
| short   | Short      |

래퍼 클래스는 java.lang 패키지에 포함되어 있다.

char형과 int형은 각각 Character와 Integer의 래퍼클래스를 가지고 있고, 나머지는 기본형의 첫 글자를 대문자로 바꾼 이름이다.

#### 래퍼 클래스 구조도

모든 래퍼 클래스의 부모는 Object이고, 숫자를 다루는 래퍼 클래스의 부모는 Number 클래스이다. 모든 래퍼 클래스는 최종 클래스로 정의된다.

![img](https://blog.kakaocdn.net/dn/bvzp79/btqEbacB01v/QQjO7cSc9tTvKJkyzFsK90/img.png)

[그림출처][https://coding-factory.tistory.com/547]

#### 박싱( Boxing)과 언박싱(UnBoxing)

기본형의 값을 포장 객체로 만드는 과정을 박싱이라고 하고 반대로 포장 객체에서 기본형의 값을 얻는 과정을 언박싱이라 한다.

![img](https://blog.kakaocdn.net/dn/38MsL/btqEbRcxIfZ/fOMbL4b3wCzqeO1aKKbFZ0/img.png)

[그림출처][https://coding-factory.tistory.com/547]

박싱과 언박싱을 코드로 표현하면 다음과 같다.

```Java
public class Wrapper {
    public static void main(String[] args)  {
        Integer num = new Integer(5); // 박싱
        int n = num.intValue(); //언박싱
        System.out.println(n);
    }
}
```

#### 자동 박싱(AutoBoxing)과 자동 언박싱(AutoUnBoxing)

기본형의 값을 직접 박싱, 언박싱하지 않아도 자동적으로 박싱과 언박싱이 일어나는 경우가 있다.

자동 박싱의 포장 클래스 타입에 기본값이 대입될 경우에 발생한다.

예를 들어, int형의 값을 Integer클래스 변수에 대입하면 자동 박싱이 일어나 힙 영역에 Integer 객체가 생성된다.

```java
public class Wrapper {
    public static void main(String[] args)  {
        Integer num = 17; // 자동 박싱
        int n = num; //자동 언박싱
        System.out.println(n);
    }
}
```

### 예제

#### 문자열을 기본형 값으로 변환

```java
public class Wrapper {
    public static void main(String[] args)  {
        String str = "1";
        String str2 = "1.5";
        String str3 = "true";
        
        byte b = Byte.parseByte(str);
        int i = Integer.parseInt(str);
        short s = Short.parseShort(str);
        long l = Long.parseLong(str);
        float f = Float.parseFloat(str2);
        double d = Double.parseDouble(str2);
        boolean bool = Boolean.parseBoolean(str3);
		
        System.out.println("문자열 byte값 변환 : "+b);
        System.out.println("문자열 int값 변환 : "+i);
        System.out.println("문자열 short값 변환 : "+s);
        System.out.println("문자열 long값 변환 : "+l);
        System.out.println("문자열 float값 변환 : "+f);
        System.out.println("문자열 double값 변환 : "+d);
        System.out.println("문자열 boolean값 변환 : "+bool);
    }
}
/* 출력 결과
문자열 byte값 변환 : 1
문자열 int값 변환 : 1
문자열 short값 변환 : 1
문자열 long값 변환 : 1
문자열 float값 변환 : 1.5
문자열 double값 변환 : 1.5
문자열 boolean값 변환 : true

*/
```

래퍼 클래스의 주 용도는 기본형의 값을 박싱해서 포장 객체로 만드는 것이지만, 문자열을 기본 타입의 값으로 변환할 때도 사용된다. 

### 값 비교

````java
public class Wrapper {
    public static void main(String[] args)  {
        Integer num = new Integer(10); //래퍼 클래스1
        Integer num2 = new Integer(10); //래퍼 클래스2
        int i = 10; //기본타입
		 
        System.out.println("래퍼클래스 == 기본타입 : "+(num == i)); // true
        System.out.println("래퍼클래스.equals(기본타입) : "+num.equals(i)); // true
        System.out.println("래퍼클래스 == 래퍼클래스 : "+(num == num2)); // false
        System.out.println("래퍼클래스.equals(래퍼클래스) : "+num.equals(num2)); // true
    }
}
````

래퍼 객체는 내부의 값을 비교하기 위해 == 연산자를 사용할 수 없다. 이는 내부의 값이 아닌 래퍼 객체의 참조 주소를 비교하기 때문이다.

객체끼리의 비교는 equals 메서드를 사용해야한다. 래퍼 클래스와 기본형의 비교는 == 연산과 equals 연산 모두 가능하다. 그 이유는 컴파일러가 자동박싱과 자동언박싱을 해주기 때문이다.

