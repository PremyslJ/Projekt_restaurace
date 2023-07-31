package com.engeto;

import java.io.*;
import java.util.List;

public class FileIO {
    // Metoda pro načtení objektu ze souboru
    public static Object loadObjectFromFile(String fileName) throws FileIOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return inputStream.readObject();
        } catch (FileNotFoundException e) {
            return null; // Pokud soubor neexistuje, vrátíme null
        } catch (IOException | ClassNotFoundException e) {
            throw new FileIOException("Chyba při načítání dat ze souboru " + fileName + ": " + e.getMessage());
        }
    }

    // Metoda pro uložení objektu do souboru
    public static void saveObjectToFile(Object object, String fileName) throws FileIOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(object);
        } catch (IOException e) {
            throw new FileIOException("Chyba při ukládání dat do souboru " + fileName + ": " + e.getMessage());
        }
    }

    // Metoda pro načtení seznamu objednávek ze souboru
    public static List<Order> loadOrdersFromFile(String fileName) throws FileIOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Order>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            return null; // Pokud soubor neexistuje, vrátíme null
        } catch (IOException | ClassNotFoundException e) {
            throw new FileIOException("Chyba při načítání dat ze souboru " + fileName + ": " + e.getMessage());
        }
    }

    // Metoda pro uložení seznamu objednávek do souboru
    public static void saveOrdersToFile(List<Order> orders, String fileName) throws FileIOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(orders);
        } catch (IOException e) {
            throw new FileIOException("Chyba při ukládání dat do souboru " + fileName + ": " + e.getMessage());
        }
    }

    // Metoda pro načtení menu ze souboru
    public static Menu loadMenuFromFile(String fileName) throws FileIOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Menu) inputStream.readObject();
        } catch (FileNotFoundException e) {
            return null; // Pokud soubor neexistuje, vrátíme null
        } catch (IOException | ClassNotFoundException e) {
            throw new FileIOException("Chyba při načítání dat ze souboru " + fileName + ": " + e.getMessage());
        }
    }

    // Metoda pro uložení menu do souboru
    public static void saveMenuToFile(Menu menu, String fileName) throws FileIOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(menu);
        } catch (IOException e) {
            throw new FileIOException("Chyba při ukládání dat do souboru " + fileName + ": " + e.getMessage());
        }
    }

    // Metoda pro načtení CookBooku ze souboru
    public static CookBook loadCookBookFromFile(String fileName) throws FileIOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (CookBook) inputStream.readObject();
        } catch (FileNotFoundException e) {
            return null; // Pokud soubor neexistuje, vrátíme null
        } catch (IOException | ClassNotFoundException e) {
            throw new FileIOException("Chyba při načítání dat ze souboru " + fileName + ": " + e.getMessage());
        }
    }

    // Metoda pro uložení CookBooku do souboru
    public static void saveCookBookToFile(CookBook cookBook, String fileName) throws FileIOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(cookBook);
        } catch (IOException e) {
            throw new FileIOException("Chyba při ukládání dat do souboru " + fileName + ": " + e.getMessage());
        }
    }
}