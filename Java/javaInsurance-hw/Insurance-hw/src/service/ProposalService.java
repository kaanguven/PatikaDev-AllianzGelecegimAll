package service;

import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ProposalService {

    VehicleService vehicleService = new VehicleService();

    public Proposal createProposal(InsuranceCompany company, Vehicle vehicle, BigDecimal offerPrice,
                                   LocalDate startDate, LocalDate endDate, LocalDate expireDate,
                                   BigDecimal discountPrice) {
        Proposal proposal = new Proposal();
        proposal.setCompany(company);
        proposal.setVehicle(vehicle);
        proposal.setOfferPrice(offerPrice);
        proposal.setStartDate(startDate);
        proposal.setEndDate(endDate);
        proposal.setExpireDate(expireDate);
        proposal.setDiscountPrice(discountPrice);

        return proposal;
    }

    public BigDecimal makeDiscount(Proposal proposal) {

        if (proposal.getDiscountPrice() != null) {
            return proposal.getOfferPrice().subtract(proposal.getDiscountPrice());

        } else {

            return proposal.getOfferPrice();
        }

    }

    public BigDecimal calculateAccordingToAccidentOfferPrice(BigDecimal OfferPrice, Vehicle vehicle) {
        BigDecimal totalOfferPrice = BigDecimal.ZERO;
        BigDecimal totalDamagePrice = vehicleService.totalAccidentDamagePrice(vehicle);
        if (totalDamagePrice.compareTo(BigDecimal.valueOf(0)) > 0 && totalDamagePrice.compareTo(BigDecimal.valueOf(4000)) <= 0) {
            totalOfferPrice = OfferPrice.add(OfferPrice.multiply(BigDecimal.valueOf(10).divide(BigDecimal.valueOf(100))));

        } else if (totalDamagePrice.compareTo(BigDecimal.valueOf(4000)) > 0 && totalDamagePrice.compareTo(BigDecimal.valueOf(8000)) < 0) {
            totalOfferPrice = OfferPrice.add(OfferPrice.multiply(BigDecimal.valueOf(25).divide(BigDecimal.valueOf(100))));

        } else if (totalDamagePrice.compareTo(BigDecimal.valueOf(8000)) > 0 && totalDamagePrice.compareTo(BigDecimal.valueOf(16000)) < 0) {
            totalOfferPrice = OfferPrice.add(OfferPrice.multiply(BigDecimal.valueOf(40).divide(BigDecimal.valueOf(100))));

        } else {
            totalOfferPrice = OfferPrice.add(OfferPrice.multiply(BigDecimal.valueOf(80).divide(BigDecimal.valueOf(100))));
        }

        return totalOfferPrice;


    }

}
