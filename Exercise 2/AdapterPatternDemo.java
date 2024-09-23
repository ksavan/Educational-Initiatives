// Target Interface (Socket)
interface Socket {
    void plugIn();
}

// Adaptee Class (EuropeanSocket)
class EuropeanSocket {
    public void provideElectricity() {
        System.out.println("Providing electricity from a European socket (220V)");
    }
}

// Adapter Class (SocketAdapter)
class SocketAdapter implements Socket {
    private EuropeanSocket europeanSocket;

    public SocketAdapter(EuropeanSocket europeanSocket) {
        this.europeanSocket = europeanSocket;
    }

    @Override
    public void plugIn() {
        europeanSocket.provideElectricity();
        System.out.println("Adapter converting 220V to 110V");
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        EuropeanSocket europeanSocket = new EuropeanSocket();
        Socket adapter = new SocketAdapter(europeanSocket);
        adapter.plugIn();  // Using adapter to connect European socket to US socket
    }
}
