package main;

import interfaces.IBank;
import interfaces.IProvider;
import interfaces.IStore;
import services.Bank;
import services.Client;
import services.Provider;
import services.Store;

public class Main {

	public static void main(String[] args) {
		// Instanciation des services avec injection de dépendances
		IProvider prov = new Provider();
		IBank bank = new Bank();
		IStore store = new Store(prov, bank);
		Client cl = new Client(store,prov);

		cl.run();

	}

}
