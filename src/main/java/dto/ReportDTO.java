package dto;

public class ReportDTO {

    private String type;
    private Long cost;
    private Long count;

    public ReportDTO() {}

    public ReportDTO(String type, Long cost, Long count) {
        this.type = type;
        this.cost = cost;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
