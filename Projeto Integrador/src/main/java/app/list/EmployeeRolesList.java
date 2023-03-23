package app.list;

import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class EmployeeRolesList {

    /**
     * List that will contain the Employee Roles of the System.
     */
    List<String> employeeRoles = new ArrayList<>();

    /**
     * Allows the creation of the List.
     * Will add the existent roles to the created List.
     */
    public EmployeeRolesList() {
        employeeRoles.add(Constants.ROLE_ADMIN);
        employeeRoles.add(Constants.ROLE_CHEMTECH);
        employeeRoles.add(Constants.ROLE_LABCO);
        employeeRoles.add(Constants.ROLE_MEDTECH);
        employeeRoles.add(Constants.ROLE_RECEP);
        employeeRoles.add(Constants.ROLE_SPECDOC);
    }

    /**
     * Allows the System to verify if a certain role exists in the List.
     *
     * @param role Role to be checked.
     * @return Boolean value that represents if the role is present, or not, on the List.
     */
    public boolean contains(String role){
        for(String string : employeeRoles){
            if(role.equals(string)){
                return true;
            }
        }
        return false;
    }

    /**
     * Allows the System to get the Employee Roles List and use it.
     *
     * @return List of the Employee Roles.
     */
    public List<String> getList(){
        return employeeRoles;
    }
}
