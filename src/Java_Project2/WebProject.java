package Java_Project2;

/**
 * WebProject 클래스 - 웹 프로젝트 유형
 *
 * Project(부모 클래스)를 상속받아 웹 프로젝트에 맞는
 * 품질 점수 계산 방식을 구현한다.
 * 웹 프로젝트는 '배포 여부'에 가장 높은 가중치(30점)를 부여한다.
 *
 * 가중치: README(20) / 배포(30) / 커밋(15) / 기술스택(20) / 설명(15)
 */
public class WebProject extends Project { // [상속] - Project 클래스를 상속받음

    /**
     * 생성자 - 부모 클래스의 생성자를 호출하여 모든 필드를 초기화한다.
     */
    public WebProject(String projectName, String language, String githubUrl,
                      int commitCount, boolean hasReadme, boolean isDeployed,
                      int techStackCount, int descriptionLength) {
        super(projectName, language, githubUrl, commitCount,
              hasReadme, isDeployed, techStackCount, descriptionLength); // [생성자 - super 호출]
    }

    /**
     * 웹 프로젝트의 품질 점수를 계산한다. (100점 만점)
     *
     * 웹 프로젝트는 배포 여부(30점)가 가장 중요하며,
     * README(20점), 기술스택(20점), 커밋 수(15점), 설명 길이(15점) 순이다.
     *
     * @return 계산된 품질 점수 (0~100, 정수)
     */
    @Override // [오버라이딩] - 부모의 추상 메서드를 웹 프로젝트 방식으로 구현
    public int calculateQualityScore() {
        double score = 0;

        // 1. README 여부 (만점: 20점)
        score += isHasReadme() ? 20 : 0;

        // 2. 배포 여부 (만점: 30점) - 웹 프로젝트 최고 가중치
        score += isDeployed() ? 30 : 0;

        // 3. 커밋 수 (만점: 15점)
        score += getCommitRate() * 15;

        // 4. 기술스택 (만점: 20점)
        score += getTechStackRate() * 20;

        // 5. 설명 길이 (만점: 15점)
        score += getDescriptionRate() * 15;

        return (int) Math.round(score); // 정수로 반올림하여 반환
    }

    /**
     * 프로젝트 유형 이름을 반환한다.
     *
     * @return "웹 프로젝트"
     */
    @Override // [오버라이딩]
    public String getProjectType() {
        return "웹 프로젝트";
    }
}
