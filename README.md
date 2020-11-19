# 키친포스

## 요구 사항
### 상품

-[x] 상품 등록 기능 구현
-[x] 올바르지 않은 상품의 가격에 대한 예외 처리
    * 상품의 가격은 null이 될 수 없다.
    * 상품의 가격은 0 원 이상이어야 한다.
-[x] 상품 목록 조회 기능 구현

### 메뉴 그룹

-[x] 메뉴 그룹 등록 기능 구현
-[x] 메뉴 그룹 목록 조회 기능 구현

### 메뉴

-[x] 메뉴 등록 기능 구현
    * 1개 이상의 등록된 상품을 메뉴로 등록할 수 있다.
-[x] 올바르지 않은 메뉴 가격에 대한 예외 처리
    * 메뉴의 가격은 null이 될 수 없다.
    * 메뉴의 가격은 0 원 이상이어야 한다.
    * 메뉴에 속한 상품 금액의 합은 메뉴의 가격 보다 크거나 같아야 한다.
-[x] 메뉴와 메뉴 그룹의 연관관계 매핑
-[x] 올바르지 않은 메뉴와 상품의 연관관계 매핑에 대한 예외 처리
    * 메뉴와 연관관계가 있는 상품 아이디가 존재해야 한다. 
-[x] 올바르지 않은 메뉴와 메뉴 그룹의 연관관계 매핑에 대한 예외 처리
    * 메뉴와 연관관계가 있는 메뉴 그룹의 아이디가 존재해야 한다. 
-[x] 메뉴 목록 조회 기능 구현

### 주문 테이블

-[x] 주문 테이블 등록 기능 구현
-[x] 주문 테이블 목록 조회 기능 구현
-[x] 빈 테이블 설정 혹은 해지 기능 구현
-[x] 빈 테이블 설정 혹은 해지에 대한 예외 처리
    * 존재하지 않는 테이블은 빈 테이블 설정할 수 없다.
    * 단체 지정된 주문 테이블은 빈 테이블 설정 또는 해지할 수 없다.
    * 주문 상태가 조리 또는 식사인 주문 테이블은 빈 테이블 설정 또는 해지할 수 없다.
-[x] 방문한 손님 수 입력 기능 구현
-[x] 올바르지 않은 방문한 손님 수에 대한 예외 처리
    * 방문한 손님 수는 0 명 이상이어야 한다.
    * 빈 테이블은 방문한 손님 수를 입력할 수 없다.

### 단체 지정

-[x] 빈 테이블 단체 지정 혹은 해지 기능 구현
-[x] 올바르지 않은 단체 지정에 대한 예외 처리
    * 2개 미만의 빈 테이블을 단체로 지정할 수 없다.
    * 단체 지정은 중복될 수 없다.
    * 단체 지정된 주문 테이블의 주문 상태가 조리 또는 식사인 경우 단체 지정을 해지할 수 없다.

### 주문

-[x] 주문 등록 기능 구현
-[x] 주문 등록에 대한 예외 처리
    * 주문하는 메뉴는 1개 이상이어야 한다.
    * 존재하지 않는 메뉴는 주문할 수 없다.
    * 존재하지 않는 테이블에는 주문을 등록할 수 없다.
    * 빈 테이블에는 주문을 등록할 수 없다.
-[x] 주문 목록 조회 기능 구현
-[x] 주문 상태 변경 기능 구현
-[x] 주문 상태 변경에 대한 예외 처리
    * 주문 상태가 계산 완료인 경우 변경할 수 없다.
    
## 서비스 리팩토링

### 요구사항
-[x] JPA를 적용
-[ ] Service 리팩토링
    -[x] MenuService
    -[x] OrderService
    -[ ] ProductService
    -[ ] TableGroupService
    -[ ] TableService
-[ ] DTO 클래스 생성

## 용어 사전

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
| 상품 | product | 메뉴를 관리하는 기준이 되는 데이터 |
| 메뉴 그룹 | menu group | 메뉴 묶음, 분류 |
| 메뉴 | menu | 메뉴 그룹에 속하는 실제 주문 가능 단위 |
| 메뉴 상품 | menu product | 메뉴에 속하는 수량이 있는 상품 |
| 금액 | amount | 가격 * 수량 |
| 주문 테이블 | order table | 매장에서 주문이 발생하는 영역 |
| 빈 테이블 | empty table | 주문을 등록할 수 없는 주문 테이블 |
| 주문 | order | 매장에서 발생하는 주문 |
| 주문 상태 | order status | 주문은 조리 ➜ 식사 ➜ 계산 완료 순서로 진행된다. |
| 방문한 손님 수 | number of guests | 필수 사항은 아니며 주문은 0명으로 등록할 수 있다. |
| 단체 지정 | table group | 통합 계산을 위해 개별 주문 테이블을 그룹화하는 기능 |
| 주문 항목 | order line item | 주문에 속하는 수량이 있는 메뉴 |
| 매장 식사 | eat in | 포장하지 않고 매장에서 식사하는 것 |
