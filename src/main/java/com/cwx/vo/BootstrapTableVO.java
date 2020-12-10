package com.cwx.vo;

import java.util.List;

/**
 * bootstrap-table前端需要的对象
 * @author nick
 */
public class BootstrapTableVO {
    private long total;
    private List rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
