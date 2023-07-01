package br.com.fiap.hackaton.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class MovieDto {
    @JsonProperty("id")
    Long id;
    @JsonProperty("title")
    String title;
    @JsonProperty("description")
    String description;
    @JsonProperty("category")
    String category;
    @JsonProperty("cover_uri")
    String coverUri;
    @JsonProperty("video_uri")
    String videoUri;
    @JsonProperty("release_date")
    Date releaseDate;
}
