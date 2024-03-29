package com.sda.auction.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@EqualsAndHashCode
@Data
public class ItemDto {

    private Integer id;

    @NotEmpty(message = "Please insert item's name")
    @Pattern(regexp = "[A-Za-z ]+", message = "Letters and spaces only!")
    private String name;

    @NotEmpty(message = "Please insert item's description")
    private String description;

    @Positive
    private int startingPrice;

    private int currentPrice;

    @NotEmpty
    private String category;

    @NotEmpty
    private String startDate;

    @NotEmpty
    private String endDate;

    @NotEmpty
    private String photo;

    private String owner;

    public void resetOwner() {
        owner = null;
    }

    private int myLastBidValue;
}
