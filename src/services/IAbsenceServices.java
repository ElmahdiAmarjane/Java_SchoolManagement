package services;

import java.time.LocalDate;

import modules.Absence;

public interface IAbsenceServices {

	boolean insertAbsence(Absence absence);
	Absence fetchAbsenceFilier(String absence);
	Absence fetchAbsenceFilieByDater(LocalDate date);
}
