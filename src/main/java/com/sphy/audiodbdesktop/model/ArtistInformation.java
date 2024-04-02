package com.sphy.audiodbdesktop.model;


import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistInformation {

    int idArtist;
    String name;
    Image image_size_small;
    List<Tag> tags;
    String summary;
    //List<Album> albums;
    //List<String> similarArtist;


}
