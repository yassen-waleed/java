import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Readfile {
    public static int[] readfile(String path) {
        File file = new File(path);

        Scanner scanner;

        int[] ar = null;

        int num = 0;
        try {
            scanner = new Scanner(file);
            if (scanner.hasNext()) {
                num = scanner.nextInt();

            }
            ar = new int[num];
            int i = 0;
            while (scanner.hasNext()) {
                ar[i] = scanner.nextInt();
                i++;

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ar;

    }
}
