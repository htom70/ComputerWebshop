package hu.tom.webshop.dao;

import hu.tom.webshop.domain.CpuVendor;

import javax.persistence.Query;

public class CpuVendorDao extends BaseDao<CpuVendor> {

    public CpuVendorDao() {
        super(CpuVendor.class);
    }
}
