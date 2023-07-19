package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    ProposalService proposalService = new ProposalService();
    AgencyService agencyService = new AgencyService();
    PaymentMovementService paymentMovementService = new PaymentMovementService();
    public Customer createCustomer(String name, CustomerTypeEnum customerTypeEnum) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCustomerTypeEnum(customerTypeEnum);

        return customer;
    }

    public void addBankAccountToCustomer(Customer customer, BankAccount bankAccount) {
        if (customer.getBankAccountList() != null) {
            customer.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccountList = new ArrayList<>();
            bankAccountList.add(bankAccount);
            customer.setBankAccountList(bankAccountList);
        }
    }

    public void addInsuranceRequestToCustomer(Customer customer, InsuranceRequest insuranceRequest) {
        if (customer.getInsuranceRequestList() != null) {
            customer.getInsuranceRequestList().add(insuranceRequest);
        } else {
            ArrayList<InsuranceRequest> insuranceRequestList = new ArrayList<>();
            insuranceRequestList.add(insuranceRequest);
            customer.setInsuranceRequestList(insuranceRequestList);
        }
    }

    public void addPolicyListToCustomer(Customer customer, Policy policy) {
        if (customer.getPolicyList() != null) {
            customer.getPolicyList().add(policy);
        } else {
            ArrayList<Policy> policyRequestList = new ArrayList<>();
            policyRequestList.add(policy);
            customer.setPolicyList(policyRequestList);
        }
    }

    public void addPaymentMovementCustomer(Customer customer, PaymentMovement paymentMovement) {
        if (customer.getPaymentMovementList() != null) {
            customer.getPaymentMovementList().add(paymentMovement);
        } else {
            ArrayList<PaymentMovement> paymentMovementList = new ArrayList<>();
            paymentMovementList.add(paymentMovement);
            customer.setPaymentMovementList(paymentMovementList);
        }
    }

    public void addVehicleCustomer(Customer customer, Vehicle vehicle) {
        if (customer.getVehicleList() != null) {
            customer.getVehicleList().add(vehicle);
        } else {
            ArrayList<Vehicle> vehicleList = new ArrayList<>();
            vehicleList.add(vehicle);
            customer.setVehicleList(vehicleList);
        }
    }

    public void acceptProposal(Customer customer, Proposal proposal, InsuranceRequest insuranceRequest,Agency agency) {
        List<InsuranceRequest> insuranceRequestList = customer.getInsuranceRequestList();
        for (InsuranceRequest insuranceRequest1 : insuranceRequestList) {
            if (insuranceRequest1.equals(insuranceRequest)) {
                for (Proposal proposal1 : insuranceRequest1.getProposalList()) {
                    if (proposal1.equals(proposal)) {
                        BankAccount bankAccount = getBankAccountWithEnoughMoney(customer,proposalService.makeDiscount(proposal));
                        if (bankAccount!=null){
                            bankAccount.setAmount(bankAccount.getAmount().subtract(proposalService.makeDiscount(proposal)));
                            PaymentMovement paymentMovement = paymentMovementService.createPaymentMovement(bankAccount,"Ödeme",MovementTypeEnum.OUTCOME
                            ,proposalService.makeDiscount(proposal));

                            PaymentMovement paymentMovement1 = paymentMovementService.createPaymentMovement(agency.getBankAccountList().get(0),
                                    "Alınan ödeme",MovementTypeEnum.INCOME ,proposalService.makeDiscount(proposal));

                            agencyService.addPaymentMovementToAgency(agency,paymentMovement1);
                            agency.getBankAccountList().get(0).setAmount(agency.getBankAccountList().get(0).getAmount().add(proposalService.makeDiscount(proposal)));
                            proposal1.setApproved(true);

                        }
                    }
                }
            }
        }
    }

    public BankAccount getBankAccountWithEnoughMoney(Customer customer, BigDecimal amount) {
        for (BankAccount bankAccount : customer.getBankAccountList()) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }
}


