package beans;

import java.sql.Blob;

public class Books implements java.io.Serializable{
    private int BookNo, Year, Cost, Hits;
    private Integer Author1No, Author2No, Author3No, Author4No, PublisherNo, CategoryNo;
    private String BookName, ISBN, Edition, Synopsis, AboutAuthors, TopicsCovered, ContentsCDROM;
    private Blob CoverPage, Toc, SampleChapter;

    public Books() {
    }

    public int getHits() {
        return Hits;
    }

    public void setHits(int Hits) {
        this.Hits = Hits;
    }

    public String getAboutAuthors() {
        return AboutAuthors;
    }

    public void setAboutAuthors(String AboutAuthors) {
        this.AboutAuthors = AboutAuthors;
    }

    public Integer getAuthor1No() {
        return Author1No;
    }

    public void setAuthor1No(Integer Author1No) {
        this.Author1No = Author1No;
    }

    public Integer getAuthor2No() {
        return Author2No;
    }

    public void setAuthor2No(Integer Author2No) {
        this.Author2No = Author2No;
    }

    public Integer getAuthor3No() {
        return Author3No;
    }

    public void setAuthor3No(Integer Author3No) {
        this.Author3No = Author3No;
    }

    public Integer getAuthor4No() {
        return Author4No;
    }

    public void setAuthor4No(Integer Author4No) {
        this.Author4No = Author4No;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public int getBookNo() {
        return BookNo;
    }

    public void setBookNo(int BookNo) {
        this.BookNo = BookNo;
    }

    public Integer getCategoryNo() {
        return CategoryNo;
    }

    public void setCategoryNo(Integer CategoryNo) {
        this.CategoryNo = CategoryNo;
    }

    public String getContentsCDROM() {
        return ContentsCDROM;
    }

    public void setContentsCDROM(String ContentsCDROM) {
        this.ContentsCDROM = ContentsCDROM;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int Cost) {
        this.Cost = Cost;
    }

    public Blob getCoverPage() {
        return CoverPage;
    }

    public void setCoverPage(Blob CoverPage) {
        this.CoverPage = CoverPage;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String Edition) {
        this.Edition = Edition;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getPublisherNo() {
        return PublisherNo;
    }

    public void setPublisherNo(Integer PublisherNo) {
        this.PublisherNo = PublisherNo;
    }

    public Blob getSampleChapter() {
        return SampleChapter;
    }

    public void setSampleChapter(Blob SampleChapter) {
        this.SampleChapter = SampleChapter;
    }

    public String getSynopsis() {
        return Synopsis;
    }

    public void setSynopsis(String Synopsis) {
        this.Synopsis = Synopsis;
    }

    public Blob getToc() {
        return Toc;
    }

    public void setToc(Blob Toc) {
        this.Toc = Toc;
    }

    public String getTopicsCovered() {
        return TopicsCovered;
    }

    public void setTopicsCovered(String TopicsCovered) {
        this.TopicsCovered = TopicsCovered;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }
}