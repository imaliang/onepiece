package link.aliang.onepiece.html;

import link.aliang.onepiece.core.TMDBUtils;
import link.aliang.onepiece.core.TmdbCollections;
import link.aliang.onepiece.core.TmdbTv;
import link.aliang.onepiece.core.TmdbTvSeasons;

import java.util.Objects;

/**
 * @Description: HtmlFileUtils
 * @Author: aliang
 * @Date: 2022-12-17 20:33
 */
public class HtmlConstant {

    public static final String IMG_TOC_LIST = "${IMG_TOC_LIST}";
    public static final String IMG_CARD_LIST = "${IMG_CARD_LIST}";
    public static final String MOVIE_COUNT = "${MOVIE_COUNT}";


    /**
     * movie
     */
    public static class MovieHtml {
        public static final String MOVIE_TITLE = "${TOC_TITLE}";
        private static final String MOVIE_DATE = "${MOVIE_DATE}";
        private static final String MOVIE_IMG_URL = "${MOVIE_IMG_URL}";
        private static final String MOVIE_INTRO = "${MOVIE_INTRO}";
        private static final String MOVIE_STAR = "${MOVIE_STAR}";

        private static final String MOVIE_DIV = "<div class=\"media\">"
                + "<div class=\"media-cover\" style=\"background-image:url(" + MOVIE_IMG_URL + ")\"></div>"
                + "<div class=\"media-meta\">"
                + "<div class=\"media-meta-item title\">" + MOVIE_TITLE + "</div>"
                + "<div class=\"media-meta-item\"><span class=\"author\">上映日期：" + MOVIE_DATE + "</span><span class=\"star-score\">" + MOVIE_STAR + "</span></div>"
                + "<div class=\"media-meta-item intro\">" + MOVIE_INTRO + "</div>"
                + "</div>"
                + "</div>";

        public static String getHtml(TmdbCollections.PartsDTO dto) {
            return MOVIE_DIV
                    .replace(MOVIE_TITLE, dto.getTitle())
                    .replace(MOVIE_DATE, dto.getReleaseDate())
                    .replace(MOVIE_IMG_URL, TMDBUtils.getImgUrl_454x254(dto.getBackdropPath()))
                    .replace(MOVIE_INTRO, dto.getOverview())
                    .replace(MOVIE_STAR, getStar(dto.getVoteAverage()))
                    ;
        }
    }

    /**
     * 目录
     */
    public static class TvEpisodesTocHtml {
        public static final String TOC_TITLE = "${TOC_TITLE}";
        private static final String TOC_COUNT = "${TOC_COUNT}";
        private static final String TOC_HREF = "${TOC_HREF}";
        private static final String TOC_SELECTED = "${TOC_SELECTED}";
        private static final String TOC_DIV = "<div class=\"post-toc " + TOC_SELECTED + "\">"
                + "<span class=\"post-toc-bt bt1\"><a href=\"" + TOC_HREF + "\">" + TOC_TITLE + "</a></span>"
                + "<span class=\"post-toc-bt bt2\">共" + TOC_COUNT + "集</span>&nbsp;"
                + "</div>";

        public static String getHtml(TmdbTv.SeasonsDTO dto, Integer seasonNumber) {
            return TOC_DIV
                    .replace(TOC_SELECTED, Objects.equals(seasonNumber, dto.getSeasonNumber()) ? "selected" : "")
                    .replace(TOC_TITLE, dto.getName())
                    .replace(TOC_COUNT, dto.getEpisodeCount() + "")
                    .replace(TOC_HREF, (Objects.equals(seasonNumber, 999) ? "op/" : "") + getSeasonNum(dto.getSeasonNumber()) + ".html")
                    ;
        }
    }

    /**
     * 集
     */
    public static class TvEpisodesHtml {

        private static final String EP_IMG_URL = "${EP_IMG_URL}";
        public static final String EP_TITLE = "${EP_TITLE}";
        private static final String EP_DATE = "${EP_DATE}";
        private static final String EP_STAR = "${EP_STAR}";
        private static final String EP_INTRO = "${EP_INTRO}";
        private static final String IMG_CARD = "<div class=\"media\">\n" +
                "                    <div class=\"media-cover\"\n" +
                "                         style=\"background-image:url(" + EP_IMG_URL + ")\"></div>\n" +
                "                    <div class=\"media-meta\">\n" +
                "                        <div class=\"media-meta-item title\">" + EP_TITLE + "</div>\n" +
                "                        <div class=\"media-meta-item\"><span class=\"author\">" + EP_DATE + "</span><span class=\"star-score\">" + EP_STAR + "</span>\n" +
                "                        </div>\n" +
                "                        <div class=\"media-meta-item intro\">" + EP_INTRO + "</div>\n" +
                "                    </div>\n" +
                "                </div>";

        public static String getHtml(TmdbTvSeasons.EpisodesDTO dto) {
            return IMG_CARD
                    .replace(EP_IMG_URL, TMDBUtils.getImgUrl_454x254(dto.getStillPath()))
                    .replace(EP_TITLE, getTitle(dto))
                    .replace(EP_INTRO, dto.getOverview())
                    .replace(EP_DATE, "播出日期：" + dto.getAirDate())
                    .replace(EP_STAR, getStar(dto.getVoteAverage()))
                    ;
        }

        private static String getTitle(TmdbTvSeasons.EpisodesDTO dto) {
            String seasonNumber = dto.getSeasonNumber() < 10 ? "0" + dto.getSeasonNumber() : "" + dto.getSeasonNumber();
            String episodeNumber = "";
            if (dto.getSeasonNumber() == 0) {
                if (dto.getEpisodeNumber() < 10) {
                    episodeNumber = "0" + dto.getEpisodeNumber();
                } else {
                    episodeNumber = "" + dto.getEpisodeNumber();
                }
            } else {
                if (dto.getEpisodeNumber() < 10) {
                    episodeNumber = "000" + dto.getEpisodeNumber();
                } else if (dto.getEpisodeNumber() < 100) {
                    episodeNumber = "00" + dto.getEpisodeNumber();
                } else if (dto.getEpisodeNumber() < 1000) {
                    episodeNumber = "0" + dto.getEpisodeNumber();
                } else {
                    episodeNumber = "" + dto.getEpisodeNumber();
                }
            }
            return "海贼王.S" + seasonNumber + "E" + episodeNumber + "." + dto.getName();
        }

    }

    private static String getStar(Double value) {
        int num = value.intValue() / 2;
        switch (num) {
            case 0:
                return "★";
            case 1:
                return "★★";
            case 2:
                return "★★★";
            case 3:
                return "★★★★";
            default:
                return "★★★★★";
        }
    }

    public static String getSeasonNum(Integer seasonNumber) {
        if (seasonNumber < 10) {
            return "S0" + seasonNumber;
        }
        return "S" + seasonNumber;
    }

}
