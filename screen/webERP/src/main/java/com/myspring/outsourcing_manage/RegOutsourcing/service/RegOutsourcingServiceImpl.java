package com.myspring.outsourcing_manage.RegOutsourcing.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.outsourcing_manage.RegOutsourcing.dao.RegOutsourcingDAO;
import com.myspring.outsourcing_manage.RegOutsourcing.vo.RegOutsourcingVO;

@Service("RegOutsourcingService")
@Transactional(propagation = Propagation.REQUIRED)
public class RegOutsourcingServiceImpl implements RegOutsourcingService {
	@Autowired
	private RegOutsourcingDAO regOutsourcingDAO;
	
	@Override
	public List listOutsourcing() throws DataAccessException{
		List outsourcingList = null;
		outsourcingList = regOutsourcingDAO.viewOutsourcingList();
		return outsourcingList;
	}

	@Override
	 public int addOutsourcing(RegOutsourcingVO regOutsourcingVO) throws DataAccessException{
		return regOutsourcingDAO.insertOutsourcing(regOutsourcingVO);
	}

	@Override
	public void removeOutsourcing(String[] noary) throws DataAccessException{
		regOutsourcingDAO.deleteOutsourcing(noary);
	}
	
	@Override
	public int updateOutsourcing(RegOutsourcingVO regOutsourcingVO) throws DataAccessException{
		return regOutsourcingDAO.updateOutsourcing(regOutsourcingVO);
	}

	@Override
	public List productionPlanView(String startDate, String endDate) throws ParseException {
		  List popList = null;
		  popList = regOutsourcingDAO.productionPlanPop(startDate, endDate);
		  return popList;
	}
}
