package com.kolshop.kolshopmaterial.model.android;

import org.parceler.Parcel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gundeep on 05/09/15.
 */

@Parcel(value = Parcel.Serialization.BEAN, analyze = { AttributeValue.class })
public class AttributeValue extends RealmObject {

    @PrimaryKey
    private String id;
    private String productVarietyId;
    private String productVarietyAttributeId;
    private String value;
    private int sortOrder;

    public AttributeValue()
    {

    }

    public AttributeValue(String id, String productVarietyId, String productVarietyAttributeId, String value) {
        this.id = id;
        this.productVarietyId = productVarietyId;
        this.productVarietyAttributeId = productVarietyAttributeId;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductVarietyId() {
        return productVarietyId;
    }

    public void setProductVarietyId(String productVarietyId) {
        this.productVarietyId = productVarietyId;
    }

    public String getProductVarietyAttributeId() {
        return productVarietyAttributeId;
    }

    public void setProductVarietyAttributeId(String productVarietyAttributeId) {
        this.productVarietyAttributeId = productVarietyAttributeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }
}