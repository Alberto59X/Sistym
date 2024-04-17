package servico;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplServer extends UnicastRemoteObject implements Operacao {

    public ImplServer(String name) throws RemoteException {
        super();
        System.out.println("Servidor de operações matemáticas criado!");
    }

    // Implementação do método de soma definido na interface Operacao
    @Override
    public int soma(int varA, int varB) throws RemoteException {
        int soma = varA + varB;
        return soma;
    }

    // Implementação do método de produto definido na interface Operacao
    @Override
    public int produto(int varA, int varB) throws RemoteException {
        int produto = varA * varB;
        return produto;
    }
}
