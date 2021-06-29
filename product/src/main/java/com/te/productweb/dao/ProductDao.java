package com.te.productweb.dao;

import com.te.productweb.beans.ProductInfoBean;

public interface ProductDao {
  public ProductInfoBean authenticate(int id,String accesstype);
}
