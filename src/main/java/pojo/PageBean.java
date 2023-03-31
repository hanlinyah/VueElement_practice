package pojo;

import java.util.List;

public class PageBean<T> {
    private int totalRowInPages;
    private List<T> datalist;



    public PageBean() {
    }
    public PageBean(int totalRowInPages, List<T> datalist) {
        this.totalRowInPages = totalRowInPages;
        this.datalist = datalist;
    }

    public int getTotalRowInPages() {
        return totalRowInPages;
    }

    public void setTotalRowInPages(int totalRowInPages) {
        this.totalRowInPages = totalRowInPages;
    }

    public List<T> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<T> datalist) {
        this.datalist = datalist;
    }
}
