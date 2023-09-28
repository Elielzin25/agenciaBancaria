package br.senai.sp.jandira.model;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    Cliente referenciaCliente = new Cliente();
    Conta referenciaConta = new Conta();

    public void executarMenu() {

        boolean exit = false;

        while (!exit) {

            System.out.println("/-/-/-/-/-/-/-    Menu   -/-/-/-/-/-/-/");
            System.out.println("1 - Cadastrar Cliente                  ");
            System.out.println("2 - Gerar Conta                        ");
            System.out.println("3 - Cosultar Saldo                     ");
            System.out.println("4 - Realizar Saque                     ");
            System.out.println("5 - Realizar Deposito                  ");
            System.out.println("6 - Realizar Transferencia             ");
            System.out.println("7 - Sair                               ");
            System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");

            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser) {

                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    referenciaCliente.adicionarList(cliente);
                    break;
                case 2:
                    Conta conta = new Conta();
                    System.out.println("Informe o CPF cliente: ");
                    Long cpfCliente = scanner.nextLong();
                    scanner.nextLine();

                    Cliente clienteConta = referenciaCliente.pesquisarCliente(cpfCliente);

                    if (clienteConta != null) {
                        conta.gerarConta(clienteConta);
                        referenciaConta.adicionarContaList(conta);
                        System.out.println("Conta gerada com sucesso !");
                    } else {
                        System.out.println("Cliente não cadastrado...");
                    }


                    break;
                case 3:
                    System.out.println("Informe o CPF: ");
                    long cpfSaldo = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaSaldo = referenciaConta.pesquisarConta(cpfSaldo);

                    if (contaSaldo != null) {
                        contaSaldo.consultarSaldo();
                    } else {
                        System.out.println("O cliente não tem uma conta...");
                    }

                    break;
                case 4:
                    System.out.println("Informe o CPF: ");
                    long cpfSaque = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaSaque = referenciaConta.pesquisarConta(cpfSaque);

                    if (contaSaque != null){
                        System.out.println("Informe o valor que deseja sacar: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();

                        contaSaque.realizarSaque(valorSaque);

                    }else {
                        System.out.println("O cliente não tem uma conta...");
                    }


                    break;
                case 5:
                    System.out.println("Informe o CPF: ");
                    long cpfDeposito = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaDeposito = referenciaConta.pesquisarConta(cpfDeposito);

                    if (contaDeposito != null){
                        System.out.println("Informe um valor para deposito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();

                        contaDeposito.realizarDeposito(valorDeposito);

                    } else {
                        System.out.println("O cliente não tem conta...");
                    }

                    break;

                case 6:

                    System.out.println("Infome o seu CPF: ");
                    long cpfUser = scanner.nextLong();

                    System.out.println("Informe o CPF que deseja transferir: ");
                    long cpfTransferencia = scanner.nextLong();

                    Conta contaUser = referenciaConta.pesquisarConta(cpfUser);
                    Conta contaTransferencia = referenciaConta.pesquisarConta(cpfTransferencia);

                    if ( contaUser != null && contaTransferencia != null ){
                        referenciaConta.realizarTransferencia(contaUser, contaTransferencia);

                    } else {
                        System.out.println("Verifique os CPF´s informados...");
                    }

                    break;

                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("Obrigado por utilizar nosso banco senai !");

            }
        }


    }


}