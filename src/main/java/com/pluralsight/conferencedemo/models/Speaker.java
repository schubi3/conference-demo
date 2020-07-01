package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name="speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Speaker {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long speaker_id;
    @Getter @Setter private String first_name;
    @Getter @Setter private String last_name;
    @Getter @Setter private String title;
    @Getter @Setter private String company;
    @Getter @Setter private String speaker_bio;

    @Lob //large object: binary data
    @Type(type="org.hibernate.type.BinaryType") //helps hibernate dealing with large objects (hibernate = persistence api)
    @Getter @Setter private byte[] speaker_photo;

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    @Getter @Setter private List<Session> sessions;

    public Speaker() {
    }
}
