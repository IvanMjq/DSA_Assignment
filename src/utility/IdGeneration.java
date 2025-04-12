/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import adt.ListInterface;

/**
 *
 * @author User
 */
public class IdGeneration {

    public static <T extends Identifiable> String generateID(ListInterface<T> list, String prefix) {
        if (list.getLastData() != null) {
            String id = list.getLastData().getId();
            int num = Integer.parseInt(id.substring(prefix.length() + 1));
            return prefix + "-" + (num + 1);
        } else {
            return prefix + "-1";
        }
    }

    public interface Identifiable {
        String getId();
    }
}
