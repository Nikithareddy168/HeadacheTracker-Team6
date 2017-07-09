import java.time.*;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.HOURS;

import java.util.*;


public class Headache {
	
	private LocalDate date; 
	private LocalTime startTime; 
	private LocalTime endTime; 
	private Map<String,Integer> severity;
	private List<Location> painLocation; 
	private Sidedness sidedness; 
	private List<HeadacheType> headacheType; 
	private List <Trigger> trigger; 
	private Map<Phase,Symptom> symptom; 
	private List <Treatment> treatment; 
	private Phase a; 
	

	
	public Headache(LocalDate date, LocalTime startTime, LocalTime endTime, Map<String, Integer> severity,
			List<Location> painLocation, Sidedness sidedness, List<HeadacheType> headacheType, List<Trigger> trigger,
			Map<Phase,Symptom> symptom, List<Treatment> treatment) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.severity = severity;
		this.painLocation = painLocation;
		this.sidedness = sidedness;
		this.headacheType = headacheType;
		this.trigger = trigger;
		this.symptom = symptom;
		this.treatment = treatment;
		
		
	}
	
	public void getAll(){
		//Output all headache info in a formatted string
		System.out.println("\tGetting Headache info");
		//Get info from each object headache is composed of
		System.out.println("Date " + getDate().format(DateTimeFormatter.ofPattern("MM-dd-yy")) + 
				", Start time: " + getStartTime().format(DateTimeFormatter.ofPattern("hh:mm a")) + 
				", End time: " + getEndTime().format(DateTimeFormatter.ofPattern("hh:mm a")) + ", duration: " + getDuration());
		getTreatmentInfo(); 
		//Get Info for each Phase and Symptom
		System.out.println("\tGetting Symptom/Phase info");
		for(Phase p : symptom.keySet()){
			System.out.print(p.toString() + ": ");
			symptom.get(p).getAll();
			System.out.println(""); 
		}
	}
	
	//get all info from each treatment type
	public void getTreatmentInfo(){
		List<Treatment>tList = getTreatment(); 
		for(Treatment t : tList){
			t.getAll();
		}
	}
	
	/* Are these useful? 
	public long getDurationHours(){
		return getStartTime().until(getEndTime(),HOURS); 
	}
	
	public long getDurationMinutes(){
		return getStartTime().until(getEndTime(),MINUTES); 
	}*/
	
	public double getDuration(){
		return (((double)getStartTime().until(getEndTime(),MINUTES))/60); 
	}
	
	//Getters and Setters
	//Need more abstraction - making new class to handle date/time, severity and painlocation (?), etc. 

	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	public LocalTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}


	public Map<String, Integer> getSeverity() {
		return severity;
	}


	public void setSeverity(Map<String, Integer> severity) {
		this.severity = severity;
	}


	public List<Location> getPainLocation() {
		return painLocation;
	}


	public void setPainLocation(List<Location> painLocation) {
		this.painLocation = painLocation;
	}


	public Sidedness getSidedness() {
		return sidedness;
	}


	public void setSidedness(Sidedness sidedness) {
		this.sidedness = sidedness;
	}


	public List<HeadacheType> getHeadacheType() {
		return headacheType;
	}


	public void setHeadacheType(List<HeadacheType> headacheType) {
		this.headacheType = headacheType;
	}


	public List<Trigger> getTrigger() {
		return trigger;
	}


	public void setTrigger(List<Trigger> trigger) {
		this.trigger = trigger;
	}

	public List<Treatment> getTreatment() {
		return treatment;
	}


	public void setTreatment(List<Treatment> treatment) {
		this.treatment = treatment;
	}

}
