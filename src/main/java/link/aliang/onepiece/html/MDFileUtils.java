package link.aliang.onepiece.html;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description: HtmlFileUtils
 * @Author: aliang
 * @Date: 2022-12-18 13:13
 */
public class MDFileUtils {

    private static final Path ONEPIECE_README_ROOT = Paths.get("README.md");
    private static final Path ONEPIECE_MD_INDEX_TEMPLATE = Paths.get("template/README.md");

    public static String readIndexTemplateFile() throws IOException {
        byte[] bytes = Files.readAllBytes(ONEPIECE_MD_INDEX_TEMPLATE);
        return new String(bytes);
    }

    public static void writeYml(String content, String name) throws IOException {
        Path path = ONEPIECE_README_ROOT.resolve(name + ".md");
        write(path, content);
    }

    public static void writeReadme(String content) throws IOException {
        write(ONEPIECE_README_ROOT, content);
    }

    public static void write(Path path, String content) throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
    }

}
