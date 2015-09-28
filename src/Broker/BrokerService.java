package Broker;

public class BrokerService{
	private int id;
	private String name;

	public BrokerService(String name){
            System.out.println("Me has Agregado!");
            this.name = name;
	}
        
        public void serve(){
            // realiza servicio
        }

	public String getName(){
		return name;
	}
}