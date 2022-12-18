package link.aliang.onepiece.core;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TmdbTvSeasons
 * @Author: aliang
 * @Date: 2022-12-17 18:31
 */
@NoArgsConstructor
@Data
public class TmdbTvSeasons {

    @JSONField(name = "_id")
    private String _id;
    @JSONField(name = "air_date")
    private String airDate;
    @JSONField(name = "episodes")
    private List<EpisodesDTO> episodes;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "overview")
    private String overview;
    @JSONField(name = "id")
    private Integer id;
    @JSONField(name = "poster_path")
    private String posterPath;
    @JSONField(name = "season_number")
    private Integer seasonNumber;

    @NoArgsConstructor
    @Data
    public static class EpisodesDTO {
        @JSONField(name = "air_date")
        private String airDate;
        @JSONField(name = "episode_number")
        private Integer episodeNumber;
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "overview")
        private String overview;
        @JSONField(name = "production_code")
        private String productionCode;
        @JSONField(name = "runtime")
        private Integer runtime;
        @JSONField(name = "season_number")
        private Integer seasonNumber;
        @JSONField(name = "show_id")
        private Integer showId;
        @JSONField(name = "still_path")
        private String stillPath;
        @JSONField(name = "vote_average")
        private Double voteAverage;
        @JSONField(name = "vote_count")
        private Integer voteCount;
        @JSONField(name = "crew")
        private List<CrewDTO> crew;
        @JSONField(name = "guest_stars")
        private List<?> guestStars;

        @NoArgsConstructor
        @Data
        public static class CrewDTO {
            @JSONField(name = "job")
            private String job;
            @JSONField(name = "department")
            private String department;
            @JSONField(name = "credit_id")
            private String creditId;
            @JSONField(name = "adult")
            private Boolean adult;
            @JSONField(name = "gender")
            private Integer gender;
            @JSONField(name = "id")
            private Integer id;
            @JSONField(name = "known_for_department")
            private String knownForDepartment;
            @JSONField(name = "name")
            private String name;
            @JSONField(name = "original_name")
            private String originalName;
            @JSONField(name = "popularity")
            private Double popularity;
            @JSONField(name = "profile_path")
            private Object profilePath;
        }
    }
}
