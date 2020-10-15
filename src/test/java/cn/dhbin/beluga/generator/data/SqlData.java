package cn.dhbin.beluga.generator.data;

/**
 * @author dhb
 */
public class SqlData {

    /**
     * 获取列表权限id
     */
    private String listPermId;
    /**
     * 新增权限id
     */
    private String createPermId;
    /**
     * 删除权限id
     */
    private String deletePermId;
    /**
     * 更新权限id
     */
    private String updatePermId;
    /**
     * 通过id获取资源权限id
     */
    private String retrievePermId;

    public String getListPermId() {
        return listPermId;
    }

    public void setListPermId(String listPermId) {
        this.listPermId = listPermId;
    }

    public String getCreatePermId() {
        return createPermId;
    }

    public void setCreatePermId(String createPermId) {
        this.createPermId = createPermId;
    }

    public String getDeletePermId() {
        return deletePermId;
    }

    public void setDeletePermId(String deletePermId) {
        this.deletePermId = deletePermId;
    }

    public String getUpdatePermId() {
        return updatePermId;
    }

    public void setUpdatePermId(String updatePermId) {
        this.updatePermId = updatePermId;
    }

    public String getRetrievePermId() {
        return retrievePermId;
    }

    public void setRetrievePermId(String retrievePermId) {
        this.retrievePermId = retrievePermId;
    }
}
