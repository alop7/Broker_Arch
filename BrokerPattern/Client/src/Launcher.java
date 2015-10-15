package Client;

import java.util.ArrayList;

public class Launcher {

    public static void main(String[] args) {
        ArrayList<Controller> controllers = new ArrayList();

        ClientProxy proxy = new ClientProxy(controllers);
        proxy.start();

        VoteCtrl votes = new VoteCtrl(proxy);
        RegisterCtrl registerCtrl = new RegisterCtrl(proxy);
        registerCtrl.bindMeSomeCands(votes);
        controllers.add(votes);
        controllers.add(registerCtrl);

    }
}
