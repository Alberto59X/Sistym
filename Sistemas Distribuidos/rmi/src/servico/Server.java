package servico;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class Server {

    public static void main(String args[]) {
        // Definindo a política de segurança para o acesso ao servidor RMI
        System.setProperty("java.security.policy", "file:///C:\\tmp\\fabio.policy");
        // Configurando o Security Manager para permitir operações RMI
        System.setSecurityManager(new RMISecurityManager());

        try {
            // Criando uma instância do servidor de operações matemáticas
            ImplServer obj = new ImplServer("OppMathServer");
            // Registrando o servidor com o nome "OppMathServer" no registro RMI
            Naming.rebind("OppMathServer", obj);

            System.out.println("Servidor de operações matemáticas registrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
