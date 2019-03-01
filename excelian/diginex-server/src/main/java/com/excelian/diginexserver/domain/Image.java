package com.excelian.diginexserver.domain;

import java.util.Objects;

public class Image {

    private String data;
    private DocumentType documentType;
    private DocumentCategory documentCategory;
    private ImageType imageType;

    public Image(String data, DocumentType documentType, DocumentCategory documentCategory, ImageType imageType) {
        this.data = data;
        this.documentType = documentType;
        this.documentCategory = documentCategory;
        this.imageType = imageType;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public DocumentCategory getDocumentCategory() {
        return documentCategory;
    }

    public void setDocumentCategory(DocumentCategory documentCategory) {
        this.documentCategory = documentCategory;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(data, image.data) &&
                documentType == image.documentType &&
                documentCategory == image.documentCategory &&
                imageType == image.imageType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, documentType, documentCategory, imageType);
    }
}
