# 3주차 반복문 ~ 초기화와 생성자



## 반복문

인간은 반복적인 작업을 싫어한다. 그 일을 컴퓨터가 대신하도록 하는 것이 반복문이다.

반복문이 없다면 똑같은 문장을 1천 번 출력해야 할 때, 똑같은 코드를 1천 번 작성해야한다. 하지만, 반복문을 사용하면 훨씬 적은 코드로 똑같은 동작이 가능하다.

### 반복문의 문법

#### while

while문은 조건이 참인 동안 반복 실행 영역이 반복하여 실행된다.


```JAVA
/* while문의 문법
while(조건){
    반복 실행 영역
}
*/

int i = 0;

while (i < 5) { // while 문의 조건이 참인 동안 계속 실행
    System.out.println("Coding Everybody"+i);
    i++;
}

/* 출력 결과
Coding Everybody 0
Coding Everybody 1
Coding Everybody 2
Coding Everybody 3
Coding Everybody 4
*/
```

#### for

while문을 보면 변수 i값을 초기화하고, while문 안에서 i의 값을 증가시킨다.

이러한 패턴을 문법적인 형태로 만든 것이 for문이다.


```JAVA
/* for문의 문법
for(초기화; 종료조건; 반복실행){
    반복 실행 영역
}
*/

int i = 0;

for (int i = 0; i < 5; i++) { // for 문의 조건이 참인 동안 계속 실행
    System.out.println("Coding Everybody"+i);
}

/* 출력 결과
Coding Everybody 0
Coding Everybody 1
Coding Everybody 2
Coding Everybody 3
Coding Everybody 4
*/
```

### 반복문의 제어

#### break

반복 작업을 중간에 중단시키고자 한다면 break를 사용한다.

```JAVA
for (int i = 0; i < 5; i++) {
    if (i == 3)
        break;
    System.out.println("Coding Everybody " + i);
}

/* 출력 결과
Coding Everybody 0
Coding Everybody 1
Coding Everybody 2
*/

```

#### continue

실행을 즉시 중단하면서 반복은 지속하고 싶다면 continue를 사용한다.

```JAVA
for (int i = 0; i < 5; i++) {
    if (i == 3)
        continue; // continue가 실행되면 for문의 종료조건으로 돌아간다.
    System.out.println("Coding Everybody " + i);
}

/* 출력 결과
Coding Everybody 0
Coding Everybody 1
Coding Everybody 2
Coding Everybody 4
*/
```

### 반복문의 중첩

반복문 안에 다시 반복문이 나타날 수 있다.

```JAVA
 for (int i = 0; i < 3; i++) {
     for (int j = 0; j < 3; j++) {
         System.out.println(i + "" + j);
     }
 }
/* 출력결과
00
01
02
10
11
12
20
21
22
*/
```

## 배열

배열은 연관된 정보를 모아서 관리하기 위해 사용하는 데이터 타입이다.


### 배열의 생성

배열을 생성하고 사용하는 경우 다음과 같이 작성한다.

```java
String[] classGroup = { "최진혁", "최유빈", "한이람" }; // 배열의 생성(String은 데이터의 타입, classGroup은 배열이 담길 변수의 이름)
System.out.println(classGroup[0]);// 최진혁 출력
System.out.println(classGroup[1]);// 최유빈 출력
System.out.println(classGroup[2]);// 한이람 출력
```

배열에 담긴 각각의 데이터를 원소(element)라고 한다.

classGroup[0]은 최진혁이다. 여기서 숫자 0은 원소 최진혁을 식별하는 식별자이다.

이러한 식별자를 인덱스(index)라고 부른다.

배열이 담을 수 있는 원소의 개수를 길이(length)라고 한다.

classGroup의 길이는 3이다. 길이(length)는 배열에 담긴 원소의 숫자가 아니라 배열을 선언할 때 지정한 배열이 담을 수 있는 값의 크기를 의미한다.

```Java
String[] classGroup = new String[3]; // 배열의 생성
classGroup[0] = "최진혁";
System.out.println(classGroup.length); // 3 출력
classGroup[1] = "최유빈";
System.out.println(classGroup.length); // 3 출력
classGroup[2] = "한이람";
System.out.println(classGroup.length); // 3 출력
```

### 배열의 사용


배열의 원소를 사용하기 위해서 반복문을 이용한다.

```JAVA
String[] members = { "최진혁", "최유빈", "한이람" };
for (int i = 0; i < members.length; i++) {
    String member = members[i];
    System.out.println(member + "이 상담을 받았습니다");
}
/* 출력 결과
최진혁이 상담을 받았습니다
최유빈이 상담을 받았습니다
한이람이 상담을 받았습니다
*/
```

배열의 원소를 사용하기 위해 for문을 좀 더 간편하게 사용할 수 있는 방법이 있다.

```Java
String[] members = { "최진혁", "최유빈", "한이람" };
for (String e : members) { // 배열의 값을 차례로 변수 e에 담는다.
    System.out.println(e + "이 상담을 받았습니다");
}
/* 출력 결과
최진혁이 상담을 받았습니다
최유빈이 상담을 받았습니다
한이람이 상담을 받았습니다
*/
```

## 메서드

메서드는 결함이 없고, 유지보수가 쉬운 애플리케이션을 만들기 위한 기법이다. 메서드 없이 프로그램을 만들 수 있지만, 규모있는 애플리케이션을 만드는 것은 현실적으로 어려운 일이다.

### 메서드의 정의와 호출

메서드(method)는 코드를 재사용할 수 있게 해준다. 

> public static void main(String[] args){
>
> }

우리가 이때까지 사용했던 위의 코드가 main이라는 메서드이다. 

직접 메서드를 만드는 것을 정의라고 하고, 만들어진 메서드를 실행하는 것을 호출이라고 한다.

```Java
public class Method 
    public static void numbering() { // 메서드의 정의
        int i = 0;
        while (i < 3) {
            System.out.println(i);
            i++;
        }
    }
 
    public static void main(String[] args) {
        numbering(); // 메서드의 호출: 정의한 코드와 동일한 코드 실행
    }
}
/* 출력 결과
0
1
2
*/
```

### 매개변수와 인자

위의 예제는 0부터 2까지 숫자를 화면에 출력하였다. 만약 필요에 따라서 출력되는 숫자의 범위를 변경하고 싶다면 매개변수와 인자를 사용한다.

```Java
public class Method {
    public static void numbering(int limit) {
        int i = 0;
        while (i < limit) {
            System.out.println(i);
            i++;
        }
    }
 
    public static void main(String[] args) {
        numbering(5);
    }
}
/* 출력 결과
0
1
2
3
4
*/
```

위 코드의 실행 결과는 0부터 4까지 출력한다. numbering의 괄호 안의 숫자 5는 메서드가 호출될 때 limit이라는 변수의 값이 된다. 이 값은 메서드 numbering의 중괄호 안에서만 사용할 수 있다. 그림으로 표현하면 다음과 같다.

![img](https://s3.ap-northeast-2.amazonaws.com/opentutorials-user-file/module/516/1838.gif)

여기서 limit이라는 변수는 메서드 numbering의 정의 부에 있는 로직들에게 5라는 값을 전달하고 있다. 호출에서 입력한 값을 로직으로 매개한다는 의미에서 이러한 변수를 매개변수(parameter)라고 부른다. 그리고 메서드를 호출할 때 전달된 값인 5를 인자(argument)라고 한다.



복수의 인자를 사용하여 메서드를 호출할 수도 있다.

```Java
public class Method {
 
    public static void numbering(int init, int limit) {
        int i = init;
        while (i < limit) {
            System.out.println(i);
            i++;
        }
    }
 
    public static void main(String[] args) {
        numbering(1, 5);
    }
}
/* 출력 결과
1
2
3
4
*/
```

### return

위의 예제는 화면에 숫자를 출력한다. 출력이 아닌 원하는 용도로 사용하고 싶을 때 return을 이용한다. return은 메서드를 중단시키고 값을 반환하는 동작을 한다.

```Java
public class Return {
    public static int numbering(int init, int limit) {
        int i = init;
        int output = 0;
        while (i <= limit) {
            output += i;// i의 합을 구함
            i++;
        }
        return output; // output에 담겨 있는 숫자를 메서드 외부로 반환하려면 아래와 같이 return 키워드 뒤에 반환하려는 값을 배치하면 된다.
    }

    public static void main(String[] args) {
        int result = numbering(1, 5); // 메서드 numbering이 반환한 값이 변수 result에 담긴다.
        System.out.println("1부터 5까지의 합은: "+result);
    }
}
/* 출력 결과
1부터 4까지의 합은: 15
*/
```

배열을 반환하여 여러 개의 데이터를 처리할 수도 있다.

```Java
public class Return {
 
    public static String[] getMembers() {
        String[] members = { "최진혁", "최유빈", "한이람" };
        return members; // members 배열 반환
    }

    public static void main(String[] args) {
        String[] member2 = getMembers(); // 반환된 배열을 members 배열에 대입
        System.out.println(member2[1]); // 최유빈 출력
    }
}
```

## 입력과 출력

위에서 메서드에서의 입력과 출력에 대해서 알아보았다. 그럼 자바 애플리케이션에서의 입력과 출력을 알아보자.

### String[] args

main 메서드는 자바에서 특별한 의미를 가진 메서드이다. 

자바 애플리케이션을 실행할 때 main 메서드가 호출되면서 프로그램이 구동하게 되는 것이다. 

이 때, String[] args는 입력 값의 매개변수로 동작한다. 매개변수는 호출될 떄 전달된 입력 값을 메서드 내부로 전달하는 역할을 하는 변수다. 

이 변수의 데이터형은 String[]이고, args.length는 배열의 길이를 의미한다.

이를 기억하고, 아래의 코드를 실행해보자.

```java
class Input{
    public static void main(String[] args){
            System.out.println(args.length);
    }
}
```

> javac Input.java

> java Input 1 2 3 4

javac 명령어는 .java 파일을 .class 파일로 만들어준다.(Input.java > Input.clss)

실행 결과는 4가 나온다. 이를 통해서 자바 애플리케이션 실행 명령인 java Input 뒤에 따라오는 값의 숫자 만큼 변수 args에 값이 들어간다는 것을 알 수 있다.

### 실행 중에 입력 받기

이번에는 자바 애플리케이션이  실행되고 있는 동안에 사용자의 입력을 받는 법을 알아보자. 자바에서 기본적으로 제공하는 라이브러리 중에 scanner을 이용하면 쉽게 사용자의 입력을 받을 수 있다.


```JAVA
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextInt()) {
        System.out.println(sc.nextInt()*1000); 
    }
    sc.close();
}
```

sc.hasNextInt()는 입력값이 생기기 전까지 실행을 유보시키는 역할을 한다. 만약 입력한 값이 int형이 아닐 경우에는 false를 리턴하고, int로 표현할 수 있는 형식의 숫자형인 경우는 true를 리턴한다.

## 클래스와 객체 그리고 인스턴스

### 클래스

클래스는 객체를 만들어내기 위한 설계도 혹은 틀이다. 연관되어 있는 변수와 메서드의 집합이다.

### 객체

객체는 소프트웨어 세계에 구현할 대상이다. 클래스에 선언된 모양 그대로 생성된 실체이다. 클래스의 인스턴스 라고 부른다. 객체는 모든 인스턴스를 대표하는 포괄적인 의미를 갖는다.

### 인스턴스

인스턴스는 설계도를 바탕으로 소프트웨어 세계에 구현된 구체적인 실체이다. 즉, 객체를 소프트웨어에 실체화하면 그것을 인스턴스라고 부른다. 실체화된 인스턴스는 메모리에 할당된다. 인스턴스는 객체에 포함된다고 볼 수 있다.

#### 클래스 vs 객체

클래스는 설계도 객체는 설계도로 구현한 모든 대상을 의미한다.

#### 객체 vs 인스턴스

클래스의 타입으로 선언되었을 때 객체라고 부르고, 그 객체가 메모리에 할당되어 실제 사용될 때 인스턴스라고 부른다.

```Java
/* 클래스 */
public class Animal {
  ...
}
/* 객체와 인스턴스 */
public class Main {
  public static void main(String[] args) {
    Animal cat, dog; // cat과 dog은 '객체'

    cat = new Animal(); // cat은 Animal 클래스의 '인스턴스'(객체를 메모리에 할당)
    dog = new Animal(); // dog은 Animal 클래스의 '인스턴스'(객체를 메모리에 할당)
  }
}
```

## 클래스 멤버와 인스턴스 멤버

### 멤버

멤버(member)는 영어로 구성우너이라는 뜻이다. 객체도 구성원이 있는데 아래와 같다.

- 변수
- 메서드

객체를 만들기 위해 클래스를 정의하고, 클래스에 대한 인스턴스를 만들었다.

```Java
class Calculator2 {
    static double PI = 3.14; // static을 멤버 앞에 붙이면 클래스의 멤버가 된다.
    static int base = 0; // 클래스 변수
    int left, right;
 
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void sum() {
        System.out.println(this.left + this.right + base);
    }
 
    public void avg() {
        System.out.println((this.left + this.right + base) / 2);
    }
}
 
public class CalculatorDemo2 {
 
    public static void main(String[] args) {
 
        Calculator2 c1 = new Calculator2();
        c1.setOprands(10, 20);
        c1.sum(); // 30 출력
 
        Calculator2 c2 = new Calculator2();
        c2.setOprands(20, 40);
        c2.sum(); // 60 출력
 
        Calculator2.base = 10; // 클래스 변수 base의 값을 10으로 지정했다.
 
        c1.sum(); // 40 출력
        c2.sum(); // 70 출력
    }
}
```

### 클래스 메서드

클래스 변수가 있다면 클래스 메서드도 있다. 위의 예제에서 굳이 인스턴스가 left와 right값을 항상 유지하고 있어야할 이유가 없다. 합계나 평균을 구할 때마다 좌항과 우항의 값을 주는 방식으로 계산을 할 수도 있다.

```Java
class Calculator3{
    public static void sum(int left, int right){ // 클래스 메서드
        System.out.println(left+right);
    } 
    public static void avg(int left, int right){ // 클래스 메서드
        System.out.println((left+right)/2);
    }
}
 
public class CalculatorDemo3 {
     
    public static void main(String[] args) {
        Calculator3.sum(10, 20); // 30 출력
        Calculator3.avg(10, 20); // 15 출력
         
        Calculator3.sum(20, 40); // 60 출력
        Calculator3.avg(20, 40); // 30 출력
    }
}
```

만약 메서드가 인스턴스 변수를 참조하지 않는다면 클래스 메서드를 사용하여 불필요한 인스턴스의 생성을 막을 수 있다.

- 인스턴스 메서드는 클래스 맴버에 접근 할 수 있다.

- 클래스 메서드는 인스턴스 맴버에 접근 할 수 없다.

  인스턴스 변수는 인스턴스가 만들어지면서 생성되는데, 클래스 메서드는 인스턴스가 생성되기 전에 만들어지기 때문에 클래스 메서드가 인스턴스 맴버에 접근하는 것은 존재하지 않는 인스턴스 변수에 접근하는 것과 같다.

## 유효범위

프로그램이 커지면 여러가지 이유로 이름이 중복하여 사용된다. 이를 해결하기 위해 유효범위(Scope)라는 개념이 생겼다.

```Java
static void a() {
    int i = 0;
}
public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
        a();
        System.out.println(i);
    }
}
/* 출력 결과
0
1
2
3
4
*/
```

위의 코드가 실행될 때, 메서드 a의 변수 i 값이 반복문의 변수 i 값을 덮어쓰게 된다면 반복문이 실행될 때마다 변수 i의 값이 0이 되기 때문에 무한 반복이 될 것이다. 

하지만, 실행결과를 보면 메서드 내의 변수가 외부의 변수에 영향을 미치지 않는다.

```Java
static int i;    
static void a() {
    i = 0;
}
public static void main(String[] args) {
    for (i = 0; i < 5; i++) {
        a();
        System.out.println(i);
    }
}
/* 출력 결과
0
0
0
...
*/
```

위의 코드에서 변수 i는 어떠한 메서드의 소속도 아닌 클래스 변수다.

클래스 소속의 변수가 되면 모든 메서드에 접근할 수 있다. 

따라서, 반복문을 통해 변수 i값을 아무리 바꾸어도 메서드 a에 의해 i의 값이 0이 되기 때문에 반복문은 멈추지 않고 계속해서 0을 출력한다.

이를 해결하기 위해,  a 메서드를 다음과 같이 변경한다.

```java
static void a(){
    int i = 0;
}
```

a 메서드에서 선언한 변수는 메서드가 실행될 때 만들어지고, 메서드가 종료되면 삭제된다.

만약 클래스 변수와 메서드 변수가 같은 이름을 가진다면 메서드 변수가 우선이다.

클래스 전역에서 접근할 수 있는 변수를 **전역변수**, 메서드 내에서만 접근할 수 있는 변수를 **지역변수**라고 한다.    



인스턴스에서의 유효범위도 클래스와 거의 동일하지만 차이점은 this를 사용하는 것이다.

```java
class C3 {
    int v = 10;

    void m() {
        int v = 20;
        System.out.println(this.v);
    }
}
public class HelloWorldMain {
    public static void main(String[] args) {
        C3 c1 = new C3();
        c1.m();
    }
}
/* 출력 결과
10
*/
```

위의 코드 실행 결과는 10이다. this는 인스턴스 자신을 의미하는 키워드이다. 따라서, 메서드 변수 v가 아닌 인스턴스 변수 v가 사용된 것이다.

## 생성자

```java {line-numbers}
class Calculator {
    int left, right;
 
    public Calculator(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void sum() {
        System.out.println(this.left + this.right);
    }
 
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}
 
public class CalculatorDemo1 {
 
    public static void main(String[] args) {
 
        Calculator c1 = new Calculator(10, 20);
        c1.sum();
        c1.avg();
 
        Calculator c2 = new Calculator(20, 40);
        c2.sum();
        c2.avg();
    }
 
}
```

4행에 나오는 클래스와 동일한 이름을 가지는 메서드를 생성자라 한다. 생성자는 인스턴스가 생성될 때 변수의 값을 입력하도록 강제한다.

생성자의 특징은 다음과 같다.

- 값을 반환하지 않는다

  생성자는 인스턴스를 생성해주는 역할을 하는 특수한 메서드라고 할 수 있다. 그런데 반환 값이 있다면 엉뚱한 객체가 생성될 것이다. 따라서 반환 값을 필요로하는 작업에서는 생성자를 사용하지 않는다. 반환 값이 없기 때문에 return도 사용하지 않고, 반환 값을 메소드 정의에 포함시키지도 않는다.

- 생성자의 이름은 클래스의 이름과 동일하다.

  자바에서 클래스의 이름과 동일한 메서드는 생성자로 사용한다고 약속되어 있다.











