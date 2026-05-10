package Java_Project;

import java.util.Scanner; // 키보드 입력을 받기 위한 Scanner 클래스 불러오기

public class SafeTrade {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in); // Scanner 객체 생성 → 키보드 입력 준비

        int riskScore = 0;   // 사기 위험 총점 (질문마다 점수가 누적됨)
        int dangerCount = 0; // 위험 항목에 "예"라고 답한 횟수
        int itemChoice;      // 사용자가 선택한 거래 물품 번호 저장
        int answer;      // 각 질문에 대한 사용자 답변 저장 (1=예, 2=아니오)

        // 프로그램 시작 안내 출력
        System.out.println("======================================");
        System.out.println(" SafeTrade 중고거래 사기 위험도 체크 프로그램");
        System.out.println("======================================");
        System.out.println("중고거래 전에 사기 위험 요소를 점검해보는 프로그램입니다.");
        System.out.println();


        // STEP 1. 거래 물품 종류 선택
        System.out.println("[거래 물품 종류를 선택하세요]");
        System.out.println("1. 전자기기");
        System.out.println("2. 의류");
        System.out.println("3. 티켓");
        System.out.println("4. 게임 / 취미용품");
        System.out.println("5. 기타");
        System.out.print("선택 번호 입력: ");
        itemChoice = s.nextInt(); // 사용자가 입력한 번호를 itemChoice에 저장

        System.out.println();


        // STEP 2. 선택한 물품에 맞는 주의사항 출력
        // switch문: itemChoice 값에 따라 해당 case로 이동해서 출력
        switch (itemChoice) {

            case 1: // 전자기기 선택 시
                System.out.println("전자기기 거래를 선택했습니다.");
                System.out.println("전자기기는 고가 거래가 많아 선입금 사기를 주의해야 합니다.");
                break; // switch문 탈출 (없으면 아래 case도 연속 실행됨)

            case 2: // 의류 선택 시
                System.out.println("의류 거래를 선택했습니다.");
                System.out.println("의류는 실제 상태와 사진이 다를 수 있으므로 상품 상태 확인이 중요합니다.");
                break;

            case 3: // 티켓 선택 시
                System.out.println("티켓 거래를 선택했습니다.");
                System.out.println("티켓은 가짜 예매 내역이나 중복 판매를 특히 주의해야 합니다.");
                break;

            case 4: // 게임/취미용품 선택 시
                System.out.println("게임 / 취미용품 거래를 선택했습니다.");
                System.out.println("한정판 상품이나 희귀 상품은 가격이 비정상적으로 낮은 경우 주의해야 합니다.");
                break;

            case 5: // 기타 선택 시
                System.out.println("기타 물품 거래를 선택했습니다.");
                System.out.println("거래 전 판매자 정보와 결제 방식을 꼭 확인해야 합니다.");
                break;

            default: // 1~5 이외의 번호 입력 시
                System.out.println("잘못된 번호를 입력했습니다. 프로그램을 종료합니다.");

                s.close();  // Scanner 닫기
                return;     // main 메서드 즉시 종료
        }

        System.out.println();
        System.out.println("이제 사기 위험 요소를 체크합니다.");
        System.out.println("각 질문에 대해 1번은 예, 2번은 아니오로 입력하세요.");
        System.out.println();


        // STEP 3. 질문 내용과 점수를 배열로 정의
        // questions 배열: 5개의 질문을 순서대로 저장
        String[] questions = {
                "시세보다 가격이 너무 저렴한가요?",       // index 0
                "판매자가 직거래를 거부하나요?",           // index 1
                "판매자가 선입금을 요구하나요?",           // index 2
                "판매자 정보가 부족한가요?",               // index 3
                "판매자가 거래를 급하게 유도하나요?"       // index 4
        };

        // scores 배열: 각 질문에 "예" 답변 시 추가될 위험 점수 (questions와 index 일치)
        int[] scores = {20, 20, 30, 15, 15};
        //               ↑   ↑   ↑   ↑   ↑
        //              Q1  Q2  Q3  Q4  Q5


        // STEP 4. 사기 위험 질문 5개 반복 출력 및 점수 계산
        // i = 0부터 4까지 → 총 5번 반복 (질문 5개)
        for (int i = 0; i < 5; i++) {

            // (i+1)로 출력하는 이유: 배열은 0부터 시작하지만 사람에게는 1번부터 보여줘야 자연스러움
            System.out.println((i + 1) + ". " + questions[i]); // 현재 질문 출력
            System.out.println("1. 예");
            System.out.println("2. 아니오");
            System.out.print("입력: ");
            answer = s.nextInt(); // 사용자 답변 입력받기

            if (answer == 1) {
                // "예" 선택 시 → 해당 질문의 점수를 riskScore에 누적
                riskScore += scores[i]; // ex) i=2이면 scores[2]=30점 추가
                dangerCount++;          // 위험 항목 카운트 1 증가
                System.out.println("위험 점수 +" + scores[i] + "점");

            } else if (answer == 2) {
                // "아니오" 선택 시 → 점수 변화 없음
                System.out.println("위험 점수 변화 없음");

            } else {
                // 1, 2 이외의 값 입력 시 → 점수 변화 없이 안내만 출력
                System.out.println("잘못된 입력입니다. 점수 변화 없음");
            }

            System.out.println(); // 질문 사이 빈 줄 출력
        }


        // STEP 5. 최종 결과 출력
        System.out.println("======================================");
        System.out.println("              진단 결과");
        System.out.println("======================================");
        System.out.println("총 위험 점수: " + riskScore + "점");   // 누적된 총 위험 점수
        System.out.println("위험 항목 개수: " + dangerCount + "개"); // "예" 답변 횟수
        System.out.println();


        // STEP 6. 위험 등급 판단
        // riskScore 범위에 따라 4단계 등급으로 나눔
        if (riskScore <= 20) {
            // 0 ~ 20점: 안전
            System.out.println("위험 등급: 안전");
            System.out.println("비교적 안전한 거래로 보입니다.");
            System.out.println("그래도 거래 전 상품 상태와 판매자 정보를 한 번 더 확인하세요.");

        } else if (riskScore <= 50) {
            // 21 ~ 50점: 주의
            System.out.println("위험 등급: 주의");
            System.out.println("일부 위험 요소가 있습니다.");
            System.out.println("가능하면 직거래 또는 안전결제를 이용하는 것이 좋습니다.");

        } else if (riskScore <= 80) {
            // 51 ~ 80점: 위험
            System.out.println("위험 등급: 위험");
            System.out.println("사기 가능성이 높은 거래입니다.");
            System.out.println("선입금은 피하고, 판매자 정보를 충분히 확인해야 합니다.");

        } else {
            // 81점 이상: 매우 위험
            System.out.println("위험 등급: 매우 위험");
            System.out.println("사기 가능성이 매우 높습니다.");
            System.out.println("해당 거래는 진행하지 않는 것을 추천합니다.");
        }

        s.close(); // Scanner 사용 완료 후 닫기 → 메모리 자원 반환
    }
}