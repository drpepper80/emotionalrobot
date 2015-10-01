package com.blindcarboncopy.emotionalrobot.model.cloudant.messages;

import com.blindcarboncopy.emotionalrobot.model.nodered.NodeRedMessage;

import org.w3c.dom.Node;

/**
 * Created by DrPepper80 on 01/10/2015.
 */
public class CloudantMessagePackage {
    private float total_rows;
    private float offset;
    private CloudantMessageRecord[] rows;

    public CloudantMessagePackage() {
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

    public CloudantMessageRecord[] getRows() {
        return rows;
    }

    public void setRows(CloudantMessageRecord[] rows) {
        this.rows = rows;
    }
}
