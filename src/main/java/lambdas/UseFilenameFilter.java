package lambdas;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class UseFilenameFilter {
    public static void main(String[] args) {
        File dir = new File("src/main/java");
        String[] names = dir.list();
        System.out.println(Arrays.asList(names));

        // Using anonymous inner class
        names = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File directory, String name) {
                return name.endsWith(".java");
            }
        });
        System.out.println(Arrays.asList(names));

        // Use a lambda expression
        names = dir.list((directory, name) -> name.endsWith(".java"));
        System.out.println(Arrays.asList(names));

        names = dir.list(new MyFilter());
        System.out.println(Arrays.asList(names));
    }
}
