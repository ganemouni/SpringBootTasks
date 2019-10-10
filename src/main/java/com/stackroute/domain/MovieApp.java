package com.stackroute.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity(name = "movie")
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieApp {

    @Id
  //@GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @ApiModelProperty
    //@Getter
    String id;
//    @PrePersist
//    private void generateCodeIdentifier(){
//        setId("ff8081816db46343016db4634cfe0000");
//    }



    @ApiModelProperty
    String title;
    @ApiModelProperty
    String genre;
    @ApiModelProperty
    String language;
}
//    public MovieApp() {
//    }
//
//    public MovieApp(String id, String title, String genre, String language) {
//        this.id = id;
//        this.title = title;
//        this.genre = genre;
//        this.language = language;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//
//
//    @Override
//    public String toString() {
//        return "MovieApp{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", genre='" + genre + '\'' +
//                ", language='" + language + '\'' +
//                '}';
//    }


