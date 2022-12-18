package link.aliang.onepiece.html;


import cn.hutool.core.collection.CollUtil;
import link.aliang.onepiece.core.TMDBUtils;
import link.aliang.onepiece.core.TmdbCollections;
import link.aliang.onepiece.core.TmdbTv;
import link.aliang.onepiece.core.TmdbTvSeasons;
import link.aliang.onepiece.util.ProxyUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: HtmlFileUtils
 * @Author: aliang
 * @Date: 2022-12-17 21:26
 */
@Slf4j
public class OnePieceGenerator {

    private static final String DOMAIN = "https://onepiece.aliang.link/";

    public static void main(String[] args) throws IOException {
        ProxyUtil.init();
        generatorAll();
    }

    public static void generatorAll() throws IOException {
        TmdbCollections collections = TMDBUtils.getCollections("23456");
        TmdbTv tv = TMDBUtils.getTv("37854");
        List<TmdbTv.SeasonsDTO> seasons = tv.getSeasons();
        movieHtmlGenerator(collections, seasons);
        readmeMdGenerator(collections, seasons);
        for (TmdbTv.SeasonsDTO season : seasons) {
            TmdbTvSeasons tvSeasons = TMDBUtils.getTvSeasons(season.getSeasonNumber(), "37854");
            if (CollUtil.isEmpty(tvSeasons.getEpisodes())) {
                continue;
            }
            episodesHtmlGenerator(tvSeasons, seasons, collections.getParts().size());
        }
    }

    public static void readmeMdGenerator(TmdbCollections collections, List<TmdbTv.SeasonsDTO> list) throws IOException {
        String content = MDFileUtils.readIndexTemplateFile();
        // 组装内容
        StringBuilder cardList = new StringBuilder();
        String clo1 = "| ![VAR_A](VAR_A) <br> [VAR_B 共VAR_C集](VAR_D) ";
        cardList.append("|  -  |  -  |  -  | \n");
        cardList.append("|:---:|:---:|:---:| \n");
        cardList.append(clo1
                .replace("VAR_A", TMDBUtils.getImgUrl_188x282("/4floYRInCRdi6Nk85lLQzGPbV5K.jpg"))
                .replace("VAR_B", "剧场版")
                .replace("VAR_C", "" + collections.getParts().size())
                .replace("VAR_D", DOMAIN + "index.html")
        );
        //List<TmdbTv.SeasonsDTO> sortList = list.stream().sorted(Comparator.comparing(TmdbTv.SeasonsDTO::getSeasonNumber, Comparator.reverseOrder())).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            int ii = i % 3;
            String clo = " ![VAR_A](VAR_A) <br> [VAR_B 共VAR_C集](VAR_D) ";
            if (ii == 0 || ii == 2) {
                clo = "|" + clo;
            }
            if (ii == 1) {
                clo = "|" + clo + "| \n";
            }
            TmdbTv.SeasonsDTO dto = list.get(i);
            cardList.append(clo
                    .replace("VAR_A", TMDBUtils.getImgUrl_188x282(dto.getPosterPath()))
                    .replace("VAR_B", dto.getName())
                    .replace("VAR_C", "" + dto.getEpisodeCount())
                    .replace("VAR_D", DOMAIN + "op/" + HtmlConstant.getSeasonNum(dto.getSeasonNumber()) + ".html")
            );
        }
        int num = (list.size() + 1) % 3;
        if (num == 1) {
            cardList.append("| - | - | \n");
        }
        if (num == 2) {
            cardList.append("| - | \n");
        }
        content += cardList;
        // 写到文件
        MDFileUtils.writeReadme(content);
        log.info("生成README.md成功");
    }

    public static void movieHtmlGenerator(TmdbCollections collections, List<TmdbTv.SeasonsDTO> seasons) throws IOException {
        String templateFile = HtmlFileUtils.readMovieTemplateFile();
        // 剧场版总计
        String html = templateFile.replace(HtmlConstant.MOVIE_COUNT, collections.getParts().size() + "");
        // 替换目录
        html = replaceTvTocList(html, seasons, 999);
        // 替换季列表
        html = replaceCollectionsList(html, collections);
        // 写到文件
        HtmlFileUtils.writeIndexHtml(html, "index");
        log.info("{} 生成html成功", collections.getName());
    }

    public static void episodesHtmlGenerator(TmdbTvSeasons tvSeasons, List<TmdbTv.SeasonsDTO> seasons, int movieCount) throws IOException {
        String templateFile = HtmlFileUtils.readEpisodesTemplateFile();
        String html = templateFile.replace(HtmlConstant.MOVIE_COUNT, movieCount + "");
        // 替换目录
        html = replaceTvTocList(html, seasons, tvSeasons.getSeasonNumber());
        // 替换剧集列表
        html = replaceTvEpisodesList(html, tvSeasons.getEpisodes());
        // 写到文件
        HtmlFileUtils.writeHtml(html, HtmlConstant.getSeasonNum(tvSeasons.getSeasonNumber()));
        log.info("{} 生成html成功", tvSeasons.getName());
    }


    private static String replaceTvTocList(String html, List<TmdbTv.SeasonsDTO> list, Integer seasonNumber) {
        StringBuilder imgList = new StringBuilder();
        for (TmdbTv.SeasonsDTO dto : list) {
            imgList.append(HtmlConstant.TvEpisodesTocHtml.getHtml(dto, seasonNumber));
        }
        return html.replace(HtmlConstant.IMG_TOC_LIST, imgList);
    }

    private static String replaceTvEpisodesList(String html, List<TmdbTvSeasons.EpisodesDTO> episodes) {
        StringBuilder imgList = new StringBuilder();
        for (TmdbTvSeasons.EpisodesDTO dto : episodes) {
            imgList.append(HtmlConstant.TvEpisodesHtml.getHtml(dto));
        }
        return html.replace(HtmlConstant.IMG_CARD_LIST, imgList);
    }

    private static String replaceCollectionsList(String html, TmdbCollections collections) {
        StringBuilder imgList = new StringBuilder();
        List<TmdbCollections.PartsDTO> list = collections.getParts();
        List<TmdbCollections.PartsDTO> sortList = list.stream().sorted(Comparator.comparing(TmdbCollections.PartsDTO::getReleaseDate, Comparator.reverseOrder())).collect(Collectors.toList());
        for (TmdbCollections.PartsDTO dto : sortList) {
            imgList.append(HtmlConstant.MovieHtml.getHtml(dto));
        }
        return html.replace(HtmlConstant.IMG_CARD_LIST, imgList);
    }


}
