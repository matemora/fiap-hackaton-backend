package br.com.fiap.hackaton.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 1024)
    private String description;

    @Column(name = "category", nullable = false, length = 200)
    private String category;

    @Column(name = "cover_uri", nullable = false)
    private String coverUri;

    @Column(name = "video_uri", nullable = false)
    private String videoUri;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;
}
