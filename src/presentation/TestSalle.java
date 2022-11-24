package presentation;

import java.sql.Date;


import entities.Machine;
import entities.Salle;
import services.MachineService;
import services.SalleService;

public class TestSalle {
	
	public static void main(String[] args) {
		
		SalleService ss = new SalleService();
//		ss.create(new Salle("CC2", "Info"));
	//	ss.create(new Salle("LR", "Auto"));
		
//		System.out.println("Liste des salles disponibles  : ");
//		for(Salle s : ss.findAll())
//			System.out.println(s);
////		
//		ss.delete(ss.findById(1));
		
		MachineService ms = new MachineService();
//		ms.create(new Machine("PO45", "HP", 10000, new Date(), ss.findById(2)));
//		ms.create(new Machine("RT45", "Lenovo", 7000, new Date(), ss.findById(2)));
//		ms.create(new Machine("CC45", "Dell", 9000, new Date(), ss.findById(3)));
		
		
	/*	for(Salle s1 : ss.findAll()) {
			System.out.println(s1+" \n ses machines : ");
			for(Machine m : ms.findAll()) {
				if(m.getSalle().getId() == s1.getId())
					System.out.println("\t"+m);
			}
		}
		*///System.out.println(ms.entreDeuxDates(new Date(16-11-2022),new Date(19-11-2022)));;

		
		
		
		System.out.println(ms.findBydate(new Date(16-11-2022),new Date(19-11-2022)));
		
		
		System.out.println(ms.findById(2));
		System.out.println(ms.findBysl(2));
		
	}

}
