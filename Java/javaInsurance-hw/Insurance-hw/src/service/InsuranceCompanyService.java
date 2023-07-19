package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InsuranceCompanyService {

    public InsuranceCompany createInsuranceCompany(String name, String taxOffice,
                                                   String taxNumber, String address, BigDecimal commission) {
        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setName(name);
        insuranceCompany.setTaxOffice(taxOffice);
        insuranceCompany.setTaxNumber(taxNumber);
        insuranceCompany.setAddress(address);
        insuranceCompany.setCommission(commission);
        return insuranceCompany;
    }

    public void addInsuranceToInsuranceCompany(InsuranceCompany insuranceCompany, Insurance insurance) {
        if (insuranceCompany.getInsuranceList() != null) {
            insuranceCompany.getInsuranceList().add(insurance);
        } else {
            ArrayList<Insurance> insuranceList = new ArrayList<>();
            insuranceList.add(insurance);
            insuranceCompany.setInsuranceList(insuranceList);
        }
    }

    public void addBankAccountToInsuranceCompany(InsuranceCompany insuranceCompany, BankAccount bankAccount) {
        if (insuranceCompany.getBankAccountList() != null) {
            insuranceCompany.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccountArrayList = new ArrayList<>();
            bankAccountArrayList.add(bankAccount);
            insuranceCompany.setBankAccountList(bankAccountArrayList);
        }
    }

    public void addPaymentMovementToInsuranceCompany(InsuranceCompany insuranceCompany,
                                                     PaymentMovement paymentMovement) {

        if (insuranceCompany.getBankAccountList() == null) {
        } else {

            if (paymentMovement.getMovementType() == MovementTypeEnum.OUTCOME) {
                if (!checkIfInsuranceCompanyHasEnoughBalanceForPayment(insuranceCompany, paymentMovement)) {
                }
            } else {
                if (insuranceCompany.getPaymentMovementList() == null) {
                    ArrayList<PaymentMovement> paymentMovementArrayList = new ArrayList<>();
                    paymentMovementArrayList.add(paymentMovement);
                    insuranceCompany.setPaymentMovementList(paymentMovementArrayList);
                } else {
                    insuranceCompany.getPaymentMovementList().add(paymentMovement);
                }
            }
        }
    }

    public boolean checkIfInsuranceCompanyHasEnoughBalanceForPayment(InsuranceCompany insuranceCompany,
                                                                     PaymentMovement paymentMovement) {
        BigDecimal amount = paymentMovement.getAmount();
        boolean flag = false;
        for (BankAccount bankAccount : insuranceCompany.getBankAccountList()) {
            if (amount.compareTo(bankAccount.getAmount()) > -1) {
                flag = true;
                break;
            }
        }
        return flag;
    }


}
