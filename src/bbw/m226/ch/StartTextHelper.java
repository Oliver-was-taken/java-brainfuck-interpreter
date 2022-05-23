package bbw.m226.ch;

/**
 * Class to print out big banner in beginning
 *
 * @author Oliver
 * @since 23.05.2022
 */
public class StartTextHelper {

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static final String ANSI_RESET = "\u001B[0m";

    public void getStartText() {
        System.out.print(ANSI_BLUE);
        System.out.println("||  ___  ____ ____ _ _  _ ____ _  _ ____ _  _ ");
        System.out.println("||  |__] |__/ |__| | |\\ | |___ |  | |    |_/");
        System.out.println("||  |__] |  \\ |  | | | \\| |    |__| |___ | \\_");
        System.out.println("||  _ _  _ ___ ____ ____ ___  ____ ____ ___ ____ ____ ");
        System.out.println("||  | |\\ |  |  |___ |__/ |__] |__/ |___  |  |___ |__/");
        System.out.println("||  | | \\|  |  |___ |  \\ |    |  \\ |___  |  |___ |  \\ ");
        System.out.println("||" + ANSI_CYAN + "  ~By Oliver" + ANSI_RESET);

    }
}
