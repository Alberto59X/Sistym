/**
 * Cliente responsável por acessar operações matemáticas remotas via RMI.
 */
package cliente;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import servico.Operacao;

public class Client {
    public static void main(String args[]) {
        // Configurando o Security Manager para permitir operações RMI
        System.setSecurityManager(new RMISecurityManager());
        // Definindo a política de segurança para o acesso ao servidor RMI
        System.setProperty("java.security.policy", "file:///C:/Users/botel/eclipse-workspace/unievaRMI/fabio.policy");

        try {
            // Procurando o objeto remoto no registro RMI
            Operacao operacaoRemota = (Operacao) Naming.lookup("OppMathServer");
            System.out.println("Objeto de operações matemáticas localizado com sucesso.");

            // Obtendo os argumentos a partir dos parâmetros da linha de comando
            int tipoOperacao = Integer.parseInt(args[0]);
            int a = Integer.parseInt(args[1]);
            int b = Integer.parseInt(args[2]);
            int resultado = 0;

            // Realizando a operação de acordo com o tipo especificado
            switch (tipoOperacao) {
                case 1:
                    resultado = operacaoRemota.soma(a, b);
                    break;
                case 2:
                    resultado = operacaoRemota.produto(a, b);
                    break;
                default:
                    System.err.println("Tipo de operação inválido.");
            }

            // Exibindo o resultado da operação
            System.out.println("Resultado = " + resultado);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            // Encerrando a execução do cliente
            System.exit(0);
        }
    } // fim public... main
} // fim class
