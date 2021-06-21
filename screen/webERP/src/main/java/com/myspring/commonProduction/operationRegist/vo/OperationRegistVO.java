package com.myspring.commonProduction.operationRegist.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("OperationRegistVO")
public class OperationRegistVO {
	private String workOrderNumber;
	private String materialstatus;
	private String workPlaceCode;
	private Date instructionDate;
	private Date dueDate;
	private String itemCode;
	private String itemName;
	private String standard;
	private String inventoryUnit;
	private int indicated;
	private String status;
	private String inspection;
	private String note;
	private String productionPlanCode;
	private String facility;
	private String taskTeam;
	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getTaskTeam() {
		return taskTeam;
	}

	public void setTaskTeam(String taskTeam) {
		this.taskTeam = taskTeam;
	}

	private List<OperationRegistVO> ListVO;
	
	public String getMaterialstatus() {
		return materialstatus;
	}

	public void setMaterialstatus(String materialstatus) {
		this.materialstatus = materialstatus;
	}

	public String getWorkPlaceCode() {
		return workPlaceCode;
	}

	public void setWorkPlaceCode(String workPlaceCode) {
		this.workPlaceCode = workPlaceCode;
	}

	@Override
	public String toString() {
		return Arrays.toString(ListVO.toArray());
	}
	
	public OperationRegistVO() {
		super();
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}

	public Date getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getInventoryUnit() {
		return inventoryUnit;
	}

	public void setInventoryUnit(String inventoryUnit) {
		this.inventoryUnit = inventoryUnit;
	}

	public int getIndicated() {
		return indicated;
	}

	public void setIndicated(int indicated) {
		this.indicated = indicated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInspection() {
		return inspection;
	}

	public void setInspection(String inspection) {
		this.inspection = inspection;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getProductionPlanCode() {
		return productionPlanCode;
	}

	public void setProductionPlanCode(String productionPlanCode) {
		this.productionPlanCode = productionPlanCode;
	}

	public List<OperationRegistVO> getListVO() {
		return ListVO;
	}

	public void setListVO(List<OperationRegistVO> listVO) {
		this.ListVO = new ArrayList();
	}
	
	
}
