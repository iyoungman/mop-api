# Product Name
> MoP(Meeting of People) Server

## Motivation
기존 동호회 관련 어플리케이션은 다양한 동호회 분류와 채팅, 게시판 기능에 집중되어 있었다. 하지만 자전거 동호회, 산악 동호회 같이 안정성과 편의성을 이유로 
서로의 위치를 실시간으로 파악하는 것이 중요한 동호회를 대상으로 어플리케이션 내에서 회원들간의 위치정보 공유를 주 기능으로 하여 지원한다면 좀 더 편리한 동호회 활동을 할 수 있다고 생각하였다. 
또한, 기존 대부분의 동호회 어플리케이션에서 목록 형식으로 구현된 일정을 보기 쉬운 달력 UI로 구현하였다.

## Fuction
* 위치 정보 공유
  + 어플내에서 회원들간의 위치정보를 공유
  + 동호회 내의 모든 인원들의 위치정보 공유가 아닌 자신이 원하는 인원의 위치 정보를 파악
  + 산악, 자전거 동호회 회원들간의 위치 정보 공유가 필요한 동호회에서 안정성과 편의성을 제공
* 일정 관리
  + 기존 대부분의 동호회 어플리케이션에서 단순히 목록으로 구현되어있던 반면 일정 파악이 쉽게 달력 UI로 구현
  + 일정이 있는 날을 파악하기 위해서 일정이 있는 날은 날짜 밑에 빨간점으로 표시하였으며 일정이 있는 날을 클릭할 경우 해당 날짜의 일정 목록과 정보를 표시
* 게시판
  + 게시판을 통해서 동호회 회원들 간의 자유로운 의사소통을 보장

## Specification
* [Requery](https://github.com/coupang/spring-data-requery)
* Spring Boot
* Maven
* Spring Data JPA
* H2
* Restful API
* Lombok
* QueryDSL
* MySQL

## Test
* BDD(Behaviour-Driven Development) 방식
* JUnit + Mockito 
