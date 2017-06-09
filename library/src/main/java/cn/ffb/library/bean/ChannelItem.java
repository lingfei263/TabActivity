package cn.ffb.library.bean;

import java.io.Serializable;

/**
 * ITEM的对应可序化队列属性
 */
public class ChannelItem implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6465237897027410019L;
    /**
     * 栏目对应ID
     */
    private Integer id;
    /**
     * 栏目对应NAME
     */
    private String name;
    /**
     * 栏目在整体中的排序顺序  rank
     */
    private Integer orderId;
    /**
     * 栏目是否选中
     */
    private Integer selected;

    private String path;

    public ChannelItem() {
    }

    public ChannelItem(int id, String name, int orderId, int selected, String path) {
        this.id = Integer.valueOf(id);
        this.name = name;
        this.orderId = Integer.valueOf(orderId);
        this.selected = Integer.valueOf(selected);
        this.path = path;
    }

    public int getId() {
        return this.id.intValue();
    }

    public String getName() {
        return this.name;
    }

    public int getOrderId() {
        return this.orderId.intValue();
    }

    public Integer getSelected() {
        return this.selected;
    }

    public void setId(int paramInt) {
        this.id = Integer.valueOf(paramInt);
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOrderId(int paramInt) {
        this.orderId = Integer.valueOf(paramInt);
    }

    public void setSelected(Integer paramInteger) {
        this.selected = paramInteger;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}