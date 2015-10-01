package com.blindcarboncopy.emotionalrobot.model.cloudant.ids;

/**
 * Created by DrPepper80 on 01/10/2015.
 */
public class CloudantIDPackage {
    private float total_rows;
    private float offset;
    private CloudantIDRecord[] rows;

    public CloudantIDPackage() {
    }

    public float getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(float total_rows) {
        this.total_rows = total_rows;
    }

    public float getOffset() {
        return offset;
    }

    public void setOffset(float offset) {
        this.offset = offset;
    }

    public CloudantIDRecord[] getRows() {
        return rows;
    }

    public void setRows(CloudantIDRecord[] rows) {
        this.rows = rows;
    }
}
