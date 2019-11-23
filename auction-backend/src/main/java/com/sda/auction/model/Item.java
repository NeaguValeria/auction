package com.sda.auction.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "item")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int startingPrice;
    @Column
    private Date startDate;
    @Column
    private Date endDate;

    @Column
    private String category;

    @Lob
    @Column
    private String photo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<Bid> bids = new HashSet<>();
}
