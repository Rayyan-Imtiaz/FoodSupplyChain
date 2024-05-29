/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodsupplychainsystem;

/**
 *
 * @author RIMSHA
 */
class Distributor extends User {
    public Distributor(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public void displayRole() {
        System.out.println(name + " is a Distributor.");
    }

    // Additional distributor-specific methods
}

