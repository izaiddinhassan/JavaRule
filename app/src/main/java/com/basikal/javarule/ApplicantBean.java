package com.basikal.javarule;

public class ApplicantBean {
    private String ruleFact;
    private String ruleResult;
    private String ruleFact2;
    private String rulResult2;

    public ApplicantBean() {
    }

    public ApplicantBean(String ruleFact, String ruleResult, String ruleFact2, String rulResult2) {
        this.ruleFact = ruleFact;
        this.ruleResult = ruleResult;
        this.ruleFact2 = ruleFact2;
        this.rulResult2 = rulResult2;
    }

    public String getRuleFact() {
        return ruleFact;
    }

    public void setRuleFact(String ruleFact) {
        this.ruleFact = ruleFact;
    }

    public String getRuleResult() {
        return ruleResult;
    }

    public void setRuleResult(String ruleResult) {
        this.ruleResult = ruleResult;
    }

    public String getRuleFact2() {
        return ruleFact2;
    }

    public void setRuleFact2(String ruleFact2) {
        this.ruleFact2 = ruleFact2;
    }

    public String getRulResult2() {
        return rulResult2;
    }

    public void setRulResult2(String rulResult2) {
        this.rulResult2 = rulResult2;
    }
}