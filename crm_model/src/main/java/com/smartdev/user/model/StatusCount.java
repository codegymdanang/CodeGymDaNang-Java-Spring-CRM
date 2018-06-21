package com.smartdev.user.model;

public class StatusCount {
    private int prospect;
    private int lead;
    private int potentialLead;
    private int activeLead;

    public StatusCount() {}

    public StatusCount(int prospect, int lead, int potentialLead, int activeLead) {
        this.prospect = prospect;
        this.lead = lead;
        this.potentialLead = potentialLead;
        this.activeLead = activeLead;
    }

    public int getProspect() {
        return prospect;
    }

    public void setProspect(int prospect) {
        this.prospect = prospect;
    }

    public int getLead() {
        return lead;
    }

    public void setLead(int lead) {
        this.lead = lead;
    }

    public int getPotentialLead() {
        return potentialLead;
    }

    public void setPotentialLead(int potentialLead) {
        this.potentialLead = potentialLead;
    }

    public int getActiveLead() {
        return activeLead;
    }

    public void setActiveLead(int activeLead) {
        this.activeLead = activeLead;
    }
}
