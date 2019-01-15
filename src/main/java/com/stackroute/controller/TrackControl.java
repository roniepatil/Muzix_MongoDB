package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/")
public class TrackControl {
    @Autowired
    private TrackService trackService;

    public TrackControl(TrackService trackService) {
        this.trackService = trackService;
    }

    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }



    //@ApiOperation(value = "Saves track in database")
    @RequestMapping(value = "track", method= RequestMethod.POST)
    public ResponseEntity<Track> saveTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try {
            Track trackOne = trackService.saveTrack(track);
            responseEntity = new ResponseEntity<Track>(track, HttpStatus.CREATED);
        } catch (TrackAlreadyExistsException ex)
        {
            responseEntity = new ResponseEntity <String>(ex.getMessage(),HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;

    }



   // @ApiOperation(value = "Gets all tracks from database")
    @RequestMapping(value = "tracks", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> showAllTracks() {
        List<Track > trackOne = trackService.showAllTracks();
        return new ResponseEntity<List<Track>>(trackOne, HttpStatus.OK);
    }


   // @ApiOperation(value = "Update comment of a track")
    @RequestMapping(value = "track", method= RequestMethod.PUT)
    public ResponseEntity<Track> updateTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try {
            Track trackOne = trackService.updateComment(track);
            return new ResponseEntity<Track>(trackOne, HttpStatus.OK);
        }catch (TrackNotFoundException ex)
        {
            responseEntity = new ResponseEntity <String>(ex.getMessage(),HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;

    }


    //@ApiOperation(value = "Deletes a track from database")
    @RequestMapping(value = "track", method= RequestMethod.DELETE)
    public ResponseEntity<String > deleteTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try {
            boolean answer = trackService.deleteTrack(track);
            return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        }catch (TrackNotFoundException ex)
        {
            responseEntity = new ResponseEntity <String>(ex.getMessage(),HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;

    }


 /*
    @RequestMapping(value = "track/{trackName}", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> getTrackByName(@PathVariable("trackName") String trackName) throws Exception {
        List<Track> trackOne = trackService.getTrackByName(trackName);
        return new ResponseEntity<List<Track>>(trackOne, HttpStatus.OK);
    }
*/

}
