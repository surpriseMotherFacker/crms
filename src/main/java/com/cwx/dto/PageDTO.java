package com.cwx.dto;

public class PageDTO {
    //排除前几笔
    private int offset=0;

    /**
     * 取几笔
     */
    private int limit=1;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
