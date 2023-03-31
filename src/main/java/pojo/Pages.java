package pojo;

public class Pages<T> {
    private int currentpage;
    private  int pagesize;

    private  T searchdata;


    public Pages() {
    }

    public Pages(int currentpage, int pagesize) {
        this.currentpage = currentpage;
        this.pagesize = pagesize;
    }

    public Pages(int currentpage, int pagesize, T searchdata) {
        this.currentpage = currentpage;
        this.pagesize = pagesize;
        this.searchdata = searchdata;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public T getSearchdata() {
        return searchdata;
    }

    public void setSearchdata(T searchdata) {
        this.searchdata = searchdata;
    }

}
