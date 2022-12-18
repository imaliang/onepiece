package link.aliang.onepiece.core;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TmdbCollections
 * @Author: aliang
 * @Date: 2022-12-17 18:56
 */
@NoArgsConstructor
@Data
public class TmdbCollections {

    @JSONField(name = "id")
    private Integer id;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "overview")
    private String overview;
    @JSONField(name = "poster_path")
    private String posterPath;
    @JSONField(name = "backdrop_path")
    private String backdropPath;
    @JSONField(name = "parts")
    private List<PartsDTO> parts;

    @NoArgsConstructor
    @Data
    public static class PartsDTO {
        @JSONField(name = "adult")
        private Boolean adult;
        @JSONField(name = "backdrop_path")
        private String backdropPath;
        @JSONField(name = "genre_ids")
        private List<Integer> genreIds;
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "original_language")
        private String originalLanguage;
        @JSONField(name = "original_title")
        private String originalTitle;
        @JSONField(name = "overview")
        private String overview;
        @JSONField(name = "popularity")
        private Double popularity;
        @JSONField(name = "poster_path")
        private String posterPath;
        @JSONField(name = "release_date")
        private String releaseDate;
        @JSONField(name = "title")
        private String title;
        @JSONField(name = "video")
        private Boolean video;
        @JSONField(name = "vote_average")
        private Double voteAverage;
        @JSONField(name = "vote_count")
        private Integer voteCount;
    }
}
