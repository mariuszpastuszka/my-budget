package pl.sda.mybudget.model.enumeration;

public enum IncomeType {
    JOB("Job"), // IncomeType JOB = new IncomeType("Job")
    ADDITIONAL("Additional"),
    MOPS("Mops");

    private String description;

    public String getDescription() {
        return description;
    }

    IncomeType(String description) {
        this.description = description;
    }
}
