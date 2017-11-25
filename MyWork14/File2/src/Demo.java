import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.persistence.Temporal;

import org.junit.Test;


public class Demo {
	@Test
	public void sys() {
		File f = new File(this.getClass().getResource("").getPath());
		System.out.println(f);
	}
}
