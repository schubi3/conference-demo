package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long session_id;
    @Getter @Setter private String session_name;
    @Getter @Setter private String session_description;
    @Getter @Setter private Integer session_length;
    @ManyToMany
    @JoinTable(
            name = "session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id"))
    @Getter @Setter private List<Speaker> speakers;
    public Session() {
    }

}
