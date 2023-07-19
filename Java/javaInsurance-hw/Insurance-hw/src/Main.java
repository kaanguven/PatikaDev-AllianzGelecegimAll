import model.*;
import service.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        AccidentService accidentService = new AccidentService();
        AgencyService agencyService = new AgencyService();
        BankAccountService bankAccountService = new BankAccountService();
        CustomerService customerService = new CustomerService();
        InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();
        InsuranceRequestService insuranceRequestService = new InsuranceRequestService();
        InsuranceService insuranceService = new InsuranceService();
        PaymentMovementService paymentMovementService = new PaymentMovementService();
        PolicyService policyService = new PolicyService();
        ProposalService proposalService = new ProposalService();
        VehicleService vehicleService = new VehicleService();

        // creating objects
        Agency Mom = agencyService.createAgency("Mom");

        Customer customer1 = customerService.createCustomer("Ufuk", CustomerTypeEnum.INDIVIDUAL);

        BankAccount agencyBankAccount = bankAccountService.createBankAccount("İş Bankası", "1234",BigDecimal.valueOf(0)); // create agencyBankAccount

        BankAccount allianzBankAccount = bankAccountService.createBankAccount("Halk Bank", "7214",BigDecimal.valueOf(5000)); // create allianz bank account

        BankAccount customerBankAccount = bankAccountService.createBankAccount("Ziraat Bankası", "5678",BigDecimal.valueOf(10000)); // customers bank account

        InsuranceCompany insuranceCompany = insuranceCompanyService.createInsuranceCompany("Allianz", // create Insurance Company
                "1432","2342","TEST-ADRESS",BigDecimal.valueOf(8));

        Insurance insurance = insuranceService.createInsurance(InsuranceTypeEnum.COMPULSORY_TRAFFIC_INSURANCE,"Consulary Traffic Insurance"); // Create new insurance

        insuranceCompanyService.addInsuranceToInsuranceCompany(insuranceCompany,insurance); // Add insurance to Insurance company

        agencyService.addBankAccountToAgency(Mom,agencyBankAccount); // add agencyBankAccount to  Mom

        customerService.addBankAccountToCustomer(customer1,customerBankAccount); // add customers bank account

        insuranceCompanyService.addBankAccountToInsuranceCompany(insuranceCompany,allianzBankAccount);

        agencyService.addCustomerToAgency(Mom,customer1); // add customer1 to Mom agency

        Vehicle vehicle1 = vehicleService.createVehicle("Audi","R8","11A22","23252",2011,ColorTypeEnum.BLUE); // create new car

        customerService.addVehicleCustomer(customer1,vehicle1); // add vehicle to customer

        InsuranceRequest insuranceRequest = insuranceRequestService.createInsuranceRequest(vehicle1);

        customerService.addInsuranceRequestToCustomer(customer1,insuranceRequest);

        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 1);
        LocalDate expireDate =  startDate.plusDays(3);


        Proposal proposal = proposalService.createProposal(insuranceCompany,vehicle1,BigDecimal.valueOf(1000),startDate,endDate,expireDate,BigDecimal.valueOf(8));

        insuranceRequestService.addProposalToInsuranceRequest(insuranceRequest,proposal);

        customerService.acceptProposal(customer1,proposal,insuranceRequest,Mom);

        if(proposal.isApproved()){
            insuranceRequestService.insuranceIncomeToCompany(Mom,proposal,insuranceCompany);
            Policy policy = policyService.createPolicy(proposal.getCompany(),
                    proposal.getVehicle(),
                    proposalService.makeDiscount(proposal),
                    proposal.getStartDate(),
                    proposal.getEndDate());
        }


        System.out.println(Mom);
        System.out.println(customer1);
        System.out.println(insuranceCompany);

        LocalDate accidentDate = LocalDate.now();

        Accident accident = accidentService.createAccident(accidentDate,"Trafik kazası yapıldı",BigDecimal.valueOf(5000),6);



        vehicleService.addAccidentToVehicle(vehicle1,accident);

    }
}