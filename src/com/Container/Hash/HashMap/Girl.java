package com.Container.Hash.HashMap;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2616:41
 */
public class Girl {

    private String id;

    private String name;

    public Girl(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Girl girl = (Girl) o;

        if (id != null ? !id.equals(girl.id) : girl.id != null)
            return false;
        return name != null ? name.equals(girl.name) : girl.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
