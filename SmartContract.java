/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodsupplychainsystem;

/**
 *
 * @author RIMSHA
 */
abstract class SmartContract implements Contract {
    protected String contractId;
    protected User initiator;
    protected User participant;

    public SmartContract(String contractId, User initiator, User participant) {
        this.contractId = contractId;
        this.initiator = initiator;
        this.participant = participant;
    }

    @Override
    public void createContract() {
        System.out.println("Creating smart contract: " + contractId);
    }

    @Override
    public void executeContract() {
        System.out.println("Executing smart contract: " + contractId);
    }

    @Override
    public void updateContract() {
        System.out.println("Updating smart contract: " + contractId);
    }

    @Override
    public void validateContract() {
        System.out.println("Validating smart contract: " + contractId);
    }
}

