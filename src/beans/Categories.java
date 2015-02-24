package beans;

public class Categories implements java.io.Serializable{
    private int CategoryNo;
    private String Category, Description;

    public Categories() {
    }

    public int getCategoryNo() {
        return CategoryNo;
    }

    public void setCategoryNo(int CategoryNo) {
        this.CategoryNo = CategoryNo;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
}