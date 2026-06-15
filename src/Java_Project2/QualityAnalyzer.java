package Java_Project2;

/**
 * QualityAnalyzer 클래스 - 품질 점수를 등급으로 변환하는 클래스
 *
 * 점수(0~100)를 입력받아 A+, A, B, C, D 등급과 설명을 반환한다.
 * 등급 기준:
 *   90점 이상 → A+ (매우 우수)
 *   80점 이상 → A  (완성도 높음)
 *   70점 이상 → B  (기본 구성 좋음)
 *   60점 이상 → C  (개선 필요)
 *   60점 미만 → D  (포트폴리오 보완 필요)
 */
public class QualityAnalyzer { // [클래스]

    /**
     * 점수를 받아 등급 문자열을 반환한다.
     *
     * @param score 품질 점수 (0~100)
     * @return 등급 문자열 (예: "A+ (매우 우수)")
     */
    public String getGrade(int score) { // [접근제한자] - public으로 외부에서 호출 가능
        if (score >= 90) {
            return "A+ (매우 우수)";
        } else if (score >= 80) {
            return "A (완성도 높음)";
        } else if (score >= 70) {
            return "B (기본 구성 좋음)";
        } else if (score >= 60) {
            return "C (개선 필요)";
        } else {
            return "D (포트폴리오 보완 필요)";
        }
    }

    /**
     * 등급에 따른 한 줄 종합 평가를 반환한다.
     *
     * @param score 품질 점수 (0~100)
     * @return 종합 평가 문자열
     */
    public String getSummary(int score) {
        if (score >= 90) {
            return "포트폴리오에 바로 사용할 수 있는 우수한 프로젝트입니다!";
        } else if (score >= 80) {
            return "완성도가 높습니다. 약간의 보완으로 더 좋아질 수 있습니다.";
        } else if (score >= 70) {
            return "기본기가 잘 갖추어져 있습니다. 몇 가지 개선을 추천합니다.";
        } else if (score >= 60) {
            return "개선이 필요한 부분이 있습니다. 아래 조언을 참고하세요.";
        } else {
            return "포트폴리오로 사용하기엔 부족합니다. 적극적인 보완이 필요합니다.";
        }
    }
}
