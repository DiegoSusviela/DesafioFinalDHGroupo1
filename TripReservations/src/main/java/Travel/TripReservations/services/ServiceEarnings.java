package Travel.TripReservations.services;

import Travel.TripReservations.DTOs.DayEarningDTO;
import Travel.TripReservations.DTOs.MonthEarningDTO;
import Travel.TripReservations.models.Bookings;
import Travel.TripReservations.models.Flights;
import Travel.TripReservations.models.Package;
import Travel.TripReservations.models.Reservations;
import Travel.TripReservations.repo.RepoBooking;
import Travel.TripReservations.repo.RepoPackage;
import Travel.TripReservations.repo.RepoReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ServiceEarnings {

    @Autowired
    private RepoPackage repPack;

    @Autowired
    private RepoBooking repBoo;

    @Autowired
    private RepoReservation repRes;

    public Object calculateEarnings(Date date, int month, int year){
        double total = 0;
        DayEarningDTO ret = new DayEarningDTO();
        List<Bookings> bookings = repBoo.getDailyBooking(date, month, year);
        for (Bookings books: bookings)
            total += books.getTotalEarning();
        List<Reservations> reservations = repRes.getDailyReservation(date, month, year);
        for (Reservations res: reservations)
            total += res.getTotalEarnings();
        List<Package> packs = repPack.getDailyPack(date, month, year);
        for (Package pack: packs)
            total += pack.getTotalEarnings();
        ret.setDate(date);
        ret.setTotal_income(total);
        return ret;
    }
}
