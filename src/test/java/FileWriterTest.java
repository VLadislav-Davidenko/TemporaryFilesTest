import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterTest {
    @Test
    void ensureThatPathFromTempDirIsWritable(@TempDir Path path){
        assertTrue(Files.isWritable(path));
    }
    @Test
    void ensureThatNonExistingFileThrowsAnException(@TempDir Path path){
        Path file = path.resolve("content.txt");
        assertThrows(IOException.class, () ->{
            FileWriter.appendFile(file, "Hello");
        });
    }
    @Test
    void ensureAppendingWorks(@TempDir Path path) throws IOException {
        Path file = path.resolve("content.txt");
        FileWriter.createFile(file);
        FileWriter.appendFile(file, "Hello");
        assertTrue(Files.isReadable(file));
        assertEquals("Hello", Files.readString(file));
    }

}
