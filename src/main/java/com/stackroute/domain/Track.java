package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data //Using lombok to handle the getter setters
@NoArgsConstructor //Creates a zero argument constructor
@AllArgsConstructor //Creates an all argument constructor
@Builder
@Document(collection="Track")
public class Track {
    @Id
    private int trackID;


    private String trackName;


    private String comments;

}
