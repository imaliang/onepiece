package link.aliang.onepiece.core;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

/**
 * @Description: TMDB工具
 * @Author: aliang
 * @Date: 2022-12-17 17:33
 */
public class TMDBUtils {

    private final static String LANGUAGE = "zh-CN";
    private final static String API_KEY = System.getenv("TMDB_API_KEY");
    public static final String TMDB_API_DOMAIN = "https://api.themoviedb.org";
    public static final String TMDB_IMAGE_W454_H254 = "https://image.tmdb.org/t/p/w454_and_h254_bestv2";
    public static final String TMDB_IMAGE_W188_H282 = "https://image.tmdb.org/t/p/w188_and_h282_bestv2";
    public static final String TMDB_IMAGE_W300_H450 = "https://image.tmdb.org/t/p/w300_and_h450_bestv2";

    /**
     * 根据tv_id获取剧集详情
     *
     * @param tv_id id
     * @return {@link TmdbTv}
     */
    public static TmdbTv getTv(String tv_id) {
        String url = TMDB_API_DOMAIN + "/3/tv/" + tv_id + "?api_key=" + API_KEY + "&language=" + LANGUAGE;
        String dataStr = HttpUtil.get(url);
        return JSONObject.parseObject(dataStr, TmdbTv.class);
    }

    /**
     * 根据tv_id和季号获取季详情
     *
     * @param seasonNumber {@link TmdbTv.SeasonsDTO#getSeasonNumber()}
     * @param tv_id        {@link TmdbTv#getId()}
     * @return {@link TmdbTvSeasons}
     */
    public static TmdbTvSeasons getTvSeasons(Integer seasonNumber, String tv_id) {
        String url = TMDB_API_DOMAIN + "/3/tv/" + tv_id + "/season/" + seasonNumber + "?api_key=" + API_KEY + "&language=" + LANGUAGE;
        String dataStr = HttpUtil.get(url);
        return JSONObject.parseObject(dataStr, TmdbTvSeasons.class);
    }

    /**
     * 根据系列id获取系列详情
     *
     * @param collection_id 系列id
     * @return {@link TmdbCollections}
     */
    public static TmdbCollections getCollections(String collection_id) {
        String url = TMDB_API_DOMAIN + "/3/collection/" + collection_id + "?api_key=" + API_KEY + "&language=" + LANGUAGE;
        String dataStr = HttpUtil.get(url);
        return JSONObject.parseObject(dataStr, TmdbCollections.class);
    }

    /**
     * 获取 188x282 的图片地址
     *
     * @param path 路径
     * @return 图片地址
     */
    public static String getImgUrl_188x282(String path) {
        return TMDB_IMAGE_W188_H282 + path;
    }

    /**
     * 获取 300x450 的图片地址
     *
     * @param path 路径
     * @return 图片地址
     */
    public static String getImgUrl_300x450(String path) {
        return TMDB_IMAGE_W300_H450 + path;
    }

    /**
     * 获取 454x254 的图片地址
     *
     * @param path 路径
     * @return 图片地址
     */
    public static String getImgUrl_454x254(String path) {
        return TMDB_IMAGE_W454_H254 + path;
    }


}
