package Java_Project2;

// 웹 프로젝트 클래스 - Project를 상속받아 웹 전용 점수 계산 구현
// 가중치: README(20) / 배포(30) / 커밋(15) / 기술스택(20) / 설명(15)
public class WebProject extends Project { // [상속]

    // 생성자 - 부모 생성자에 그대로 넘김 // [생성자]
    public WebProject(String projectName, String language, String githubUrl,
                      int commitCount, boolean hasReadme, boolean isDeployed,
                      int techStackCount, int descriptionLength) {
        super(projectName, language, githubUrl, commitCount,
              hasReadme, isDeployed, techStackCount, descriptionLength); // [생성자 - super 호출]
    }

    // 점수 계산 - 웹은 배포(30점) 가중치가 제일 높음 // [오버라이딩]
    @Override
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

    // 유형 이름 반환 // [오버라이딩]
    @Override
    public String getProjectType() {
        return "웹 프로젝트";
    }
}
