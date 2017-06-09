package cn.ffb.library.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/23.
 */
public class ModuleEntity implements Serializable{

    /**
     * title : 年度工作计划
     * userhave : true
     * order : 0
     * path : /publish/1@68/2@69/7@70
     */

    private String title;
    private boolean userhave;
    private int order;
    private String path;

    public ModuleEntity(String title, boolean userhave, int order, String path) {
        this.title = title;
        this.userhave = userhave;
        this.order = order;
        this.path = path;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isUserhave() {
        return userhave;
    }

    public void setUserhave(boolean userhave) {
        this.userhave = userhave;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
