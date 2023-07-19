package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InsuranceRequestService {

    ProposalService proposalService = new ProposalService();

    PaymentMovementService paymentMovementService = new PaymentMovementService();

    InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();

    AgencyService agencyService = new AgencyService();

    public InsuranceRequest createInsuranceRequest(Vehicle vehicle) {
        InsuranceRequest insuranceRequest = new InsuranceRequest();
        insuranceRequest.setVehicle(vehicle);
        return insuranceRequest;
    }

    public void addProposalToInsuranceRequest(InsuranceRequest insuranceRequest, Proposal proposal) {
        if (insuranceRequest.getProposalList() != null) {
            insuranceRequest.getProposalList().add(proposal);
        } else {
            ArrayList<Proposal> proposalArrayList = new ArrayList<>();
            proposalArrayList.add(proposal);
            insuranceRequest.setProposalList(proposalArrayList);
        }
    }

    public void insuranceIncomeToCompany(Agency agency,Proposal proposal,InsuranceCompany insuranceCompany){

        PaymentMovement paymentMovement = paymentMovementService.createPaymentMovement(insuranceCompany.getBankAccountList().get(0), "Aktarılan ödeme",
                MovementTypeEnum.INCOME,proposalService.makeDiscount(proposal));
        insuranceCompanyService.addPaymentMovementToInsuranceCompany(insuranceCompany,paymentMovement);
        insuranceCompany.getBankAccountList().get(0).setAmount(insuranceCompany.getBankAccountList().get(0).getAmount().add(proposalService.makeDiscount(proposal)));

        agency.getBankAccountList().get(0).setAmount(agency.getBankAccountList().get(0).getAmount().subtract(proposalService.makeDiscount(proposal)));
        BigDecimal commisionAmount = proposalService.makeDiscount(proposal).multiply(insuranceCompany.getCommission().divide(BigDecimal.valueOf(100)));
        PaymentMovement paymentMovement1 = paymentMovementService.createPaymentMovement(insuranceCompany.getBankAccountList().get(0), "Insurance Company Komisyon ödemesi yapılması",
                MovementTypeEnum.OUTCOME,commisionAmount);
        insuranceCompanyService.addPaymentMovementToInsuranceCompany(insuranceCompany,paymentMovement1);
        insuranceCompany.getBankAccountList().get(0).setAmount(insuranceCompany.getBankAccountList().get(0).getAmount().subtract(commisionAmount));
        agency.getBankAccountList().get(0).setAmount(agency.getBankAccountList().get(0).getAmount().add(commisionAmount));

        PaymentMovement paymentMovement2 = paymentMovementService.createPaymentMovement(agency.getBankAccountList().get(0), "Agency Komisyon ödemesi alınması",
                MovementTypeEnum.INCOME,commisionAmount);
        agencyService.addPaymentMovementToAgency(agency,paymentMovement2);

    }

}
