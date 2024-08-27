package rough;

import org.testng.annotations.Test;
import utils.Config;

import java.io.IOException;

public class rough {

    @Test
    public void setup() throws IOException {
      Config config = new Config();
      System.out.println(config.getProperties("browser"));

    }
}
