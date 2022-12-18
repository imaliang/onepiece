package link.aliang.onepiece.core;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TmdbTv
 * @Author: aliang
 * @Date: 2022-12-17 18:26
 */
@NoArgsConstructor
@Data
public class TmdbTv {

    @JSONField(name = "adult")
    private Boolean adult;
    @JSONField(name = "backdrop_path")
    private String backdropPath;
    @JSONField(name = "created_by")
    private List<?> createdBy;
    @JSONField(name = "episode_run_time")
    private List<Integer> episodeRunTime;
    @JSONField(name = "first_air_date")
    private String firstAirDate;
    @JSONField(name = "genres")
    private List<GenresDTO> genres;
    @JSONField(name = "homepage")
    private String homepage;
    @JSONField(name = "id")
    private Integer id;
    @JSONField(name = "in_production")
    private Boolean inProduction;
    @JSONField(name = "languages")
    private List<String> languages;
    @JSONField(name = "last_air_date")
    private String lastAirDate;
    @JSONField(name = "last_episode_to_air")
    private LastEpisodeToAirDTO lastEpisodeToAir;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "next_episode_to_air")
    private NextEpisodeToAirDTO nextEpisodeToAir;
    @JSONField(name = "networks")
    private List<NetworksDTO> networks;
    @JSONField(name = "number_of_episodes")
    private Integer numberOfEpisodes;
    @JSONField(name = "number_of_seasons")
    private Integer numberOfSeasons;
    @JSONField(name = "origin_country")
    private List<String> originCountry;
    @JSONField(name = "original_language")
    private String originalLanguage;
    @JSONField(name = "original_name")
    private String originalName;
    @JSONField(name = "overview")
    private String overview;
    @JSONField(name = "popularity")
    private Double popularity;
    @JSONField(name = "poster_path")
    private String posterPath;
    @JSONField(name = "production_companies")
    private List<ProductionCompaniesDTO> productionCompanies;
    @JSONField(name = "production_countries")
    private List<ProductionCountriesDTO> productionCountries;
    @JSONField(name = "seasons")
    private List<SeasonsDTO> seasons;
    @JSONField(name = "spoken_languages")
    private List<SpokenLanguagesDTO> spokenLanguages;
    @JSONField(name = "status")
    private String status;
    @JSONField(name = "tagline")
    private String tagline;
    @JSONField(name = "type")
    private String type;
    @JSONField(name = "vote_average")
    private Double voteAverage;
    @JSONField(name = "vote_count")
    private Integer voteCount;

    @NoArgsConstructor
    @Data
    public static class LastEpisodeToAirDTO {
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
        private Object runtime;
        @JSONField(name = "season_number")
        private Integer seasonNumber;
        @JSONField(name = "show_id")
        private Integer showId;
        @JSONField(name = "still_path")
        private String stillPath;
        @JSONField(name = "vote_average")
        private Integer voteAverage;
        @JSONField(name = "vote_count")
        private Integer voteCount;
    }

    @NoArgsConstructor
    @Data
    public static class NextEpisodeToAirDTO {
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
        private Object runtime;
        @JSONField(name = "season_number")
        private Integer seasonNumber;
        @JSONField(name = "show_id")
        private Integer showId;
        @JSONField(name = "still_path")
        private Object stillPath;
        @JSONField(name = "vote_average")
        private Integer voteAverage;
        @JSONField(name = "vote_count")
        private Integer voteCount;
    }

    @NoArgsConstructor
    @Data
    public static class GenresDTO {
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class NetworksDTO {
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "logo_path")
        private String logoPath;
        @JSONField(name = "origin_country")
        private String originCountry;
    }

    @NoArgsConstructor
    @Data
    public static class ProductionCompaniesDTO {
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "logo_path")
        private String logoPath;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "origin_country")
        private String originCountry;
    }

    @NoArgsConstructor
    @Data
    public static class ProductionCountriesDTO {
        @JSONField(name = "iso_3166_1")
        private String iso31661;
        @JSONField(name = "name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class SeasonsDTO {
        @JSONField(name = "air_date")
        private String airDate;
        @JSONField(name = "episode_count")
        private Integer episodeCount;
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "overview")
        private String overview;
        @JSONField(name = "poster_path")
        private String posterPath;
        @JSONField(name = "season_number")
        private Integer seasonNumber;
    }

    @NoArgsConstructor
    @Data
    public static class SpokenLanguagesDTO {
        @JSONField(name = "english_name")
        private String englishName;
        @JSONField(name = "iso_639_1")
        private String iso6391;
        @JSONField(name = "name")
        private String name;
    }
}
