package Java_Project2;

/**
 * Main 클래스 - 프로그램의 시작점 (Entry Point)
 *
 * main() 메서드에서 ProjectManager 객체를 생성하고 실행한다.
 * IntelliJ에서 이 클래스를 실행(Run)하면 프로그램이 시작된다.
 */
public class Main { // [클래스]

    /**
     * 프로그램의 시작 메서드
     * ProjectManager를 생성하여 프로그램을 실행시킨다.
     *
     * @param args 명령줄 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        // ProjectManager 객체를 생성하고 실행
        ProjectManager manager = new ProjectManager(); // [생성자] 호출
        manager.run(); // 프로그램 메인 루프 시작
    }
}
