package com.example.seedtrackingtracing.dataobjects;

import java.util.Date;

public class QdsReg {
    public String seed_producer;
    public String loction_of_farm;
    public Integer years_of_experience;
    public Integer grower_number;
    public String cropping_history;

    public QdsReg(String seed_producer, String loction_of_farm, Integer years_of_experience, Integer grower_number, String cropping_history, String adequate_isolation, String certified_seed_awareness, Date appliction_date) {
        this.seed_producer = seed_producer;
        this.loction_of_farm = loction_of_farm;
        this.years_of_experience = years_of_experience;
        this.grower_number = grower_number;
        this.cropping_history = cropping_history;
        this.adequate_isolation = adequate_isolation;
        this.certified_seed_awareness = certified_seed_awareness;
        this.appliction_date = appliction_date;
    }

    public String adequate_isolation;
    public String certified_seed_awareness;
    public Date appliction_date;
}
