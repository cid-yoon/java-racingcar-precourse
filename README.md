# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 2차에서 집중할 부분

TDD 원칙

```text
실패하는 단위 테스트를 작성할 때까지 프로덕션 코드를 작성하지 않는다

컴파일은 실패하지 않으면서 실행이 실패하는 정도로만 단위 테스트를 작성한다

현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다
```

테스틐 작성 & 커밋

```text
테스트가 모두 완료 된 다음에 커밋, 커밋은 테스트 케이스를 기반으로 작성하자

거꾸로 만드는 구조에 익숙해지자

private 욕구가 생기는 경우에는 이곳에 있는 것이 맞는지? 그게 아니면 패키지 권한으로 테스트 하자

```

## 기능 요구사항

```text
주어진 횟수 동안 n 대의 자동차는 전진 또는 멈출 수 있다

각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다

자동차의 이름은 쉼표(,)를 기준으로 구분하여 이름은 5자 이하 글자만 가능하다

사용자는 몇 번의 이동을 할 것인지를 입력할 수 있다

전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고 3 이하의 값이면 멈춘다

자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다 우승자는 한 명일 수 있다
```

# 요구사항

처음부터 너무 힘 주지 않드

## 구현 객체 정리

구현 객체 정리

### Track

자동자가 움직일 필드

- 필드는 레이싱에 출전한 자동차 목록을 전달 받는다
- 필드는 레이싱카의 생명주기를 관리한다

### Car

- Car는 여러 모듈을 통해 이루어진다
- 모듈은 구동 모듈과 디스플레이 모듈로 나눠진다
    - 구동 모듈
        - 구동 모듈은 엔진, 연료통으로 나뉜다
        - 엔진은 토크라는 값을 이용해서 움직임을 판단한다
        - 연료는 매 턴 소비된다
        - 연료가 모두 소비되면 자동차는 더이상 움직일 수 없다
    - 대쉬보드
        - 디스플레이 모듈은 번호판, 주행 기록으로 나뉜다
        - 번호판은 자동차의 이름을 표시한다
            - 이름은 1글자~5글자로 이루어진다
        - 주행 기록
            - 연료 소비에 따른 주행 결과를 기록한다
            - 주행 결과는 누적되어 기록된다
            - 대쉬 보드를 통해 각자의 주행 결과를 기록한다(고민)

### UiSystem

시스템 입출력

* ConsoleSystem
    * Input Output

## 구현 목록

가장 쉬운 대상부터, 유틸성이 높은 녀석부터 만들어서 합치기로 하기

### NumberPlate

각 자동차는 이름을 가질 수 있다

- [ ] 자동차의 이름은 5자 이하 글자만 가능하다
- [ ] 자동차 이름이 5글자를 초과하거나 0글자인 경우 예외를 반환한다

### FuelTank

이동(구동)에 필요한 횟수를 관리한다

- [ ] 이동 시 연료를 소비한다
- [ ] 연료는 설정된 소비량에 따라 점진적으로 사용된다
- [ ] 연료가 없는 상태에서 소비를 요청할 경우 예외를 반환한다

### Engine

자동차의 움직임을 관리한다

- [ ] 0 ~9 사이에 random 값을 가질 수 있다
- [ ] 생성된 랜덤 값은 Torque 라는 일급 객체로 관리한다
- [ ] 토크가 4 이상인 경우에는 이동을
- [ ] 토크가 3이하인 경우에는 이동하지 않는다

### DriveRecord

엔진의 동작을 통해 생성된 이동 값을 관리한다

- [ ] 이동 거리를 가진다
- [ ] 자동차 이름을 가진다

### DisplayPanel

자동차의 주행 기록을 표시한다

- [ ] 사용자의 이름을 출력할 수 있다
- [ ] 사용자 별 주행 결과를 출력할 수 있다

