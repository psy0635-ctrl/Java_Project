package Java_Project2;

import java.util.Scanner;

/**
 * ProjectManager 클래스 - 프로그램의 전체 실행 흐름을 담당하는 클래스
 *
 * 메뉴 출력, 사용자 입력 처리, 프로젝트 유형별 객체 생성,
 * 점수 계산, 등급 판정, 결과 출력까지 전체 과정을 관리한다.
 */
public class ProjectManager { // [클래스]

    Scanner sc = new Scanner(System.in); // 입력 받을 때 쓰는 Scanner

    // 생성자 // [생성자]
    public ProjectManager() {
        // 딱히 초기화할 게 없어서 비워둠
    }

    // 프로그램 메인 루프
    public void run() {
        System.out.println("=====================================");
        System.out.println("  GitHub 프로젝트 품질 점검 시스템");
        System.out.println("=====================================");

        int choice = 0;

        // 3번(종료) 입력할 때까지 계속 반복
        while (choice != 3) {
            System.out.println();
            System.out.println("1. 프로젝트 품질 점검 시작");
            System.out.println("2. 프로그램 설명 보기");
            System.out.println("3. 종료");
            System.out.print("메뉴 선택 >> ");

            // 입력값이 숫자가 아닐 수도 있어서 일단 문자열로 받음
            String input = sc.nextLine();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
                continue;
            }

            if (choice == 1) {
                startCheck();
            } else if (choice == 2) {
                showDesc();
            } else if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
            } else {
                System.out.println("1~3 중에서 선택해주세요.");
            }
        }
    }

    // 품질 점검 실행
    private void startCheck() {
        System.out.println();
        System.out.println("-- 프로젝트 유형 선택 --");
        System.out.println("1. Web Project");
        System.out.println("2. AI Project");
        System.out.println("3. Java Project");
        System.out.print("선택 >> ");

        int type;
        try {
            type = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        if (type < 1 || type > 3) {
            System.out.println("1~3 중에서 선택해주세요.");
            return;
        }

        // 프로젝트 정보 입력
        System.out.print("프로젝트 이름 : ");
        String name = sc.nextLine();

        System.out.print("사용 언어 : ");
        String lang = sc.nextLine();

        System.out.print("GitHub 주소 : ");
        String url = sc.nextLine();

        int commits = readInt("커밋 수 : ");        // 숫자 아니면 다시 입력받음

        boolean readme = readYesNo("README 있나요? (y/n) : ");

        boolean deployed = readYesNo("배포했나요? (y/n) : ");

        int stack = readInt("기술스택 개수 : ");

        int descLen = readInt("설명 글자 수 : ");

        // 유형에 맞는 객체 생성 // [다형성]
        Project p; // 부모 타입으로 선언 // [다형성]

        if (type == 1) {
            p = new WebProject(name, lang, url, commits, readme, deployed, stack, descLen); // [상속]
        } else if (type == 2) {
            p = new AIProject(name, lang, url, commits, readme, deployed, stack, descLen); // [상속]
        } else {
            p = new JavaProject(name, lang, url, commits, readme, deployed, stack, descLen); // [상속]
        }

        // 점수 계산 - 유형에 따라 다른 메서드가 실행됨 // [오버라이딩]
        int score = p.calculateQualityScore();

        // 등급 계산
        QualityAnalyzer qa = new QualityAnalyzer();
        String grade = qa.getGrade(score);
        String summary = qa.getSummary(score);

        // 결과 출력
        PortfolioReport report = new PortfolioReport();
        report.printReport(p, score, grade, summary); // [다형성]
    }

    // 프로그램 설명 출력
    private void showDesc() {
        System.out.println();
        System.out.println("이 프로그램은 GitHub 프로젝트 품질을 점검하는 시스템입니다.");
        System.out.println();
        System.out.println("[평가 항목]");
        System.out.println("  - README 작성 여부");
        System.out.println("  - 배포 여부");
        System.out.println("  - 커밋 수");
        System.out.println("  - 기술스택 개수");
        System.out.println("  - 설명 글자 수");
        System.out.println();
        System.out.println("[등급 기준]");
        System.out.println("  90점 이상 → A+");
        System.out.println("  80점 이상 → A");
        System.out.println("  70점 이상 → B");
        System.out.println("  60점 이상 → C");
        System.out.println("  60점 미만 → D");
        System.out.println();
        System.out.println("※ 프로젝트 유형마다 항목별 가중치가 다릅니다.");
    }

    // 0 이상 정수를 안전하게 입력받음 (숫자 아니거나 음수면 다시 입력)
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value < 0) {
                    System.out.println("0 이상의 숫자를 입력해주세요.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    // y/n 입력받아서 boolean으로 변환 (대소문자 둘 다 허용)
    private boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("y 또는 n을 입력해주세요.");
            }
        }
    }
}
