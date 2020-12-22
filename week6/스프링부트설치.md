## 스프링 부트 프로젝트 만들기 (Spring Intializr)

스프링 부트 프로젝트 만드는 방법 중에 Spring에서 제공하는 Spring Intializr 웹 도구를 사용하는 간편한 방법이 있다.

먼저, https://start.spring.io/에 접속한다.

위 주소로 접속하면, 다음과 같은 화면이 보인다.

![js1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/js1.png?raw=true)

선택해야 하는 옵션은 다음과 같다.

- **Project: 사용할 빌드 툴 선택 (Maven/Gradle)**

Maven, Gradle은 프로젝트에 필요한 의존성을 관리하고 빌드 라이프사이클을 관리해주는 툴이다. 과거에는 Maven을, 최근에는 Gradle을 사용하는 추세이다. 스프링 라이브러리 관리 자체도 최근에는 Gradle로 하고 있다.

- **Language: 언어 선택**
- **Spring Boot: 버전 선택**

SNAPSHOT이 붙은 것은 현재 개발중인 버전, M(Minor)은 정식 릴리즈되지 않은 버전이고 아무것도 붙어있지 않은 것이 정식 릴리즈된 버전이다. 따라서 정식 릴리즈된 버전 중 가장 최신 버전을 선택하는 것이 좋다.

- **Project Metadata: Group, Artifact 입력**

보통 Group은 기업의 도메인명을 적는다. 개인 프로젝트라면 자유롭게 작성하면 된다.

Artifact는 빌드 결과물 이름을 의미한다.

- **Dependency: 라이브러리 추가 **

마지막으로 필요한 Dependency를 검색하여 추가한다. 스프링 프로젝트에 사용할 라이브러리를 추가하는 단계이다. Web 프로젝트를 만들려면 Spring Web을 추가해야 한다.



설정이 끝나면, Generate를 클릭하여 zip파일을 다운로드한다.

zip 파일의 압축을 해제하고, IntelliJ로 Open한다.

![js1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/js2.png?raw=true)



스프링 부트 프로젝트에 필요한 의존성과 플러그인이 자동으로 import한다.

![js1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/js3.png?raw=true)



## 스프링 부트 프로젝트 실행하기(Gradle)

이제 만든 스프링 부트 프로젝트를 실행해보자.

Gradle 프로젝트는 Gradle을 통해서가 아닌 IntelliJ로 자바를 실행하도록 설정을 변경하면 프로젝트를 더 빨리 띄울 수 있다.

![js1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/js4.png?raw=true)



@SpringBootApplication이 있는 DemoApplication 파일로 들어가서 실행한다.

![js1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/js5.png?raw=true)



콘솔 로그에 톰캣이 8080포트로 구동되었다는 것을 확인할 수 있다.

![js1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/js6.png?raw=true)



src/main/resources/static 경로에 index.html 문서를 작성하고, localhost:8080으로 접속한다.

![js1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/js7.png?raw=true)

접속하면, Hello World!가 출력된다.

![js1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/js8.png?raw=true)



## 스프링 부트 API 호출

DemoApplication과 동일한 위치에 ApiController 클래스 파일을 하나 생성한다.

![js1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/js9.png?raw=true)

그리고 다음과 같이 입력한다.

getApiTest() 메소드는 /api/test로 GET 방식으로 요청이 왔을 때, HTTP 상태 메시지는 OK로 응답하고 {"result":"ok"}가 출력된다.

getApiTest2() 메소드는 /api/test로 POST 방식으로 요청이 왔을 때, HTTP 상태 메시지는 OK로 응답하고{"result2":"ok"}가 출력된다.

```java
package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping(value = "/api/test", method = RequestMethod.GET) 
    @ResponseStatus(value = HttpStatus.OK) 
    public String getApiTest() {
        return "{\"result\":\"ok\"}";
    }

    @RequestMapping(value = "/api/test", method = RequestMethod.POST) 
    @ResponseStatus(value = HttpStatus.OK) 
    public String getApiTest2() {
        return "{\"result2\":\"ok\"}";
    }

}

```

application.properties에 port를 수정하기 위해 serer.port=8090을 입력한다.

![js1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/js10.png?raw=true)



요청과 응답을 확인하기 위해, Postman을 사용한다.

먼저, localhost:8090/api/test에 GET 요청을 보내면, {"result":"ok"} 응답이 온다.

![js1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/js11.png?raw=true)



그 다음, localhost:8090/api/test에 POST 요청을 보내면, {"result2":"ok"} 응답이 온다.

![js1.png](https://github.com/dpfkdlemtp/JavaStudy/blob/image/js12.png?raw=true)



