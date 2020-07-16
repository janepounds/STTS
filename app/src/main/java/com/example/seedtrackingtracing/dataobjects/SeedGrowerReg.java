package com.example.seedtrackingtracing.dataobjects;

public class SeedGrowerReg {
    public String seed_grower;
    public Integer years_of_experience;
    public String crop;
    public String crop_variety;
    public Integer number_of_hectares;
    public String source_of_seed;
    public Integer grower_number;
    public String last_crops_of_season;

    public SeedGrowerReg(String seed_grower, Integer years_of_experience, String crop, String crop_variety, Integer number_of_hectares, String source_of_seed, Integer grower_number, String last_crops_of_season, String adequate_isolation, String adequate_labour, String certified_seed_awareness) {
        this.seed_grower = seed_grower;
        this.years_of_experience = years_of_experience;
        this.crop = crop;
        this.crop_variety = crop_variety;
        this.number_of_hectares = number_of_hectares;
        this.source_of_seed = source_of_seed;
        this.grower_number = grower_number;
        this.last_crops_of_season = last_crops_of_season;
        this.adequate_isolation = adequate_isolation;
        this.adequate_labour = adequate_labour;
        this.certified_seed_awareness = certified_seed_awareness;
    }

    public String adequate_isolation;
    public String adequate_labour;
    public String certified_seed_awareness;


    public SeedGrowerReg() {

    }

}
