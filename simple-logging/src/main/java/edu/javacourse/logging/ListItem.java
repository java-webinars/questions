package edu.javacourse.logging;

import java.util.Objects;

public class ListItem
{
    private Long itemId;
    private Double itemValue;

    public ListItem(Long itemId, Double itemValue) {
        this.itemId = itemId;
        this.itemValue = itemValue;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Double getItemValue() {
        return itemValue;
    }

    public void setItemValue(Double itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "itemId=" + itemId +
                ", itemValue=" + itemValue +
                '}';
    }
}
