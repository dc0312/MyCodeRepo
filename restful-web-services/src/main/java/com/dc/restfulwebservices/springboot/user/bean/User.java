package com.dc.restfulwebservices.springboot.user.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "All information about the User")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @ApiModelProperty(notes = "Name should be minimum length of 2.")
    @Size(min=2,message = "Name should be minimum length of 2.")
    private String name;
    @ApiModelProperty(notes = "Date should be in past.")
    @Past
    private Date date;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
