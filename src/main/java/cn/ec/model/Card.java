package cn.ec.model;

import lombok.Data;

import java.util.Date;
@Data
public class Card {

    private Integer id;

    private String pid;

    private Date issuedDate;

    private Date deadline;

    private User user;

}
