import com.refactoring.practice01.before.Parser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Adi on 12/26/2014.
 */
public class ParserTest {

    private Parser _parser;

    @Before
    public void setUp() {
        _parser = new Parser(new File("E:\\Temp\\java\\source.txt"));
    }

    @Test
    public void testRead() throws IOException {
        String content = _parser.getContent();
        Assert.assertNotNull(content);
        System.out.println(content);
    }

    @Test
    public void testRead2() throws IOException {
        String content = _parser.getContentWithoutUnicode();
        Assert.assertNotNull(content);
        System.out.println(content);
    }

    @Test
    public void testWrite() throws IOException {
        _parser.saveContent("blahx blahx blahx");
        Assert.assertNotNull(_parser.getContent());
    }
}
