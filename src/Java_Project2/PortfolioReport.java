package Java_Project2;

/**
 * PortfolioReport 클래스 - 프로젝트 품질 점검 결과를 보기 좋게 출력하는 클래스
 *
 * 프로젝트 기본 정보, 품질 점수, 등급, 종합 평가, 개선 조언을
 * 깔끔한 형식으로 콘솔에 출력한다.
 */
public class PortfolioReport { // [클래스]

    // 점검 결과를 콘솔에 출력하는 메서드
    // Project 타입으로 받아서 어떤 유형이든 다 처리 가능 // [다형성]
    public void printReport(Project project, int score, String grade, String summary) {

        System.out.println();
        System.out.println("=====================================");
        System.out.println("     프로젝트 품질 점검 결과");
        System.out.println("=====================================");

        // 기본 정보 출력
        System.out.println("프로젝트명  : " + project.getProjectName());
        System.out.println("유형        : " + project.getProjectType()); // [다형성] - 실제 타입에 맞는 메서드 호출
        System.out.println("사용 언어   : " + project.getLanguage());
        System.out.println("GitHub 주소 : " + project.getGithubUrl());
        System.out.println("-------------------------------------");

        // 세부 항목 출력
        System.out.println("커밋 수     : " + project.getCommitCount() + "회");
        System.out.println("README      : " + (project.isHasReadme() ? "있음" : "없음"));
        System.out.println("배포 여부   : " + (project.isDeployed() ? "완료" : "미배포"));
        System.out.println("기술스택    : " + project.getTechStackCount() + "개");
        System.out.println("설명 길이   : " + project.getDescriptionLength() + "자");
        System.out.println("-------------------------------------");

        // 점수, 등급 출력
        System.out.println("품질 점수   : " + score + " / 100점");
        System.out.println("등급        : " + grade);
        System.out.println("평가        : " + summary);
        System.out.println("-------------------------------------");

        // 개선 조언 출력
        System.out.println("[개선 조언]");
        String advice = project.getAdvice();
        String[] lines = advice.split("\n");
        for (int i = 0; i < lines.length; i++) {
            if (!lines[i].isEmpty()) {
                System.out.println(lines[i]);
            }
        }

        System.out.println("=====================================");
        System.out.println();
    }
}
