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
    @ApiModelProperty
    String id;
    @ApiModelProperty
    String title;
    @ApiModelProperty
    String genre;
    @ApiModelProperty
    String language;
}
