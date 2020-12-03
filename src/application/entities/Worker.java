package application.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import application.entities.enuns.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		this.contracts.removeIf(x -> x.getID() == contract.getID());
	}
	
	public double income(Integer year, Integer month) {
		double total = this.baseSalary;
		Calendar cal = Calendar.getInstance();
		
		for( HourContract contract : this.contracts ) {
			cal.setTime(contract.getDate());
			if( cal.get(Calendar.MONTH)+1 == month && cal.get(Calendar.YEAR) == year ) {
				total += contract.totalValue(); 
			}
		}
		
		return total;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public String getDepartment() {
		return department.getName();
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + ", department=" + department
				+ ", contracts=" + contracts + "]";
	}
	
	public static void exerciseRun() {
		
		Scanner sc = new Scanner(System.in);
		Department department;
	    Worker worker = new Worker();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter department name: ");
		department = new Department(sc.nextLine());
		worker.setDepartment(department);
		
		System.out.println("Enter Work Data: ");
		System.out.println("Name: ");
		worker.setName(sc.nextLine());
		
		System.out.println("Level: ");
		worker.setLevel(WorkerLevel.valueOf(sc.nextLine()));
		
		System.out.println("Base salary: ");
		worker.setBaseSalary(sc.nextDouble());
		sc.nextLine();
		
		System.out.println("How many contracts to this worker ? ");
		
		int contractsToRead = sc.nextInt();
		sc.nextLine();
		for( int x = 1; x <= contractsToRead; x++) {
			HourContract contract = new HourContract();
			
			System.out.println("Enter contract " + x + "# data: ");
			contract.setID(x);
			
			System.out.println("Date (DD/MM/YYYY): ");
			try {
				contract.setDate(sdf.parse(sc.nextLine()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			System.out.println("Value per hour: ");
			contract.setValuePerHour(sc.nextDouble());
			sc.nextLine();
			
			System.out.println("Duration (hours): ");
			contract.setHours(sc.nextDouble());
			sc.nextLine();
			
			worker.addContract(contract);
			
		}
		
		System.out.println("Enter month and year to calculate income (MM/YYYY)");
		String incomeDate = sc.nextLine();
		int incomeMonth = Integer.parseInt(incomeDate.split("/")[0]);
		int incomeYear = Integer.parseInt(incomeDate.split("/")[1]);
		
		
		
		System.out.println("Name: " + worker.getName() + "\nDepartment: " + worker.getDepartment());
		System.out.println("Income for " + incomeDate + ": " + worker.income(incomeYear, incomeMonth));
		
		sc.close();
	}
	
}
