package com.example.seedtrackingtracing.dataobjects;

public class MerchantRegInfo {
    public String seed_merchant;
    public Integer years_of_experience;
    public String years_of_experience_as;
    public String application_production;
    public String production_other_crops;
    public String application_processing;
    public String process_other_crops;
    public String application_marketing;
    public String marketing_other_crops;
    public String adequate_lnd_for_basic_needs;
    public String contractual_agreement;
    public String adequate_field_officers;
    public String knowledgeable_personnel;
    public String source_of_breeder_seed;
    public String source_of_basic_seed;
    public String adequate_land_production_basic_seed;
    public String internal_quality_program;

    public MerchantRegInfo() {

    }

    public MerchantRegInfo(String seed_merchant, Integer years_of_experience, String years_of_experience_as, String application_production, String production_other_crops, String application_processing, String process_other_crops, String application_marketing, String marketing_other_crops, String adequate_lnd_for_basic_needs, String contractual_agreement, String adequate_field_officers, String knowledgeable_personnel, String source_of_breeder_seed, String source_of_basic_seed, String adequate_land_production_basic_seed, String internal_quality_program) {
        this.seed_merchant = seed_merchant;
        this.years_of_experience = years_of_experience;
        this.years_of_experience_as = years_of_experience_as;
        this.application_production = application_production;
        this.production_other_crops = production_other_crops;
        this.application_processing = application_processing;
        this.process_other_crops = process_other_crops;
        this.application_marketing = application_marketing;
        this.marketing_other_crops = marketing_other_crops;
        this.adequate_lnd_for_basic_needs = adequate_lnd_for_basic_needs;
        this.contractual_agreement = contractual_agreement;
        this.adequate_field_officers = adequate_field_officers;
        this.knowledgeable_personnel = knowledgeable_personnel;
        this.source_of_breeder_seed = source_of_breeder_seed;
        this.source_of_basic_seed = source_of_basic_seed;
        this.adequate_land_production_basic_seed = adequate_land_production_basic_seed;
        this.internal_quality_program = internal_quality_program;
    }
}
