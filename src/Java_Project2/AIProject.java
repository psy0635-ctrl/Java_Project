package Java_Project2;

// AI 프로젝트 클래스 - Project를 상속받아 AI 전용 점수 계산 구현
// 가중치: README(20) / 배포(10) / 커밋(20) / 기술스택(25) / 설명(25)
public class AIProject extends Project { // [상속]

    // 생성자 - 부모 생성자에 그대로 넘김 // [생성자]
    public AIProject(String projectName, String language, String githubUrl,
                     int commitCount, boolean hasReadme, boolean isDeployed,
                     int techStackCount, int descriptionLength) {
        super(projectName, language, githubUrl, commitCount,
              hasReadme, isDeployed, techStackCount, descriptionLength); // [생성자 - super 호출]
    }

    // 점수 계산 - AI는 기술스택(25점)·설명(25점) 가중치가 제일 높음 // [오버라이딩]
    @Override
    public int calculateQualityScore() {
        double score = 0;

        // 1. README 여부 (만점: 20점)
        score += isHasReadme() ? 20 : 0;

        // 2. 배포 여부 (만점: 10점) - AI 프로젝트는 배포 비중이 낮음
        score += isDeployed() ? 10 : 0;

        // 3. 커밋 수 (만점: 20점)
        score += getCommitRate() * 20;

        // 4. 기술스택 (만점: 25점) - AI 프로젝트 최고 가중치
        score += getTechStackRate() * 25;

        // 5. 설명 길이 (만점: 25점) - AI 프로젝트 최고 가중치
        score += getDescriptionRate() * 25;

        return (int) Math.round(score); // 정수로 반올림하여 반환
    }

    // 유형 이름 반환 // [오버라이딩]
    @Override
    public String getProjectType() {
        return "AI 프로젝트";
    }
}
