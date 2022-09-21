/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 21-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.service.database;


import com.niit.jdp.model.Song;

import java.util.Comparator;
import java.util.List;

public class SongService {

    public List<Song> sortSongNameInAlphabeticalOrder(List<Song> serviceData) {
        Comparator<Song> songNameComparator = (((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getSongName(), o2.getSongName())));
        serviceData.sort(songNameComparator);
        for (Song songName : serviceData)
            System.out.println(songName.getSongName());
        return serviceData;
    }
}
