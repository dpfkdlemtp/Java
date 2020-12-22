## RESTful API

### REST

REST는 REpresentational State Transfer 의 약자로, 웹에 존재하는 모든 자원(이미지, 동영상, DB 자원)에 고유한 URI를 부여하여 활용하는 것으로 자원을 정의하고 자원에 대한 주소를 지정하는 방법론을 의미한다. 

> **URI 과 URL의 차이점**
>
> URL은 Uniform Resource Locator로 인터넷 상 자원의 위치를 의미한다. 자원의 위치라는 것은 결국 어떤 파일의 위치를 의미한다. 반면에 URI는 Uniform Resource Identifier로 인터넷 상의 자원을 식별하기 위한 문자열의 구성으로, URI는 URL을 포함하게 된다. 그러므로 URI가 보다 포괄적인 범위라고 할 수 있다.

아래의 6가지 조건을 "REST"라고 하며 이를 잘 지키는 서비스 디자인을 보고 RESTful 하다고 한다.

- Uniform Interface

REST는 HTTP 표준만 따른다면, 어떠한 기술이든 사용이 가능한 인터페이스이다. 예를 들어, HTTP + JSON으로 REST API를 정의했다면 안드로이드, IOS 플랫폼이나 C, Java, Python 언어나 기술에 종속받지 않고 HTTP와 JSON을 사용할 수 있는 모든 플랫폼에 사용이 가능한 느슨한 결합(Loosely Coupling) 형태의 구조이다.

- Client-Server

서비스가 수행되길 기대하는 클라이언트는 서버에 요청을 보내며, 서버는 해당 요청을 거절하거나 수행하고 클라이언트에 응답을 보낸다. 모든 통신은 클라이언트-서버 간의 일대일로 연결된다. REST 서버는 API를 제공하고, 제공된 API를 이용하여 비즈니스 로직 처리 및 저장을 책임진다. 클라이언트의 경우 사용자 인증이나 Context(세션, 로그인 정보)등을 직접 관리하고 책임지는 구조로 역할이 나뉜다.

이렇게 역할이 구분되면서, 개발 관점에서 클라이언트와 서버에서 개발해야 할 내용들이 명확하게 되고 서로의 개발에 있어서 의존성이 줄어들게 된다

- Stateless

State의 의미는 사용자나 클라이언트의 Context를 서버 쪽에서 유지 하지 않는다는 의미로, HTTP Session과 같은 Context 저장소에 상태 정보를 저장하지 않는 형태를 의미한다. 상태 정보를 저장하지 않으면 각 API 서버는 들어오는 요청의 메시지로만 처리하면 되며, 세션과 같은 Context 정보를 신경 쓸 필요가 없기 때문에 구현이 단순해진다.

- Cacheable

자기 서술형 메시지 덕분에 각각의 요청에 대한 응답은 그 자체로 해석이 가능하다.

> **자기 서술형 메시지 **
>
> REST는 메시지가 자신을 어떻게 처리해야할 지에 대한 정보를 포함하고 있어야 한다. 즉 수신자가 이해하기 위한 모든 정보를 가지고 있어야 한다. API 메시지 자체만 보고도 API를 이해할 수 있는 Self-descriptiveness 구조를 갖는다.

그렇기 때문에 독립적으로 처리가 가능한데, 이로 인해 Caching이 가능해진다. 다른 상황에 영향을 받는다면 Chaching을 했을 경우 잘못된 결과가 나올 수 있다. 네트워크를 사용하는 비용이 가장 오래 걸리므로 이를 줄이는 것이 어플리케이션 성능을 향상시키는 좋은 방법이다.

- Layered System

서버는 클라이언트가 모르게 API 서버에 여러 계층을 추가하여 유연한 구조로 개발될 수 있다. 클라이언트 입장에서는 REST API 서버만 호출한다. 그러나 서버는 다중 계층으로 구성될 수 있다.

- Code on Demand(optional)

클라이언트는 리소스에 대한 표현을 응답으로 받고 처리해야 하는데, 어떻게 처리해야 하는지에 대한 Code를 서버가 제공하는 것을 의미한다. HTML에서의 javascript가 대표적인 예이다.

### REST API

API는 데이터와 기능의 집합을 제공하여 컴퓨터 프로그램간 상호작용을 촉진하며, 서로 정보를 교환가능 하도록 하는 것이다.

REST API는 REST 기반으로 서비스 API를 구현한 것이다. 최근에 OpenAPI(누구나 사용할 수 있도록 공개된 API: 구글 맵 등), 마이크로 서비스 등을 제공하는 업체 대부분은 REST API를 제공한다.

Restful API는 REST의 특징을 지키면서 API를 제공하는 것이다.



### OpenAPI 호출

POSTMAN을 활용하여 OpenAPI를 호출해보자. 

http://httpbin.org는 다음과 같이 다양한 OpenAPI를 제공한다.

- http://httpbin.org/ip Origin IP를 반환
- http://httpbin.org/user-agent user-agent를 반환
- http://httpbin.org/headers 헤더 dict를 반환
- http://httpbin.org/get GET 데이터를 반환
- http://httpbin.org/post POST 데이터를 반환
- http://httpbin.org/put PUT 데이터를 반환
- http://httpbin.org/delete DELETE 데이터를 반환



http://httpbin.org/get에 GET 방식으로 key가 test이고, value가 hello인 값을 전송하였다. "args": { "test": "hello"}가 출력된다.

![oa1.PNG](https://github.com/dpfkdlemtp/JavaStudy/blob/image/oa1.PNG?raw=true)



http://httpbin.org/user-agent를 GET 방식으로 전송하였다. "user-agent": { "PostmanRuntime/7.26.8"}가 출력된다.

![oa1.PNG](https://github.com/dpfkdlemtp/JavaStudy/blob/image/oa2.PNG?raw=true)

http://httpbin.org/post에 POST 방식으로 key가 OpenAPI이고, value가 WoW인 값을 전송하였다. "args": { "OpenAPI": "WoW"}가 출력된다.

![oa1.PNG](https://github.com/dpfkdlemtp/JavaStudy/blob/image/oa3.PNG?raw=true)

