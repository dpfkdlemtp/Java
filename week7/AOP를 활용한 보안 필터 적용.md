## AOP를 활용한 보안 필터 적용



### AOP

AOP는 Aspect Oriented Programming의 약자로 관점 지향 프로그래밍이라고 불린다. 관점 지향을 쉽게 말하면 어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 보고 그 관점을 기준으로 각각 모듈화하는 것이다. 모듈화는 공통된 로직이나 기능을 하나의 단위로 묶는 것을 말한다.

 

AOP에서 각 관점을 기준으로 로직을 모듈화하는 것은 코드를 부분적으로 나누어서 모듈화하겠다는 의미이다. 이때, 소스 코드상에서 다른 부분에 계속 반복해서 쓰는 코드들을 발견할 수 있는데 이를 흩어진 관심사(Crosscutting Concerns)라 부른다.

![aop1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/aop1.png?raw=true)

위와 같이 흩어진 관심사를 Aspect로 모듈화하고 핵심적인 비즈니스 로직에서 분리하여 재사용 하는 것이 AOP의 목적이다.



#### AOP 주요 개념

·  Aspect : 위에서 설명한 흩어진 관심사를 모듈화 한 것, 주로 부가기능을 모듈화

·  Target : Aspect를 적용하는 곳 (클래스, 메서드 .. )

·  Advice : 실질적으로 어떤 일을 해야할 지에 대한 것, 실질적인 부가기능을 담은 구현체

·  JointPoint : Advice가 적용될 위치, 끼어들 수 있는 지점. 메서드 진입 지점, 생성자 호출 시점, 필드에서 값을 꺼내올 때 등 다양한 시점에 적용가능

·  PointCut : JointPoint의 상세한 스펙을 정의한 것. 'A란 메서드의 진입 시점에 호출할 것'과 같이 더욱 구체적으로 Advice가 실행될 지점을 정할 수 있음



#### 스프링 AOP 특징

- 프록시 패턴 기반의 AOP 구현체, 프록시 객체를 쓰는 이유는 접근 제어 및 부가기능을 추가하기 위해서이다.
- 스프링 빈에만 AOP를 적용 가능하다.
- 모든 AOP 기능을 제공하는 것이 아닌 스프링 IoC와 연동하여 엔터프라이즈 애플리케이션에서 가장 흔한 문제(중복코드, 프록시 클래스 작성의 번거로움, 객체들 간 관계 복잡도 증가 ...)에 대한 해결책을 지원하는 것이 목적이다.



#### Aspect 실행 시점 지정 어노테이션

- @Before (이전) : 어드바이스 타겟 메소드가 호출되기 전에 어드바이스 기능을 수행
- @After (이후) : 타겟 메소드의 결과에 관계없이(즉 성공, 예외 관계없이) 타겟 메소드가 완료 되면 어드바이스 기능을 수행
- @AfterReturning (정상적 반환 이후)타겟 메소드가 성공적으로 결과값을 반환 후에 어드바이스 기능을 수행
- @AfterThrowing (예외 발생 이후) : 타겟 메소드가 수행 중 예외를 던지게 되면 어드바이스 기능을 수행
- @Around (메소드 실행 전후) : 어드바이스가 타겟 메소드를 감싸서 타겟 메소드 호출전과 후에 어드바이스 기능을 수행


 

AOP를 적용하기 위한 예제는 Maven으로 작성된 Spring 오픈소스코드이다.

https://github.com/spring-projects/spring-petclinic에서 받을 수 있다. URL을 복사하고, 

![aop2.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/aop2.png?raw=true)

 

IntelliJ – VCS – Get from Version Control에서 복사한 URL을 입력한다.

![aop3.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/aop3.png?raw=true)

![aop4.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/aop4.png?raw=true)

 

그 후, Terminal에서 프로젝트를 빌드하기 위해 mvnw package 명령어를 입력한다.

![aop5.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/aop5.png?raw=true)

 

BUILD SUCCESS가 나오면, 완료된 것이다.

![aop6.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/aop6.png?raw=true)

 

Main – java – PetClinicApplication 을 실행한다.

![aop7.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/aop7.png?raw=true)

 

실행한 애플리케이션을 웹 페이지로 접속하면, 다음과 같다.

![1.PNG](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/1.PNG?raw=true)



 

 

먼저, 메소드 처리 시간을 측정하는 예제이다. /owners/find에 GET 요청이 들어왔을 때, 실행되는 메소드의 위 아래로 @LogExecutionTime 어노테이션을 추가한다.

![2.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/2.png?raw=true)

 

그 다음, LogExecutionTime 어노테이션을 만들어준다.

![3.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/3.png?raw=true)



그 다음, LogAspect 클래스를 만들어서 Around 어노테이션을 통해 LogExecutionTime 어노테이션 안의 메소드의 처리 시간을 측정한다.

![4.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/4.png?raw=true)

 

애플리케이션을 실행하고, owners/find에 GET 요청을 보낸다.

![5.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/5.png?raw=true)



 

그러면, 다음과 같이 처리 시간이 측정된다.

![6.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/6.png?raw=true)

 

이제, AOP를 이용하여 SQL Injection과 XSS에 대한 보안 필터를 적용해보자.

 

#### SQL Injection

SQL 인젝션은 코드 인젝션의 한 기법으로 클라이언트의 입력 값을 조작하여 서버의 데이터베이스를 공격할 수 있는 공격방식을 말한다. 주로 사용자가 입력한 데이터를 제대로 필터링, 이스케이핑하지 못했을 경우에 발생한다.

Ex) SELECT user FROM user_table WHERE id='admin' AND password=' <span style="color:red">**' OR '1' = '1**</';

 

#### XSS

SQL 인젝션과 함께 웹 상에서 가장 기초적인 취약점 공격 방법의 일종으로, 악의적인 사용자가 공격하려는 사이트에 스크립트를 넣는 기법을 말한다. 공격에 성공하면 사이트에 접속한 사용자는 삽입된 코드를 실행하게 되며, 보통 의도치 않은 행동을 수행시키거나 쿠키나 세션 토큰 등의 민감한 정보를 탈취한다.

Ex) <script>alert('XSS');</script>

 

애플리케이션에 주인의 Last Name을 입력하면, 해당 주인의 정보를 알려주는 메소드가 있다.

![7.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/7.png?raw=true)



해당 부분에 CheckInput 어노테이션을 추가한다.

![8.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/8.png?raw=true)



CheckInput 어노테이션을 만들어준다.

![9.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/9.png?raw=true)



그 다음, InputAspect를 만들어서 @Before 어노테이션을 통해 메소드 실행 전에 입력 값을 확인한다. 블랙리스트에 있는 입력 값이 확인되면, No!가 출력된다.

![10.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/10.png?raw=true)



 애플리케이션을 실행하고, 작성한 코드가 잘 작동하는지 확인한다.

Last name에 <script>를 넣는다.

 

![11.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/11.png?raw=true)



입력 값과 No!가 출력된다. 

![12.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/12.png?raw=true)



이번엔, 'or 1=1 #을 입력한다. 

![13.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/13.png?raw=true)



입력 값과 No!가 출력된다. 

![14.png](https://github.com/dpfkdlemtp/JavaStudy/blob/dpfkdlemtp-aop/14.png?raw=true)

 
