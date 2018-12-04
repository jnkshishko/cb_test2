package dto;

public class CountDTO {

    private Long fineId;

    private Long count;

    public CountDTO(){}

    public CountDTO(Long fineId, Long count) {
        this.fineId = fineId;
        this.count = count;
    }

    public Long getFineId() {
        return fineId;
    }

    public void setFineId(Long fineId) {
        this.fineId = fineId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
