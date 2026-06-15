package Java_Project2;

/**
 * Project 클래스 - GitHub 프로젝트의 공통 정보를 담는 부모 추상 클래스
 *
 * 모든 프로젝트 유형(Web, AI, Java)의 공통 필드와 메서드를 정의한다.
 * calculateQualityScore()와 getProjectType()은 추상 메서드로 선언하여
 * 각 자식 클래스가 자신만의 방식으로 구현하도록 강제한다.
 */
public abstract class Project { // [추상화] - abstract 키워드로 직접 객체 생성 불가

    // 필드는 전부 private으로 선언 (외부에서 직접 접근 못 하게) // [캡슐화] [접근제한자]
    private String projectName;
    private String language;
    private String githubUrl;
    private int commitCount;
    private boolean hasReadme;
    private boolean isDeployed;
    private int techStackCount;
    private int descriptionLength;

    // 생성자 - 객체 만들 때 필드 초기화 // [생성자]
    public Project(String projectName, String language, String githubUrl,
                   int commitCount, boolean hasReadme, boolean isDeployed,
                   int techStackCount, int descriptionLength) {
        this.projectName = projectName;
        this.language = language;
        this.githubUrl = githubUrl;
        this.commitCount = commitCount;
        this.hasReadme = hasReadme;
        this.isDeployed = isDeployed;
        this.techStackCount = techStackCount;
        this.descriptionLength = descriptionLength;
    }

    // getter - private 필드 읽기용 // [캡슐화]
    public String getProjectName() { return projectName; }
    public String getLanguage() { return language; }
    public String getGithubUrl() { return githubUrl; }
    public int getCommitCount() { return commitCount; }
    public boolean isHasReadme() { return hasReadme; }
    public boolean isDeployed() { return isDeployed; }
    public int getTechStackCount() { return techStackCount; }
    public int getDescriptionLength() { return descriptionLength; }

    // 추상 메서드 - 자식 클래스에서 반드시 구현해야 함 // [추상화]
    public abstract int calculateQualityScore(); // 점수 계산
    public abstract String getProjectType();     // 유형 이름 반환

    // 커밋 수 비율 계산 (자식 클래스에서 점수 계산할 때 씀)
    protected double getCommitRate() {
        if (commitCount >= 20) return 1.0;
        else if (commitCount >= 10) return 0.75;
        else if (commitCount >= 5) return 0.5;
        else return 0.25;
    }

    // 기술스택 비율 계산
    protected double getTechStackRate() {
        if (techStackCount >= 5) return 1.0;
        else if (techStackCount >= 3) return 0.75;
        else if (techStackCount >= 1) return 0.5;
        else return 0.0;
    }

    // 설명 길이 비율 계산
    protected double getDescriptionRate() {
        if (descriptionLength >= 100) return 1.0;
        else if (descriptionLength >= 50) return 0.75;
        else if (descriptionLength >= 20) return 0.5;
        else return 0.25;
    }

    // 개선 조언 생성 - 부족한 항목 찾아서 문자열로 반환
    public String getAdvice() {
        String advice = "";

        if (!hasReadme) {
            advice += "  - README 파일을 추가하세요.\n";
        }
        if (!isDeployed) {
            advice += "  - 프로젝트를 배포해보세요.\n";
        }
        if (commitCount < 5) {
            advice += "  - 커밋이 너무 적습니다. 최소 10회 이상 권장합니다.\n";
        } else if (commitCount < 10) {
            advice += "  - 커밋 수를 더 늘려보세요.\n";
        } else if (commitCount < 20) {
            advice += "  - 커밋이 양호하지만 20회 이상이면 더 좋습니다.\n";
        }
        if (techStackCount == 0) {
            advice += "  - 사용 기술스택을 적어주세요.\n";
        } else if (techStackCount < 3) {
            advice += "  - 기술스택을 좀 더 다양하게 써보세요.\n";
        }
        if (descriptionLength < 20) {
            advice += "  - 프로젝트 설명이 너무 짧습니다.\n";
        } else if (descriptionLength < 50) {
            advice += "  - 설명을 좀 더 구체적으로 작성해보세요.\n";
        } else if (descriptionLength < 100) {
            advice += "  - 설명이 100자 이상이면 더 좋습니다.\n";
        }

        if (advice.isEmpty()) {
            advice = "  - 모든 항목이 잘 갖춰져 있습니다!\n";
        }

        return advice;
    }
}
