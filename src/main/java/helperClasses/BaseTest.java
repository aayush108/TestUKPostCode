package helperClasses;

import org.junit.BeforeClass;

public class BaseTest {
    protected static PathFormer path;

    @BeforeClass
    public static void beforeClass() {
        path = new PathFormer("http://api.postcodes.io");

    }
}