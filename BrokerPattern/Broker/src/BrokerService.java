package Broker;

public class BrokerService{
	private int id;
	private String name;

	public BrokerService(String name){
            this.name = name;
	}
        
        public void serve(){
            // realiza servicio
        }

	public String getName(){
		return name;
	}
}