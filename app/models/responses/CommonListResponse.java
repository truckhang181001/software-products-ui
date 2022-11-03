package models.responses;

import utils.models.ObjectReference;

import java.util.List;

public class CommonListResponse <T> {
    private Integer page;
    private Integer pageSize;
    private Integer totalCount;
    private String fromXtoY;
    private Boolean hasNext;
    private Boolean hasPrev;
    private List<T> items;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getFromXtoY() {
        return fromXtoY;
    }

    public void setFromXtoY(String fromXtoY) {
        this.fromXtoY = fromXtoY;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Boolean getHasPrev() {
        return hasPrev;
    }

    public void setHasPrev(Boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
