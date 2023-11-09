# Mr_Noin

## 주차별 진행상황 : dev_week branch 확인

## 💡 요구사항

> 윗선에서 프로젝트가 엎어졌습니다. 저희에게 Rest API 형식으로 서비스를 제공하라고 명령이 내려왔습니다. 이에 맞춰 저희의 서비스를 리팩토링 해봅시다.



## TODO - LIST

|이름 | O/X |
|---|-----|
| 기존 Controller를 RestController로 변경 | X   |
| 비동기 통신을 활용하여 서버에서 각 페이지에서 데이터를 받아오기 | X  |



### 제한 사항
저희가 기존 쓰던 @ModelAttribute와 @Model model 방식은 피해주세요.

## 과제 방법

기존의 코드를 프론트는 비동기로 서버에 통신하며 서버는 데이터만 내려주는 구조를 만들어 봅시다.
템플릿을 첨부하였으니, 막혔을 때 언제든 참조하세요.

[ 템플릿 레포지토리 주소 ]( https://github.com/AMIVAYUN/springtrashTemplate )

## Git Update Convention

| **Type** | **Meaning** |
  | -------- | ------|
| Feat    | 새로운 기능 |
| Fix     | 버그 수정 |
| Resolve | 충돌 해결 |
| Build   | 빌드 관련 파일 수정 |
| Chore   | 그 외 자잘한 수정 |
| Style   | 스타일 변경 |
| Docs    | 문서 수정 |
| Refactor| 코드 리팩토링 |
| Test    | 테스트 코드 수정 |
| Add     | 새로운 라이브러리 / 파일 생성 |


## 변경 이력
| 날짜          | 버전  | 작성자          | 설명               |
|-------------|-----|--------------|------------------|
| 2023-10-20  | 0.1 | 한규준 | DB연동, Login기능 추가 |
 | 2023-10-20 | 0.2 | 한규준 | SignUp, MemberInfoUpdate 기능추가 |
|2023-11-07|0.3|한규준|Board, Notice, Role 기능추가 |