package dto;

public class AnswerDTO {

    private String gosnumber;

    private String mark;

    private String model;

    private String ownerLastname;

    private String ownerFirstname;

    private String ownerMiddlename;

    private String typeOfFine;

    private Long costOfFine;

    public AnswerDTO() {

    }

    public AnswerDTO(String gosnumber, String mark, String model, String ownerLastname, String ownerFirstname, String ownerMiddlename, String typeOfFine, Long costOfFine) {
        this.gosnumber = gosnumber;
        this.mark = mark;
        this.model = model;
        this.ownerLastname = ownerLastname;
        this.ownerFirstname = ownerFirstname;
        this.ownerMiddlename = ownerMiddlename;
        this.typeOfFine = typeOfFine;
        this.costOfFine = costOfFine;
    }

    public String getGosnumber() {
        return gosnumber;
    }

    public void setGosnumber(String gosnumber) {
        this.gosnumber = gosnumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwnerLastname() {
        return ownerLastname;
    }

    public void setOwnerLastname(String ownerLastname) {
        this.ownerLastname = ownerLastname;
    }

    public String getOwnerFirstname() {
        return ownerFirstname;
    }

    public void setOwnerFirstname(String ownerFirstname) {
        this.ownerFirstname = ownerFirstname;
    }

    public String getOwnerMiddlename() {
        return ownerMiddlename;
    }

    public void setOwnerMiddlename(String ownerMiddlename) {
        this.ownerMiddlename = ownerMiddlename;
    }

    public String getTypeOfFine() {
        return typeOfFine;
    }

    public void setTypeOfFine(String typeOfFine) {
        this.typeOfFine = typeOfFine;
    }

    public Long getCostOfFine() {
        return costOfFine;
    }

    public void setCostOfFine(Long costOfFine) {
        this.costOfFine = costOfFine;
    }
}
