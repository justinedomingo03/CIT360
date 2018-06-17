package com.hibernate.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FFXIV {
	// Create an EntityManagerFactory when you start the application.
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("ffxiv");

	public static void main(String[] args) {

		// Create classes with IDs
		create(1, "White Mage", "WHI");
		create(2, "Scholar", "SCH");
		create(3, "Astrologian", "AST");
		create(4, "Paladin", "PLD");

		// Update White Mage
		upate(1, "White Mage", "WHM");

		// Delete Paladin from database
		delete(4);

		// Print all the classes
		List classes = readAll();
		if (classes != null) {
			System.out.println(classes);
		}

		// Close ENTITY_MANAGER_FACTORY
		ENTITY_MANAGER_FACTORY.close();
	}

	// Create class
	public static void create(int id, String name, String abv) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get and begin transaction
			transaction = manager.getTransaction();
			transaction.begin();

			// Create and save new Class object
			Class cla = new Class();
			cla.setId(id);
			cla.setName(name);
			cla.setAbv(abv);

			manager.persist(cla);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			// Close the EntityManager
			manager.close();
		}
	}

	// Read and return all classes
	public static List readAll() {

		List classes = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();

			// Get a List of classes
			classes = manager.createQuery("SELECT s FROM Class s",
					Class.class).getResultList();

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		return classes;
	}

	// Delete class
	public static void delete(int id) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get and begin transaction
			transaction = manager.getTransaction();
			transaction.begin();

			// Get and delete the Class object
			Class cla = manager.find(Class.class, id);
			
			manager.remove(cla);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			manager.close();
		}
	}

	// Update class
	public static void upate(int id, String name, String string) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			// Get and begin transaction
			transaction = manager.getTransaction();
			transaction.begin();

			// Get and update the Class object
			Class cla = manager.find(Class.class, id);
			cla.setName(name);
			cla.setAbv(string);
			
			manager.persist(cla);

			// Commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			// If there are any exceptions, roll back the changes
			if (transaction != null) {
				transaction.rollback();
			}
			// Print the Exception
			ex.printStackTrace();
		} finally {
			manager.close();
		}
	}
}