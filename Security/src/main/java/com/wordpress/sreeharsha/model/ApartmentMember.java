package com.wordpress.sreeharsha.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ApartmentMember")
public class ApartmentMember {

	@Id
	private String blockNumber;
	private String primaryMemberName;
	private String secondaryMemberName;
	private List<String> mobileNumbers;
	private String occupyStatus;
	private List<MotorVehicleDetails> vehicleList;

	public String getBlockNumber() {
		return blockNumber;
	}

	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}

	public String getPrimaryMemberName() {
		return primaryMemberName;
	}

	public void setPrimaryMemberName(String primaryMemberName) {
		this.primaryMemberName = primaryMemberName;
	}

	public String getSecondaryMemberName() {
		return secondaryMemberName;
	}

	public void setSecondaryMemberName(String secondaryMemberName) {
		this.secondaryMemberName = secondaryMemberName;
	}
	
	

	public String getOccupyStatus() {
		return occupyStatus;
	}

	public void setOccupyStatus(String occupyStatus) {
		this.occupyStatus = occupyStatus;
	}

	public List<String> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(List<String> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	public List<MotorVehicleDetails> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<MotorVehicleDetails> vehicleList) {
		this.vehicleList = vehicleList;
	}

}
