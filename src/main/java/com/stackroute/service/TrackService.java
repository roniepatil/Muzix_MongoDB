package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> showAllTracks();
    public Track updateComment(Track track) throws TrackNotFoundException;
    public boolean deleteTrack(Track track) throws TrackNotFoundException;
    //public List<Track> getTrackByName(String trackName) throws TrackNotFoundException;
}
