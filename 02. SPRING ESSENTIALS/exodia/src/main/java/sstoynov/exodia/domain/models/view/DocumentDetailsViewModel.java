package sstoynov.exodia.domain.models.view;

public class DocumentDetailsViewModel {

    private String id;
    private String title;
    private String content;

    public DocumentDetailsViewModel() {
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
