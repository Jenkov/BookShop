package beans;

public class PopularSearches implements java.io.Serializable {
     private Integer searchNo;
     private String criteria;
     private String value;

    public PopularSearches() {
    }

    public Integer getSearchNo() {
        return this.searchNo;
    }
    
    public void setSearchNo(Integer searchNo) {
        this.searchNo = searchNo;
    }

    public String getCriteria() {
        return this.criteria;
    }
    
    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}