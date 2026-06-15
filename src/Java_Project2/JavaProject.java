package Java_Project2;

/**
 * JavaProject 클래스 - Java 프로젝트 유형
 *
 * Project(부모 클래스)를 상속받아 Java 프로젝트에 맞는
 * 품질 점수 계산 방식을 구현한다.
 * Java 프로젝트는 '커밋 수'와 '설명 길이'에 높은 가중치(각 25점)를 부여한다.
 *
 * 가중치: README(20) / 배포(15) / 커밋(25) / 기술스택(15) / 설명(25)
 */
public class JavaProject extends Project { // [상속] - Project 클래스를 상속받음

    /**
     * 생성자 - 부모 클래스의 생성자를 호출하여 모든 필드를 초기화한다.
     */
    public JavaProject(String projectName, String language, String githubUrl,
                       int commitCount, boolean hasReadme, boolean isDeployed,
                       int techStackCount, int descriptionLength) {
        super(projectName, language, githubUrl, commitCount,
              hasReadme, isDeployed, techStackCount, descriptionLength); // [생성자 - super 호출]
    }

    /**
     * Java 프로젝트의 품질 점수를 계산한다. (100점 만점)
     *
     * Java 프로젝트는 커밋 수(25점)와 설명 길이(25점)가 가장 중요하며,
     * README(20점), 배포 여부(15점), 기술스택(15점) 순이다.
     *
     * @return 계산된 품질 점수 (0~100, 정수)
     */
    @Override // [오버라이딩] - 부모의 추상 메서드를 Java 프로젝트 방식으로 구현
    public int calculateQualityScore() {
        double score = 0;

        // 1. README 여부 (만점: 20점)
        score += isHasReadme() ? 20 : 0;

        // 2. 배포 여부 (만점: 15점)
        score += isDeployed() ? 15 : 0;

        // 3. 커밋 수 (만점: 25점) - Java 프로젝트 최고 가중치
        score += getCommitRate() * 25;

        // 4. 기술스택 (만점: 15점)
        score += getTechStackRate() * 15;

        // 5. 설명 길이 (만점: 25점) - Java 프로젝트 최고 가중치
        score += getDescriptionRate() * 25;

        return (int) Math.round(score); // 정수로 반올림하여 반환
    }

    /**
     * 프로젝트 유형 이름을 반환한다.
     *
     * @return "Java 프로젝트"
     */
    @Override // [오버라이딩]
    public String getProjectType() {
        return "Java 프로젝트";
    }
}
