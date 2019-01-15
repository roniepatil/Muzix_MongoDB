package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


@Repository
public interface TrackRepository extends MongoRepository<Track,Integer> {

//  @Query(value = "select * from Track where trackName = ?2")
//  public List<Track> getTrackByName(String trackName);

}
