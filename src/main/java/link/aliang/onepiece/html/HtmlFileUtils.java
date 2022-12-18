package link.aliang.onepiece.html;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description: HtmlFileUtils
 * @Author: aliang
 * @Date: 2022-12-17 20:55
 */
public class HtmlFileUtils {

    private static final Path ONEPIECE_HTML_ROOT = Paths.get("docs/op/");
    private static final Path ONEPIECE_MOVIE_ROOT = Paths.get("docs/");
    private static final Path ONEPIECE_EPISODES_HTML_TEMPLATE = Paths.get("template/onepiece-episodes-template.html");
    private static final Path ONEPIECE_MOVIE_HTML_TEMPLATE = Paths.get("template/onepiece-movie-template.html");


    public static String readMovieTemplateFile() throws IOException {
        byte[] bytes = Files.readAllBytes(ONEPIECE_MOVIE_HTML_TEMPLATE);
        return new String(bytes);
    }

    public static String readEpisodesTemplateFile() throws IOException {
        byte[] bytes = Files.readAllBytes(ONEPIECE_EPISODES_HTML_TEMPLATE);
        return new String(bytes);
    }

    public static void writeHtml(String html, String htmlName) throws IOException {
        Path path = ONEPIECE_HTML_ROOT.resolve(htmlName + ".html");
        if (!Files.exists(ONEPIECE_HTML_ROOT)) {
            Files.createDirectory(ONEPIECE_HTML_ROOT);
        }
        MDFileUtils.write(path, html);
    }

    public static void writeIndexHtml(String html, String htmlName) throws IOException {
        Path path = ONEPIECE_MOVIE_ROOT.resolve(htmlName + ".html");
        MDFileUtils.write(path, html);
    }


}
