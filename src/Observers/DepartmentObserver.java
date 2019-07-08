package Observers;

import Entities.Department;
import MainGui.GuiMethods;

/**
 *
 * @author user
 */
public class DepartmentObserver extends Observer {

    public DepartmentObserver(Department aDepartment) {
        this.aDepartment = aDepartment;
        aDepartment.attach(this);
    }

    @Override
    public void update() {
        GuiMethods.viewDepartmentList();
        GuiMethods.viewProductList();
    }
}
