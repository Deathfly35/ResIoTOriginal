import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.link.medium.TPSettings;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Classe pincipale permettant de lancer l'application
 */
public class Main {

    /**
     * Constante définissant le temps de mise à jour
     */
    private static final int TEMPS_MISE_A_JOUR = 500;

    /**
     * constante définissant le port de l'ordinateur
     */
    private static final int PORT_LOCAL = 8080;

    /**
     * constante définissant l'adresse distante sur laquelle se connecter
     */
    private static final String ADRESSE_DISTANTE = "192.168.1.201";

    /**
     * constante définissant le port de l'adresse distante sur laquelle se connecter
     */
    private static final int PORT_DISTANT = 3671;

    /**
     * Méthode permettant de lancer l'application
     * @param args : paramétre définissant les arguments
     * @throws KNXException : exception géré
     * @throws InterruptedException : exception géré
     */
    public static void main(String[] args) throws KNXException, InterruptedException, UnknownHostException {

        // on récupérer l'adresse local
        InetAddress localhost = InetAddress.getLocalHost();

        // on crée la connection KNX
        KNXConnection knxConnection = new KNXConnection(new InetSocketAddress(localhost.getHostAddress(), PORT_LOCAL), new InetSocketAddress(ADRESSE_DISTANTE, PORT_DISTANT), false, new TPSettings(), 1000);

        // tant que la connection n'est pas fermé
        while(!knxConnection.estFerme()){

            // on attend pour revérifier l'état
            Thread.sleep(TEMPS_MISE_A_JOUR);

        }

    }

}
