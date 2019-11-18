package com.sda.auction.dto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@EqualsAndHashCode
public class ItemDto {

    private int id;
    @NotEmpty(message = "{error.item.name.notEmpty}")
    @Pattern(regexp = "[A-Za-z]+", message = "{error.item.name.pattern}")
    private String name;

    @NotEmpty(message = "{error.item.description.notEmpty}")
    private String description;

    @Positive
    @NotEmpty(message = "{error.item.startingPrice.notEmpty}")
    private int startingPrice;

    @NotEmpty(message = "{error.item.startDate.notEmpty}")
    private String startDate;

    @NotEmpty(message = "{error.item.endDate.notEmpty}")
    private String endDate;

    @NotEmpty(message = "{error.item.category.notEmpty}")
    private String category;

}
