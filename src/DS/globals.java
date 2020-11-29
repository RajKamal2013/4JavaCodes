package DS;

public class globals {
    public static int []warning = {1, 2, 3};
    public static boolean[] warn = {true, true, false};
    public static int []error = {1, 2, 3};
    public static boolean[] err = {true, true, false};

    static void LogWarning(int level, int line, String warning , String fileName) {
        if (warn[level]) {
            System.out.println("WARNING:" + fileName + ":" + line + ":" + warning);
        }
    }
    static void LogError(int level, int line, String fileName, String error) {
        if (err[level]) {
            System.out.println("WARNING:" + fileName + ":" + line + ":" + error);
        }
    }
}
