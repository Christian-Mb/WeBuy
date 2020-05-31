package univ.tours.webuy.core.product;

import java.io.Serializable;

import univ.tours.webuy.core.utils.BaseWebuy;

public class Product extends BaseWebuy implements Serializable {

    private String label, content, image;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "label='" + label + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
