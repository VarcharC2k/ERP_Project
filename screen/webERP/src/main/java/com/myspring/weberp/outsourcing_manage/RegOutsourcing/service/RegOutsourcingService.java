package com.myspring.weberp.outsourcing_manage.RegOutsourcing.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.weberp.outsourcing_manage.RegOutsourcing.vo.RegOutsourcingVO;

public interface RegOutsourcingService {
	 public List listOutsourcing() throws DataAccessException;
	 public int addOutsourcing(RegOutsourcingVO regOutsourcingVO) throws DataAccessException;
	 public int removeOutsourcing(int workOrderNumber) throws DataAccessException;
	 public List itemView() throws DataAccessException;
}
