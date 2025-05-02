package com.eazybytes.loans.service;

import com.eazybytes.loans.dto.LoansDto;

public interface LoansService {

    /**
     * @param mobileNumber
     */
    void createLoan(String mobileNumber);

    /**
     * @param mobileNumber
     * @return
     */
    LoansDto fetchLoan(String mobileNumber);

    /**
     * @param loansDto
     */
    boolean updateLoan(LoansDto loansDto);

    /**
     * @param mobileNumber
     * @return
     */
    boolean deleteLoan(String mobileNumber);
}
